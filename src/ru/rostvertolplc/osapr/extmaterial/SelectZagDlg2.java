package ru.rostvertolplc.osapr.extmaterial;

import javax.swing.*;
import java.awt.*;
import com.borland.dx.sql.dataset.*;
import com.borland.dx.dataset.*;
import com.borland.dbswing.*;
import javax.swing.tree.*;

import java.math.BigDecimal;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Enumeration;
import com.teamcenter.rac.util.*;
import java.util.Vector;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.kernel.TCComponentUser;
import com.teamcenter.rac.kernel.TCComponentRole;


public class SelectZagDlg2 extends abstractSelMatDlg
{
  DefaultMutableTreeNode nodeRoot = new DefaultMutableTreeNode( "Заготовки" );
  String sClassKind;
  String sqGroup, sqMat;
  MatGroupData tree_data = null;
  //String sColInd = null;  // Поле "обозначение"
  String sfGOST = "F7";        // Поле ГОСТ
  String sfInnerTable = "F13"; // Поле определяющее внутреннюю таблицу
  String sfPrimen = "F8";      // Поле "Применяемость"
  String sfOgranich = "F43";   // Поле "Ограничитель"
  // Массив ролей, которые видят по применяемости, остальные - по ограничителю
  String saPrimRoles[] = new String[]{"manager"};
  // поле, фактически используемое для фильтра
  String sfFactFiltr;

  Registry R = Registry.getRegistry("com.LANIT.extmaterial.extmaterial");
  IMBASE_Util IMB;
  int codeAux = 1;  // Код "вспомогательный материал" = 2
  public static final String cstAuxMat = "Вспомогательные материалы МВЗ";
  private boolean bExpanded = false; // развёрнуто ли окно
  private int old_x, old_y, old_w, old_h;

  JPanel jPanel2 = new JPanel();
  JSplitPane jSplitPane1 = new JSplitPane();
  JButton btOk = new JButton();
  JButton btCancel = new JButton();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  public Database dbMaterial = new Database();
  QueryDataSet qMat = new QueryDataSet();
  QueryDataSet qGroup = new QueryDataSet();
  JTree jTree = new JTree(nodeRoot);
  ParameterRow paramRow = new ParameterRow();
  TableScrollPane tspMaterials = new TableScrollPane();
  JScrollPane spTree = new JScrollPane(jTree);
  JdbTable dbtMat = new JdbTable();
  Column MatCatID = new Column();

  Column column1 = new Column();
  Column column2 = new Column();
  Column column3 = new Column();
  Column column4 = new Column();
  Column column5 = new Column();
  Column column6 = new Column();
  Column column7 = new Column();
  Column column8 = new Column();
  Column column9 = new Column();
  Column column10 = new Column();
  Column column11 = new Column();
  Column column12 = new Column();

  Column FKey = new Column();
  Column Level = new Column();
  Column FGostSort = new Column();
  Column FMatName = new Column();
  JSplitPane jSplitPane2 = new JSplitPane();
  TableScrollPane tspInner = new TableScrollPane();
  JdbTable dbtInner = new JdbTable();
  QueryDataSet qInner = new QueryDataSet();
  Column FInnerTable = new Column();
  Column FKey_Inner = new Column();
  Column PTableName = new Column();
  Column FMarkMat = new Column();
  Column FDescr = new Column();
  Column FGostHim = new Column();
  Column FOgranich = new Column();
  JButton btExpand = new JButton(R.getImageIcon("btExpand.ICON"));
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  Column FPrim = new Column();


  public SelectZagDlg2(Component comp)
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

  public SelectZagDlg2(Component comp, String p_sMark, TCSession theSession)
  {
    if (p_sMark!=null && p_sMark.equals(cstAuxMat)) // вспомогательный материал
    {
      codeAux = 2;
      sMatMark = null;
      setTitle("Выбор Вспомогательных материалов МВЗ из IMBASE");
    }
    else
    {
      codeAux = 1;
      sMatMark = p_sMark;
    }

    WaitDlg wdlg = null;
    sfGOST = R.getString("GOST.FIELD","F7");
    sfInnerTable = R.getString("INNER_TBL.FIELD","F13");
    sfPrimen = R.getString("PRIMEN.FIELD","F8");
    sfOgranich = R.getString("OGRANICH.FIELD","F43");
    saPrimRoles = R.getStringArray("PRIMEN.ROLES");
    sfFactFiltr = sfOgranich;

    try
    {
      // смотрим что юзер может входить в список ролей,
      // которые выбирают по применяемости в обход ограничителя
      if (theSession!=null)
      {
        //TCComponentUser u = theSession.getUser();
        //TCComponentRole roles[] = u.getRoles( u.getLoginGroup());
        //if (roles!=null && roles.length>0)
        // -- 2kX0322 - Проверяем именно текущую роль
        String sCurrRole = theSession.getRole().toString();
        for (int i=0; i<saPrimRoles.length; i++)
            if (sCurrRole.equalsIgnoreCase(saPrimRoles[i]))
            {
              sfFactFiltr = sfPrimen;
              break;
            }
      }
      wdlg = new WaitDlg();
      wdlg.setModal(false);
      Thread TH = new Thread(wdlg);
      TH.setPriority(Thread.MAX_PRIORITY);
      TH.start();
      Thread.currentThread().sleep(200);

      dbMaterial.setConnection(/* new com.borland.dx.sql.dataset.ConnectionDescriptor(
        //"jdbc:odbc:IMBASE-mat", "sysdba", "masterkey", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
        "jdbc:oracle:thin:@"+R.getString("IMBASE.SERVER")+":"+R.getString("IMBASE.PORT")+":"+R.getString("IMBASE.SID"),
        "sysdba", "sysmaster", false, "oracle.jdbc.driver.OracleDriver")); */
        IMBASE_Util.new_IMBASE_Connection(R));

      if (codeAux == 2)sqGroup = "SELECT * FROM CTL000001 where f_name!='Металлы цветные' AND f_name!='Металлы черные' order by f_name";
      else sqGroup = "SELECT * FROM CTL000001 order by f_name";
      //sqGroup = "SELECT * FROM CTL000001 WHERE F_MASK=0 or F_MASK is NULL ORDER BY F_NAME";
      //sqGroup = "SELECT * FROM CTL000001 WHERE (F_MASK=0 or F_MASK is NULL) "
      // +"and (F_OWNER=0 or F_OWNER in (select F_LEVEL from CTL000001)) ORDER BY F_NAME";

      // Проверим для sqMat наличие сортамента если задана марка материала
      
      StringBuffer tableNames=new StringBuffer();
      
      if (sMatMark!=null)
      {        sqMat = "SELECT F_KEY, F13 FROM CTL000001_REC t "+
                "WHERE F27='"+sMatMark+"' AND "+sfFactFiltr+"='+'";
        qMat.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbMaterial, sqMat, paramRow, true, Load.AS_NEEDED));
        qMat.open();
        
        
        
        if (qMat.getRowCount()==0)
        {
          
          wdlg.stop();
          MessageBox.post("Нет сортамента на этот материал!", "Выбор Сортамента из IMBASE", MessageBox.WARNING);
          return;
        }
  
        qMat.close();
        qMat = new QueryDataSet();
       
      }

      
      
      sqMat = "SELECT ctl.*, t.F_DESCR " +
      "FROM CTL000001_REC ctl, IM_TABLES t WHERE ctl.F_LEVEL = :F_LEVEL "+
      "AND ctl."+sfFactFiltr+"='+' "+ // применяемость или ограничитель
      "AND ctl."+sfInnerTable+"=t.F_TABLE ";

  

      //sqMat = "SELECT ctl.F_KEY,ctl.F_LEVEL,ctl.F5,ctl."+sfGOST+",ctl."+sfInnerTable+",ctl.F27,ctl.F26 " +
      //    "FROM CTL000001_REC ctl WHERE ctl.F_LEVEL = :F_LEVEL AND F8='+' "; // F8 = применяемость
      if (sMatMark!=null)
        sqMat += "AND F27='"+sMatMark+"'";
      else sqMat += " ORDER BY F5";
     
      
      jbInit();

      paramRow.setInt("F_LEVEL",0);
      
      //qMat.open();

      
      
      Thread.currentThread().sleep(200);
      nodeRoot.setUserObject(new MatGroupData( 0, 0, "Заготовки" ));
      IMB = new IMBASE_Util(qInner, qMat);
      IMB.sfInnerTable = sfInnerTable;
      
      if (sfFactFiltr.equals(sfPrimen))
        IMB.sfПРИМЕНЯЕМОСТЬ = "ПРИМЕНЯЕМОСТЬ";
      fillTree(nodeRoot);
      jTree.setCellRenderer(new MatTreeRenderer(null));
      jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener()
      {
        public void valueChanged(TreeSelectionEvent e)
        {
          jTree_valueChanged(e);
        }
      });

      wdlg.stop();

      pack();
      setSize(800,600);
      //setLocationRelativeTo(comp);
      java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
      Dimension dim = toolkit.getScreenSize();
      int x = (dim.width-getWidth())/2 + 50;
      int y = (dim.height-getHeight())/2 + 50;
      // Если вызвано из диалога материалов
      //if (sMatMark!=null) {x+=50;  y+=50;}
      setLocation(x, y);
      show();
    }
    catch(Exception e)
    {
      e.printStackTrace();
      wdlg.stop();
      MessageBox.post(e);
    }
  }

  private void bindNode_Parent(int ID, int Parent_ID)
  {
    DefaultMutableTreeNode
        node, root, group = null,  parent = null;

    root = (DefaultMutableTreeNode)jTree.getModel().getRoot();
    Enumeration nodes = root.breadthFirstEnumeration();
    while (nodes.hasMoreElements())
    {
      node = (DefaultMutableTreeNode) nodes.nextElement();
      int idx = ((MatGroupData)node.getUserObject()).index;
      if (idx==ID)          group = node;
      if (idx==Parent_ID)     parent = node;
      if (group!=null && parent!=null)
      {
        root.remove(group);
        parent.insert(group, parent.getChildCount());
        /*
        MatGroupData dataP = (MatGroupData)parent.getUserObject();
        MatGroupData dataC = (MatGroupData)group.getUserObject();
        dataP.count += dataC.count;
        if (dataP.count<0)
        {
          MessageBox mb = new MessageBox(String.valueOf(dataP.count), dataP.name, MessageBox.INFORMATION );
          mb.setModal(true);
          mb.show();
        }*/
        break;
      }
    }
  }

  private void removeEmptyBranches(DefaultMutableTreeNode root)
  {
    DefaultMutableTreeNode
      node, parent = null;

    //root = (DefaultMutableTreeNode) jTree.getModel().getRoot();
    Enumeration nodes = root.depthFirstEnumeration();
    //Enumeration nodes = root.children();
    while (nodes.hasMoreElements())
    {
      node = (DefaultMutableTreeNode) nodes.nextElement();
      tree_data = (MatGroupData)node.getUserObject();
      if (tree_data.key==0) continue;
      if (node.getChildCount()==0 && tree_data.count==0)
      {
        parent = (DefaultMutableTreeNode)node.getParent();
        parent.remove(node);
        nodes = root.depthFirstEnumeration();
        //root.remove(node);
      }
      
      if ((node.getChildCount()==0)&&(root.toString().equals("Заготовки")))
      {
    	//System.out.println("node="+node.toString());  
      }
      
      
      //else removeEmptyBranches(node);
    }
  }

  private void removeUnattached(DefaultMutableTreeNode root)
  {
    DefaultMutableTreeNode
      node = null;

    //Enumeration nodes = root.depthFirstEnumeration();
    Enumeration nodes = root.children();
    while (nodes.hasMoreElements())
    {
      node = (DefaultMutableTreeNode) nodes.nextElement();
      tree_data = (MatGroupData)node.getUserObject();
      if (tree_data.owner!=0)
      {
        root.remove(node);
        nodes = root.children();
      }
    }
  }
/*
  private void createMarkFolders(DefaultMutableTreeNode node)
  {
    tree_data = (MatGroupData)node.getUserObject();

    // отображаем внутреннюю таблицу только для листов дерева с маркой материала
    if (tree_data.index==IMB.CODE_LEAF)
      return;
    paramRow.setInt("F_LEVEL",tree_data.index);
    qMat.refresh();
    //IMB.updateInnerTable();

    // -- вместо того, чтобы обновлять внутреннюю таблицу,
    // добавить в дерево элементы правой верхней таблицы
    qMat.first();
    while (qMat.inBounds())
    {
      String sTable = qMat.getString(sfInnerTable);// реальное имя таблицы в БД
      IMB.setIM_TABLES_Table(sTable);
      MatGroupData data = new MatGroupData(-2, IMB.CODE_LEAF, IMB.getIM_TABLES_Field("F_DESCR") );
      data.sInnerTable = sTable;

      node.add(new DefaultMutableTreeNode(data));
      qMat.next();
    }
    // очистить таблицу qMat
    paramRow.setInt("F_LEVEL", -2);
    qMat.refresh();
    // поставить признак данного узла что он подгружен (это не лист, но и не имеет индекса уже)
    if (tree_data.index !=IMB.CODE_LEAF)
      tree_data.index = -2;
  }
*/
  private void fillTree(DefaultMutableTreeNode top)
  {
    DefaultMutableTreeNode root, group = null;
    DefaultMutableTreeNode nodeAuxMat = null;
   
    qGroup.open();
    qGroup.first();
    //int n = qGroup.getRowCount();
    //for (int i=0; i<n; i++)
    while (qGroup.inBounds())
    {
      MatGroupData data = new MatGroupData(
        qGroup.getInt("F_KEY"), qGroup.getInt("F_LEVEL"), qGroup.getString("F_NAME") );
      data.owner = qGroup.getInt("F_OWNER");
      // Проверка, есть ли там элементы
      paramRow.setInt("F_LEVEL", qGroup.getInt("F_LEVEL"));
      qMat.refresh();
      data.count = qMat.getRowCount();
     // System.out.println("qMat.getRowCount()"+qMat.getRowCount());
      group = new DefaultMutableTreeNode(data);

       // -- если вспомогательный материал
      if (codeAux==2 && data.name.equals(cstAuxMat))
      {
        nodeAuxMat = group;  // запомним его
      }
      // Папки IM не привязывать
   	  top.add(group);
      
      qGroup.next();
    }
    // -- Установление родителей
    qGroup.first();
    //for (int i=0; i<n; i++)
    while (qGroup.inBounds())
    {
      bindNode_Parent(  qGroup.getInt("F_LEVEL"),  qGroup.getInt("F_OWNER") );
      qGroup.next();
    }
    qGroup.close();

    // -- Удалить папки IM
    group = (DefaultMutableTreeNode)jTree.getModel().getRoot();
   if (codeAux==1) IMBASE_Util.removeIM_rec(group);
   else IMBASE_Util.removeIM_rec(group, codeAux);

    // -- Удалить узлы, которые никуда не прикреплены, но и не корневые (F_OWNER=0)
    root = (DefaultMutableTreeNode) jTree.getModel().getRoot();
    removeUnattached(root);

    // -- Удалить пустые, если включен фильтр по марке материала
    if (sMatMark!=null)
      removeEmptyBranches(root);

    // -- если выбран "вспомогательный материал" (codeAux=2), выкинуть всё кроме него
    if (codeAux==2 && nodeAuxMat!=null)
    {
      jTree.setModel(new DefaultTreeModel(nodeAuxMat));
    }

    // -- Для каждого узла добавить папки с марками материалов
    /*
    Enumeration nodes = root.depthFirstEnumeration();
    Vector v_nodes = new Vector();
    while (nodes.hasMoreElements())
      v_nodes.add(nodes.nextElement());
    int n = v_nodes.size();
    for (int i=0; i<n; i++)
    {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode)v_nodes.get(i);
      createMarkFolders(node);
    }*/

    // -- Развернуть самый корень дерева --
    //jTree.expandRow(0);

    // -- Развернуть до тех пор пока не будет несколько дочерних веток
    group = top;
    do{
      jTree.expandPath(new TreePath(group.getPath()));
      if(group.getChildCount()!=1) break;
      group = (DefaultMutableTreeNode)group.getFirstChild();
    }
    while(true);
  }

  public static void main(String[] args)
  {
    new SelectZagDlg2(null, null, null);
    System.exit(0);
  }

  private void jbInit() throws Exception
  {
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setMinimumSize(new Dimension(10, 40));
    jPanel2.setPreferredSize(new Dimension(10, 40));
    jPanel2.setLayout(gridBagLayout2);
    btOk.setText("ОК");
    btOk.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        btOk_actionPerformed(e);
      }
    });
    btCancel.setText("Отмена");
    btCancel.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        btCancel_actionPerformed(e);
      }
    });
    jPanel1.setLayout(gridBagLayout1);

    qMat.setReadOnly(true);
    qMat.setEditable(false);
    qMat.setEnableInsert(false);
    qMat.setEnableUpdate(false);
    qMat.setEnableDelete(false);
    qMat.close();
    qMat.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbMaterial, sqMat, paramRow, true, Load.AS_NEEDED));

    qGroup.setReadOnly(true);
    qGroup.setEditable(false);
    qGroup.setEnableInsert(false);
    qGroup.setEnableUpdate(false);
    qGroup.setEnableDelete(false);
    qGroup.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbMaterial, sqGroup, null, true, Load.ALL));
    jSplitPane1.setDebugGraphicsOptions(0);
    jSplitPane1.setDividerSize(4);
    jSplitPane1.setResizeWeight(0.2);
    jTree.setMinimumSize(new Dimension(100, 100));
    this.setModal(true);
    //this.setAlwaysOnTop(true);
    this.setTitle("Выбор Cортамента из БД IMBASE");
    this.addWindowListener(new java.awt.event.WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {
        this_windowClosing(e);
      }
    });
    tspMaterials.setMinimumSize(new Dimension(28, 28));
    MatCatID.setColumnName("F_LEVEL");
    MatCatID.setDataType(com.borland.dx.dataset.Variant.INT);
    MatCatID.setDefault("2");
    MatCatID.setParameterType(ParameterType.IN);
    MatCatID.setPreferredOrdinal(1);
    MatCatID.setServerColumnName("NewColumn1");
    MatCatID.setSqlType(0);
    dbtMat.setDataSet(qMat);
    dbtMat.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        dbtMat_mouseClicked(e);
      }
    });

    column2.setColumnName("F_KEY");
    column2.setDataType(com.borland.dx.dataset.Variant.INT);
    column2.setPrecision(10);
    column2.setScale(0);
    column2.setServerColumnName("F_KEY");
    column2.setSqlType(3);
    column3.setColumnName("F_OWNER");
    column3.setDataType(com.borland.dx.dataset.Variant.INT);
    column3.setPrecision(10);
    column3.setScale(0);
    column3.setServerColumnName("F_OWNER");
    column3.setSqlType(3);
    column4.setColumnName("F_LEVEL");
    column4.setDataType(com.borland.dx.dataset.Variant.INT);
    column4.setPrecision(10);
    column4.setScale(0);
    column4.setServerColumnName("F_LEVEL");
    column4.setSqlType(3);
    column5.setColumnName("F_SORT");
    column5.setDataType(com.borland.dx.dataset.Variant.INT);
    column5.setPrecision(10);
    column5.setScale(0);
    column5.setServerColumnName("F_SORT");
    column5.setSqlType(3);
    column6.setColumnName("F_MASK");
    column6.setDataType(com.borland.dx.dataset.Variant.INT);
    column6.setPrecision(10);
    column6.setScale(0);
    column6.setServerColumnName("F_MASK");
    column6.setSqlType(3);
    column7.setColumnName("F_TAG1");
    column7.setDataType(com.borland.dx.dataset.Variant.INT);
    column7.setPrecision(10);
    column7.setScale(0);
    column7.setServerColumnName("F_TAG1");
    column7.setSqlType(3);
    column8.setColumnName("F_TAG2");
    column8.setDataType(com.borland.dx.dataset.Variant.INT);
    column8.setPrecision(10);
    column8.setScale(0);
    column8.setServerColumnName("F_TAG2");
    column8.setSqlType(3);
    column9.setColumnName("F_TEXTID");
    column9.setDataType(com.borland.dx.dataset.Variant.INT);
    column9.setPrecision(10);
    column9.setScale(0);
    column9.setServerColumnName("F_TEXTID");
    column9.setSqlType(3);
    column10.setColumnName("F_GRAPHID");
    column10.setDataType(com.borland.dx.dataset.Variant.INT);
    column10.setPrecision(10);
    column10.setScale(0);
    column10.setServerColumnName("F_GRAPHID");
    column10.setSqlType(3);
    column11.setColumnName("F_TAG3");
    column11.setDataType(com.borland.dx.dataset.Variant.INT);
    column11.setPrecision(10);
    column11.setScale(0);
    column11.setServerColumnName("F_TAG3");
    column11.setSqlType(3);
    column12.setColumnName("F_TAG4");
    column12.setDataType(com.borland.dx.dataset.Variant.INT);
    column12.setPrecision(10);
    column12.setScale(0);
    column12.setServerColumnName("F_TAG4");
    column12.setSqlType(3);

    FKey.setColumnName("F_KEY");
    FKey.setDataType(com.borland.dx.dataset.Variant.INT);
    FKey.setPrecision(10);
    FKey.setPreferredOrdinal(0);
    FKey.setRowId(true);
    FKey.setScale(0);
    FKey.setVisible(com.borland.jb.util.TriStateProperty.FALSE);
    FKey.setServerColumnName("F_KEY");
    FKey.setSqlType(3);
    Level.setColumnName("F_LEVEL");
    Level.setDataType(com.borland.dx.dataset.Variant.INT);
    Level.setPrecision(10);
    Level.setPreferredOrdinal(1);
    Level.setScale(0);
    Level.setVisible(com.borland.jb.util.TriStateProperty.FALSE);
    Level.setServerColumnName("F_LEVEL");
    Level.setSqlType(3);
    FGostSort.setCaption("ГОСТ на Сортамент");
    FGostSort.setColumnName("F35");
    FGostSort.setCurrency(false);
    FGostSort.setDataType(com.borland.dx.dataset.Variant.STRING);
    FGostSort.setPrecision(64);
    FGostSort.setWidth(16);
    FGostSort.setPreferredOrdinal(5);
    FGostSort.setServerColumnName("F35");
    FGostSort.setSqlType(12);
    FMatName.setCaption("Наименование");
    FMatName.setColumnName("F5");
    FMatName.setDataType(com.borland.dx.dataset.Variant.STRING);
    FMatName.setWidth(12);
    FMatName.setPreferredOrdinal(3);
    FMatName.setServerColumnName("F5");
    FMatName.setSqlType(16);
    jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane2.setDividerSize(5);
    jSplitPane2.setLastDividerLocation(100);
    qInner.setDisplayErrors(true);
    qInner.setReadOnly(true);
    qInner.setEditable(false);
    qInner.setTableName("");
    qInner.setEnableInsert(false);
    qInner.setEnableUpdate(false);
    qInner.setEnableDelete(false);
    FInnerTable.setCaption("Inner Table");
    FInnerTable.setColumnName("F13");
    FInnerTable.setDataType(com.borland.dx.dataset.Variant.STRING);
    FInnerTable.setPreferredOrdinal(7);
    FInnerTable.setVisible(com.borland.jb.util.TriStateProperty.TRUE);
    FInnerTable.setServerColumnName("F13");
    FInnerTable.setSqlType(0);
    dbtInner.setDataSet(qInner);
    FKey_Inner.setColumnName("F_KEY");
    FKey_Inner.setDataType(com.borland.dx.dataset.Variant.BIGDECIMAL);
    FKey_Inner.setPrecision(10);
    FKey_Inner.setRowId(true);
    FKey_Inner.setScale(0);
    FKey_Inner.setVisible(com.borland.jb.util.TriStateProperty.FALSE);
    FKey_Inner.setServerColumnName("F_KEY");
    FKey_Inner.setSqlType(3);

    PTableName.setCaption("TABLE_NAME");
    PTableName.setColumnName("TABLE_NAME");
    PTableName.setDataType(com.borland.dx.dataset.Variant.STRING);
    PTableName.setParameterType(ParameterType.IN);
    PTableName.setPreferredOrdinal(1);
    PTableName.setServerColumnName("NewColumn1");
    PTableName.setSqlType(0);
    FMarkMat.setCaption("Марка Материала");
    FMarkMat.setColumnName("F27");
    FMarkMat.setDataType(com.borland.dx.dataset.Variant.STRING);
    FMarkMat.setPreferredOrdinal(6);
    FMarkMat.setVisible(com.borland.jb.util.TriStateProperty.TRUE);
    FMarkMat.setServerColumnName("F27");
    FMarkMat.setSqlType(0);
    FDescr.setCaption("Описание");
    FDescr.setColumnName("F_DESCR");
    FDescr.setDataType(com.borland.dx.dataset.Variant.STRING);
    FDescr.setPreferredOrdinal(4);
    FDescr.setWidth(35);
    FDescr.setServerColumnName("F_DESCR");
    FDescr.setSqlType(0);
    FGostHim.setCaption("ГОСТ на Хим.состав");
    FGostHim.setColumnName("F26");
    FGostHim.setDataType(com.borland.dx.dataset.Variant.STRING);
    FGostHim.setPreferredOrdinal(8);
    FGostHim.setVisible(com.borland.jb.util.TriStateProperty.FALSE);
    FGostHim.setServerColumnName("F26");
    FGostHim.setSqlType(0);
    btExpand.setMaximumSize(new Dimension(25, 25));
    btExpand.setPreferredSize(new Dimension(25, 25));
    btExpand.setMargin(new Insets(2, 2, 2, 2));
    btExpand.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        btExpand_actionPerformed(e);
      }
    });
    jLabel1.setText(".");
    jLabel2.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel2.setText(".");
    FPrim.setCaption("Примен.");
    FPrim.setColumnName(sfPrimen);
    FPrim.setDataType(com.borland.dx.dataset.Variant.STRING);
    FPrim.setDefault("");
    FPrim.setPreferredOrdinal(2);
    FPrim.setVisible(com.borland.jb.util.TriStateProperty.DEFAULT);
    FPrim.setWidth(6);
    FPrim.setServerColumnName(sfPrimen);
    FPrim.setSqlType(0);

    FOgranich.setCaption("Огранич.");
    FOgranich.setColumnName(sfOgranich);
    FOgranich.setDataType(com.borland.dx.dataset.Variant.STRING);
    FOgranich.setDefault("");
    FOgranich.setPreferredOrdinal(3);
    FOgranich.setVisible(com.borland.jb.util.TriStateProperty.DEFAULT);
    FOgranich.setWidth(6);
    FOgranich.setServerColumnName(sfOgranich);
    FOgranich.setSqlType(0);
    jSplitPane1.add(spTree, JSplitPane.LEFT);
    spTree.getViewport().add(jTree, null);
    this.getContentPane().add(jPanel2, BorderLayout.SOUTH);
    jPanel2.add(btOk,     new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(btCancel,     new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(btExpand,      new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel1,   new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2,   new GridBagConstraints(3, 0, 1, 1, 0.9, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    this.getContentPane().add(jSplitPane1, BorderLayout.CENTER);
    jSplitPane1.add(jPanel1, JSplitPane.RIGHT);
    jPanel1.add(jSplitPane2,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    jSplitPane2.add(tspMaterials, JSplitPane.TOP);
    jSplitPane2.add(tspInner, JSplitPane.BOTTOM);
    tspInner.getViewport().add(dbtInner, null);
    tspMaterials.getViewport().add(dbtMat, null);
    jSplitPane1.setDividerLocation(240);
    qGroup.setColumns(new Column[] {column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12});
    jSplitPane2.setDividerLocation(150);//--
    //qInner.setColumns(new Column[] {column13, column14, column15, column18, column21, column16, column17, column19, column20});
    qInner.setColumns(new Column[] {FKey_Inner});
    paramRow.setColumns(new Column[] {MatCatID, PTableName});
    qMat.setColumns(new Column[] {FKey, FOgranich, Level, FPrim, FMatName, FDescr, FGostSort, FMarkMat, FInnerTable, FGostHim});
  }

  void DlgExit()
  {
    qMat.close();
    qGroup.close();
    dbMaterial.closeConnection();
    hide();
  }


  void btOk_actionPerformed(ActionEvent e)
  {
	
	
    if (dbtInner.getRowCount()>0){
    	sMatName = "";
    
    sMatSort = qMat.getString("F5");
    if (sMatSort.length()==0 )
      sMatSort = tree_data.name;
    if (IMB.sColInd!=null) // Если есть формула расчёта обозначения то посчитать
    {
      sMatSort = IMB.BuildIndication();
    }
/**/

    sMatNDSort = qMat.getString(sfGOST);
    //if (sMatNDSort.length()==0 && qInner.hasColumn("F7")!=null )
    //  sMatNDSort = qInner.getString("F7");

    sMatShifr = Integer.toString( qMat.getInt("F_KEY") )+'-'+Integer.toString( qInner.getBigDecimal("F_KEY").intValue() );
    sIMBASE_Code = IMB.makeIMBASE_Code(IMBASE_Util.cstCTL_SORT);


   // -- Если вспомогательный материал, то попробовать взять плотность
   //if (codeAux==2) // на самом деле надо пробовать взять плотность в сортаменте независимо от типа материала
   System.out.println("do fDensity");
    {
     fDensity = IMB.getDensity();
   
   }
   if (fDensity == -1.0) // если не получилось... то ...
   {
     // -- Считать плотность из связанной марки
     // i6 TTTTTT FFFFFF RRRRRR
     // i6 - сигнатура = "i6"
     // T - HEX-ключ каталога в IM_TABLES
     // F - HEX-ключ записи в каталоге
     // R - HEX-ключ записи во внутренней таблице

     /*
         DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTree.getSelectionPath().getLastPathComponent();
         MatGroupData data = (MatGroupData)((DefaultMutableTreeNode)node.getParent()).getUserObject();
         paramRow.setInt("F_LEVEL",data.index);
         qMat.refresh();
      */
     String sMtr = qMat.getString("F25"); // ссылка на марку материала
     if (sMtr.startsWith("i6"))
     {
       int idxCat = Integer.parseInt(sMtr.substring(2, 8), 16);
       int idxRecCat = Integer.parseInt(sMtr.substring(8, 14), 16);
       int idxRecTbl = Integer.parseInt(sMtr.substring(14), 16);
       QueryDataSet qMatCat = new QueryDataSet();
       qMatCat.setQuery(new QueryDescriptor(dbMaterial,
         "SELECT " + sfInnerTable + " FROM CTL000002_REC WHERE F_KEY='"+String.valueOf(idxRecCat) + "'", null, true, Load.ALL));
       qMatCat.open();
       if (qMatCat.getRowCount() > 0)
       {
         String sInnerTable = qMatCat.getString(sfInnerTable);
         QueryDataSet qMatRec = new QueryDataSet();
         qMatRec.setQuery(new QueryDescriptor(dbMaterial,
           "SELECT * FROM " + sInnerTable + " WHERE F_KEY='" + String.valueOf(idxRecTbl)+"'", null, true, Load.ALL));
         qMatRec.open();
         IMBASE_Util IMB2 = new IMBASE_Util(qMatRec, qMatCat);
         IMB2.paramRow.setString("TABLE_NAME", sInnerTable);
         fDensity = IMB2.getDensity();
       }
       qMatCat.close();
     }
   } // если после вспомогательных плотность не нашлась
   // -- -- -- -- -- -- -- --- ----- - - - - -- - - - - - -
	iResult = 1;

    DlgExit();
    }
    else {
    	MessageBox.post("Сортамент не выбран", "Teamcenter", MessageBox.INFORMATION);
    	this.setAlwaysOnTop(true);
    	this.setAlwaysOnTop(false);
    }
  }

  void btCancel_actionPerformed(ActionEvent e)
  {
    sMatShifr = null; // Отмена - значит нет выбора
    DlgExit();
  }

  void jTree_valueChanged(TreeSelectionEvent evTreeChange)
  {
    TreePath path = evTreeChange.getPath();
    // Если это не новый компонент стал выделенным, а событие о развыделении старого, выйти
    if (!evTreeChange.isAddedPath(path)) return;
    DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
    tree_data = (MatGroupData)node.getUserObject();
    /*
    // отображаем внутреннюю таблицу только для листов дерева с маркой материала
    if (tree_data.index==IMB.CODE_LEAF)
    {
      IMB.qInner.open();
      IMB.updateInnerTable(tree_data.sInnerTable);
      return;
    }
    else
      IMB.qInner.close();
    */
    paramRow.setInt("F_LEVEL",tree_data.index);
    qMat.refresh();
    IMB.updateInnerTable(null);
  }

  void dbtMat_mouseClicked(MouseEvent e)
  {
    //if (e.getClickCount()==2)
    //  btOk_actionPerformed(new ActionEvent(btOk, ActionEvent.ACTION_PERFORMED, "OK"));
    if (e.getClickCount()==1)
    {
      IMB.updateInnerTable(null);
    }

  }

  void this_windowClosing(WindowEvent e)
  {
    sMatShifr = null; // Закрытие крестом равно отмене
    DlgExit();
  }

  // развернуть диалог на весь экран
  void btExpand_actionPerformed(ActionEvent e)
  {
    java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
    Dimension dim = toolkit.getScreenSize();
    int x=0, y=0;
    if (bExpanded)
    {
      x = old_x;  y = old_y;
      setSize(old_w, old_h);
    }
    else
    {
      Point p=getLocation();
      old_x = p.x;  old_y = p.y;
      old_w = getWidth();  old_h = getHeight();
      setSize(dim.width, dim.height);
    }
    setLocation(x, y);
    validate();
    bExpanded = !bExpanded;
  }

}

