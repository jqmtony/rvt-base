package ru.rostvertolplc.osapr.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;

import ru.rostvertolplc.osapr.util.LUtil;
import ru.rostvertolplc.osapr.util.TextFieldDocument;
import java.awt.*;

import javax.swing.*;

import com.teamcenter.rac.util.*;
import com.teamcenter.rac.common.lov.*;
import com.teamcenter.rac.kernel.TCSession;


public class DocRevPanel extends JPanel implements InterfaceFormPanel
{
  DSEUserData data = null;
  //Registry R = Registry.getRegistry("com.avid.forms.forms");

  public JLabel LHeader = new JLabel();

  private JLabel LTrud = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel5= new JLabel();
  private JLabel jLabel10 = new JLabel();
  private JTextField dateCreate = new JTextField();
  private JTextField edIndication = new TextFieldDocument(128);
  JComboBox cbLiter1 = new JComboBox();
  JTabbedPane TabbedPane = new JTabbedPane();
  JPanel MainPanel = new JPanel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  TitledBorder titledBorder4;
  private JLabel jLabel26 = new JLabel();
  private JLabel jLabel14 = new JLabel();
  private JTextField edCodeDSE = new TextFieldDocument(15);
  BorderLayout borderLayout1 = new BorderLayout();
  private JLabel jLabel21 = new JLabel();
  private JTextField edNameFull = new TextFieldDocument(256);
  private JTextField edTrud = new TextFieldDocument(10);
  private JLabel jLabel110 = new JLabel();
  private DateButton dateChange = new DateButton();
//  private TitledBorder titledBorder1;
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
//  private JTextField edCreator = new JTextField();
  //private TitledBorder titledBorder5;
  private JLabel jLabel23 = new JLabel();
  private JComboBox cbFormat = new JComboBox();
  private JLabel jLabel24 = new JLabel();
  private JTextField edN_Izv = new TextFieldDocument(32);
  private JTextField edFormat = new TextFieldDocument(20);
  private JButton btClrFmt = new JButton();
  JComboBox cbLiter2 = new JComboBox();
  JComboBox cbLiter3 = new JComboBox();
  JLabel jLabel8 = new JLabel();
  JTextField edType = new JTextField();
  JTextField edRev = new JTextField();
  JLabel jLabel9 = new JLabel();
  JLabel LNotSaved = new JLabel();
  JLabel LApprover3 = new JLabel();
  JTextField edNachBrig = new JTextField();
  DateButton dateNachBrig = new DateButton();
  JLabel jLabel15 = new JLabel();
  LOVComboBox cbOtdel = new LOVComboBox();
  LOVComboBox cbCreator = new LOVComboBox();
  JLabel LMassa = new JLabel();
  JTextField edMassa = new JTextField();
  JTextField edKolListov = new JTextField();

  public DocRevPanel() {
	  
    try {
    	System.out.println("DocRevPanel");
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public DocRevPanel(DSEUserData theData) {
    data = theData;
    System.out.println("DocRevPanel");
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
	  System.out.println("renderData");
    // Отображаемое поле
    edType.setText(data.item.getType());
    edCodeDSE.setText(data.code_dse);
    edIndication.setText(data.indication);
    edNameFull.setText(data.name_dse);
    edRev.setText(data.revision);
    LNotSaved.setVisible(data.sc==null);
    // Реальные поля
    edKolListov.setText(data.kolListov);
    dateCreate.setText(LUtil.Date2String(data.date_create_obj));
    dateChange.setDate(data.change_date);
    edN_Izv.setText(data.izv_id);

    edTrud.setText( data.trud );
    edMassa.setText( LUtil.float2string(data.massa, 6) );

    TCSession session = (TCSession)data.item.getSession();

    cbCreator.setLOVComponent(session, "User Names");
    cbCreator.setSelectedItem(data.creator);  dateCreator.setDate(data.date_create);
    cbOtdel.setLOVComponent(session, "Group Names");
    cbOtdel.setSelectedItem(data.otvetstv);

    //edCreator.setText(data.creator);        dateCreator.setDate(data.date_create);
    edReviewer.setText(data.reviewer);      dateReview.setDate(data.date_review);
    edNachBrig.setText(data.nach_brig);     dateNachBrig.setDate(data.date_nach_brig);
    edTechcontrol.setText(data.tcontrol);   dateTK.setDate(data.date_tcontrol);
    edNormocontrol.setText(data.ncontrol);  dateNK.setDate(data.date_ncontrol);
    edApprover.setText(data.approver);      dateApprove.setDate(data.date_approve);
    edNachOtd.setText(data.nach_otd);       dateNachOtd.setDate(data.date_nach_otd);

    edAdditional.setText("");
    for (int i=0; i<data.viza.length; i++)
      edAdditional.append(data.viza[i]+"\n");

    // Литера
    LUtil.fillComboBoxLOV(cbLiter1, data.lov_liter);
    LUtil.fillComboBoxLOV(cbLiter2, data.lov_liter);
    LUtil.fillComboBoxLOV(cbLiter3, data.lov_liter);
    cbLiter1.setSelectedItem(data.liter1);
    cbLiter2.setSelectedItem(data.liter2);
    cbLiter3.setSelectedItem(data.liter3);
    // Формат
    LUtil.fillComboBoxLOV(cbFormat, data.lov_format);
    edFormat.setText(data.format);
    System.out.println("end renderData");
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
      data.izv_id = edN_Izv.getText();
      data.trud = edTrud.getText();
      data.massa = LUtil.string2float(edMassa.getText());
      data.kolListov=edKolListov.getText();
      data.creator = LUtil.getSelectedStrCB(cbCreator);  data.date_create = dateCreator.getDate();
      data.otvetstv = LUtil.getSelectedStrCB(cbOtdel);
//      data.creator = edCreator.getText();        data.date_create = dateCreator.getDate();
      data.reviewer = edReviewer.getText();      data.date_review = dateReview.getDate();
      data.nach_brig = edNachBrig.getText();     data.date_nach_brig = dateNachBrig.getDate();
      data.tcontrol = edTechcontrol.getText();   data.date_tcontrol = dateTK.getDate();
      data.ncontrol = edNormocontrol.getText();  data.date_ncontrol = dateNK.getDate();
      data.approver = edApprover.getText();      data.date_approve = dateApprove.getDate();
      data.nach_otd = edNachOtd.getText();       data.date_nach_otd = dateNachOtd.getDate();

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

      data.liter1 = LUtil.getSelectedStrCB(cbLiter1);
      data.liter2 = LUtil.getSelectedStrCB(cbLiter2);
      data.liter3 = LUtil.getSelectedStrCB(cbLiter3);
      //data.format = cbFormat.getSelectedItem()==null ? "" : cbFormat.getSelectedItem().toString();
      data.format = edFormat.getText();
    }
    catch (Exception ex)
    {
      MessageBox.post(ex);
    }
  }

  public void setHeader(String s)
  {System.out.println("setHeader");
    LHeader.setText(s);
  }

  private void jbInit() throws Exception {
 //   titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134))," Материал ");
//    titledBorder5 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(134, 134, 134)),"ВР 6 - Контроль ДСЕ после испытаний");
	  System.out.println("jbInit");
	  this.setLayout(borderLayout1);
    jLabel5.setText("Обозначение");
    jLabel1.setText("Наименование");
    LTrud.setText("Трудоёмкость");
    jLabel10.setText("Дата создания");
    dateCreate.setBorder(BorderFactory.createLineBorder(Color.black));
    dateCreate.setMinimumSize(new Dimension(150, 21));
    dateCreate.setPreferredSize(new Dimension(150, 21));
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
    jLabel26.setText(".");
    LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
    LHeader.setAlignmentX((float) 0.5);
    LHeader.setHorizontalAlignment(SwingConstants.CENTER);
    LHeader.setHorizontalTextPosition(SwingConstants.CENTER);
    LHeader.setText("Конструкторский документ - модификация");
    MainPanel.setMinimumSize(new Dimension(400, 320));
    MainPanel.setPreferredSize(new Dimension(400, 320));
    jLabel14.setForeground(Color.gray);
    jLabel14.setText("Код ДСЕ");
    jLabel21.setText("Литеры");
    edNameFull.setBackground(new Color(255, 217, 217));
    edNameFull.setMinimumSize(new Dimension(20, 21));
    edNameFull.setPreferredSize(new Dimension(150, 21));
    edNameFull.setEditable(false);
    edNameFull.setColumns(0);
    cbLiter1.setMinimumSize(new Dimension(50, 21));
    cbLiter1.setPreferredSize(new Dimension(50, 21));
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
    LApprover2.setText("Нач. Отдела");
    dateTK.setDisplayFormat("dd-MM-yyyy");
    dateTK.setText("Дата не установлена");
    LApprover1.setText("Тех. Контроль");
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
//    edCreator.setMinimumSize(new Dimension(140, 21));
//    edCreator.setPreferredSize(new Dimension(140, 21));
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
    edCodeDSE.setBackground(UIManager.getColor("Button.background"));
    edCodeDSE.setForeground(Color.gray);
    edCodeDSE.setBorder(null);
    edCodeDSE.setEditable(false);
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
    cbLiter2.setPreferredSize(new Dimension(50, 21));
    cbLiter2.setMinimumSize(new Dimension(50, 21));
    cbLiter3.setPreferredSize(new Dimension(50, 21));
    cbLiter3.setMinimumSize(new Dimension(50, 21));
    jLabel8.setText("Вид изделия");
    edType.setFont(new java.awt.Font("Dialog", 1, 11));
    edType.setEditable(false);
    edType.setText("");
    edRev.setText("");
    edRev.setEditable(false);
    jLabel9.setText("Ревизия");
    LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
    LNotSaved.setForeground(Color.red);
    LNotSaved.setText("Карточка не сохранена!");
    LApprover3.setText("Нач. Бригады");
    edNachBrig.setPreferredSize(new Dimension(140, 21));
    edNachBrig.setMinimumSize(new Dimension(140, 21));
    dateNachBrig.setDisplayFormat("dd-MM-yyyy");
    dateNachBrig.setText("Дата не установлена");
    jLabel15.setText("Отдел");
    cbOtdel.setMinimumSize(new Dimension(100, 19));
    LMassa.setBackground(UIManager.getColor("Viewport.background"));
    LMassa.setDebugGraphicsOptions(0);
    LMassa.setText("Масса");
    edMassa.setMinimumSize(new Dimension(140, 21));
    edMassa.setPreferredSize(new Dimension(140, 21));
    edMassa.setHorizontalAlignment(SwingConstants.LEADING);
    edKolListov.setMinimumSize(new Dimension(20, 21));
    edKolListov.setPreferredSize(new Dimension(100, 21));
    MainPanel.add(cbFormat,                                                          new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 2, 5, 0), 0, 0));
    MainPanel.add(edN_Izv,                                                      new GridBagConstraints(1, 6, 5, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel23,                                                                        new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel24,                                                                 new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    MainPanel.add(jLabel5,                                                                                  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    MainPanel.add(jLabel1,                                                                                 new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0, 0));
    MainPanel.add(edIndication,                                                                            new GridBagConstraints(1, 1, 6, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel26,                                                                                new GridBagConstraints(0, 10, 2, 1, 0.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    MainPanel.add(jLabel14,                                                                               new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    MainPanel.add(edCodeDSE,                                                                              new GridBagConstraints(1, 9, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    MainPanel.add(jLabel21,                                                                                new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 5, 5, 0), 0, 0));
    MainPanel.add(edNameFull,                                                                               new GridBagConstraints(1, 2, 6, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(cbLiter1,                                                                                new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(10, 5, 5, 0), 0, 0));
    //MainPanel.add(LTrud,                                                    new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
    //        ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    //MainPanel.add(edTrud,                                                    new GridBagConstraints(1, 7, 3, 1, 0.0, 0.0
    //        ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel10,                                                                                  new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    MainPanel.add(dateCreate,                                                                                   new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel110,                                                                                  new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(dateChange,                                                                                  new GridBagConstraints(1, 5, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(edFormat,                                                   new GridBagConstraints(1, 7, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 0), 0, 0));
    MainPanel.add(btClrFmt,                                               new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 2, 5, 0), 0, 0));
    MainPanel.add(cbLiter2,                                         new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
    MainPanel.add(cbLiter3,                                  new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
    MainPanel.add(jLabel8,                        new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 5, 5, 0), 0, 0));
    MainPanel.add(edType,                         new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(20, 5, 5, 0), 0, 0));
    MainPanel.add(jLabel9,                 new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(edRev,                new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    MainPanel.add(LNotSaved,              new GridBagConstraints(2, 10, 3, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    MainPanel.add(LMassa,          new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
    MainPanel.add(edMassa,      new GridBagConstraints(5, 8, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    MainPanel.add(edKolListov,      new GridBagConstraints(5, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    MainPanel.add(new JLabel("Кол-во листов"),      new GridBagConstraints(4, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    
    TabbedPane.add(MainPanel, "Общие данные");

    this.add(LHeader,  BorderLayout.NORTH);
    this.add(TabbedPane,  BorderLayout.CENTER);
    jpSignOffs.add(LCreator,                              new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    jpSignOffs.add(LReviewer,                              new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
//    jpSignOffs.add(edCreator,                            new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
//            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(edReviewer,                              new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(dateCreator,                               new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
//    jpSignOffs.add(edAdditional,     new GridBagConstraints(0, 7, 3, 1, 0.0, 0.0
//            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
//    jpSignOffs.add(jLabel12,     new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0
//            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 0, 5, 0), 0, 0));
    TabbedPane.add(jpSignOffs,  "Подписи");
    jpSignOffs.add(LNormo,                             new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    jpSignOffs.add(LApprover1,                             new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    jpSignOffs.add(LApprover2,                             new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    jpSignOffs.add(edApprover,                             new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(edNormocontrol,                             new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(edTechcontrol,                             new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(edNachOtd,                              new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(LApprover,                             new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    jpSignOffs.add(dateApprove,                             new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(dateNK,                             new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(dateTK,                             new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(dateReview,                             new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(dateNachOtd,                              new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(LApprover3,                            new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    jpSignOffs.add(edNachBrig,                         new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(dateNachBrig,                     new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
    jpSignOffs.add(jLabel15,                new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    jpSignOffs.add(cbOtdel,           new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    jpSignOffs.add(cbCreator,        new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
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


}
