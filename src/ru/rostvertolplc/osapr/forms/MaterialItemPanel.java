package ru.rostvertolplc.osapr.forms;

import javax.swing.border.TitledBorder;


import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.kernel.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import ru.rostvertolplc.osapr.util.*;
import ru.rostvertolplc.osapr.extmaterial.*;
//import com.LANIT.util.LUtil;

//import com.LANIT.util.*;
//import com.LANIT.regbook.*;


public class MaterialItemPanel extends JPanel
{
  DSEUserData data = null;
  //Registry R = Registry.getRegistry("com.avid.forms.forms");
  public TCSession session;

  JTabbedPane TabbedPane = new JTabbedPane();
  JPanel MainPanel = new JPanel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  TitledBorder titledBorder4;
  private JLabel jLabel6 = new JLabel();
  private JLabel jLabel14 = new JLabel();
  private JTextField edMatShifr = new JTextField();
  BorderLayout borderLayout1 = new BorderLayout();
  private JLabel jLabel8 = new JLabel();
  private JTextField edNameMat = new TextFieldDocument(128);
  private JTextField edMarkMat = new TextFieldDocument(64);
  private JTextField edNDMark = new TextFieldDocument(64);
  JTextField edNDSort = new TextFieldDocument(64);
  JTextField edVidZagot = new TextFieldDocument(128);
  private JLabel jLabel17 = new JLabel();
  private JLabel jLabel18 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel16 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField edFullName = new JTextField();
  JTextField edDensity = new JTextField();
  JRadioButton rbMaterial = new JRadioButton();
  JRadioButton rbZagotovka = new JRadioButton();
  JButton btMaterial1 = new JButton();
  ButtonGroup bgMatZag = new ButtonGroup();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField edLength = new JTextField();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField edWidth = new JTextField();
  JTextField edDepth = new JTextField();
  JTextField edMassa = new JTextField();
  JCheckBox chbFromModel = new JCheckBox();

  public MaterialItemPanel()
  {
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public MaterialItemPanel(DSEUserData theData)
  {
    data = theData;
    if (data.form!=null)
      session = (TCSession)data.form.getSession();
    try
    {
      jbInit();
      renderData();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  void renderData()
  {
	String item_id="";
	try { item_id = data.item.getProperty("item_id"); }
	catch (TCException e) { }
    // Отображаемое поле
    //edIndication.setText(data.name_dse);
    edMatShifr.setText(data.code_dse);
    rbZagotovka.setSelected(item_id.startsWith("0-"));
    lockMatProps(data.density);
    // Реальные поля
    edNameMat.setText(data.vid_obrab);
    edMarkMat.setText(data.mater_mark);
    edNDSort.setText(data.mater_sort_nd);
    edNDMark.setText(data.mater_mark_nd);
    edVidZagot.setText(data.mater_zagot);
    edFullName.setText(data.material);
    edDensity.setText(LUtil.float2string(data.density, 8));

    edMassa.setText(  LUtil.float2string(data.massa, 6) );
    edMassa.setEnabled(!data.pr_from_model);
    chbFromModel.setSelected(data.pr_from_model);

    // габариты
    String saGab[] = data.gabarit.split("x", 3);
    if (saGab.length < 3) saGab = new String[]{"", "", ""};
    edLength.setText(saGab[0]);
    edWidth.setText(saGab[1]);
    edDepth.setText(saGab[2]);

  }

  void saveToUserData()
  {

    try
    {
      //data.name_dse = edIndication.getText();
      data.code_dse = edMatShifr.getText();
      data.material = edFullName.getText();
      data.mater_mark = edMarkMat.getText();
      data.mater_sort_nd = edNDSort.getText();
      data.mater_mark_nd = edNDMark.getText();
      data.mater_zagot = edVidZagot.getText();
      data.vid_obrab = edNameMat.getText();
      data.density = LUtil.string2float(edDensity.getText());
      data.gabarit = edLength.getText()+'x'+edWidth.getText()+'x'+edDepth.getText();

      data.massa = LUtil.string2float(edMassa.getText());
      data.pr_from_model = chbFromModel.isSelected();
    }
    catch (Exception ex)
    {
      MessageBox.post(ex);
    }
  }

  private void jbInit() throws Exception
  {
	 
    this.setLayout(borderLayout1);
    TabbedPane.setEnabled(true);
    TabbedPane.setMinimumSize(new Dimension(500, 350));
    TabbedPane.setPreferredSize(new Dimension(500, 350));
    MainPanel.setLayout(gridBagLayout3);
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel6.setAlignmentX( (float) 0.5);
    jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel6.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel6.setText("Материал");
    MainPanel.setMinimumSize(new Dimension(400, 300));
    MainPanel.setPreferredSize(new Dimension(400, 300));
    jLabel14.setText("Шифр материала");
    jLabel8.setText("Наименование материала");
    edMatShifr.setBackground(UIManager.getColor("Button.background"));
    edMatShifr.setEnabled(false);
    edMatShifr.setMinimumSize(new Dimension(150, 21));
    edMatShifr.setPreferredSize(new Dimension(150, 21));
    edMatShifr.setEditable(false);
    jLabel17.setText("Марка материала");
    edVidZagot.setMinimumSize(new Dimension(150, 21));
    edVidZagot.setPreferredSize(new Dimension(150, 21));
    edVidZagot.setEditable(false);
    edVidZagot.setEnabled(false);
    jLabel18.setText("Вид заготовки");
    edNameMat.setMinimumSize(new Dimension(250, 21));
    edNameMat.setPreferredSize(new Dimension(250, 21));
    edNameMat.setEditable(false);
    edNameMat.setEnabled(false);
    this.setMinimumSize(new Dimension(500, 300));
    this.setPreferredSize(new Dimension(500, 300));
    edMarkMat.setMinimumSize(new Dimension(250, 21));
    edMarkMat.setPreferredSize(new Dimension(250, 21));
    edMarkMat.setEditable(true);
    edMarkMat.setEnabled(false);
    edNDMark.setMinimumSize(new Dimension(250, 21));
    edNDMark.setPreferredSize(new Dimension(250, 21));
    edNDMark.setEditable(false);
    edNDMark.setEnabled(false);
    edNDSort.setMinimumSize(new Dimension(250, 21));
    edNDSort.setPreferredSize(new Dimension(250, 21));
    edNDSort.setEditable(false);
    edNDSort.setEnabled(false);
    jLabel16.setText("НД на сортамент");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("Обозначение материала");
    jLabel4.setText("Плотность");
    edFullName.setMinimumSize(new Dimension(100, 21));
    edFullName.setPreferredSize(new Dimension(100, 21));
    edFullName.setText("");
    edFullName.setEditable(false);
    edFullName.setEnabled(false);
    edDensity.setMinimumSize(new Dimension(80, 21));
    edDensity.setPreferredSize(new Dimension(80, 21));
    edDensity.setText("");
    rbMaterial.setFont(new java.awt.Font("Dialog", 1, 12));
    rbMaterial.setSelected(true);
    rbMaterial.setText("Материал");
    rbZagotovka.setFont(new java.awt.Font("Dialog", 1, 12));
    rbZagotovka.setText("Вспомогательный материал МВЗ");
    btMaterial1.setText("<");
    btMaterial1.setMargin(new Insets(0, 0, 0, 0));
    btMaterial1.setPreferredSize(new Dimension(21, 21));
    btMaterial1.setMinimumSize(new Dimension(21, 21));
    btMaterial1.setMaximumSize(new Dimension(21, 21));
    btMaterial1.setFont(new java.awt.Font("Dialog", 1, 12));
    btMaterial1.setBackground(Color.green);
    btMaterial1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
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
    jLabel2.setToolTipText("");
    jLabel2.setText("НД на Марку");
    jLabel5.setText("Наименование");
    jLabel7.setText("Длина");
    edLength.setMinimumSize(new Dimension(80, 20));
    edLength.setPreferredSize(new Dimension(80, 20));
    edLength.setRequestFocusEnabled(true);
    edLength.setToolTipText("");
    edLength.setSelectionStart(11);
    edLength.setText("");
    edLength.setColumns(0);
    jLabel9.setText("Ширина");
    jLabel10.setText("Высота");
    edWidth.setMinimumSize(new Dimension(80, 20));
    edWidth.setPreferredSize(new Dimension(80, 20));
    edWidth.setRequestFocusEnabled(true);
    edWidth.setText("");
    edWidth.setColumns(0);
    edDepth.setMinimumSize(new Dimension(80, 20));
    edDepth.setPreferredSize(new Dimension(80, 20));
    edDepth.setRequestFocusEnabled(true);
    edDepth.setColumns(0);
    edMassa.setMinimumSize(new Dimension(140, 21));
    edMassa.setPreferredSize(new Dimension(140, 21));
    edMassa.setHorizontalAlignment(SwingConstants.LEADING);
    chbFromModel.setHorizontalTextPosition(SwingConstants.LEADING);
    chbFromModel.setText("Масса из модели");
    chbFromModel.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        chbFromModel_actionPerformed(e);
      }
    });
    MainPanel.add(jLabel14,                    new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 30, 5, 5), 0, 0));
    MainPanel.add(edMatShifr,                     new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    MainPanel.add(edNameMat,                   new GridBagConstraints(1, 3, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    MainPanel.add(edNDMark,                  new GridBagConstraints(1, 5, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    TabbedPane.add(MainPanel, "Общие данные");

    this.add(jLabel6, BorderLayout.NORTH);
    this.add(TabbedPane, BorderLayout.CENTER);
    MainPanel.add(jLabel1,                  new GridBagConstraints(0, 11, 5, 1, 0.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    MainPanel.add(jLabel17,                   new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0));
    MainPanel.add(jLabel18,                   new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 5, 5), 0, 0));
    MainPanel.add(edMarkMat,                  new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    MainPanel.add(edNDSort,                  new GridBagConstraints(1, 7, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    MainPanel.add(edVidZagot,                      new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    MainPanel.add(jLabel16,                  new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0));
    MainPanel.add(jLabel4,                  new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 30, 0, 0), 0, 0));
    MainPanel.add(edDensity,                    new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(20, 5, 5, 0), 0, 0));
    MainPanel.add(rbMaterial,                    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 10, 0, 0), 0, 0));
    MainPanel.add(jLabel2,                   new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0));
    MainPanel.add(jLabel5,                    new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 0, 0));
    MainPanel.add(jLabel7,                      new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, new Insets(0, 20, 5, 5), 0, 0));
    MainPanel.add(edLength,                   new GridBagConstraints(3, 8, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
    MainPanel.add(jLabel9,                   new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, new Insets(0, 20, 5, 5), 0, 0));
    MainPanel.add(jLabel10,                new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, new Insets(0, 20, 5, 5), 0, 0));
    MainPanel.add(edWidth,            new GridBagConstraints(3, 9, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
    MainPanel.add(edDepth,            new GridBagConstraints(3, 10, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
    MainPanel.add(edMassa,            new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 0), 0, 0));
    MainPanel.add(chbFromModel,           new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 25, 0, 0), 0, 0));
    MainPanel.add(rbZagotovka,      new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
    MainPanel.add(jLabel3,   new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 10, 10, 0), 0, 0));
    MainPanel.add(edFullName,   new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(20, 5, 10, 0), 0, 0));
    MainPanel.add(btMaterial1,     new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(15, 2, 5, 10), 0, 0));
    bgMatZag.add(rbMaterial);
    bgMatZag.add(rbZagotovka);
  }

/*
  public void setNameSpec1()
  {
    String sNDSort = edNDSort.getText();
    String sNDMark = edNDMark.getText();
    String sVidZagot = edVidZagot.getText();
    // Сформировать строку для спец-ии
    String sNameSpec = (sVidZagot + " " + sNDSort).trim();
    if (sVidZagot.length()==0)
      sNameSpec = (sNameSpec + " " + edNameMat.getText()).trim();
    sNameSpec = (sNameSpec + " " + edMarkMat.getText()).trim();
    if (!sNDSort.equals(sNDMark))
      sNameSpec = (sNameSpec + " " + sNDMark).trim();
    edFullName.setText(sNameSpec);
  }
*/

  void lockMatProps(double dens)
  {
    boolean нет_шифра = edMatShifr.getText().length() == 0;
    edFullName.setEditable(нет_шифра);
    edNameMat.setEditable(нет_шифра);
    edNDMark.setEditable(нет_шифра);
    edNDSort.setEditable(нет_шифра);
    edMarkMat.setEditable(нет_шифра);
    edVidZagot.setEditable(нет_шифра);
    btMaterial1.setEnabled(нет_шифра);
    edDensity.setEnabled(нет_шифра || dens==0.0);
  }

  public void setNameSpec()
  {
    String sNDSort = edNDSort.getText();
    String sNDMark = edNDMark.getText();
    String sVidZagot = edVidZagot.getText();
    String sMarkMat = edMarkMat.getText();
   
    // Сформировать строку для спец-ии
    String sNameSpec = (sVidZagot);// + " " + sNDSort).trim();
    if (sVidZagot.length()==0)
      sNameSpec = edNameMat.getText();
    if (sNameSpec.indexOf(sNDSort)<0)
      sNameSpec = (sNameSpec + " " + sNDSort).trim();
    if (sNameSpec.indexOf(sMarkMat)<0)
      sNameSpec = (sNameSpec + " " + sMarkMat).trim();
    if (sNameSpec.indexOf(sNDMark)<0)
      sNameSpec = (sNameSpec + " " + sNDMark).trim();
    // очистить вид заготовки от марки
    int i = sVidZagot.indexOf(sMarkMat);
    if (i>0)
      edVidZagot.setText(sVidZagot.substring(0, i-1));
    // очистить вид заготовки от НД на сортамент
    i = sVidZagot.indexOf(sNDSort);
    if (i>0)
      edVidZagot.setText(sVidZagot.substring(0, i-1));
    
    edFullName.setText(sNameSpec);
  }

  void btMaterial1_actionPerformed(ActionEvent e)
  {
    if (rbMaterial.isSelected())
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

        setNameSpec();
        lockMatProps(dlg.fDensity);
      }
    }
    else if (rbZagotovka.isSelected())
    {
      SelectZagDlg2 dlg = new SelectZagDlg2(btMaterial1, SelectZagDlg2.cstAuxMat, session);
      if (dlg.sMatShifr != null)
      {
        String sMatShifr = "0-"+dlg.sMatShifr;
        edNameMat.setText(dlg.sMatName);
        edNDSort.setText(dlg.sMatNDSort);
        edVidZagot.setText(dlg.sMatSort);
        edMarkMat.setText("");
        edNDMark.setText("");
        edMatShifr.setText(dlg.sIMBASE_Code);//sMatShifr);
        if (dlg.fDensity > -1)
          edDensity.setText(LUtil.float2string(dlg.fDensity, 8));

        setNameSpec();
        lockMatProps(dlg.fDensity);
      }
    }
  }

  void chbFromModel_actionPerformed(ActionEvent e)
  {
    if (e.getSource()==chbFromModel)
    {
      boolean bFromModel = chbFromModel.isSelected();
      if (e.getActionCommand().equals("Set"))
        bFromModel = data.pr_from_model;
      double Massa;
      //String sMassa;
      edMassa.setEnabled(!bFromModel);
      Massa = bFromModel? data.getMassFromModel() : data.massa;
      //sMassa = Double.toString(Massa);
      //edMassa.setText(sMassa);
      edMassa.setText(  LUtil.float2string(Massa, 6) );
    }
  }

}
