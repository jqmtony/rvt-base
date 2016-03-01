/*
Используется для Диалога создания Материалов из IMBASE
*/

package ru.rostvertolplc.osapr.forms;

import javax.swing.border.TitledBorder;

import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;
import java.awt.*;
import javax.swing.*;
import ru.rostvertolplc.osapr.util.*;
import java.awt.event.*;
import ru.rostvertolplc.osapr.extmaterial.SelectMatDlg3;
import ru.rostvertolplc.osapr.extmaterial.SelectZagDlg2;
import com.teamcenter.rac.kernel.TCSession;


public class MaterialRevPanel extends JPanel
{
DSEUserData data = null;
TCSession session;
//Registry R = Registry.getRegistry("com.avid.forms.forms");

private JLabel jLabel7 = new JLabel();
private JTextField edNameMat = new JTextField();
private JLabel jLabel12 = new JLabel();
private JTextField edMarkMat = new JTextField();
private JLabel LNDSort = new JLabel();
private JTextField edNDSort = new JTextField();
JLabel jLabel17 = new JLabel();
JTextField edNDMark = new JTextField();
JLabel LSort = new JLabel();
JTextField edVidZagot = new JTextField();
JPanel MainPanel = new JPanel();
GridBagLayout gridBagLayout3 = new GridBagLayout();
TitledBorder titledBorder2;
TitledBorder titledBorder3;
TitledBorder titledBorder4;
private JLabel jLabel25 = new JLabel();
BorderLayout borderLayout1 = new BorderLayout();
JLabel jLabel19 = new JLabel();
JTextField edMatShifr = new JTextField();
TextFieldDocument edNameMat1 = new TextFieldDocument(256);
JLabel jLabel110 = new JLabel();
JRadioButton rbZagot = new JRadioButton();
JPanel jpMaterial = new JPanel();
JButton btMaterial = new JButton();
JRadioButton rbMat = new JRadioButton();
GridBagLayout gridBagLayout7 = new GridBagLayout();
JButton btMaterial1 = new JButton();
JTextField edDensity = new JTextField();
JButton btMaterialClr = new JButton();
JLabel jLabel8 = new JLabel();
JLabel jLabel1 = new JLabel();
ButtonGroup bgMat = new ButtonGroup();

public MaterialRevPanel() {
  try {
    jbInit();
  }
  catch(Exception e) {
    e.printStackTrace();
  }
}

public MaterialRevPanel(DSEUserData theData) {
  data = theData;
  session = data.session;
  try {
    jbInit();
    renderData();
  }
  catch(Exception e) {
    e.printStackTrace();
  }
}

public void renderData()
{
  edNameMat1.setText(data.material);
  edNameMat.setText(data.mater_name);
  edMarkMat.setText(data.mater_mark);
  edNDMark.setText(data.mater_mark_nd);
  edNDSort.setText(data.mater_sort_nd);
  edVidZagot.setText(data.mater_zagot);
  edMatShifr.setText(data.mater_shifr);
  edDensity.setText(LUtil.float2string(data.density, 8));
}

public void saveToUserData()
{
//  String sObj=null;
//  int len;
  try
  {
    data.material = edNameMat1.getText();
    data.mater_name = edNameMat.getText();
    data.mater_mark = edMarkMat.getText();
    data.mater_mark_nd = edNDMark.getText();
    data.mater_sort_nd = edNDSort.getText();
    data.mater_zagot = edVidZagot.getText();
    data.mater_shifr = edMatShifr.getText();
  }
  catch (Exception ex)
  {
    MessageBox.post(ex);
  }
}

private void jbInit() throws Exception {
  this.setLayout(borderLayout1);
  jLabel7.setText("Наименование материала");
  edNameMat.setMinimumSize(new Dimension(250, 21));
  edNameMat.setEditable(false);
  edNameMat.setEnabled(false);
  edNameMat.setPreferredSize(new Dimension(250, 21));
  jLabel12.setText("НД на марку");
  edMarkMat.setMinimumSize(new Dimension(100, 21));
  edMarkMat.setEditable(false);
  edMarkMat.setEnabled(false);
  LNDSort.setText("НД на сортамент");
  edNDSort.setMinimumSize(new Dimension(100, 21));
  edNDSort.setPreferredSize(new Dimension(100, 21));
  edNDSort.setEditable(false);
  edNDSort.setEnabled(false);
  jLabel17.setText("Марка");
  LSort.setText("Сортамент");
  MainPanel.setLayout(gridBagLayout3);
  jLabel25.setText(".");
  MainPanel.setMinimumSize(new Dimension(400, 350));
  MainPanel.setPreferredSize(new Dimension(400, 350));
  jLabel19.setText("Код IMBASE");
  edNameMat1.setPreferredSize(new Dimension(250, 21));
  edNameMat1.setMinimumSize(new Dimension(250, 21));
  edNameMat1.setEditable(false);
  edNameMat1.setEnabled(false);
  edNDMark.setEditable(false);
  edNDMark.setEnabled(false);
  edVidZagot.setEditable(false);
  edVidZagot.setEnabled(false);
  jLabel110.setText("Плотность");
  rbZagot.setText("Вспомогательный материал");
  jpMaterial.setLayout(gridBagLayout7);
  jpMaterial.setPreferredSize(new Dimension(500, 100));
  jpMaterial.setOpaque(true);
  jpMaterial.setMinimumSize(new Dimension(500, 100));
  btMaterial.setBackground(new Color(160, 204, 153));
  btMaterial.setFont(new java.awt.Font("Dialog", 1, 12));
  btMaterial.setMaximumSize(new Dimension(100, 21));
  btMaterial.setMinimumSize(new Dimension(21, 21));
  btMaterial.setPreferredSize(new Dimension(25, 21));
  btMaterial.setToolTipText("Вставить обозначение объекта (Материала/Заготовки) из буфера обмена");
  btMaterial.setHorizontalTextPosition(SwingConstants.CENTER);
  btMaterial.setMargin(new Insets(0, 0, 0, 0));
  btMaterial.setText("<");
  btMaterial.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
      btMaterial_actionPerformed(e);
    }
  });
  btMaterial.setBackground(Color.green);
  btMaterial.setFont(new java.awt.Font("Dialog", 1, 12));
  btMaterial.setMaximumSize(new Dimension(21, 21));
  btMaterial.setMinimumSize(new Dimension(21, 21));
  btMaterial.setPreferredSize(new Dimension(21, 21));
  btMaterial.setMargin(new Insets(0, 0, 0, 0));
  btMaterial.setText("<");
  rbMat.setSelected(true);
  rbMat.setText("Материал");
  btMaterial1.setText("<");
  btMaterial1.setMargin(new Insets(0, 0, 0, 0));
  btMaterial1.setPreferredSize(new Dimension(21, 21));
  btMaterial1.setMinimumSize(new Dimension(21, 21));
  btMaterial1.setMaximumSize(new Dimension(21, 21));
  btMaterial1.setFont(new java.awt.Font("Dialog", 1, 12));
  btMaterial1.setBackground(Color.green);
  btMaterial1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
      btMaterial1_actionPerformed(e);
    }
  });
  btMaterial1.setText("M");
  btMaterial1.setMargin(new Insets(0, 0, 0, 0));
  btMaterial1.setHorizontalTextPosition(SwingConstants.CENTER);
  btMaterial1.setToolTipText("Вставить Материал из внешней БД");
  btMaterial1.setPreferredSize(new Dimension(25, 21));
  btMaterial1.setMinimumSize(new Dimension(21, 21));
  btMaterial1.setMaximumSize(new Dimension(100, 21));
  btMaterial1.setFont(new java.awt.Font("Dialog", 1, 12));
  btMaterial1.setBackground(new Color(177, 224, 224));
  btMaterial1.setBackground(new Color(142, 230, 230));
  btMaterial1.setFont(new java.awt.Font("Dialog", 1, 12));
  btMaterial1.setMaximumSize(new Dimension(21, 21));
  btMaterial1.setMinimumSize(new Dimension(21, 21));
  btMaterial1.setPreferredSize(new Dimension(21, 21));
  btMaterial1.setMargin(new Insets(0, 0, 0, 0));
  btMaterial1.setText("M");
  edDensity.setMinimumSize(new Dimension(80, 20));
  edDensity.setPreferredSize(new Dimension(80, 20));
  edDensity.setText("");
  edDensity.setEditable(false);
  edDensity.setEnabled(false);
  btMaterialClr.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(ActionEvent e) {
      btMaterialClr_actionPerformed(e);
    }
  });
  btMaterialClr.setText("x");
  btMaterialClr.setMargin(new Insets(0, 0, 0, 0));
  btMaterialClr.setHorizontalTextPosition(SwingConstants.CENTER);
  btMaterialClr.setToolTipText("Удалить");
  btMaterialClr.setPreferredSize(new Dimension(25, 21));
  btMaterialClr.setMinimumSize(new Dimension(21, 21));
  btMaterialClr.setMaximumSize(new Dimension(100, 21));
  btMaterialClr.setFont(new java.awt.Font("Dialog", 1, 12));
  btMaterialClr.setBackground(Color.pink);
  btMaterialClr.setBackground(Color.pink);
  btMaterialClr.setFont(new java.awt.Font("Dialog", 1, 12));
  btMaterialClr.setMaximumSize(new Dimension(21, 21));
  btMaterialClr.setMinimumSize(new Dimension(21, 21));
  btMaterialClr.setPreferredSize(new Dimension(21, 21));
  btMaterialClr.setMargin(new Insets(0, 0, 0, 0));
  btMaterialClr.setText("x");
  jLabel8.setText("Материал");
  jLabel8.setHorizontalTextPosition(SwingConstants.CENTER);
  jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
  jLabel8.setAlignmentX((float) 0.5);
  jLabel8.setFont(new java.awt.Font("Dialog", 1, 14));
  edMatShifr.setEditable(false);
  edMatShifr.setEnabled(false);
  edMatShifr.setColumns(0);
  jLabel1.setFont(new java.awt.Font("Dialog", 3, 12));
  jLabel1.setForeground(Color.blue);
  jLabel1.setText("Проверьте правильность автоматического определения следующих полей:");
  MainPanel.add(jLabel7,                         new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 5, 5, 5), 0, 0));
  MainPanel.add(edNameMat,                        new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 5, 5, 5), 0, 0));
  MainPanel.add(jLabel12,                      new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
  MainPanel.add(edMarkMat,                      new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
  MainPanel.add(LNDSort,                      new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
  MainPanel.add(edNDSort,                       new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
  MainPanel.add(jLabel17,                      new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
  MainPanel.add(edNDMark,                      new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
  MainPanel.add(LSort,                     new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
  MainPanel.add(edVidZagot,                     new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
  MainPanel.add(jLabel25,                      new GridBagConstraints(0, 9, 1, 1, 0.0, 1.0
          ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  MainPanel.add(jpMaterial,              new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0
          ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
  jpMaterial.add(rbZagot, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
  jpMaterial.add(rbMat, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
  jpMaterial.add(jLabel110, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0
          ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
  jpMaterial.add(edDensity,  new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
          ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 2), 0, 0));
  jpMaterial.add(btMaterial, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
          ,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
  jpMaterial.add(btMaterial1, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
          ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
  jpMaterial.add(btMaterialClr, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
          ,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
  jpMaterial.add(edNameMat1,  new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0
          ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 2), 0, 0));
  MainPanel.add(jLabel8,        new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0
          ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
  MainPanel.add(jLabel19,    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
          ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
  MainPanel.add(edMatShifr,     new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
          ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
  MainPanel.add(jLabel1,   new GridBagConstraints(0, 3, 3, 1, 0.0, 0.0
          ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));

  this.add(MainPanel, BorderLayout.NORTH);
  bgMat.add(rbMat);
  bgMat.add(rbZagot);
}
void btMaterial_actionPerformed(ActionEvent e)
{

}
void btMaterialClr_actionPerformed(ActionEvent e)
{

}

// --- !!! Логика должна соответствовать abstractSelMatDlg.makeMatString

public void setNameSpec()
{
 String sNDSort = edNDSort.getText();
 String sNDMark = edNDMark.getText();
 String sVidZagot = edVidZagot.getText();
 String sMarkMat = edMarkMat.getText();

 // Сформировать строку для спец-ии
 String sNameSpec = (sVidZagot);// + " " + sNDSort).trim();
if (sVidZagot==null || sVidZagot.length()==0)
   sNameSpec = edNameMat.getText();
/* -- Была попытка добавлять в полное маименование компоненты, если их нет
 * но это не правильно, т.к. необходимо строгое формирование как в IMBASE 
 * без волюнтаризма
 * --
 if (sNameSpec.indexOf(sNDSort)<0)
   sNameSpec = (sNameSpec + " " + sNDSort).trim();
 if (sNameSpec.indexOf(sMarkMat)<0)
   sNameSpec = (sNameSpec + " " + sMarkMat).trim();
 if (sNameSpec.indexOf(sNDMark)<0)
   sNameSpec = (sNameSpec + " " + sNDMark).trim();
 */
 // -- проверим составные части и обрежем если надо
 int i = sVidZagot.indexOf(sMarkMat);
 if (i>-1 && sMarkMat.length()>0)
 {
   // выделить сортамент с гостом
   sVidZagot = sVidZagot.substring(0, i-1);
   if (sVidZagot.endsWith("/"))
     sVidZagot = sVidZagot.substring(0, sVidZagot.length()-1);
   // выделить ГОСТ на марку
   int j = sNDSort.indexOf(sMarkMat);
   String sNDSort1 = "";
   if (j>-1)
   {
     sNDSort1 = sNDSort.substring(0, j).trim();
     sNDMark = sNDSort.substring(j + sMarkMat.length()).trim();
     if (sNDSort1.endsWith("/"))
       sNDSort1 = sNDSort1.substring(0, sNDSort1.length()-1);
     edNDSort.setText(sNDSort1);
     edNDMark.setText(sNDMark);
     sNDSort = sNDSort1;
   }
 }
 // выделить один сортамент
 if (sVidZagot.endsWith(sNDSort))
   sVidZagot = sVidZagot.substring(0, sVidZagot.indexOf(sNDSort)).trim();

 edVidZagot.setText(sVidZagot);

 edNameMat1.setText(sNameSpec);
}

void btMaterial1_actionPerformed(ActionEvent e)
{
  if (rbMat.isSelected())
  {
    SelectMatDlg3 dlg = new SelectMatDlg3(btMaterial1, 1, session);
    if (dlg.sMatShifr != null)
    {
      edNameMat.setText(dlg.sMatName);
      edMarkMat.setText(dlg.sMatMark);
      edNDMark.setText(dlg.sMatNDMark);
      edVidZagot.setText(dlg.sMatSort);
      edNDSort.setText(dlg.sMatNDSort);
      edMatShifr.setText(dlg.sIMBASE_Code);//sMatShifr);
      edDensity.setText(LUtil.float2string(dlg.fDensity, 8));
      data.density = dlg.fDensity;
      data.code_okp = dlg.sMatShifr;

      //lockMatProps();
      setNameSpec();
    }
  }
  else if (rbZagot.isSelected())
  {
    SelectZagDlg2 dlg = new SelectZagDlg2(btMaterial1, SelectZagDlg2.cstAuxMat, session);
    if (dlg.sMatShifr != null)
    {
      edNameMat.setText(dlg.sMatName);
      edNDSort.setText(dlg.sMatNDSort);
      edVidZagot.setText(dlg.sMatSort);
      edMarkMat.setText("");
      edNDMark.setText("");
      edMatShifr.setText(dlg.sIMBASE_Code);//"0-"+dlg.sMatShifr);
      edDensity.setText(LUtil.float2string(dlg.fDensity, 8));
      data.density = dlg.fDensity;
      data.code_okp = "0-"+dlg.sMatShifr;

      //lockMatProps();
      setNameSpec();
    }
  }
}
}


