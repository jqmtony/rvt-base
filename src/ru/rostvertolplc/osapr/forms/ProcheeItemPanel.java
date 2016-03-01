package ru.rostvertolplc.osapr.forms;

import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;

import java.awt.*;
import javax.swing.*;
import com.teamcenter.rac.form.lovcombobox.FormLOVCombobox;
import ru.rostvertolplc.osapr.util.*;
import com.teamcenter.rac.util.*;
import java.awt.event.*;


public class ProcheeItemPanel extends JPanel implements InterfaceFormPanel
{
  /**
	 *
	 */
  private static final long serialVersionUID = 5188803840893447256L;

  //Registry R = Registry.getRegistry("com.LANIT.forms.L-forms");
  NameResolver NR = new NameResolver();

  DSEUserData data = null;
  //Registry R = Registry.getRegistry("com.avid.forms.forms");
  String[] asTipIzgot = new String[]{"Покупное","Собственное"};

  private JLabel LHeader = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  JTabbedPane JTabbedPane = new JTabbedPane();
  JPanel jpMain = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel LTipIzgot = new JLabel();
  JTextField edIndication = new TextFieldDocument(128);
  JLabel LName = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel LComment = new JLabel();
  JTextField edName = new TextFieldDocument(256);
  JLabel LIndication = new JLabel();
  JComboBox icbTipIzgot = new JComboBox();
  JPanel jpPKI = new JPanel();
  JTextField edCodeOKP = new TextFieldDocument(12);
  JLabel jLabel2 = new JLabel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel6 = new JLabel();
  FormLOVCombobox icbVidPKI = new FormLOVCombobox();
  JLabel jLabel7 = new JLabel();
  JLabel LIzgot = new JLabel();
  TextFieldDocument edDocPost = new TextFieldDocument(64);
  TextFieldDocument edOrgPost = new TextFieldDocument(256);
  //MLabel LClass = new MLabel();
  //MLabel LProtocol = new MLabel();
  JLabel LClass = new JLabel();
  JLabel LProtocol = new JLabel();
  TextFieldDocument edClass = new TextFieldDocument(128);
  TextFieldDocument edNProtocol = new TextFieldDocument(50);
  JScrollPane spComment = new JScrollPane();
  TextAreaDocument edComment = new TextAreaDocument(240);
  JLabel jLabel11 = new JLabel();
  JCheckBox chbPrintID = new JCheckBox();
  JLabel jLabel12 = new JLabel();
  DateButton dtProtocol = new DateButton();
  JTextField edGOST = new JTextField();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JTextField edMassa = new JTextField();
  JCheckBox chbFromModel = new JCheckBox();
  JLabel LDopInfo = new JLabel();
  JTextField edDopInfo = new TextFieldDocument(256);
  JLabel LDeveloper = new JLabel();
  TextFieldDocument edOrgDeveloper = new TextFieldDocument(256);
  JLabel LNotSaved = new JLabel();

  public ProcheeItemPanel() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public ProcheeItemPanel(DSEUserData theData) {
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
    if (data.bNewID)  edIndication.setForeground(Color.GRAY);
    if (data.bNewName)  edName.setForeground(Color.GRAY);
    LNotSaved.setVisible(data.sc==null);

    edIndication.setText(data.indication);
    edGOST.setText(data.gost);
    edName.setText(data.name_dse);
    edComment.setText(data.comment);

    edCodeOKP.setText(data.code_okp);
    edOrgPost.setText(data.org_postav);
    edOrgDeveloper.setText(data.creator);
    edClass.setText(data.material);
    edDocPost.setText(data.doc_postav);
    edNProtocol.setText(data.n_protraz);  dtProtocol.setDate(data.date_protocol);
    edDopInfo.setText(data.dop_info);

    edMassa.setText(  LUtil.float2string(data.massa, 4) );
    edMassa.setEnabled(!data.pr_from_model);
    chbFromModel.setSelected(data.pr_from_model);

    LUtil.fillComboBoxLOV( icbTipIzgot, asTipIzgot);  icbTipIzgot.setSelectedItem(data.type_izgot);
    chbPrintID.setSelected(data.print_id);

    try
    {
      icbVidPKI.load(data.form);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      MessageBox.post(ex);
    }
  }

  public void saveToUserData()
  {
//    String sObj=null;
//    int len;
    try
    {
      data.indication = edIndication.getText();
      data.gost = edGOST.getText();
      data.name_dse = edName.getText();

      data.code_okp = edCodeOKP.getText();
      data.org_postav = edOrgPost.getText();
      data.creator = edOrgDeveloper.getText();
      data.material = edClass.getText();
      data.doc_postav = edDocPost.getText();
      data.comment = edComment.getText();
      data.dop_info = edDopInfo.getText();
      data.n_protraz = edNProtocol.getText();  data.date_protocol = dtProtocol.getDate();

      //data.type_izgot = LUtil.getSelectedStrCB(icbTipIzgot);
      data.type_izgot = edClass.getText();
      data.vid_pki = icbVidPKI.getSelectedString();
      data.print_id = chbPrintID.isSelected();

      data.massa = LUtil.string2float(edMassa.getText());
      data.pr_from_model = chbFromModel.isSelected();
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
    LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
    LHeader.setHorizontalAlignment(SwingConstants.CENTER);
    LHeader.setText("Прочее Изделие");
    this.setMinimumSize(new Dimension(500, 350));
    this.setPreferredSize(new Dimension(500, 350));
    jpMain.setLayout(gridBagLayout1);
    LTipIzgot.setText("Тип изготовления");
    edIndication.setMaximumSize(new Dimension(3000, 21));
    edIndication.setMinimumSize(new Dimension(250, 21));
    edIndication.setPreferredSize(new Dimension(250, 21));
    LName.setText("Наименование");
    LComment.setText("Комментарий");
    edName.setPreferredSize(new Dimension(250, 21));
    edName.setMinimumSize(new Dimension(250, 21));
    edName.setMaximumSize(new Dimension(300, 21));
    LIndication.setToolTipText("");
    LIndication.setText("Oбозначение");
    edCodeOKP.setMinimumSize(new Dimension(250, 21));
    edCodeOKP.setPreferredSize(new Dimension(250, 21));
    jLabel2.setText("Код ОКП");
    jpPKI.setLayout(gridBagLayout2);
    jLabel6.setText("Вид ПКИ");
    jLabel7.setText("Документ на поставку");
    LIzgot.setText("Изготовитель (предприятие)");
    edDocPost.setEnabled(true);
    edDocPost.setToolTipText("");
    edDocPost.setText("");
    edOrgPost.setEnabled(true);
    edOrgPost.setToolTipText("256 символов");
    edOrgPost.setText("");
    /*
    LClass.setMarginHeight(2);
    LClass.setMarginWidth(0);
    LClass.setText("Информационная карта,\\nсправочник");
    LProtocol.setText("Протокол разрешения\\nпримениения");
    LProtocol.setMarginWidth(0);
    LProtocol.setMarginHeight(2);*/
    LClass.setText("Информац.карта,справочник");
    LProtocol.setText("Протокол разреш. примен.");

    edClass.setBackground(UIManager.getColor("window"));
    edClass.setEnabled(true);
    edClass.setToolTipText("128 символов");
    edClass.setEditable(true);
    edClass.setText("");
    edNProtocol.setEnabled(true);
    edNProtocol.setMinimumSize(new Dimension(150, 21));
    edNProtocol.setPreferredSize(new Dimension(150, 21));
    edNProtocol.setToolTipText("");
    edNProtocol.setText("");
    icbVidPKI.setFormProperty(NR.fld_VIDPKI);
    icbVidPKI.setLovName(NR.lov_VIDPKI);
    icbTipIzgot.setMinimumSize(new Dimension(150, 21));
    icbTipIzgot.setPreferredSize(new Dimension(150, 21));
    edComment.setMinimumSize(new Dimension(100, 51));
    edComment.setColumns(86);
    spComment.setMinimumSize(new Dimension(100, 76));
    spComment.setPreferredSize(new Dimension(100, 76));
    jLabel11.setText("-");
    chbPrintID.setHorizontalTextPosition(SwingConstants.LEADING);
    chbPrintID.setSelected(false);
    chbPrintID.setText("Выводить обозначение");
    jLabel12.setText("-");
    dtProtocol.setText("( Даты нет )");
    dtProtocol.setDisplayFormat("dd.MM.yyyy");
    edGOST.setText("");
    jLabel13.setText("ТУ, ГОСТ");
    jLabel14.setText("Масса");
    edMassa.setMinimumSize(new Dimension(120, 21));
    edMassa.setPreferredSize(new Dimension(120, 21));
    edMassa.setText("");
    chbFromModel.setText("Из модели");
    chbFromModel.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        chbFromModel_actionPerformed(e);
      }
    });
    LDopInfo.setText("Дополн. информация");
    edDopInfo.setPreferredSize(new Dimension(250, 21));
    edDopInfo.setMinimumSize(new Dimension(250, 21));
    LDeveloper.setText("Разработчик (предприятие)");
    edOrgDeveloper.setText("");
    edOrgDeveloper.setToolTipText("256 символов");
    edOrgDeveloper.setEnabled(true);
    LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
    LNotSaved.setForeground(Color.red);
    LNotSaved.setText("Карточка не сохранена!");
    this.add(LHeader,  BorderLayout.NORTH);
    this.add(JTabbedPane, BorderLayout.CENTER);
    JTabbedPane.add(jpMain,  "Общие данные");
    jpMain.add(jLabel1,                     new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jpMain.add(LName,                       new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    jpMain.add(edName,                new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    //jpMain.add(LIndication,                 new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
    //        ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    //jpMain.add(edIndication,                   new GridBagConstraints(1, 2, 3, 1, 1.0, 0.0
    //        ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 10), 0, 0));
    //jpMain.add(LTipIzgot,            new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
    //        ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    //jpMain.add(icbTipIzgot,              new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0
    //        ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 10), 0, 0));
    jpMain.add(edDopInfo,             new GridBagConstraints(1, 3, 3, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 10), 0, 0));
    jpMain.add(LDopInfo,       new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
    jpMain.add(LComment,               new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    jpMain.add(spComment,               new GridBagConstraints(1, 4, 3, 1, 1.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH, new Insets(0, 5, 5, 10), 0, 0));
    jpMain.add(jLabel11,             new GridBagConstraints(0, 7, 1, 1, 0.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    //jpMain.add(chbPrintID,                    new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0
    //        ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 8, 0, 0), 0, 0));
    jpMain.add(edGOST,             new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 5, 10), 0, 0));
    jpMain.add(jLabel13,         new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));
    jpMain.add(jLabel14,        new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    jpMain.add(edMassa,       new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 0, 0));
    jpMain.add(chbFromModel,      new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jpMain.add(LNotSaved,     new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0
            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(30, 0, 0, 0), 0, 0));
    spComment.getViewport().add(edComment, null);
    JTabbedPane.add(jpPKI,  "ПКИ");
    jpPKI.add(jLabel2,                       new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(8, 10, 5, 0), 0, 0));
    jpPKI.add(jLabel6,                    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    jpPKI.add(icbVidPKI,                       new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
    jpPKI.add(edCodeOKP,                     new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    jpPKI.add(jLabel7,                   new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    jpPKI.add(LIzgot,                   new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    jpPKI.add(edDocPost,                      new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    jpPKI.add(edOrgPost,                      new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    jpPKI.add(LClass,                   new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    jpPKI.add(LProtocol,                   new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    jpPKI.add(edClass,                       new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
    jpPKI.add(edNProtocol,                      new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    jpPKI.add(jLabel12,                   new GridBagConstraints(0, 7, 1, 1, 0.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jpPKI.add(dtProtocol,                      new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));
    jpPKI.add(LDeveloper,            new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
    jpPKI.add(edOrgDeveloper,        new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
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
