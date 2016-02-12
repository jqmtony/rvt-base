package ru.rostvertolplc.osapr.util;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class SendListDlg extends JDialog implements java.awt.event.ActionListener
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 7988331825075571245L;
	
	
  LListModel dmList = new LListModel();
  boolean dlgResult = false;

  JPanel jPanel1 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JButton btOK = new JButton();
  JButton btCancel = new JButton();
  JList jList = new JList(dmList);

  public SendListDlg()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public SendListDlg(String[] array)
  {
    dmList.setData(array);
    try
    {
      jbInit();
      setSize(240,400);
      setLocation(400,200);
      //show();
      this.setVisible(true);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    jPanel1.setLayout(borderLayout1);
    jPanel2.setMinimumSize(new Dimension(10, 40));
    jPanel2.setPreferredSize(new Dimension(10, 40));
    btOK.setText("OK");
    btOK.addActionListener(this);
    btCancel.setText("Отмена");
    btCancel.addActionListener(this);
    this.setModal(true);
    this.setResizable(true);
    this.setTitle("Выбор элементов списка");
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jScrollPane1, BorderLayout.CENTER);
    jPanel1.add(jPanel2,  BorderLayout.SOUTH);
    jPanel2.add(btOK, null);
    jPanel2.add(btCancel, null);
    jScrollPane1.getViewport().add(jList, null);
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("OK"))
    {
      dlgResult = true;
      //hide();
      this.setVisible(false);
    }
    if (e.getActionCommand().equals("Отмена"))
    {
      dlgResult = false;
      //hide();
      this.setVisible(false);
    }
  }

}
