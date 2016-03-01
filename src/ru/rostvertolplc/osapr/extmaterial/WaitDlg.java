package ru.rostvertolplc.osapr.extmaterial;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.borland.jbcl.layout.*;
import java.util.TimerTask;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: LANIT</p>
 * @author not attributable
 * @version 1.0
 */

public class WaitDlg extends JDialog implements Runnable
{
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  public JLabel LMsg = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();

  Timer timer;

  public WaitDlg() throws HeadlessException
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
  public static void main(String[] args) throws HeadlessException
  {
    WaitDlg dialog = new WaitDlg();
    dialog.setModal(true);
    dialog.run();

    System.exit(0);
  }

  class RemindTask extends TimerTask {
     public void run()
     {
       seconds++;
       jLabel1.setText(String.valueOf(seconds));
       //if (seconds>10) dlg.hide();
       dlg.setSize(dlg.getWidth()+1, dlg.getHeight());
       dlg.validate();
       dlg.repaint();
     }
   }

  public void run()
  {

    setSize(320,100);
    java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
    Dimension dim = toolkit.getScreenSize();
    setLocation((dim.width-getWidth())/2, (dim.height-getHeight())/2);
    show();

    //timer = new Timer(delay, taskPerformer);
    timer = new Timer();
    seconds = 0;
    timer.scheduleAtFixedRate(new RemindTask(), 100, delay);
  }

 private void jbInit() throws Exception
  {
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("Подождите пожалуйста...");
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Доступ к IMBASE ...");
    jPanel1.setLayout(borderLayout1);
    LMsg.setFont(new java.awt.Font("Dialog", 1, 12));
    LMsg.setHorizontalAlignment(SwingConstants.CENTER);
    LMsg.setHorizontalTextPosition(SwingConstants.CENTER);
    LMsg.setText("_");
    this.getContentPane().add(jPanel1,  BorderLayout.CENTER);
    jPanel1.add(jLabel1, BorderLayout.CENTER);
    jPanel1.add(LMsg, BorderLayout.SOUTH);
  }

  JDialog dlg = this;
  int delay = 1000; //milliseconds
  int seconds = 0;

  ActionListener taskPerformer = new ActionListener() {
    public void actionPerformed(ActionEvent evt)
    {
      seconds++;
      jLabel1.setText(String.valueOf(seconds));
      //if (seconds>10) dlg.hide();
      dlg.repaint();
    }
   };

  public void stop()
  {
    //timer.stop();
    timer.cancel();
    hide();
  }
}