package ru.rostvertolplc.osapr.util;

import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.text.*;

public class TextAreaDocument extends JTextArea
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
    static final int defaultRow = 3;
    static final int defaultColumn = 20;

    public TextAreaDocument(int j)
    {
        this("", 3, j/3+1, j);
    }

    public TextAreaDocument(int i, int j)
    {
        this("", i, j, j);
    }

    public TextAreaDocument(int i, int j, int k)
    {
        this("", i, j, k);
    }

    public TextAreaDocument(String s, int i, int j, int k)
    {
        super.setDocument(new FixedPlainDocument(k));
        if(s == null)
            super.setText("");
        else
            super.setText(s);
        super.setRows(i);
        super.setColumns(j);
    }

}