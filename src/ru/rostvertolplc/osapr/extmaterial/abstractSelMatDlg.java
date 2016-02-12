package ru.rostvertolplc.osapr.extmaterial;

import javax.swing.*;
import ru.rostvertolplc.osapr.forms.*;

abstract public class abstractSelMatDlg extends JDialog
{
  public String sMatName="", sMatMark, sMatNDMark, sMatSort=null, sMatNDSort;
  public String sMatShifr = null;
  public String sIMBASE_Code = null;
  public double fDensity = -1;
  public int iResult = 0;

  public abstractSelMatDlg()
  {
  }

  // --- !!! Логика должна соответствовать MaterialRevPanel.setNameSpec

  public void makeMatString(DSEUserData mat_data)
  {
    String sNDSort = mat_data.mater_sort_nd;
    String sNDMark = mat_data.mater_mark_nd;
    String sVidZagot = mat_data.mater_zagot;
    String sMarkMat = mat_data.mater_mark;
    // Сформировать строку для спец-ии
    String sNameSpec = sVidZagot;// + " " + sNDSort).trim();
    if (sVidZagot==null || sVidZagot.length()==0)
      sNameSpec = mat_data.mater_name;
    if (sNameSpec==null) sNameSpec = "";
    /* -- Была попытка добавлять в полное маименование компоненты, если их нет
     * но это не правильно, т.к. необходимо строгое формирование как в IMBASE 
     * без волюнтаризма
     * --
    if (sNDSort!=null  && sNameSpec.indexOf(sNDSort)<0)
      sNameSpec = (sNameSpec + " " + sNDSort).trim();
    if (sMarkMat!=null && sNameSpec.indexOf(sMarkMat)<0)
      sNameSpec = (sNameSpec + " " + sMarkMat).trim();
    if (sNDMark!=null  && sNameSpec.indexOf(sNDMark)<0)
      sNameSpec = (sNameSpec + " " + sNDMark).trim();
    */
    mat_data.material = sNameSpec;
  }


}
