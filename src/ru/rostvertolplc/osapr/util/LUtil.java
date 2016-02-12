package ru.rostvertolplc.osapr.util;

import java.util.Date;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.aif.kernel.AIFComponentContext;
import com.teamcenter.rac.kernel.TCComponentListOfValuesType;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.kernel.TCComponentListOfValues;
import com.teamcenter.rac.util.MessageBox;
import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;
import com.teamcenter.rac.kernel.TCComponentBOMViewRevision;
import com.teamcenter.rac.kernel.TCComponentViewTypeType;
import com.teamcenter.rac.kernel.TCComponentViewType;
import com.teamcenter.rac.kernel.TCComponentBOMViewRevisionType;
import com.teamcenter.rac.aif.AIFClipboard;
import com.teamcenter.rac.aif.AIFDesktop;
import com.teamcenter.rac.aif.AIFPortal;

import java.awt.Frame;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import com.teamcenter.rac.util.combobox.iComboBox;
import java.text.NumberFormat;
import java.util.Locale;

public class LUtil
{
  static SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");


  public static void AttachOnce(TCComponent where, String sRelation, TCComponent vad) throws TCException
  {
    //AIFComponentContext children[] = where.getSecondary();
    AIFComponentContext children[] = vad.whereReferenced(true);

    boolean isAttached=false;
    for (int i=0; i<children.length; i++)
    {
      isAttached = children[i].getComponent().equals(where);
      if (isAttached)  break;
    }
    // Если не подцеплен, подцепить
    if (!isAttached)  where.add(sRelation, vad);
  }

  public static TCComponentItemRevision findItemRevision(TCComponentItem item, String sRevID) throws TCException
  {
    TCComponentItemRevision ir = null;
    TCComponent[] components = item.getRelatedComponents("revision_list");
    for (int i=0; i<components.length; i++ )
    {
      TCComponentItemRevision ir_test=(TCComponentItemRevision)components[i];
      try {
        if (ir_test.getProperty("item_revision_id").equals(sRevID))
        {
          ir = ir_test; break;
        }
      }
      catch (TCException ex)
      { continue; }
    }
    return ir;
  }

  public static TCComponentBOMViewRevision getBVR(TCComponentItemRevision ir, String bv_type) throws TCException
  {
    TCComponentBOMViewRevision bvr = null;
    TCComponent[] array_bvr = ir.getRelatedComponents("structure_revisions");
    for (int i=0; i<array_bvr.length; i++)
      //if (array_bvr[i].getProperty("object_type").startsWith(bv_type))
      if (array_bvr[i].getReferenceProperty("bom_view").getProperty("view_type").equals(bv_type))
      {
        bvr = (TCComponentBOMViewRevision)array_bvr[i];  break;
      }
    return bvr;
  }

  public static TCComponentViewType findBOMViewType(String sBOMViewType, TCSession session)
  {
    TCComponentViewType vt = null;
    // Найти BOMViewType
    try
    {
      TCComponentViewTypeType tc_vtt = (TCComponentViewTypeType) session.getTypeComponent("PSViewType");
      TCComponent[] array_vt = tc_vtt.extent();
      for (int i = 0; i < array_vt.length; i++)
        if (array_vt[i].toString().equalsIgnoreCase(sBOMViewType))
        {vt = (TCComponentViewType) array_vt[i];
        break;
        }
    }
    catch (TCException ex)
    {
      ex.printStackTrace();
    }
    return vt;
  }

  public static TCComponentBOMViewRevision createBVR(TCComponentItemRevision ir, String bv_type) throws TCException
  {
    TCSession session = (TCSession)ir.getSession();
    TCComponentBOMViewRevision bvr = null;
    TCComponentViewType vt = findBOMViewType(bv_type, session);
    TCComponentBOMViewRevisionType tc_bvr = (TCComponentBOMViewRevisionType)session.getTypeComponent("BOMViewRevision");
    bvr = tc_bvr.create(ir.getItem().getProperty("item_id"), ir.getProperty("item_revision_id"), vt, true);
    return bvr;
  }

//----------------------------------------------------------------------------
  // Выравнивает целое число до строки длиной len? дополняя спереди нулями
  public static String IntToStr0(int val, int len)
  {
    String s = String.valueOf(val);
    int n = s.length();
    for (int i=n; i<len; i++) s = "0"+s;
    return s;
  }

  public static String IntToStr0(String val, int len)
  {
    String s = val;
    int n = s.length();
    for (int i=n; i<len; i++) s = "0"+s;
    return s;
  }

//----------------------------------------------------------------------------
  // Возвращает часть строки до разделителя или всю строку
  public static String parse1(String full_str, String div)
  {
    int j = full_str.indexOf(div);
    return j>0 ? full_str.substring(0, j) : full_str;
  }

  // Разбирает строку по запятым в массив строк и возвращает кол-во строк
  public static String[] parse2Array(String full_str)
  {
    // Если входная строка == null - вернуть 2 пустые строки
    if (full_str == null) return new String[]{"",""};

    Vector strArray=new Vector(2);
    int i = 0;
    int j, n = 0;
    while ((j = full_str.indexOf(',', i)) >= 0)
    {
      strArray.add(full_str.substring(i, j).trim());
      i = j+1;
    }
    strArray.add(full_str.substring(i).trim());
    n = strArray.size();
    if (n<2) n=2;
    String Result[] = new String[n];
    strArray.toArray(Result);
    return Result;
  }
///!!!!Diyakova
  public static String[] parse2Array2(String full_str)
  {
    // Если входная строка == null - вернуть 2 пустые строки
    if (full_str == null) return new String[]{"",""};

    Vector strArray=new Vector(2);
    int i = 0;
    int j, n = 0;
    while ((j = full_str.indexOf("@", i)) >= 0)
    {
      strArray.add(full_str.substring(i, j).trim());
      i = j+1;
    }
    strArray.add(full_str.substring(i).trim());
    n = strArray.size();
    if (n<2) n=2;
    String Result[] = new String[n];
    strArray.toArray(Result);
    return Result;
  }
/*
  Date parseDate(String full_str)
  {
    DateFormat df = DateFormat.getDateInstance();
    Date date = null;
    int j = full_str.indexOf(",");
    try {
      if (j<full_str.length()-1)
	date = df.parse(full_str.substring(j+1));
    }
    catch (ParseException ex) {  }

    return date;
  }
*/
  public static String Date2String(Date date)
  {
    return date==null? "" : sdf.format(date);
  }

  public static Date String2Date(String str)
  {
    Date Result = null;
    try {
      Result = sdf.parse(str);
    }
    catch (ParseException ex) {  }
    catch (NullPointerException ex) {  }
    return Result;
  }

// === Получение строк списка значений ===
  static TCComponentListOfValuesType tc_LOV = null;

  public static String[] getLOVStrings(String sLOVName, TCSession session)
  {
    try {
      tc_LOV = (TCComponentListOfValuesType) session.getTypeComponent("ListOfValues");
    }
    catch (TCException ex) {
      ex.printStackTrace();
    }
    return getLOVStrings(sLOVName);
  }

  public static String[] getLOVStrings(String sLOVName)
  {
	
    String Result[]=null;
    try{
      TCComponentListOfValues[] lovs;
      lovs = tc_LOV.find(sLOVName);
      if (lovs == null || lovs.length == 0 || lovs[0] == null)
      {
        MessageBox.post("Не найден LOV '"+sLOVName+"'", "Warning", MessageBox.WARNING);
      }
      else
      {
        TCComponentListOfValues lov = lovs[0];
        Result = lov.getListOfValues().getStringListOfValues();
      }
    }
    catch (TCException ex) {
      ex.printStackTrace();
    }
    return Result;
  }


// === Заполнить ComboBox с добавлением пустой строки ===
  public static void fillComboBoxLOV(JComboBox cb, String[] a_lov_str)
  {
    cb.addItem("");
    fillComboBoxLOV2(cb, a_lov_str);
  }

// === Заполнить ComboBox значениями из массива строк ===
  public static void fillComboBoxLOV2(JComboBox cb, String[] a_lov_str)
  {
    if (a_lov_str==null) return;
    for (int i=0; i<a_lov_str.length; i++)
      cb.addItem( a_lov_str[i] );
  }

  public static void fillComboBoxLOV(iComboBox cb, String[] a_lov_str)
  {
    cb.addItem("");
    if (a_lov_str==null) return;
    for (int i=0; i<a_lov_str.length; i++)
      cb.addItem( a_lov_str[i] );
  }


  static private String takeListElement(String элемент, String div)
  {
    // Взять элемент с отсечением после разделителя
    if (div!=null) return LUtil.parse1(элемент, div);
   // ^^^^^^^^^^^^^
    return элемент;
  }

  static public void addItemsFromList(JTextComponent text, String[] list, String div)
  {
    SendListDlg dlg = new SendListDlg(list);
    if (!dlg.dlgResult) return;
    Object[] array = dlg.jList.getSelectedValues();
    if (array==null || array.length==0) return;
    String old = text.getText();
    String code = takeListElement((String)array[0], div);
    for (int i=1; i<array.length; i++)
    {
      code = code + "; " + takeListElement((String)array[i], div);
    }
    if (old.equalsIgnoreCase(""))
      text.setText(code);
    else
      text.setText(old + "; " + code);
  }

  static public String getSelectedStrCB(JComboBox cb)
  {
    return cb.getSelectedItem()!=null? cb.getSelectedItem().toString() : "";
  }

  static public String getSelectedStrCB(iComboBox cb)
  {
    return cb.getSelectedItem()!=null? cb.getSelectedItem().toString() : "";
  }

  static public String safeSubstr(String s, int idx1)
  {
    if (s==null) return null;
    int len = s.length();
    if (idx1>=len) return "";
    return s.substring(idx1);
  }

  static public String safeSubstr(String s, int idx1, int idx2)
  {
    if (s==null) return null;
    int len = s.length();
    if (idx1>=len) return "";
    if (idx2>len) return s.substring(idx1);
    return s.substring(idx1, idx2);
  }

  static public Vector getPortalClopboard(Object requestor)
  {
    AIFClipboard clipboard = AIFPortal.getClipboard();
    Transferable content = clipboard.getContents(requestor);
    if (content == null) return null;

    Vector childComponents = null;
    try
    {
      childComponents = (Vector) content.getTransferData(new DataFlavor(Vector.class, "AIF Vector"));
    }
    catch (Exception ex)
    {
      MessageBox.post(ex);
    }
    return childComponents;
  }

  static Locale locRu = new Locale("ru", "RU");
  
  static public String float2string(double d, int digits)
  {
    NumberFormat nf = NumberFormat.getInstance(locRu); // Locale.ENGLISH
    nf.setMaximumFractionDigits(digits);
    String s = nf.format(d);
    // -- это нужно, если мы всё-таки хотим отображать числа, меньшие заданной точности
    // но уже в том формате, как хочет Java
    //if (Math.abs(d)<Math.pow(10, -digits))  s=Double.toString(d);
    return s;
  }

  static public double string2float(String s)
  {
    NumberFormat nf = NumberFormat.getInstance(locRu); // Locale.ENGLISH
    Number n = -1.1111;
	try { n = nf.parse(s); }
	catch (ParseException e)
	{
	  e.printStackTrace();
	}
    return n.doubleValue();
  }
  
  static public Frame digParentFrame()
  {
	Frame frames[] = AIFDesktop.getFrames(); 
    Frame desktop = null;
    for (int i = 0; i < frames.length; i++)
    {
      if (frames[i] instanceof AIFDesktop)
      {
        desktop = ((AIFDesktop)frames[i]).getDesktopManager().getCurrentDesktop();
        if (desktop == null)
        {
          desktop = frames[i];
        }
        return desktop;
      }
    }
    return desktop;
  }

}
