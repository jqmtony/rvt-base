package ru.rostvertolplc.osapr.util;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.InputVerifier;
import com.teamcenter.rac.util.MessageBox;

public class FloatVerifier extends InputVerifier
{
  public boolean verify(JComponent input) throws ClassCastException
  {
    String s = "";
    if (input instanceof JTextField)
    {
      JTextField tf = (JTextField) input;
      s = tf.getText();
    }
    else
      throw new ClassCastException("Неопознанный класс текстового поля!");
    // пустая строка допустима
    if (s.length()==0) return true;
    try
    {
      double d = LUtil.string2float(s);
    }
    catch (NumberFormatException ex)
    {
      return false;
    }
    return true;
  }
}

