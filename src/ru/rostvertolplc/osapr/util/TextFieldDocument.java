package ru.rostvertolplc.osapr.util;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.text.*;

public class TextFieldDocument extends JTextField
{
    private class FixedPlainDocument extends PlainDocument
    {

        private int maxlength;

        public void insertString(int i, String s, AttributeSet attributeset)
            throws BadLocationException
        {
          if (s==null) return;
          int len = s.length();
          if(getLength() + len > maxlength)
          {
            Toolkit.getDefaultToolkit().beep();
            s = s.substring(0, maxlength-getLength());
          }
          if (len>0) super.insertString(i, s, attributeset);
        }

        public FixedPlainDocument(int i)
        {
            maxlength = i;
        }
    }


    static final int max = 256;
    static final int maxTaskNameLength = 32;
    static final int maxDescriptionLength = 240;

    public TextFieldDocument(int i)
    {
        this("", i, i);
    }

    public TextFieldDocument(int i, int j)
    {
        this("", i, j);
    }

    public TextFieldDocument(String s, int i, int j)
    {
        super.setDocument(new FixedPlainDocument(j));
        super.setText(s);
        //super.setColumns(i);
    }

}
