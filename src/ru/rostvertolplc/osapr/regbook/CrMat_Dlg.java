package ru.rostvertolplc.osapr.regbook;

import javax.swing.*;
import java.awt.*;
import ru.rostvertolplc.osapr.forms.*;
import java.awt.event.*;

import com.teamcenter.rac.aif.AbstractAIFDialog;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.util.*;


public class CrMat_Dlg extends AbstractAIFDialog //JDialog
{
  public boolean isOk = false;
  public MaterialRevPanel matPanel;
  public DSEUserData data;
  JButton btCancel = new JButton();
  JButton btOk = new JButton();
  JPanel jPanel1 = new JPanel();

  public CrMat_Dlg()
  {
    try
    {
      data = new DSEUserData();
      matPanel = new MaterialRevPanel(data);
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public CrMat_Dlg(Frame frame, TCSession theSession)
  {
    super(frame, "IMBASE", true);
    try
    {
      data = new DSEUserData();
      data.session = theSession;
      matPanel = new MaterialRevPanel(data);
      jbInit();
      setSize(550,400);
      setLocationRelativeTo(frame);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public CrMat_Dlg(Frame frame, DSEUserData theData)
  {
    super(frame, "IMBASE", true);
    try
    {
      data = theData;
      matPanel = new MaterialRevPanel(data);
      jbInit();
      setSize(550,400);
      setLocationRelativeTo(frame);
      matPanel.renderData();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    btCancel.setText("Отмена");
    btCancel.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        btCancel_actionPerformed(e);
      }
    });
    btOk.setText("Ok");
    btOk.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        btOk_actionPerformed(e);
      }
    });
    this.getContentPane().add(matPanel, BorderLayout.CENTER);
    this.getContentPane().add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(btOk, null);
    jPanel1.add(btCancel, null);
  }

  void btOk_actionPerformed(ActionEvent e)
  {
    matPanel.saveToUserData();
    hide();
    isOk = true;
  }

  void btCancel_actionPerformed(ActionEvent e)
  {
    isOk = false;
    hide();
  }
}