package ru.rostvertolplc.osapr.forms;

import ru.rostvertolplc.osapr.util.TextFieldDocument;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;

import java.awt.*;
import ru.rostvertolplc.osapr.util.*;
import java.awt.event.*;
import javax.swing.*;
import com.teamcenter.rac.util.combobox.*;
import com.teamcenter.rac.common.lov.*;
import com.teamcenter.rac.kernel.*;


public class DocItemPanel extends JPanel implements InterfaceFormPanel//, ItemListener
{
  DSEUserData data = null;
  //Registry R = Registry.getRegistry("com.LANIT.forms.L-forms");
  NameResolver NR = new NameResolver();

  private JLabel LHeader = new JLabel();
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private JLabel jLabel5= new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JTextField edIndication = new TextFieldDocument(128);
  private JLabel jLabel16 = new JLabel();
  private JTextField edName = new TextFieldDocument(256);
  private LOVComboBox cbDocType = new LOVComboBox();
  private JLabel jLabel1 = new JLabel();
  JLabel LNotSaved = new JLabel();

  public DocItemPanel() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public DocItemPanel(DSEUserData theData) {
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
    edIndication.setText(data.indication);
    edName.setText(data.name_dse);
    LNotSaved.setVisible(data.sc==null);

    //LUtil.fillComboBoxLOV(cbDocType, data.lov_doctype);
    cbDocType.setLOVComponent((TCSession)data.item.getSession(), NR.lov_KODDOC);
    cbDocType.setText(data.type_doc);
  }

  public void saveToUserData()
  {
//    String sObj=null;
//    int len;
    try
    {
      data.indication = edIndication.getText();
      data.name_dse = edName.getText();
      data.type_doc = cbDocType.getSelectedString();
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

  private void jbInit() throws Exception {
    this.setLayout(gridBagLayout1);
    jLabel5.setText("Обозначение");
    LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
    LHeader.setText("Документ Конструкторский");
    jLabel4.setText("Тип документа");
    edIndication.setMaximumSize(new Dimension(300, 21));
    edIndication.setMinimumSize(new Dimension(250, 21));
    edIndication.setPreferredSize(new Dimension(250, 21));
    jLabel16.setText("Наименование");
    edName.setPreferredSize(new Dimension(250, 21));
    edName.setMinimumSize(new Dimension(250, 21));
    edName.setMaximumSize(new Dimension(300, 21));
    this.setMinimumSize(new Dimension(500, 300));
    this.setPreferredSize(new Dimension(500, 300));
    //cbDocType.addItemListener(this);
    //cbDocType.addActionListener(this);
    cbDocType.setMinimumSize(new Dimension(200, 19));
    cbDocType.setOpaque(false);
    cbDocType.setPreferredSize(new Dimension(200, 19));
    LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
    LNotSaved.setForeground(Color.red);
    LNotSaved.setText("Карточка не сохранена!");
    this.add(jLabel5,                                   new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 0, 0), 0, 0));
    this.add(LHeader,                               new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 15, 5), 0, 0));
    this.add(jLabel4,                          new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 0, 0), 0, 0));
    this.add(edIndication,                              new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 20), 0, 0));
    this.add(jLabel16,                new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 5, 5), 0, 0));
    this.add(edName,                 new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 20), 0, 0));
    this.add(cbDocType,                      new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
    this.add(jLabel1,         new GridBagConstraints(0, 4, 1, 1, 0.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    this.add(LNotSaved,      new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(40, 0, 0, 0), 0, 0));
  }
/*
  public void itemStateChanged(ItemEvent e)
  {
    if (e.getStateChange()!=ItemEvent.SELECTED) return;
    Object компонент = e.getSource();

    if (компонент==cbDocType)
    {
      String s = "";
      if (cbDocType.getSelectedItem()!=null)
        s = LUtil.parse1(cbDocType.getSelectedItem().toString(), " = ");
      edDocType.setText(s);
    }
  }
*/
}
