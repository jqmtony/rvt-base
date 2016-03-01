package ru.rostvertolplc.osapr.forms;

import ru.rostvertolplc.osapr.util.TextFieldDocument;
import com.teamcenter.rac.util.MessageBox;
import java.awt.*;
import javax.swing.*;
//import com.teamcenter.rac.form.label.*;
import ru.rostvertolplc.osapr.util.LUtil;
import java.awt.event.*;


public class DetalItemPanel extends JPanel implements InterfaceFormPanel, ItemListener
{
  /**
   * 
   */
  private static final long serialVersionUID = -2095173736010113533L;

  DSEUserData data = null;
  //Registry R = Registry.getRegistry("com.avid.forms.forms");

  private JLabel LHeader = new JLabel();
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private JLabel jLabel2 = new JLabel();
  private JTextField edFirstUse = new TextFieldDocument(128);
  private JLabel jLabel5= new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JTextField edSpravNo = new TextFieldDocument(128);
  private JTextField edIndication = new TextFieldDocument(128);
  private JLabel jLabel16 = new JLabel();
  private JTextField edName = new TextFieldDocument(256);
  private JLabel jLabel1 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField edCodeDSE = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField edIzd = new JTextField();
  JComboBox cbIzd = new JComboBox();
  JLabel jLabel9 = new JLabel();
  JLabel LNotSaved = new JLabel();

  public DetalItemPanel() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public DetalItemPanel(DSEUserData theData) {
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
    edName.setText(data.name_dse);
    edFirstUse.setText(data.first_use);
    edSpravNo.setText(data.sprav_dse);
    edIzd.setText(data.izdelie);

    // Ответственное подразделение
    //LUtil.fillComboBoxLOV(cbOtvetstv, data.lov_otvetstv);
    //cbOtvetstv.setSelectedItem(data.otvetstv);
    LUtil.fillComboBoxLOV(cbIzd, data.lov_izdelie);
    edCodeDSE.setText(data.code_dse);
    //IndicationRecoder rec = new IndicationRecoder(data.indication);
    //edKodAsup.setText(rec.Decode());
  }

  public void saveToUserData()
  {
//    String sObj=null;
//    int len;
    try
    {
      data.indication = edIndication.getText();
      data.name_dse = edName.getText();
      data.sprav_dse = edSpravNo.getText();
      data.first_use = edFirstUse.getText();
      //data.otvetstv = LUtil.getSelectedStrCB(cbOtvetstv);
      data.izdelie = edIzd.getText();
      /*
      if (data.code_dse.equals(""))
	data.code_dse = edKodAsup.getText();
      else if (edKodAsup.getText().equals(""))
	data.code_dse = "";
      */
    }
    catch (Exception ex)
    {
      MessageBox.post(ex);
    }
    edIndication.setForeground(Color.BLACK);
    edName.setForeground(Color.BLACK);
  }

  public void setHeader(String s)
  {
    LHeader.setText(s);
  }

  public void itemStateChanged(ItemEvent ev)
  {
    if (ev.getStateChange()!=ItemEvent.SELECTED) return;
    if (ev.getSource()==cbIzd)
    {
      String sIzd = LUtil.getSelectedStrCB(cbIzd).trim();
      if (sIzd.length()<=0) return;
      String s = edIzd.getText();
      if (s.length()>0) s+=", ";
      edIzd.setText(s+sIzd);
    }
  }

  private void jbInit() throws Exception {
    this.setLayout(gridBagLayout1);
    edFirstUse.setMinimumSize(new Dimension(20, 21));
    jLabel5.setText("Обозначение");
    LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
    LHeader.setText("Деталь");
    jLabel2.setText("Первичная применяемость");
    jLabel3.setText("Справочный номер");
    edSpravNo.setMinimumSize(new Dimension(20, 21));
    edIndication.setMaximumSize(new Dimension(300, 21));
    edIndication.setMinimumSize(new Dimension(250, 21));
    edIndication.setPreferredSize(new Dimension(250, 21));
    jLabel16.setText("Наименование");
    edName.setPreferredSize(new Dimension(250, 21));
    edName.setMinimumSize(new Dimension(250, 21));
    edName.setMaximumSize(new Dimension(300, 21));
    this.setMinimumSize(new Dimension(500, 300));
    this.setPreferredSize(new Dimension(500, 300));
    jLabel6.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel6.setHorizontalTextPosition(SwingConstants.LEFT);
    jLabel6.setText("Код ДСЕ");
    edCodeDSE.setMinimumSize(new Dimension(102, 21));
    edCodeDSE.setPreferredSize(new Dimension(102, 21));
    edCodeDSE.setEditable(false);
    edCodeDSE.setText("");
    jLabel8.setText("Условное обознач. Изделия");
    edIzd.setMinimumSize(new Dimension(120, 21));
    edIzd.setPreferredSize(new Dimension(120, 21));
    edIzd.setText("");
    cbIzd.setMinimumSize(new Dimension(100, 21));
    cbIzd.setPreferredSize(new Dimension(100, 21));
    cbIzd.addItemListener(this);
    jLabel9.setMaximumSize(new Dimension(10, 15));
    jLabel9.setMinimumSize(new Dimension(5, 15));
    jLabel9.setPreferredSize(new Dimension(10, 15));
    jLabel9.setText(".");
    LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
    LNotSaved.setForeground(Color.red);
    LNotSaved.setText("Карточка не сохранена!");
    //LNotSaved.setVisible(false);
    this.add(edFirstUse,                                          new GridBagConstraints(1, 3, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 10), 0, 0));
    this.add(jLabel5,                                         new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
    this.add(jLabel2,                                    new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 5), 0, 0));
    this.add(LHeader,                                    new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 15, 5), 0, 0));
    this.add(jLabel3,                      new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
    this.add(edIndication,                                 new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 10), 0, 0));
    this.add(jLabel16,                      new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 5), 0, 0));
    this.add(edName,                      new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 10), 0, 0));
    this.add(edSpravNo,     new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 10), 0, 0));
    this.add(jLabel1,              new GridBagConstraints(0, 7, 1, 1, 0.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel6,             new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 40, 0, 0), 0, 0));
    this.add(edCodeDSE,             new GridBagConstraints(1, 6, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
    this.add(jLabel8,          new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 10, 5, 0), 0, 0));
    this.add(edIzd,                 new GridBagConstraints(1, 5, 1, 1, 0.5, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    this.add(cbIzd,             new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
    this.add(jLabel9,         new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.add(LNotSaved,   new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(40, 0, 0, 0), 0, 0));
  }

}
