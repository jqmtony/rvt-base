package ru.rostvertolplc.osapr.util;

import javax.swing.AbstractListModel;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @SIMIiX
 * @version 1.0
 */

public class LListModel extends AbstractListModel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 513582250215375132L;
String data[] = {"Строка 1", "Строка 2"};
  public LListModel() {  }
  public LListModel(String[] array )
  {
    data = array;
  }

  public int getSize()
  {
    if (data==null) return 0;
    return data.length;
  }

  public Object getElementAt(int index)
  {
    if (index >= getSize() || index < 0) return null;
    return data[index];
  }

  public void setData(String[] array )
  {
    data = array;
  }
}
