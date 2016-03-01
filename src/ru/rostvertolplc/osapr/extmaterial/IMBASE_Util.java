package ru.rostvertolplc.osapr.extmaterial;

import com.borland.dx.sql.dataset.*;
import com.borland.dx.dataset.*;
import java.sql.Types;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;

import ru.rostvertolplc.osapr.util.LUtil;
import com.teamcenter.rac.util.MessageBox;
//import com.teamcenter.rac.util.*;
import com.teamcenter.rac.util.Registry;


public class IMBASE_Util
{
  // ��� ��������� �������� ������
  static final int CODE_LEAF = -10;
  static final String cstCTL_SORT = "CTL000001";
  static final String cstCTL_MARK = "CTL000002";

  public Database dbMaterial;
  QueryDataSet qInner, qMat; // qMat - ������������ ������� ��� ������������ �����
  // ������� ���������� � �����
  QueryDataSet qFields0 = null; // ��� ������������, ���� ����������� (init by request)
  QueryDataSet qFields = new QueryDataSet();
  QueryDataSet qTables = new QueryDataSet();
  /*
  F_ENTERMODE:
  1 - cst string
  2 - LOOKUP (������������ �������� ��� ����� ��������� � ������ ������ �������)
  3 - ��� ������
  4 - ������������ �� ������������ ����. ���� � ��� �� F_LONGNAME
  5 - ������ �� �������
  */

  Column PTableName = new Column();
  //Column MatCatID = new Column();
  ParameterRow paramRow = new ParameterRow();
  public String sColInd = null;  // ���� "�����������"
  // ������� ��� ����, �� �������� ������������ ����� (������������ ��� �������������)
  public String sf������������� = "������������";
  public int iDefaultPrim = 0;   // ������������� �� ���������
  String sfInnerTable = "F13";   // ���� ��� ������� ��� ��������� �������

  public IMBASE_Util(QueryDataSet p_qInner, QueryDataSet p_qMat)
  {
    qInner = p_qInner;
    qMat = p_qMat; // ������������ �������
 
    dbMaterial = qMat.getDatabase();
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public IMBASE_Util()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    qFields.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbMaterial,
      "select f.* from IM_FIELDS f, IM_TABLES t\nwhere f.F_TABLE_ID=t.F_KEY\n" +
      "and t.F_TABLE=:TABLE_NAME", paramRow, true, Load.ALL));
    qTables.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbMaterial,
      "select * from IM_TABLES where F_TABLE=:TABLE_NAME",
      paramRow, true, Load.ALL));
    PTableName.setSqlType(0);
    PTableName.setServerColumnName("NewColumn1");
    PTableName.setPreferredOrdinal(1);
    PTableName.setParameterType(ParameterType.IN);
    PTableName.setDataType(com.borland.dx.dataset.Variant.STRING);
    PTableName.setColumnName("TABLE_NAME");
    PTableName.setCaption("TABLE_NAME");
    paramRow.setColumns(new Column[] {PTableName});
  }

  public static ConnectionDescriptor new_IMBASE_Connection(Registry R)
  {
    return new ConnectionDescriptor(
        //"jdbc:odbc:IMBASE-mat", "sysdba", "masterkey", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
        "jdbc:oracle:thin:@"+R.getString("IMBASE.SERVER")+":"+R.getString("IMBASE.PORT")+":"+R.getString("IMBASE.SID"),
        "sysdba", "sysmaster", false, "oracle.jdbc.driver.OracleDriver");
  }

  String CalcFormula(String sF)
  {
    String Result="";
    String s, sField;
    //int len = sF.length();
    int a=0;
    while (sF.length()>0)
    {
      a = sF.indexOf('{');
      if (a>-1)
      {
        if (a>0)  Result += sF.substring(0,a);
        sF = sF.substring(a+1);
      }
      else // ����� ������
      { Result += sF;
        return Result;
      }
      a = sF.indexOf('}');
      if (a>-1)
      {
        sField = sF.substring(0,a);
        s = "";
        int b = sField.indexOf('[');
        if (b>-1)
        {
          if (b>0)  s += sField.substring(0,b);
          sField = sField.substring(b+1);
          String sVal = "";
          b = sField.indexOf(']');
          if (b>-1)
          {
            sVal = getFieldValue(sField.substring(0, b));
            sField = LUtil.safeSubstr(sField, b+1);
          }
          s += sVal+sField;
          if (b>-1 && sVal.length()>0) // ���� ���� [������] � �������� ���� �� ������
            Result += s; //  �� �������� ���������, � ����� ������ �� ���������
        }
        else
          Result += getFieldValue(sField);

        sF = sF.substring(a+1);
      }
    }
    return Result;
  }

  public String getFieldValue(String sField)
  {
    String Result = "";
    Column col = qInner.hasColumn(sField);
    if (col!=null)
    {
      if (qInner.isNull(sField)) Result = null;
      else
      switch (col.getSqlType())
      {
        case Types.SMALLINT:
        case Types.INTEGER:
          Result = String.valueOf(qInner.getInt(sField)); break;
        case Types.FLOAT:
        case Types.REAL:
        case Types.DOUBLE:
          try
          {
            //Result = String.valueOf(qInner.getDouble(sField));
        	// �������� ���������� ���� ����� �������
            Result = LUtil.float2string(qInner.getDouble(sField), 6);
          }
          catch (Exception ex)
          { Result = null; }
          break;
        case Types.NUMERIC:
          Result = String.valueOf(qInner.getBigDecimal(sField)); break;
        case Types.VARCHAR:
          Result = qInner.getString(sField);
          if (Result.length()==0)  Result=null;
          break;
        case Types.DATE:
        case Types.TIME:
        case Types.TIMESTAMP:
          Result = String.valueOf(qInner.getDate(sField)); break;
        default:
          return "����������� ��� ������";
      }
    }
/*
    else if (qMat.hasColumn(sField)!=null)
      Result = qMat.getString(sField);
*/
    // ���� � ������� �� ���� ����, ���� ��� ��� ������, ������� ������� � ��������� �������
    if ((col==null || Result==null) && qFields.isOpen())
    {
      qFields.first();
      while (qFields.inBounds())
      {
        if (qFields.getString("F_FIELD").equals(sField))
        {
          int entermode = qFields.getBigDecimal("F_ENTERMODE").intValue();
          if (entermode==2) // LOOKUP
            return "";
          if (entermode==4) // ������������
          {
            String sLongName = qFields.getString("F_LONGNAME");
            return getFromParent(sLongName);
          }
          else {
            String sData = qFields.getString("F_DATA");
            if (sData.length() == 0)return "";
            else return CalcFormula(sData);
          }
        }
        qFields.next();
      }
    }
    return Result;
  }

  public String BuildIndication()
  {
    return CalcFormula(sColInd).trim();
  }

  void update_qFields(String sNameTable)
  {
    paramRow.setString("TABLE_NAME", sNameTable);
    if (!qFields.isOpen()) qFields.open();
    else qFields.refresh();
  }

  void updateInnerTable(String sNameTable)
  {
    if (qInner.isOpen()) qInner.close();

    if (sNameTable==null)
      sNameTable = qMat.getString(sfInnerTable);

    update_qFields(sNameTable);
    // ��������� ���� �������������
    String sFPrim = "����_�������������";
    while (qFields.inBounds())
    {
      if (qFields.getString("F_LONGNAME").equals(sf�������������))
      {
        sFPrim = qFields.getString("F_DATA");
        iDefaultPrim = 0;
        if (sFPrim.equals("0") || sFPrim.equals("-")) iDefaultPrim = -1;
        if (sFPrim.equals("1") || sFPrim.equals("+")) iDefaultPrim = 1;
        sFPrim = qFields.getString("F_FIELD");
        break;
      }
      qFields.next();
    }
    //String sqInner = "SELECT * FROM "+sNameTable+" WHERE "+sFPrim+"='+'";
    String sqInner = "SELECT * FROM "+sNameTable;
    // -- ���� �� ������� ���� ������������ ��� ������������� - ������ ���������
    if (sFPrim.equals("����_�������������") && qFields.rowCount()>0)
    {
      MessageBox.post("���� "+sf�������������+" �� �������. \n ����������� �� ������� �� ������ ������� �� ���������.",
                      sf�������������, MessageBox.WARNING);
    }
    else // ����� - �������� ������� ����������� �� �������������
    {
      sqInner += " WHERE "+sFPrim+"='+'";
      
      if (iDefaultPrim != -1)  sqInner += " OR "+sFPrim+" IS NULL";
    }
    if (sNameTable.length()==0) return;
    qInner.setQuery(new QueryDescriptor(dbMaterial, sqInner, null, true, Load.AS_NEEDED));
    qInner.open();

    sColInd=null;
    qFields.first();
    while (qFields.inBounds())
    {
      // ����������, ����� ���� ��� ������������ (F_SHORTNAME = "SORT")
      if (qFields.getString("F_SHORTNAME").equals("SORT"))
        sColInd = qFields.getString("F_DATA");
      String sCol = qFields.getString("F_FIELD");
      Column col = qInner.hasColumn(sCol);
      if (col!=null)
      {
        col = qInner.getColumn(sCol);
        String s = qFields.getString("F_LONGNAME").toLowerCase();
        col.setCaption(s+'('+sCol+')');
        //col.setWidth(-qFields.getBigDecimal("F_WIDTH").intValue());
      }
      qFields.next();
    }
  }

  // ������� ����������� ��� ���� �� ��� LONGNAME
  String askRealField(QueryDataSet qF, String sLongName)
  {
    if (qF==null)  qF = qFields;
    if (!qF.isOpen())  qF.open();

    qF.first();
    while (qF.inBounds())
    {
      if (qF.getString("F_LONGNAME").equals(sLongName))
      {
        return qF.getString("F_FIELD");
      }
      qF.next();
    }
    return null;
  }

  // ������� ���� �� ������������� �������� �� ��� LONGNAME � IM_FIELDS
  String getFromParent(String sLongName)
  {
    String sField="";
    if (qFields0==null)
    {
      qFields0 = new QueryDataSet();
      String sTable = qMat.getOriginalQueryString();
      if (sTable.indexOf("CTL000001_REC")>-1) sTable="CTL000001";
      else if (sTable.indexOf("CTL000002_REC")>-1) sTable="CTL000002";
      qFields0.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbMaterial,
        "select f.* from IM_FIELDS f, IM_TABLES t\nwhere f.F_TABLE_ID=t.F_KEY\n" +
        "and t.F_TABLE='"+sTable+"'", null, true, Load.ALL));
      qFields0.open();
    }
    sField = askRealField(qFields0, sLongName);
    return sField!=null? qMat.getString(sField) : "%parent field "+sField+" not found%";
  }

  // ���������� ������ �������� ������
  boolean setIM_TABLES_Table(String sName)
  {
    paramRow.setString("TABLE_NAME", sName);
    qTables.refresh();
    return qTables.isOpen();
  }

  String getIM_TABLES_Field(String sFName)
  {
    if (!qTables.isOpen())
      return null;
    return qTables.getString(sFName);
  }

  double getDensity()
  {
    // ���������
    double Result = 0;
    String s = getFieldValue("���������");
    try
    {
      if (s.length()>0) // �� ������ ����
      {
        s = s.replaceFirst(",",".");
        Result = Double.valueOf(s).doubleValue();
        return Result;
      }
    }
    catch (NumberFormatException ex)
    {
      Result = -1;
    }
    catch (NullPointerException ex1)
    {
      Result = 0;
    }


    s = askRealField(qFields, "DENS");
    s = getFieldValue(s);
    try
    {
      if (s.length()==0) return 0;
      s = s.replaceFirst(",",".");
      Result = Double.valueOf(s).doubleValue();
    }
    catch (NumberFormatException ex)
    {
      Result = -1;
    }
    catch (NullPointerException ex1)
    {
      Result = 0;
    }
    return Result;
  }

  private String intFldToHex(QueryDataSet Q, String sFldName, int digits)
  {
	String sResult = "";
	int iResult = 0;
	try {
		iResult = Q.getBigDecimal(sFldName).intValue();
	} catch (VariantException e) {
		iResult = Q.getInt(sFldName);
	}
	sResult = Integer.toHexString(iResult);
	for (int i=sResult.length(); i<digits; i++)
	  sResult = '0'+sResult;
	return sResult;
  }
  
  public String makeIMBASE_Code(String sCtlTable)
  {
	String sResult = null;
	if (!setIM_TABLES_Table(sCtlTable)) return null;
	sResult = intFldToHex(qTables, "F_KEY", 6);
	
	String R2 = intFldToHex(qMat, "F_KEY", 6);
	// ��������, ���� �� � �������� F_KEY, ���� ���, �� ��� ������ �����
	String R3 = "";
	if (qInner.hasColumn("F_KEY") != null)
	  R3 = intFldToHex(qInner, "F_KEY", 6);
	else
	{
	  String sMark = qInner.getString(0); // ����� - ������ ����
	  QueryDataSet Q = new QueryDataSet();
      Q.setQuery(new QueryDescriptor(dbMaterial,
        "SELECT F_KEY FROM " + qInner.getTableName() + " WHERE F2='"+sMark+"'", null, true, Load.ALL));
      Q.open();
      if (Q.rowCount()>1) // ����������  ����� 1 ����� � ����� ���������
      {
    	return null;      // ���������� ���������� ������� �����
      }
      R3 = intFldToHex(Q, "F_KEY", 6);
    }
	sResult += R2+R3;
	return "i6"+sResult.toUpperCase();
  }

  // ������� ���������� �� ������ ����� ������������ �� "IM"
  //��� �������� ����������
  public static void removeIM_rec(DefaultMutableTreeNode group)
  {
    Enumeration nodes = group.children();
    DefaultMutableTreeNode arr[] = new DefaultMutableTreeNode[group.getChildCount()];
    int i, n;
    for (n=0; nodes.hasMoreElements(); n++)
      arr[n] = (DefaultMutableTreeNode)nodes.nextElement();
    
    for (i=0; i<n; i++)
    {
      DefaultMutableTreeNode node = arr[i];
      if ( ((MatGroupData)node.getUserObject()).name.startsWith("IM")||((MatGroupData)node.getUserObject()).name.startsWith("_del") )
      {
        group.remove(node);
      }
      else
    	removeIM_rec(node);
    }
  }
  
  //��� ��������������� ����������
  public static void removeIM_rec(DefaultMutableTreeNode group, int codeAux)
  {
    Enumeration nodes = group.children();
    DefaultMutableTreeNode arr[] = new DefaultMutableTreeNode[group.getChildCount()];
    int i, n;
    for (n=0; nodes.hasMoreElements(); n++)
      arr[n] = (DefaultMutableTreeNode)nodes.nextElement();
    
    for (i=0; i<n; i++)
    {
      DefaultMutableTreeNode node = arr[i];
      if (((MatGroupData)node.getUserObject()).name.startsWith("IM")||((MatGroupData)node.getUserObject()).name.startsWith("_del")||((MatGroupData)node.getUserObject()).name.startsWith("����")||((MatGroupData)node.getUserObject()).name.startsWith("������")||((MatGroupData)node.getUserObject()).name.startsWith("���������")||((MatGroupData)node.getUserObject()).name.startsWith("�������� ������������") ||((MatGroupData)node.getUserObject()).name.startsWith("�����")
    		  ||((MatGroupData)node.getUserObject()).name.startsWith("��������� ���������")||((MatGroupData)node.getUserObject()).name.startsWith("����������")||((MatGroupData)node.getUserObject()).name.startsWith("��������� ��� ������ � �����")
    		  ||((MatGroupData)node.getUserObject()).name.startsWith("������������ ���������")||((MatGroupData)node.getUserObject()).name.startsWith("��������")||((MatGroupData)node.getUserObject()).name.startsWith("������������������ �������")||((MatGroupData)node.getUserObject()).name.startsWith("�������� ���������")||((MatGroupData)node.getUserObject()).name.startsWith("����������- � ������������������� ���������")||((MatGroupData)node.getUserObject()).name.startsWith("��������� ���������"))
      {
        group.remove(node);
      }
      else
    	removeIM_rec(node, codeAux);
    }
  }

}