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
  // код конечного элемента дерева
  static final int CODE_LEAF = -10;
  static final String cstCTL_SORT = "CTL000001";
  static final String cstCTL_MARK = "CTL000002";

  public Database dbMaterial;
  QueryDataSet qInner, qMat; // qMat - родительская таблица для наследования полей
  // таблица информации о полях
  QueryDataSet qFields0 = null; // для родительской, если понадобится (init by request)
  QueryDataSet qFields = new QueryDataSet();
  QueryDataSet qTables = new QueryDataSet();
  /*
  F_ENTERMODE:
  1 - cst string
  2 - LOOKUP (предлагаемые значения для ввода находятся в списке другой таблицы)
  3 - нет данных
  4 - наследование из родительской табл. поля с тем же F_LONGNAME
  5 - расчёт по формуле
  */

  Column PTableName = new Column();
  //Column MatCatID = new Column();
  ParameterRow paramRow = new ParameterRow();
  public String sColInd = null;  // Поле "обозначение"
  // длинное имя поля, по которому ограничивать выбор (ОГРАНИЧИТЕЛЬ или ПРИМЕНЯЕМОСТЬ)
  public String sfПРИМЕНЯЕМОСТЬ = "ОГРАНИЧИТЕЛЬ";
  public int iDefaultPrim = 0;   // применяемость по умолчанию
  String sfInnerTable = "F13";   // поле где указано имя Вложенной таблицы

  public IMBASE_Util(QueryDataSet p_qInner, QueryDataSet p_qMat)
  {
    qInner = p_qInner;
    qMat = p_qMat; // родительская таблица
 
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
      else // Конец строки
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
          if (b>-1 && sVal.length()>0) // Если были [скобки] и значение поля не пустое
            Result += s; //  то добавить выражение, а иначе ничего не добавлять
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
        	// отсекаем незначащие нули после запятой
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
          return "неизвестный тип данных";
      }
    }
/*
    else if (qMat.hasColumn(sField)!=null)
      Result = qMat.getString(sField);
*/
    // Если в таблице не было поля, либо оно там пустое, смотрим формулу в структуре таблицы
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
          if (entermode==4) // наследование
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
    // проверить поле применяемость
    String sFPrim = "поле_применяемость";
    while (qFields.inBounds())
    {
      if (qFields.getString("F_LONGNAME").equals(sfПРИМЕНЯЕМОСТЬ))
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
    // -- если не найдено поле ограничителя или применяемости - выдать сообщение
    if (sFPrim.equals("поле_применяемость") && qFields.rowCount()>0)
    {
      MessageBox.post("Поле "+sfПРИМЕНЯЕМОСТЬ+" не найдено. \n Ограничения на выборку из данной таблицы не действуют.",
                      sfПРИМЕНЯЕМОСТЬ, MessageBox.WARNING);
    }
    else // иначе - добавить условия ограничения по применяемости
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
      // Запоминаем, какое поле явл обозначением (F_SHORTNAME = "SORT")
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

  // выбрать фактическое имя поля по его LONGNAME
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

  // выбрать поле из родительского датасета по его LONGNAME в IM_FIELDS
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

  // установить запрос описания таблиц
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
    // плотность
    double Result = 0;
    String s = getFieldValue("ПЛОТНОСТЬ");
    try
    {
      if (s.length()>0) // не пустое поле
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
	// проверим, есть ли в датасете F_KEY, если нет, то это просто марка
	String R3 = "";
	if (qInner.hasColumn("F_KEY") != null)
	  R3 = intFldToHex(qInner, "F_KEY", 6);
	else
	{
	  String sMark = qInner.getString(0); // марка - первое поле
	  QueryDataSet Q = new QueryDataSet();
      Q.setQuery(new QueryDescriptor(dbMaterial,
        "SELECT F_KEY FROM " + qInner.getTableName() + " WHERE F2='"+sMark+"'", null, true, Load.ALL));
      Q.open();
      if (Q.rowCount()>1) // существует  более 1 марки с таким названием
      {
    	return null;      // невозможно однозначно выбрать марку
      }
      R3 = intFldToHex(Q, "F_KEY", 6);
    }
	sResult += R2+R3;
	return "i6"+sResult.toUpperCase();
  }

  // Удаляет Рекурсивно из дерева папки начинающиеся на "IM"
  //для основных мателиалов
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
  
  //для вспомогательных материалов
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
      if (((MatGroupData)node.getUserObject()).name.startsWith("IM")||((MatGroupData)node.getUserObject()).name.startsWith("_del")||((MatGroupData)node.getUserObject()).name.startsWith("Кожа")||((MatGroupData)node.getUserObject()).name.startsWith("Стекло")||((MatGroupData)node.getUserObject()).name.startsWith("Фотоплёнка")||((MatGroupData)node.getUserObject()).name.startsWith("Пластины керамические") ||((MatGroupData)node.getUserObject()).name.startsWith("Рукав")
    		  ||((MatGroupData)node.getUserObject()).name.startsWith("Древесные материалы")||((MatGroupData)node.getUserObject()).name.startsWith("Силикагель")||((MatGroupData)node.getUserObject()).name.startsWith("Материалы для сварки и пайки")
    		  ||((MatGroupData)node.getUserObject()).name.startsWith("Пластические материалы")||((MatGroupData)node.getUserObject()).name.startsWith("Текстиль")||((MatGroupData)node.getUserObject()).name.startsWith("Асбестотехнические изделия")||((MatGroupData)node.getUserObject()).name.startsWith("Бумажные материалы")||((MatGroupData)node.getUserObject()).name.startsWith("Теплозвуко- и электроизоляционные материалы")||((MatGroupData)node.getUserObject()).name.startsWith("Кабельная продукция"))
      {
        group.remove(node);
      }
      else
    	removeIM_rec(node, codeAux);
    }
  }

}