package ru.rostvertolplc.osapr.forms;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.*;

import ru.rostvertolplc.osapr.util.*;
import com.teamcenter.rac.util.*;
import com.teamcenter.rac.common.lov.*;
import com.teamcenter.rac.kernel.*;


public class SbEdRevPanel extends JPanel implements InterfaceFormPanel
{
  DSEUserData data = null;
  //Registry R = Registry.getRegistry("com.avid.forms.forms");

  public JLabel LHeader = new JLabel();
  FloatVerifier floatVerifier = new FloatVerifier();

  private JLabel LTrud = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel5= new JLabel();
  private JLabel jLabel9 = new JLabel();
  private TextFieldDocument edRoditel = new TextFieldDocument(128);
  private JLabel jLabel10 = new JLabel();
  private JTextField dateCreate = new JTextField();
  private TextFieldDocument edIndication = new TextFieldDocument(128);
  JComboBox cbLiter1 = new JComboBox();
  JTabbedPane TabbedPane = new JTabbedPane();
  JPanel MainPanel = new JPanel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JPanel jpVR = new JPanel();
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  JPanel jpVR18 = new JPanel();
  TitledBorder titledBorder4;
  GridBagLayout gridBagLayout5 = new GridBagLayout();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel19 = new JLabel();
  TextFieldDocument edMarkPlace = new TextFieldDocument(32);
  JLabel jLabel20 = new JLabel();
  JCheckBox chbVR3 = new JCheckBox();
  JCheckBox chbVR18 = new JCheckBox();
  JLabel LVR18_Note = new JLabel();
  TextAreaDocument edVR18_Note = new TextAreaDocument(256);
  private JLabel jLabel26 = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  GridBagLayout gridBagLayout6 = new GridBagLayout();
  private JLabel jLabel21 = new JLabel();
  private TextFieldDocument edNameFull = new TextFieldDocument(256);
  private JComboBox cbSoderMark = new JComboBox();
  private JComboBox cbSposobMark = new JComboBox();
  private JLabel jLabel6 = new JLabel();
  private JTextField edMassa = new JTextField();
  private TextFieldDocument edTrud = new TextFieldDocument(10);
  private JLabel jLabel110 = new JLabel();
  private DateButton dateChange = new DateButton();
  private JLabel LReviewer = new JLabel();
  private JPanel jpSignOffs = new JPanel();
  private DateButton dateNK = new DateButton();
  private JTextField edNormocontrol = new JTextField();
  private JLabel LApprover2 = new JLabel();
  private DateButton dateTK = new DateButton();
  private JLabel LApprover1 = new JLabel();
  private DateButton dateApprove = new DateButton();
  private JLabel LCreator = new JLabel();
  private JTextField edReviewer = new JTextField();
  private JTextField edNachOtd = new JTextField();
  private JLabel LNormo = new JLabel();
  private JTextArea edAdditional = new JTextArea();
  private JLabel LApprover = new JLabel();
  private DateButton dateCreator = new DateButton();
  private JLabel jLabel12 = new JLabel();
  private GridBagLayout gridbagLayout1 = new GridBagLayout();
  private DateButton dateReview = new DateButton();
  private JTextField edTechcontrol = new JTextField();
  private DateButton dateNachOtd = new DateButton();
  private JTextField edApprover = new JTextField();
  private JTextField edCreator = new JTextField();
  private JLabel jLabel23 = new JLabel();
  private JComboBox cbFormat = new JComboBox();
  private JLabel jLabel24 = new JLabel();
  private TextFieldDocument edN_Izv = new TextFieldDocument(32);
  private TextFieldDocument edFormat = new TextFieldDocument(20);
  private JButton btClrFmt = new JButton();
  JLabel jLabel30 = new JLabel();
  JComboBox cbCexa = new JComboBox();
  JLabel jLabel29 = new JLabel();
  JPanel jpRascex = new JPanel();
  JLabel jLabel32 = new JLabel();
  JTextField edRascex = new JTextField();
  GridBagLayout gridBagLayout9 = new GridBagLayout();
  JCheckBox chbVR3_p = new JCheckBox();
  GridBagLayout gridBagLayout10 = new GridBagLayout();
  JLabel LVR3_Note = new JLabel();
  JCheckBox chbVR3_s = new JCheckBox();
  JPanel jpVR3 = new JPanel();
  JScrollPane spVR3 = new JScrollPane();
  TextAreaDocument edVR3_Note = new TextAreaDocument(256);
  JScrollPane spVR18 = new JScrollPane();
  JLabel LDateVnedr = new JLabel();
  DateButton dateVnedrII = new DateButton();
  JComboBox cbLiter2 = new JComboBox();
  JComboBox cbLiter3 = new JComboBox();
  JLabel LVR10_Note = new JLabel();
  JCheckBox chbVR10 = new JCheckBox();
  JScrollPane spVR10 = new JScrollPane();
  GridBagLayout gridBagLayout4 = new GridBagLayout();
  TextAreaDocument edVR10_Note = new TextAreaDocument(256);
  JPanel jpVR10 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JCheckBox chbZag = new JCheckBox();
  TextFieldDocument edZag = new TextFieldDocument(64);
  JCheckBox chbFromModel = new JCheckBox();
  JLabel jLabel3 = new JLabel();
  TextFieldDocument edOrigin = new TextFieldDocument(128);
  JLabel jLabel4 = new JLabel();
  LOVComboBox cbConsGroup = new LOVComboBox();
  JCheckBox chbOsobo = new JCheckBox();
  JLabel jLabel8 = new JLabel();
  JTextField edType = new JTextField();
  JTextField edRev = new JTextField();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  LOVComboBox cbCAD = new LOVComboBox();
  JTextField edDepth = new JTextField();
  JLabel LCreator1 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JTextField edWidth = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel18 = new JLabel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel17 = new JLabel();
  JPanel jPanel1 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  LOVComboBox cbCreator = new LOVComboBox();
  JTextField edLength = new JTextField();
  JPanel jpMilx = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JLabel LNotSaved = new JLabel();
  JLabel jLabel22 = new JLabel();
  JTextField edNachBrig = new JTextField();
  JLabel LApprover3 = new JLabel();
  DateButton dateNachBrig = new DateButton();
  JLabel jLabel111 = new JLabel();
  LOVComboBox cbOtdel = new LOVComboBox();
  JTextField edChangeNotice = new JTextField();
  JLabel jLabelIzv = new JLabel();

  public SbEdRevPanel() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public SbEdRevPanel(DSEUserData theData) {
    data = theData;
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
    // Отображаемое поле
    edType.setText(data.item.getType());
    edIndication.setText(data.indication);
    edNameFull.setText(data.name_dse);
    edRev.setText(data.revision);
    LNotSaved.setVisible(data.sc==null);
    edChangeNotice.setText(data.changeNotice);
    // Реальные поля
    edRoditel.setText(data.roditel);
    dateCreate.setText(LUtil.Date2String(data.date_create_obj));
    dateChange.setDate(data.change_date);
    dateVnedrII.setDate(data.date_vnedr);
    edN_Izv.setText(data.izv_id);
    chbOsobo.setSelected(data.pr_otvetstv);

    //edMassa.setText( String.valueOf(data.massa) );
    edMassa.setText(  LUtil.float2string(data.massa, 6) );
    edMassa.setEnabled(!data.pr_from_model);
    chbFromModel.setSelected(data.pr_from_model);

    edOrigin.setText( data.orig );
    edZag.setText( data.zagot );
    chbZag.setSelected(data.pr_zag);

    String saGab[] = data.gabarit.split("x", 3);
    if (saGab.length < 3) saGab = new String[]{"", "", ""};
    edLength.setText(saGab[0]);
    edWidth.setText(saGab[1]);
    edDepth.setText(saGab[2]);
/*
    edTrud.setText( data.trud );
    edMarkPlace.setText(data.vr7_mesto);
    edVR10_TechPas.setText(data.vr10_tex_pas);
    chbVR10.setSelected(data.vr10);
    edVR10_Note.setText(data.vr10_note);
    chbVR3_p.setSelected(data.vr3_p);
    chbVR3_s.setSelected(data.vr3_s);
    edVR3_Note.setText(data.vr3_note);
    chbVR18.setSelected(data.vr18);
    edVR18_Note.setText(data.vr18_note);
 */
    TCSession session = (TCSession)data.item.getSession();

    cbCreator.setLOVComponent(session, "User Names");
    cbCreator.setSelectedItem(data.creator);  dateCreator.setDate(data.date_create);
    cbOtdel.setLOVComponent(session, "Group Names");
    cbOtdel.setSelectedItem(data.otvetstv);

    //edCreator.setText(data.creator);        dateCreator.setDate(data.date_create);
    edNachBrig.setText(data.nach_brig);      dateNachBrig.setDate(data.date_nach_brig);
    edReviewer.setText(data.reviewer);      dateReview.setDate(data.date_review);
    edTechcontrol.setText(data.tcontrol);   dateTK.setDate(data.date_tcontrol);
    edNormocontrol.setText(data.ncontrol);  dateNK.setDate(data.date_ncontrol);
    edApprover.setText(data.approver);      dateApprove.setDate(data.date_approve);
    edNachOtd.setText(data.nach_otd);       dateNachOtd.setDate(data.date_nach_otd);
/*
    edAdditional.setText("");
    for (int i=0; i<data.viza.length; i++)
      edAdditional.append(data.viza[i]+"\n");
*/
    // Литера
    LUtil.fillComboBoxLOV(cbLiter1, data.lov_liter);
    LUtil.fillComboBoxLOV(cbLiter2, data.lov_liter);
    LUtil.fillComboBoxLOV(cbLiter3, data.lov_liter);
    cbLiter1.setSelectedItem(data.liter1);
    cbLiter2.setSelectedItem(data.liter2);
    cbLiter3.setSelectedItem(data.liter3);

    // Конструктивная группа
    //LUtil.fillComboBoxLOV(cbConsGroup, data.lov_consgroup);
    cbConsGroup.setLOVComponent(session, data.NR.lov_CONSGROUP);
    cbConsGroup.setSelectedItem(data.cons_group);
    // Базовая CAD-система
    cbCAD.setLOVComponent(session, data.NR.lov_CADSYS);
    cbCAD.setSelectedItem(data.cad_sys);
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
    // Формат
    LUtil.fillComboBoxLOV(cbFormat, data.lov_format);
//    cbFormat.setSelectedItem(data.format);
    edFormat.setText(data.format);
    // Расцеховка
    LUtil.fillComboBoxLOV(cbCexa, data.lov_cexa);
    edRascex.setText(data.rascex);
  }

  public void saveToUserData()
  {
//    String sObj=null;
//    int len;
    try
    {
//      data.indication = edIndication.getText();
//      data.name_dse = edNameFull.getText();
//      data.code_dse = edCodeDSE.getText();
      data.change_date = dateChange.getDate();
      data.date_vnedr = dateVnedrII.getDate();
      data.izv_id = edN_Izv.getText();
      data.massa = LUtil.string2float(edMassa.getText());
      data.pr_from_model = chbFromModel.isSelected();
      data.roditel = edRoditel.getText();
      data.trud = edTrud.getText();
      data.cons_group = LUtil.getSelectedStrCB(cbConsGroup);
      data.pr_otvetstv = chbOsobo.isSelected();

      data.orig = edOrigin.getText();
      data.zagot = edZag.getText();
      data.pr_zag = chbZag.isSelected();
      data.cad_sys = LUtil.getSelectedStrCB(cbCAD);
      data.gabarit = edLength.getText()+'x'+edWidth.getText()+'x'+edDepth.getText();
/*
      data.vr10 = chbVR10.isSelected();
      data.vr10_note = edVR10_Note.getText();
//      data.vr10_tex_pas = edVR10_TechPas.getText();

      data.vr18 = chbVR18.isSelected();
      data.vr18_note = edVR18_Note.getText();
*/
      data.creator = LUtil.getSelectedStrCB(cbCreator);  data.date_create = dateCreator.getDate();
      data.otvetstv = LUtil.getSelectedStrCB(cbOtdel);

      //data.creator = edCreator.getText();        data.date_create = dateCreator.getDate();
      data.reviewer = edReviewer.getText();      data.date_review = dateReview.getDate();
      data.nach_brig = edNachBrig.getText();     data.date_nach_brig = dateNachBrig.getDate();
      data.tcontrol = edTechcontrol.getText();   data.date_tcontrol = dateTK.getDate();
      data.ncontrol = edNormocontrol.getText();  data.date_ncontrol = dateNK.getDate();
      data.approver = edApprover.getText();      data.date_approve = dateApprove.getDate();
      data.nach_otd = edNachOtd.getText();       data.date_nach_otd = dateNachOtd.getDate();
/*
      int n = edAdditional.getLineCount();
      data.viza = new String[n];
      try {
        for (int i=0; i<n; i++)
        {
          int a = edAdditional.getLineStartOffset(i);
          int b = edAdditional.getLineEndOffset(i);
          data.viza[i] = edAdditional.getText(a,b-a-1);
        }
      }
      catch (BadLocationException ex) { }
*/
      data.liter1 = LUtil.getSelectedStrCB(cbLiter1);
      data.liter2 = LUtil.getSelectedStrCB(cbLiter2);
      data.liter3 = LUtil.getSelectedStrCB(cbLiter3);
/*      data.vr7_sod_mark = cbSoderMark.getSelectedItem()==null ? "" : cbSoderMark.getSelectedItem().toString();
      data.vr7_spo_nanes = cbSposobMark.getSelectedItem()==null ? "" : cbSposobMark.getSelectedItem().toString();
*/
      data.format = edFormat.getText();
      data.rascex = edRascex.getText();
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
	  
	
	    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(165, 163, 151));
	    titledBorder1 = new TitledBorder(border1,"Габаритные размеры");
	    this.setLayout(borderLayout1);
	    jLabel5.setText("Обозначение");
	    jLabel1.setText("Наименование");
	    LTrud.setText("Трудоёмкость");
	    jLabel9.setText("Родитель");
	    edRoditel.setBackground(new Color(204, 204, 204));
	    edRoditel.setMinimumSize(new Dimension(20, 21));
	    edRoditel.setPreferredSize(new Dimension(100, 21));
	    edRoditel.setColumns(64);
	    jLabel10.setText("Дата создания");
	    dateCreate.setBorder(BorderFactory.createLineBorder(Color.black));
	    dateCreate.setMinimumSize(new Dimension(120, 21));
	    dateCreate.setPreferredSize(new Dimension(120, 21));
	    dateCreate.setToolTipText("");
	    dateCreate.setEditable(false);
	    dateCreate.setText("< Дата не задана >");
	    dateCreate.setHorizontalAlignment(SwingConstants.CENTER);
	    edIndication.setBackground(new Color(255, 217, 217));
	    edIndication.setMaximumSize(new Dimension(400, 21));
	    edIndication.setMinimumSize(new Dimension(350, 21));
	    edIndication.setPreferredSize(new Dimension(350, 21));
	    edIndication.setEditable(false);
	    TabbedPane.setEnabled(true);
	    TabbedPane.setMinimumSize(new Dimension(500, 400));
	    TabbedPane.setPreferredSize(new Dimension(500, 400));
	    MainPanel.setLayout(gridBagLayout3);
	    jpVR.setLayout(gridBagLayout6);
	    jpVR18.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"ВР 18 - Детали по директивным технологиям"));
	    jpVR18.setMinimumSize(new Dimension(100, 100));
	    jpVR18.setPreferredSize(new Dimension(434, 100));
	    jpVR18.setLayout(gridBagLayout5);
	    jLabelIzv.setText("Извещение");
	    jLabel19.setText("Место нанесения маркировки");
	    jLabel20.setText("Содержание маркировки");
	    chbVR18.setText("Признак вхождения в ВР 18");
	    chbVR18.addChangeListener(new javax.swing.event.ChangeListener() {
	      public void stateChanged(ChangeEvent e) {
	        chbVR_stateChanged(e);
	      }
	    });
	    LVR18_Note.setEnabled(false);
	    LVR18_Note.setText("Примечание ВР 18");
	    edVR18_Note.setEnabled(false);
	    //jLabel26.setText(".");
	    LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
	    LHeader.setAlignmentX((float) 0.5);
	    LHeader.setHorizontalAlignment(SwingConstants.CENTER);
	    LHeader.setHorizontalTextPosition(SwingConstants.CENTER);
	    LHeader.setText("Модификация изделия << Сб. единица >>");
	    MainPanel.setMinimumSize(new Dimension(400, 320));
	    MainPanel.setPreferredSize(new Dimension(400, 320));
	    jpVR.setMinimumSize(new Dimension(110, 400));
	    jpVR.setPreferredSize(new Dimension(444, 400));
	    jLabel21.setRequestFocusEnabled(true);
	    jLabel21.setText("Литеры");
	    edNameFull.setBackground(new Color(255, 217, 217));
	    edNameFull.setMinimumSize(new Dimension(20, 21));
	    edNameFull.setPreferredSize(new Dimension(150, 21));
	    edNameFull.setEditable(false);
	    edNameFull.setColumns(0);
	    cbLiter1.setMinimumSize(new Dimension(50, 21));
	    cbLiter1.setPreferredSize(new Dimension(50, 21));
	    jLabel6.setText("Масса");
	    edMassa.setMinimumSize(new Dimension(140, 21));
	    edMassa.setPreferredSize(new Dimension(120, 21));
	    edTrud.setPreferredSize(new Dimension(100, 21));
	    edTrud.setMinimumSize(new Dimension(100, 21));
	    jLabel110.setText("Дата изменения");
	    dateChange.setTitle("sas");
	    dateChange.setDisplayFormat("dd.MM.yyyy");
	    dateChange.setText("< Дата не задана >");
	    dateChange.setToolTipText("");
	    dateChange.setPreferredSize(new Dimension(150, 21));
	    dateChange.setMinimumSize(new Dimension(150, 21));
	    LReviewer.setText("Проверил");
	    jpSignOffs.setLayout(gridbagLayout1);
	    dateNK.setDisplayFormat("dd-MM-yyyy");
	    dateNK.setText("Дата не установлена");
	    edNormocontrol.setMinimumSize(new Dimension(140, 21));
	    edNormocontrol.setPreferredSize(new Dimension(140, 21));
	    LApprover2.setText("Нач. отдела");
	    dateTK.setDisplayFormat("dd-MM-yyyy");
	    dateTK.setText("Дата не установлена");
	    LApprover1.setText("Тех.Контроль");
	    dateApprove.setText("Дата не установлена");
	    dateApprove.setDisplayFormat("dd-MM-yyyy");
	    LCreator.setText("Разработал");
	    edReviewer.setMinimumSize(new Dimension(140, 21));
	    edReviewer.setPreferredSize(new Dimension(140, 21));
	    edNachOtd.setMinimumSize(new Dimension(140, 21));
	    edNachOtd.setPreferredSize(new Dimension(140, 21));
	    LNormo.setText("Нормоконтроль");
	    edAdditional.setBorder(null);
	    edAdditional.setMinimumSize(new Dimension(82, 64));
	    edAdditional.setPreferredSize(new Dimension(82, 64));
	    edAdditional.setRows(3);
	    LApprover.setText("Утвердил");
	    dateCreator.setText("Дата не установлена");
	    dateCreator.setDisplayFormat("dd-MM-yyyy");
	    jLabel12.setText("Дополнительные согласующие лица");
	    dateReview.setText("Дата не установлена");
	    dateReview.setDisplayFormat("dd-MM-yyyy");
	    edTechcontrol.setMinimumSize(new Dimension(140, 21));
	    edTechcontrol.setPreferredSize(new Dimension(140, 21));
	    dateNachOtd.setDisplayFormat("dd-MM-yyyy");
	    dateNachOtd.setText("Дата не установлена");
	    edApprover.setMinimumSize(new Dimension(140, 21));
	    edApprover.setPreferredSize(new Dimension(140, 21));
	    edCreator.setMinimumSize(new Dimension(140, 21));
	    edCreator.setPreferredSize(new Dimension(140, 21));
	    jLabel23.setText("Формат");
	    cbFormat.setPreferredSize(new Dimension(60, 21));
	    cbFormat.addItemListener(new java.awt.event.ItemListener() {
	      public void itemStateChanged(ItemEvent e) {
	        cbFormat_itemStateChanged(e);
	      }
	    });
	    cbFormat.setMinimumSize(new Dimension(60, 21));
	    jLabel24.setText(" N ИИ (ПИ)");
	    edN_Izv.setMinimumSize(new Dimension(100, 21));
	    edN_Izv.setPreferredSize(new Dimension(100, 21));
	    edFormat.setMinimumSize(new Dimension(100, 21));
	    edFormat.setColumns(20);
	    btClrFmt.setBackground(Color.pink);
	    btClrFmt.setFont(new java.awt.Font("Dialog", 1, 12));
	    btClrFmt.setMaximumSize(new Dimension(21, 21));
	    btClrFmt.setMinimumSize(new Dimension(21, 21));
	    btClrFmt.setPreferredSize(new Dimension(21, 21));
	    btClrFmt.setMargin(new Insets(0, 0, 0, 0));
	    btClrFmt.setText("x");
	    btClrFmt.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        btClrFmt_actionPerformed(e);
	      }
	    });
	    jLabel30.setText("Подразделения");
	    cbCexa.setMinimumSize(new Dimension(50, 21));
	    cbCexa.setPreferredSize(new Dimension(50, 21));
	    cbCexa.addItemListener(new java.awt.event.ItemListener()
	    {
	      public void itemStateChanged(ItemEvent e)
	      {
	        cbCexa_itemStateChanged(e);
	      }
	    });
	    cbCexa.setMinimumSize(new Dimension(50, 21));
	    cbCexa.setPreferredSize(new Dimension(50, 21));
	    jLabel29.setText("Расцеховка");
	    jpRascex.setLayout(gridBagLayout9);
	    jLabel32.setText("-");
	    edRascex.setMinimumSize(new Dimension(26, 21));
	    edRascex.setPreferredSize(new Dimension(26, 21));
	    edRascex.setText("");
	    chbVR3_p.setText("Переборка");
	    LVR3_Note.setText("Примечание ВР 3");
	    chbVR3_s.setText("Сдаточные испытания");
	    chbVR3_s.setHorizontalTextPosition(SwingConstants.RIGHT);
	    jpVR3.setMinimumSize(new Dimension(100, 100));
	    jpVR3.setPreferredSize(new Dimension(444, 100));
	    jpVR3.setLayout(gridBagLayout10);
	    jpVR3.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"ВР 3 - Детали, подлежащие обязательной замене при переборках"));
	    chbVR3_s.setText("Сдаточные испытания");
	    chbVR3_p.setText("Переборка");
	    LVR3_Note.setText("Примечание ВР3");
	    LDateVnedr.setText("Дата внедрения ИИ");
	    dateVnedrII.setMinimumSize(new Dimension(150, 21));
	    dateVnedrII.setPreferredSize(new Dimension(150, 21));
	    dateVnedrII.setText("< Дата не задана >");
	    dateVnedrII.setDisplayFormat("dd.MM.yyyy");
	    cbLiter2.setPreferredSize(new Dimension(50, 21));
	    cbLiter2.setMinimumSize(new Dimension(50, 21));
	    cbLiter3.setPreferredSize(new Dimension(50, 21));
	    cbLiter3.setMinimumSize(new Dimension(50, 21));
	    LVR10_Note.setEnabled(false);
	    LVR10_Note.setText("Примечание ВР 10");
	    chbVR10.setHorizontalTextPosition(SwingConstants.RIGHT);
	    chbVR10.setText("Признак вхождения в ВР 10");
	    chbVR10.addChangeListener(new javax.swing.event.ChangeListener() {
	      public void stateChanged(ChangeEvent e) {
	        chbVR_stateChanged(e);
	      }
	    });
	    edVR10_Note.setEnabled(false);
	    jpVR10.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"ВР 10 - Технологический паспорт"));
	    jpVR10.setMinimumSize(new Dimension(100, 100));
	    jpVR10.setPreferredSize(new Dimension(444, 100));
	    jpVR10.setLayout(gridBagLayout4);
	    jLabel2.setText("для");
	    chbZag.setHorizontalAlignment(SwingConstants.LEADING);
	    chbZag.setHorizontalTextPosition(SwingConstants.LEADING);
	    chbZag.setText("Заготовка");
	    edZag.setText("");
	    chbFromModel.setText("Из модели");
	    chbFromModel.addActionListener(new java.awt.event.ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        chbFromModel_actionPerformed(e);
	      }
	    });
	    jLabel3.setText("Размещение оригинала");
	    edOrigin.setText("");
	    jLabel4.setText("Конструктивная группа");
	    chbOsobo.setHorizontalTextPosition(SwingConstants.LEADING);
	    chbOsobo.setText("Особо ответственная");
	    jLabel8.setText("Вид изделия");
	    edType.setFont(new java.awt.Font("Dialog", 1, 11));
	    edType.setEditable(false);
	    edType.setText("");
	    edRev.setEditable(false);
	    edRev.setText("");
	    jLabel13.setText("Ревизия");
	    jLabel14.setToolTipText("");
	    jLabel14.setText("Базовая CAD-система");
	    this.setMinimumSize(new Dimension(500, 500));
	    this.setPreferredSize(new Dimension(500, 500));
	    edDepth.setInputVerifier(floatVerifier);
	    edDepth.setText("");
	    LCreator1.setText("Разработал");
	    jLabel16.setText("Длина, (мм)");
	    edWidth.setInputVerifier(floatVerifier);
	    edWidth.setText("");
	    jLabel18.setText("Глубина, (мм)");
	    jLabel17.setText("Ширина, (мм)");
	    jPanel1.setBorder(titledBorder1);
	    jPanel1.setMinimumSize(new Dimension(300, 100));
	    jPanel1.setPreferredSize(new Dimension(300, 100));
	    jPanel1.setLayout(gridBagLayout2);
	    edLength.setMinimumSize(new Dimension(62, 20));
	    edLength.setPreferredSize(new Dimension(62, 20));
	    edLength.setInputVerifier(floatVerifier);
	    edLength.setText("");
	    jpMilx.setLayout(gridBagLayout1);
	    jpMilx.setMinimumSize(new Dimension(400, 189));
	    jpMilx.setPreferredSize(new Dimension(400, 189));
	    LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
	    LNotSaved.setForeground(Color.red);
	    LNotSaved.setText("Карточка не сохранена!");
	    edChangeNotice.setMinimumSize(new Dimension(130, 21));
	    edChangeNotice.setPreferredSize(new Dimension(130, 21));
	    edChangeNotice.setEnabled(false);
	
	    /*jpVR18.add(chbVR18,     new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
	          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
	    jpVR18.add(LVR18_Note,    new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
	          ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
	    jpVR.add(jpVR7,    new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0
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

	    jpVR.add(jpVR18,            new GridBagConstraints(0, 2, 1, 1, 1.0, 0.8
	            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 5, 10), 0, 0));
	    jpVR.add(jpVR3,          new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 5, 10), 0, 0));
	    jpVR3.add(chbVR3_s, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
	    jpVR3.add(LVR3_Note, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0, 0));
	    jpVR3.add(chbVR3_p, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 5), 0, 0));
	    jpVR3.add(spVR3, new GridBagConstraints(1, 1, 3, 1, 1.0, 1.0
	            ,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 5, 0, 0), 0, 0));
	    jpVR.add(jpVR10,      new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 5, 10), 0, 0));
	    jpVR10.add(chbVR10, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
	    jpVR10.add(LVR10_Note, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
	    jpVR10.add(spVR10, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0
	            ,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 5, 0, 0), 0, 0));
	    jpVR18.add(spVR18,       new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

	    spVR18.getViewport().add(edVR18_Note, null);
	    spVR10.getViewport().add(edVR10_Note, null);
	    spVR3.getViewport().add(edVR3_Note, null);
	*/
	    jLabel22.setText(".");
	    edNachBrig.setPreferredSize(new Dimension(140, 21));
	    edNachBrig.setMinimumSize(new Dimension(140, 21));
	    LApprover3.setText("Нач. Бригады");
	    dateNachBrig.setDisplayFormat("dd-MM-yyyy");
	    dateNachBrig.setText("Дата не установлена");
	    jLabel111.setText("Отдел");
	    cbOtdel.setMinimumSize(new Dimension(100, 19));
	    MainPanel.add(cbFormat,                                                                                     new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 2, 5, 0), 0, 0));
	    MainPanel.add(edN_Izv,                                                                                 new GridBagConstraints(1, 6, 5, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
	    MainPanel.add(edChangeNotice,                                                                                 new GridBagConstraints(1, 6, 5, 1, 0.0, 0.0
	    		            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
	    
	    MainPanel.add(jLabel23,                                                                                                    new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 5, 0), 0, 0));
	    MainPanel.add(jLabel24,                                                                                             new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
	    MainPanel.add(jLabel5,                                                                                                    new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 10, 0, 0), 0, 0));
	    MainPanel.add(jLabel1,                                                                                                      new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 5), 0, 0));

	    MainPanel.add(jLabel9,                                                                                                          new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
	    MainPanel.add(edRoditel,                                                                                                          new GridBagConstraints(1, 12, 6, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 0), 0, 0));
	    MainPanel.add(edIndication,                                                                                                     new GridBagConstraints(1, 1, 6, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
	    MainPanel.add(jLabel26, new GridBagConstraints(0, 13, 3, 1, 0.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	    MainPanel.add(jLabel21,                                                                                                         new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 5, 0), 0, 0));
	        MainPanel.add(edNameFull,                                                                                                  new GridBagConstraints(1, 2, 6, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
	    MainPanel.add(cbLiter1,                                                                                                        new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(10, 5, 5, 0), 0, 0));
	    MainPanel.add(jLabel10,                                                                                                              new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
	    MainPanel.add(dateCreate,                                                                                                             new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
	    MainPanel.add(jLabel110,                                                                                                              new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
	    MainPanel.add(dateChange,                                                                                                             new GridBagConstraints(1, 5, 3, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
	    MainPanel.add(edFormat,                                                                              new GridBagConstraints(1, 7, 3, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 0), 0, 0));
	    MainPanel.add(btClrFmt,                                                                          new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 2, 5, 0), 0, 0));
	   
	    MainPanel.add(cbLiter2,                                                          new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
	    MainPanel.add(cbLiter3,                                                     new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
	    MainPanel.add(chbZag,                                                    new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
	    MainPanel.add(jLabel2,                                               new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
	    MainPanel.add(edZag,                                                 new GridBagConstraints(2, 10, 5, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
	    TabbedPane.add(MainPanel, "Общие данные");


	    this.add(LHeader,  BorderLayout.NORTH);
	    this.add(TabbedPane,  BorderLayout.CENTER);

	    jpSignOffs.add(cbCreator,               new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(25, 5, 5, 5), 0, 0));
	    jpSignOffs.add(dateCreator,               new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(25, 5, 5, 5), 0, 0));
	    jpSignOffs.add(LReviewer,                            new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(15, 5, 5, 5), 0, 0));
	    jpSignOffs.add(edReviewer,                             new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(15, 5, 0, 5), 0, 0));

	    jpSignOffs.add(LNormo,                         new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
	    jpSignOffs.add(LApprover1,                         new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
	    jpSignOffs.add(LApprover2,                         new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
	    jpSignOffs.add(edApprover,                          new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(edNormocontrol,                          new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(edTechcontrol,                          new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(edNachOtd,                          new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(LApprover,                         new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
	    jpSignOffs.add(dateApprove,                         new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(dateNK,                         new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(dateTK,                         new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(dateReview,                            new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(15, 5, 5, 5), 0, 0));
	    jpSignOffs.add(dateNachOtd,                         new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    
	    jpSignOffs.add(jLabel22,                       new GridBagConstraints(0, 8, 1, 1, 0.0, 1.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
	    jpSignOffs.add(edNachBrig,                       new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(LApprover3,                   new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
	    jpSignOffs.add(dateNachBrig,                new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	    jpSignOffs.add(LCreator,         new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(25, 5, 0, 5), 0, 0));
	    jpSignOffs.add(jLabel111,        new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
	    jpSignOffs.add(cbOtdel,      new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
	
	    MainPanel.add(jLabel6,                                                new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(10, 0, 5, 0), 0, 0));
	    MainPanel.add(edMassa,                                                new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(10, 5, 5, 0), 0, 0));
	    MainPanel.add(chbFromModel,                                                   new GridBagConstraints(6, 8, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
	    MainPanel.add(jLabel3,                                                    new GridBagConstraints(0, 9, 2, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 5, 0), 0, 0));
	    MainPanel.add(edOrigin,                                                  new GridBagConstraints(2, 9, 5, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 0), 0, 0));
	    MainPanel.add(jLabel4,                                                new GridBagConstraints(4, 4, 2, 1, 0.0, 0.0
	            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
	    MainPanel.add(cbConsGroup,                                          new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 0), 0, 0));
	    MainPanel.add(chbOsobo,                                        new GridBagConstraints(5, 5, 2, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
	    MainPanel.add(jLabel8,                          new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 10, 5, 0), 0, 0));
	    MainPanel.add(edType,                          new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0
	            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(20, 5, 5, 0), 0, 0));
	    MainPanel.add(jLabel13,                  new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
	    MainPanel.add(edRev,                new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
	    MainPanel.add(jLabel14,           new GridBagConstraints(0, 11, 2, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
	    MainPanel.add(cbCAD,          new GridBagConstraints(2, 11, 2, 1, 0.0, 0.0
	            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
	    MainPanel.add(LNotSaved,             new GridBagConstraints(2, 13, 4, 1, 0.0, 0.0
	            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));
	
	    MainPanel.add(jLabelIzv, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
	    //!!MainPanel.add(jLabelIzv, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
	    
	    
	    MainPanel.add(edChangeNotice, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
	    
	    TabbedPane.add(jpMilx,   "Прочее");
	    TabbedPane.add(jpSignOffs,  "Подписи");

	    jpMilx.add(jLabel7,    new GridBagConstraints(0, 5, 1, 1, 0.0, 1.0
	            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	    jpMilx.add(jPanel1,    new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0
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
	  }

  void chbVR_stateChanged(ChangeEvent e)
  {
    boolean b = false;

    if (e.getSource() == chbVR10 )
    {
      b = chbVR10.isSelected();
      LVR10_Note.setEnabled(b);    edVR10_Note.setEnabled(b);
      //LVR10_TechPas.setEnabled(b); edVR10_TechPas.setEnabled(b);
    }
    else
    if (e.getSource() == chbVR18 )
    {
      b = chbVR18.isSelected();
      LVR18_Note.setEnabled(b);    edVR18_Note.setEnabled(b);
    }
  }

  void btClrFmt_actionPerformed(ActionEvent e)
  {
    edFormat.setText("");
  }

  void cbFormat_itemStateChanged(ItemEvent e)
  {
    if(e.getStateChange() != 1) return;
    String code = cbFormat.getSelectedItem().toString();
    if (code.equals("")) return;
    String old = edFormat.getText();
    if (!old.equals("")) old = old + ",";
    old = old + code;
    edFormat.setText(old);
  }

  void cbCexa_itemStateChanged(ItemEvent e)
  {
    if(e.getStateChange() != 1) return;
    String code = cbCexa.getSelectedItem().toString();
    if (code.equals("")) return;
    String old = edRascex.getText();
    if (!old.equals("")) old = old + "-";
    old = old + code;
    edRascex.setText(old);
  }

  void chbFromModel_actionPerformed(ActionEvent e)
  {
    if (e.getSource()==chbFromModel)
    {
      boolean bFromModel = chbFromModel.isSelected();
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
