package ru.rostvertolplc.osapr.extmaterial;

import javax.swing.tree.*;
import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JTree;

class MatTreeRenderer extends DefaultTreeCellRenderer
{
    Icon customIcon;

    public MatTreeRenderer(Icon icon)
    {
        customIcon = icon;
    }

    public Component getTreeCellRendererComponent( JTree tree, Object value,
        boolean sel, boolean expanded,  boolean leaf, int row, boolean hasFocus)
    {
      boolean my_leaf = false;
      // если это элемент марки материала, то рисуем как лист (конечный элемент)
      if (value!=null)
      {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        MatGroupData data = (MatGroupData) node.getUserObject();
        if (data!=null)
          my_leaf = data.index == IMBASE_Util.CODE_LEAF;
      }
      super.getTreeCellRendererComponent( tree, value, sel, expanded, my_leaf, row, hasFocus);
      return this;
    }
}
