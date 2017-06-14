package ru.rostvertolplc.osapr.forms;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import ru.rostvertolplc.osapr.util.LUtil;
import ru.rostvertolplc.osapr.util.TextFieldDocument;
import java.awt.*;
import com.teamcenter.rac.form.lovcombobox.FormLOVCombobox;
import javax.swing.*;
import java.awt.event.*;
import com.teamcenter.rac.kernel.*;
import com.teamcenter.rac.aif.*;
import java.awt.datatransfer.*;
import java.util.*;
import ru.rostvertolplc.osapr.extmaterial.*;
import com.teamcenter.rac.common.lov.*;
import com.teamcenter.rac.util.*;
import ru.rostvertolplc.osapr.util.FloatVerifier;
import ru.rostvertolplc.osapr.regbook.*;

public class StdRevPanel extends JPanel implements InterfaceFormPanel
{
  private static final long serialVersionUID = 8026480773494394467L;
  NameResolver NR = new NameResolver();
  DSEUserData data = null;
  public JLabel LHeader = new JLabel();
  FloatVerifier floatVerifier = new FloatVerifier();
  TCSession session;
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel5= new JLabel();
  private JLabel jLabel9 = new JLabel();
  private TextFieldDocument edRoditel = new TextFieldDocument(128);
  private JLabel jLabel10 = new JLabel();
  private JTextField dateCreate = new JTextField();
  private TextFieldDocument edIndication = new TextFieldDocument(128);
  private TextFieldDocument edMarkMat = new TextFieldDocument(64);
  private TextFieldDocument edNDSort = new TextFieldDocument(64);
  private TextFieldDocument edNDMark = new TextFieldDocument(64);
  private TextFieldDocument edVidZagot = new TextFieldDocument(128);
  FormLOVCombobox icbLiter = new FormLOVCombobox();
  JTabbedPane TabbedPane = new JTabbedPane();
  JPanel MainPanel = new JPanel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JPanel jpVR = new JPanel();
  JPanel jpVR7 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JPanel jpVR10 = new JPanel();
  JPanel jpVR18 = new JPanel();
  GridBagLayout gridBagLayout4 = new GridBagLayout();
  GridBagLayout gridBagLayout5 = new GridBagLayout();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JTextField edMarkPlace = new TextFieldDocument(32);
  JLabel jLabel20 = new JLabel();
  JCheckBox chbVR10 = new JCheckBox();
  JLabel LVR10_TechPas = new JLabel();
  JTextField edVR10_TechPas = new JTextField();
  JLabel LVR10_Note = new JLabel();
  JTextArea edVR10_Note = new JTextArea();
  JCheckBox chbVR18 = new JCheckBox();
  JLabel LVR18_Note = new JLabel();
  JTextArea edVR18_Note = new JTextArea();
  private JLabel jLabel26 = new JLabel();
  private JLabel LCodeDSE = new JLabel();
  private JTextField edCodeDSE = new TextFieldDocument(15);
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayoutHead = new BorderLayout();
  GridBagLayout gridBagLayout6 = new GridBagLayout();
  private JLabel jLabel21 = new JLabel();
  private JTextField edNameFull = new TextFieldDocument(256);
  private JComboBox cbSoderMark = new JComboBox();
  private JComboBox cbSposobMark = new JComboBox();
  private JLabel jLabel6 = new JLabel();
  private JTextField edMassa = new JTextField();
  private TextFieldDocument edGOST = new TextFieldDocument(150);
  private JLabel jLabel110 = new JLabel();
  private DateButton dateChange = new DateButton();
  private JLabel jLabel24 = new JLabel();
  private TextFieldDocument edN_Izv = new TextFieldDocument(32);
  private JLabel vrtLogo = new JLabel();
  JCheckBox chbFromModel = new JCheckBox();
  JLabel jLabel8 = new JLabel();
  JTextField edType = new JTextField();
  JLabel jLabel12 = new JLabel();
  JTextField edRev = new JTextField();
  JLabel jLabel14 = new JLabel();
  LOVComboBox cbCAD = new LOVComboBox();
  JTextField edDepth = new JTextField();
  JPanel jpMaterial = new JPanel();
  JLabel jLabel16 = new JLabel();
  JTextField edWidth = new JTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel17 = new JLabel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JButton btMaterial1 = new JButton();
  JPanel jPanel1 = new JPanel();
  TextFieldDocument edNameMat = new TextFieldDocument(256);
  GridBagLayout gridBagLayout8 = new GridBagLayout();
  JRadioButton rbZagot = new JRadioButton();
  JRadioButton rbMat = new JRadioButton();
  JButton btMaterial = new JButton();
  GridBagLayout gridBagLayout7 = new GridBagLayout();
  JTextField edLength = new JTextField();
  JPanel jpMilx = new JPanel();
  JButton btMaterialClr = new JButton();
  ButtonGroup bgMat = new ButtonGroup();
  JLabel jLabel4 = new JLabel();
  JTextField edDensity = new JTextField();
  JLabel LNotSaved = new JLabel();
  JTextField edMatShifr = new JTextField();

  public StdRevPanel() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public StdRevPanel(DSEUserData theData) {
    data = theData;
    try {
      // vertol так как item может быть не определен
      session = data.item != null ? (TCSession)data.item.getSession() : (TCSession)data.form.getSession();
      jbInit();
      renderData();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  void setMassColor(double flag)
  {
    if (flag == 1)
    {
      edMassa.setBackground(new Color(255, 200, 200));
      edMassa.setForeground(Color.RED);
      edMassa.setDisabledTextColor(Color.MAGENTA);
    }
    if (flag == 0)
    {
      edMassa.setBackground(edDensity.getBackground());
      edMassa.setForeground(Color.BLACK);
      edMassa.setDisabledTextColor(Color.GRAY);
    }
  }

  public void renderData()
  {
    // Отображаемое поле
	// vertol, так как item может быть не определен при создании нового объекта
	  if (data.item != null) {
		edType.setText(data.item.getType());
	}
    edCodeDSE.setText(data.code_dse);
    edIndication.setText(data.indication);
    edNameFull.setText(data.name_dse);
    edRev.setText(data.revision);
    LNotSaved.setVisible(data.sc==null);
    // Реальные поля
    dateCreate.setText(LUtil.Date2String(data.date_create_obj));
    dateChange.setDate(data.change_date);
    edN_Izv.setText(data.izv_id);
    edMassa.setText(  LUtil.float2string(data.massa, 6) );
    edMassa.setEnabled(!data.pr_from_model);
    setMassColor(data.kim);
    chbFromModel.setSelected(data.pr_from_model);
    edDensity.setText(LUtil.float2string(data.density, 8));
    edGOST.setText( data.gost );
    edNameMat.setText( data.material );
    edMatShifr.setText(data.mater_shifr);
   // Базовая CAD-система
   cbCAD.setLOVComponent(data.NR.lov_CADSYS);
   cbCAD.setSelectedItem(data.cad_sys);
   // Литера
   try
   {
     icbLiter.load(data.form);
   }
   catch (Exception ex)
   {
     ex.printStackTrace();
     MessageBox.post(ex);
   }
   // Габариты
   String saGab[] = data.gabarit.split("x", 3);
   if (saGab.length < 3) saGab = new String[]{"", "", ""};
   edLength.setText(saGab[0]);
   edWidth.setText(saGab[1]);
   edDepth.setText(saGab[2]);
    /*
    // Содержание маркировки
    cbSoderMark.addItem("");
    for (int i=0; i<data.lov_sodermark.length; i++) {  cbSoderMark.addItem(data.lov_sodermark[i]); }
    cbSoderMark.setSelectedItem(data.vr7_sod_mark);
    // Способ нанесения маркировки
    cbSposobMark.addItem("");
    for (int i=0; i<data.lov_sposobmark.length; i++) {  cbSposobMark.addItem(data.lov_sposobmark[i]); }
    cbSposobMark.setSelectedItem(data.vr7_spo_nanes);
    */
  }

  public void saveToUserData()
  {
    try
    {
      data.change_date = dateChange.getDate();
      data.izv_id = edN_Izv.getText();
      data.massa = LUtil.string2float(edMassa.getText());
      data.pr_from_model = chbFromModel.isSelected();
      data.density = LUtil.string2float(edDensity.getText());
      data.liter1 = icbLiter.getSelectedString();
      data.material = edNameMat.getText();
      data.mater_shifr = edMatShifr.getText();
      data.cad_sys = LUtil.getSelectedStrCB(cbCAD);
      data.gabarit = edLength.getText()+'x'+edWidth.getText()+'x'+edDepth.getText();
    }
    catch (Exception ex)
    {
      MessageBox.post(ex);
    }
  }

  public void setHeader(String s)
  {
    LHeader.setText(s);
  }

  private void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    edNameMat.setEditable(false);
    edNameMat.setEnabled(false);
    jLabel5.setText("Обозначение");
    jLabel1.setText("Наименование");
    jLabel2.setText("ГОСТ / ОСТ / НОРМАЛЬ");
    jLabel9.setText("Родитель");
    edRoditel.setBackground(new Color(204, 204, 204));
    edRoditel.setMinimumSize(new Dimension(20, 21));
    edRoditel.setPreferredSize(new Dimension(100, 21));
    edRoditel.setColumns(64);
    jLabel10.setText("Дата создания");
    dateCreate.setBorder(BorderFactory.createLineBorder(Color.black));
    dateCreate.setMinimumSize(new Dimension(150, 21));
    dateCreate.setPreferredSize(new Dimension(150, 21));
    dateCreate.setToolTipText("");
    dateCreate.setEditable(false);
    dateCreate.setText("< Дата не задана >");
    dateCreate.setHorizontalAlignment(SwingConstants.CENTER);
    edIndication.setBackground(new Color(255, 217, 217));
    edIndication.setMaximumSize(new Dimension(600, 21));
    edIndication.setMinimumSize(new Dimension(20, 21));
    edIndication.setPreferredSize(new Dimension(20, 21));
    edIndication.setEditable(false);
    edIndication.setHorizontalAlignment(SwingConstants.TRAILING);
    TabbedPane.setEnabled(true);
    TabbedPane.setMinimumSize(new Dimension(500, 400));
    TabbedPane.setPreferredSize(new Dimension(500, 400));
    MainPanel.setLayout(gridBagLayout3);
    jpVR.setLayout(gridBagLayout6);
    jpVR7.setLayout(gridBagLayout1);
    jpVR10.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"ВР 10 - Технологический паспорт"));
    jpVR10.setMinimumSize(new Dimension(100, 150));
    jpVR10.setPreferredSize(new Dimension(444, 150));
    jpVR10.setLayout(gridBagLayout4);
    jpVR7.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"ВР 7 - Ведомость маркируемых деталей"));
    jpVR7.setMinimumSize(new Dimension(100, 130));
    jpVR7.setPreferredSize(new Dimension(434, 130));
    jpVR18.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"ВР 18 - Детали по директивным технологиям"));
    jpVR18.setMinimumSize(new Dimension(100, 130));
    jpVR18.setPreferredSize(new Dimension(434, 130));
    jpVR18.setLayout(gridBagLayout5);
    jLabel11.setText("Способ нанесения маркировки");
    jLabel19.setText("Место нанесения маркировки");
    jLabel20.setText("Содержание маркировки");
    chbVR10.setHorizontalTextPosition(SwingConstants.RIGHT);
    chbVR10.setText("Признак вхождения в ВР 10");
    chbVR10.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        chbVR_stateChanged(e);
      }
    });
    LVR10_TechPas.setText("Технолог. паспорт");
    edVR10_TechPas.setMinimumSize(new Dimension(200, 21));
    edVR10_TechPas.setPreferredSize(new Dimension(200, 21));
    LVR10_Note.setText("Примечание ВР 10");
    edVR10_Note.setMinimumSize(new Dimension(250, 34));
    edVR10_Note.setPreferredSize(new Dimension(250, 34));
    edVR10_Note.setRows(2);
    chbVR18.setText("Признак вхождения в ВР 18");
    chbVR18.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        chbVR_stateChanged(e);
      }
    });
    LVR18_Note.setText("Примечание ВР 18");
    edVR18_Note.setMinimumSize(new Dimension(250, 34));
    edVR18_Note.setPreferredSize(new Dimension(250, 34));
    edVR18_Note.setRows(2);
    jLabel26.setText(".");
    LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
    LHeader.setAlignmentX((float) 0.5);
    LHeader.setHorizontalAlignment(SwingConstants.CENTER);
    LHeader.setHorizontalTextPosition(SwingConstants.CENTER);
    LHeader.setText("Стандартное изделие - Модификация");
    vrtLogo.setText("");
    try {
		vrtLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(FormConsts.sVertolLogo)));
	} catch (Exception e) {
		// TODO: handle exception
	}
	vrtLogo.setAlignmentX((float) 0.5);
    vrtLogo.setHorizontalAlignment(SwingConstants.CENTER);
    vrtLogo.setHorizontalTextPosition(SwingConstants.CENTER);
    MainPanel.setMinimumSize(new Dimension(400, 320));
    MainPanel.setPreferredSize(new Dimension(400, 320));
    jpVR.setMinimumSize(new Dimension(110, 400));
    jpVR.setPreferredSize(new Dimension(444, 400));
    LCodeDSE.setForeground(Color.gray);
    LCodeDSE.setText("Код ДСЕ");
    jLabel21.setText("Литера");
    edNameFull.setBackground(new Color(255, 217, 217));
    edNameFull.setMinimumSize(new Dimension(20, 21));
    edNameFull.setPreferredSize(new Dimension(150, 21));
    edNameFull.setEditable(false);
    edNameFull.setColumns(0);
    icbLiter.setMinimumSize(new Dimension(50, 21));
    icbLiter.setFormProperty(NR.fld_LITER1);
    icbLiter.setPreferredSize(new Dimension(50, 21));
    icbLiter.setLovName(NR.lov_LITERA);
    jLabel6.setText("Масса");
    edMassa.setMinimumSize(new Dimension(140, 21));
    edMassa.setPreferredSize(new Dimension(140, 21));
    edGOST.setPreferredSize(new Dimension(20, 21));
    edGOST.setEditable(false);
    edGOST.setBackground(new Color(255, 217, 217));
    edGOST.setMinimumSize(new Dimension(20, 21));
    jLabel110.setText("Дата изменения");
    dateChange.setTitle("sas");
    dateChange.setDisplayFormat("dd.MM.yyyy");
    dateChange.setText("< Дата не задана >");
    dateChange.setToolTipText("");
    dateChange.setPreferredSize(new Dimension(150, 21));
    dateChange.setMinimumSize(new Dimension(150, 21));
    jLabel24.setText(" N ИИ (ПИ)");
    edN_Izv.setMinimumSize(new Dimension(100, 21));
    edN_Izv.setPreferredSize(new Dimension(100, 21));
    edCodeDSE.setBackground(UIManager.getColor("Button.background"));
    edCodeDSE.setForeground(Color.gray);
    edCodeDSE.setBorder(null);
    edCodeDSE.setEditable(false);
    chbFromModel.setText("Из модели");
    chbFromModel.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        chbFromModel_actionPerformed(e);
      }
    });
    jLabel8.setText("Вид изделия");
    edType.setFont(new java.awt.Font("Dialog", 1, 11));
    edType.setEditable(false);
    edType.setText("");
    jLabel12.setText("Ревизия");
    edRev.setText("");
    edRev.setEditable(false);
    edRev.setMinimumSize(new Dimension(80, 20));
    edRev.setPreferredSize(new Dimension(80, 20));
    jLabel14.setToolTipText("");
    jLabel14.setText("Базовая CAD-система");
    edDepth.setInputVerifier(floatVerifier);
    edDepth.setText("");
    jpMaterial.setLayout(gridBagLayout7);
    jpMaterial.setPreferredSize(new Dimension(500, 100));
    jpMaterial.setOpaque(true);
    jpMaterial.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(165, 163, 151)),"Материал"));
    jpMaterial.setMinimumSize(new Dimension(500, 100));
    jLabel16.setText("Длина, (мм)");
    edWidth.setInputVerifier(floatVerifier);
    edWidth.setText("");
    jLabel18.setText("Глубина, (мм)");
    jLabel17.setText("Ширина, (мм)");
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
    jPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(165, 163, 151)),"Габаритные размеры"));
    jPanel1.setMinimumSize(new Dimension(200, 100));
    jPanel1.setPreferredSize(new Dimension(200, 100));
    jPanel1.setLayout(gridBagLayout2);
    edNameMat.setMinimumSize(new Dimension(250, 21));
    edNameMat.setPreferredSize(new Dimension(250, 21));
    rbZagot.setText("Вспомогательный материал");
    rbMat.setSelected(true);
    rbMat.setText("Материал");
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
    edLength.setMinimumSize(new Dimension(62, 20));
    edLength.setPreferredSize(new Dimension(62, 20));
    edLength.setInputVerifier(floatVerifier);
    edLength.setText("");
    jpMilx.setLayout(gridBagLayout8);
    jpMilx.setMinimumSize(new Dimension(400, 189));
    jpMilx.setPreferredSize(new Dimension(400, 189));
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
    jLabel4.setText("Плотность");
    edDensity.setMinimumSize(new Dimension(80, 20));
    edDensity.setPreferredSize(new Dimension(80, 20));
    edDensity.setEnabled(false);
    edDensity.setEditable(false);
    edDensity.setText("");
    LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
    LNotSaved.setForeground(Color.red);
    LNotSaved.setText("Карточка не сохранена!");
    edMatShifr.setEnabled(false);
    edMatShifr.setEditable(false);
    edMatShifr.setMinimumSize(new Dimension(150, 20));
    edMatShifr.setPreferredSize(new Dimension(150, 20));
    edMatShifr.setText("");
    jpVR18.add(chbVR18,  new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    jpVR18.add(LVR18_Note, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    jpVR18.add(edVR18_Note,    new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpVR.add(jpVR7,    new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 5, 10), 0, 0));
    jpVR10.add(chbVR10,    new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    jpVR10.add(LVR10_TechPas, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    jpVR10.add(edVR10_TechPas,  new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    jpVR10.add(LVR10_Note, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    jpVR10.add(edVR10_Note,    new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    jpVR.add(jpVR18,   new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 5, 10), 0, 0));
    jpVR.add(jpVR10,      new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 5, 10), 0, 0));
    jpVR7.add(jLabel11,         new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    jpVR7.add(jLabel19,         new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    jpVR7.add(edMarkPlace,         new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    jpVR7.add(jLabel20,          new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    jpVR7.add(cbSoderMark,             new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
    jpVR7.add(cbSposobMark, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(edN_Izv,                                           new GridBagConstraints(1, 7, 4, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel24,                                                      new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    MainPanel.add(jLabel1,                                                                                                                    new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0, 0));
    MainPanel.add(edIndication,                                                                                                                            new GridBagConstraints(0, 2, 3, 1, 0.6, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 15, 5, 0), 0, 0));
    MainPanel.add(jLabel26,                                                                                                                      new GridBagConstraints(0, 10, 2, 1, 0.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    MainPanel.add(jLabel21,                                                                                                                new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(edNameFull,                                                                                                             new GridBagConstraints(1, 3, 5, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    MainPanel.add(icbLiter,                                                                                                             new GridBagConstraints(1, 8, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 20), 0, 0));
    MainPanel.add(jLabel6,                                                                           new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel10,                                                                        new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 0, 0), 0, 0));
    MainPanel.add(dateCreate,                                                                             new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel110,                                                                       new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(dateChange,                                                                       new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(edGOST,                                           new GridBagConstraints(3, 2, 3, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    MainPanel.add(jLabel2,                                      new GridBagConstraints(3, 1, 2, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 2, 5), 0, 0));
    MainPanel.add(jLabel5,                                     new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 2, 0), 0, 0));
    MainPanel.add(chbFromModel,                               new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 2, 0, 5), 0, 0));
    MainPanel.add(edMassa,                         new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel8,                            new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(edType,                        new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel12,                    new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(edRev,                   new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel14,         new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
    MainPanel.add(cbCAD,        new GridBagConstraints(1, 9, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
    MainPanel.add(LNotSaved,         new GridBagConstraints(1, 10, 4, 1, 0.0, 0.0
            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
    jpMilx.add(jLabel3,      new GridBagConstraints(0, 3, 1, 1, 0.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    jpMilx.add(jPanel1,      new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));
    jPanel1.add(jLabel16, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 1, 5), 0, 0));
    jPanel1.add(edLength, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jLabel17, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 1, 5), 0, 0));
    jPanel1.add(jLabel18, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 1, 5), 0, 0));
    jPanel1.add(edWidth, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(edDepth, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    jpMilx.add(jpMaterial,      new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    jpMaterial.add(rbZagot,         new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
    jpMaterial.add(rbMat,       new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
    jpMaterial.add(btMaterialClr,       new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jpMaterial.add(btMaterial,       new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jpMaterial.add(jLabel4,        new GridBagConstraints(2, 2, 1, 1, 1.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
    jpMaterial.add(edDensity,      new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jpMaterial.add(btMaterial1,      new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
    jpMaterial.add(edNameMat,      new GridBagConstraints(1, 0, 3, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
// -- шифр материала пусть будет не виден
    jpMaterial.add(edMatShifr,     new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    TabbedPane.add(MainPanel, "Общие данные");
    TabbedPane.add(jpMilx,   "Прочее");
//    TabbedPane.add(jpVR, "Ведомости");
    JPanel panelHead = new JPanel();
    panelHead.setLayout(borderLayoutHead);
    panelHead.add(LHeader, BorderLayout.CENTER);
    panelHead.add(vrtLogo, BorderLayout.EAST);
    this.add(panelHead, BorderLayout.NORTH);
    this.add(TabbedPane,  BorderLayout.CENTER);
    bgMat.add(rbMat);
    bgMat.add(rbZagot);
    bgMat.add(rbMat);
    bgMat.add(rbZagot);
  }

  void chbVR_stateChanged(ChangeEvent e)
  {
    boolean b = false;
    if (e.getSource() == chbVR10 )
    {
      b = chbVR10.isSelected();
      LVR10_Note.setEnabled(b);    edVR10_Note.setEnabled(b);
      LVR10_TechPas.setEnabled(b); edVR10_TechPas.setEnabled(b);
    }
    else if (e.getSource() == chbVR18 )
    {
      b = chbVR18.isSelected();
      LVR18_Note.setEnabled(b);    edVR18_Note.setEnabled(b);
    }
  }
  void btMaterial_actionPerformed(ActionEvent e)
  {
    AIFClipboard clipboard = AIFPortal.getClipboard();
    Transferable content = clipboard.getContents ( this );
    if ( content == null ) return;

    Vector childComponents = new Vector();
    try
    {
       childComponents = (Vector)content.getTransferData ( new DataFlavor ( Vector.class, "AIF Vector" ) );
    }
    catch ( Exception ex )
    {
        MessageBox.post ( ex );
        return;
    }

    TCComponent childComponent = (TCComponent)childComponents.get(0);
    TCComponentItem item=null;
    TCComponentItemRevision ir=null;

    try{
      if (childComponent instanceof TCComponentItem)
      {
        item=(TCComponentItem)childComponent;
//        TCComponent components[] = item.getTCProperty("revision_list").getReferenceValueArray();
//        if (components!=null) ir = (TCComponentItemRevision)components[0];

//        ir = item.getLatestItemRevision();
      }
      if (childComponent instanceof TCComponentItemRevision)
      {
        ir=(TCComponentItemRevision)childComponent;
        item=ir.getItem();
      }
    }
    catch ( Exception ex )
    { ex.printStackTrace();  }

//    String s = "";
    try{
      TCComponentForm form=(TCComponentForm)item.getRelatedComponent("IMAN_master_form");
      if (item.getType().equals(NR.TYPE_Material))
      {
        if (MaterialForm.fillDataIfClassified(data, item))
        {
          edNameMat.setText(data.material);
        }
        else{
          edNameMat.setText(form.getFormTCProperty(NR.fld_NAME_DSE).getStringValue());
          edMatShifr.setText(form.getFormTCProperty(NR.fld_DSE_CODE).getStringValue());
          edDensity.setText(form.getFormTCProperty(NR.fld_MASSA).getStringValue());
          // не обязательные поля
          edNDMark.setText(form.getFormTCProperty(NR.fld_ND_MARKA).getStringValue());
          edNDSort.setText(form.getFormTCProperty(NR.fld_ND_SORT).getStringValue());
          edMarkMat.setText(form.getFormTCProperty(NR.fld_MARKA_MAT).getStringValue());
          edVidZagot.setText(form.getFormTCProperty(NR.fld_VID_ZAGOT).getStringValue());
        }
      }
      else
        MessageBox.post("Невозможно вставить данные о материале, в буфере обмена не Материал!","LANIT",MessageBox.WARNING);
    }
    catch ( Exception ex )
    { MessageBox.post ( ex );  }
  }

  public void setNameSpec()
  {
    String sNDSort = edNDSort.getText();
    String sNDMark = edNDMark.getText();
    String sVidZagot = edVidZagot.getText();
    // Сформировать строку для спец-ии
    String sNameSpec = (sVidZagot);// + " " + sNDSort).trim();
    if (sVidZagot.length()==0)
      sNameSpec = (sNameSpec + " " + edNameMat.getText()).trim();
    sNameSpec = (sNameSpec + " " + edMarkMat.getText()).trim();
    if (sNDSort.length()==0)
      sNameSpec = (sNameSpec + " " + sNDMark).trim();
    edNameMat.setText(sNameSpec);
  }
/* -- вариант ДО введения функциональности создания Item материала при выборе, если его нет
  void btMaterial1_actionPerformed(ActionEvent e)
  {
    if (rbMat.isSelected())
    {
      SelectMatDlg3 dlg = new SelectMatDlg3(btMaterial1, 1, session);
      if (dlg.sMatShifr != null)
      {
        edNameMat.setText(dlg.sMatName);
        edNDMark.setText(dlg.sMatNDMark);
        edNDSort.setText(dlg.sMatNDSort);
        edMarkMat.setText(dlg.sMatMark);
        edVidZagot.setText(dlg.sMatSort);
        edDensity.setText(LUtil.float2string(dlg.fDensity, 8));
        edMatShifr.setText(dlg.sMatShifr);

        //lockMatProps();
        if (dlg.sMatSort!=null) // выбор материала вместе с сортаментом
          edNameMat.setText(dlg.sMatSort);
        else
          setNameSpec();
        // -- изменить цвет поля массы, сигнал что материал изменился
        data.kim = 1;
        setMassColor(1);
      }
    }
    else if (rbZagot.isSelected()) // вспомогательный материал
    {
      SelectZagDlg2 dlg = new SelectZagDlg2(btMaterial1, SelectZagDlg2.cstAuxMat, session);
      if (dlg.sMatShifr != null)
      {
        edNameMat.setText(dlg.sMatName);
        edNDSort.setText(dlg.sMatNDSort);
        edVidZagot.setText(dlg.sMatSort);
        edMarkMat.setText("");
        edNDMark.setText("");
        edMatShifr.setText("0-"+dlg.sMatShifr);

        //lockMatProps();
        setNameSpec();
      }
    }
  }
*/
  void btMaterial1_actionPerformed(ActionEvent e)
  {
    CrMat_Command cmd = new CrMat_Command(session);
    abstractSelMatDlg dlg = null;

    if (rbMat.isSelected())
    {
      dlg = new SelectMatDlg3(btMaterial1, 1, session); // 1 - обычные материалы
    }
    // -- Выбор (заготовки) чистого сортамента
    else if (rbZagot.isSelected())  // вспомогательные материалы
    {
      dlg = new SelectZagDlg2(btMaterial1, SelectZagDlg2.cstAuxMat, session);

      dlg.sMatMark = "";
      dlg.sMatNDMark = "";
      dlg.sMatShifr = "0-" + dlg.sMatShifr;
    }
    if (dlg.sMatShifr != null)
    {
      DSEUserData mat_data = new DSEUserData(session);
      mat_data.mater_name = dlg.sMatName;
      mat_data.mater_mark_nd = dlg.sMatNDMark;
      mat_data.mater_sort_nd = dlg.sMatNDSort;
      mat_data.mater_mark  = dlg.sMatMark;
      mat_data.mater_zagot = dlg.sMatSort;
      mat_data.mater_shifr = dlg.sIMBASE_Code;//sMatShifr;
      mat_data.density = dlg.fDensity;
      mat_data.code_okp = dlg.sMatShifr;
      dlg.makeMatString(mat_data);

      // проверить наличие материала, а если нет, то готовность его создать
      if (!cmd.checkMatTCE(mat_data)) return;

      edNameMat.setText(dlg.sMatName);
      edNDMark.setText(dlg.sMatNDMark);
      edNDSort.setText(dlg.sMatNDSort);
      edMarkMat.setText(dlg.sMatMark);
      edVidZagot.setText(dlg.sMatSort);
      edDensity.setText(LUtil.float2string(dlg.fDensity, 8));
      edMatShifr.setText(dlg.sIMBASE_Code);//sMatShifr);

      //lockMatProps();
      if (dlg.sMatSort != null) // выбор материала вместе с сортаментом
        edNameMat.setText(dlg.sMatSort);
      else
        edNameMat.setText(mat_data.material);
        // -- изменить цвет поля массы, сигнал что материал изменился
      data.kim = 1;
      setMassColor(1);
    }
  }

  void btMaterialClr_actionPerformed(ActionEvent e)
  {
    edNameMat.setText("");
  }

  void chbFromModel_actionPerformed(ActionEvent e)
  {
    if (e.getSource()==chbFromModel)
    {
      boolean bFromModel = chbFromModel.isSelected();
      double Massa;
      edMassa.setEnabled(!bFromModel);
      Massa = bFromModel? data.getMassFromModel() : data.massa;
      edMassa.setText(  LUtil.float2string(Massa, 6) );
    }
  }
}