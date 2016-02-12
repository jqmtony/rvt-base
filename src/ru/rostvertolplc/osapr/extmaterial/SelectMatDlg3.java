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
import oracle.jdbc.driver.*;
import java.sql.DriverManager;
//import com.teamcenter.rac.util.Registry;
import com.teamcenter.rac.kernel.TCSession;


public class SelectMatDlg3 extends abstractSelMatDlg implements intfExternalMaterial
{
  private static final long serialVersionUID = 1796812575392873020L;
  
  TCSession session;
  DefaultMutableTreeNode nodeRoot = new DefaultMutableTreeNode( "Материалы" );

  String sqGroup, sqMat;
  MatGroupData tree_data = null;
  //String sColInd = null;  // Поле "обозначение"
  Registry R = Registry.getRegistry(this);
  IMBASE_Util IMB;

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
  Column FGOST = new Column();
  Column FMatName = new Column();
  JSplitPane jSplitPane2 = new JSplitPane();
  TableScrollPane tspInner = new TableScrollPane();
  JdbTable dbtInner = new JdbTable();
  QueryDataSet qInner = new QueryDataSet();
  Column FInnerTable = new Column();
  QueryDataSet qFields = new QueryDataSet();
  Column parTableName = new Column();
  Column FPrim = new Column();


  public SelectMatDlg3(Component comp)
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

  public SelectMatDlg3(Component comp, int x, TCSession theSession)
  {
    WaitDlg wdlg=null;
    session = theSession;
    try
    {
      /* ---- Пример работы через чистый jdbc ----
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      java.sql.Connection conn = DriverManager.getConnection
              ("jdbc:oracle:thin:@simbase:1521:IMBASE","sysdba","masterkey");
      // Create Oracle DatabaseMetaData object
      java.sql.DatabaseMetaData meta = conn.getMetaData();
      // gets driver info:
      System.out.println("JDBC driver version is " + meta.getDriverVersion());
      conn.close();
      //------------------------------------------*/

      sqGroup = "SELECT * FROM CTL000002 WHERE F_MASK=0 or F_MASK is NULL ORDER BY F_NAME";
      sqMat = "SELECT ctl.F8,ctl.F_KEY,ctl.F_LEVEL,ctl.F5,ctl.F7,ctl.F13, t.F_DESCR \"Описание\" " +
          "FROM CTL000002_REC ctl, IM_TABLES t "+
          "WHERE ctl.F8 = '+' AND ctl.F_LEVEL = :F_LEVEL AND ctl.F13 = t.F_TABLE "+
          "ORDER BY ctl.F5 ";

      jbInit();

      wdlg = new WaitDlg();
      wdlg.setModal(false);
      Thread TH = new Thread(wdlg);
      TH.setPriority(Thread.MAX_PRIORITY);
      TH.start();
      //Thread.currentThread().sleep(10000);

      paramRow.setInt("F_LEVEL",0);
      qMat.open();

      Thread.currentThread().sleep(200);
      nodeRoot.setUserObject(new MatGroupData( 0, 0, "Материалы" ));
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
      setLocation((dim.width-getWidth())/2, (dim.height-getHeight())/2);

      IMB = new IMBASE_Util(qInner, qMat);

      show();
    }
/*    catch(DataSetException de)
    {
      de.printStackTrace();
      wdlg.stop();
    }*/
    catch(Exception e)
    {
      e.printStackTrace();
      wdlg.stop();
      MessageBox.post(e);
    }

  }

  // -- Сваязывает узлы по индексу, возвращает объект узла по индексу ID
  private DefaultMutableTreeNode bindNode_Parent(int ID, int Parent_ID)
  {
    DefaultMutableTreeNode
        node, root, group = null,  parent = null;

    root = (DefaultMutableTreeNode)jTree.getModel().getRoot();
    Enumeration nodes = root.breadthFirstEnumeration();
    while (nodes.hasMoreElements())
    {
      node = (DefaultMutableTreeNode) nodes.nextElement();
      int data = ((MatGroupData)node.getUserObject()).index;
      if (data==ID)          group = node;
      if (data==Parent_ID)     parent = node;
      if (group!=null && parent!=null)
      {
        root.remove(group);
        parent.insert(group, parent.getChildCount());
        break;
      }
    }
    return group;
  }

  private void fillTree(DefaultMutableTreeNode top)
  {
    DefaultMutableTreeNode group = null;

    qGroup.open();
    qGroup.first();
    //int n = qGroup.getRowCount();
    //for (int i=0; i<n; i++)
    while (qGroup.inBounds())
    {
      MatGroupData data = new MatGroupData( qGroup.getInt("F_KEY"), qGroup.getInt("F_LEVEL"), qGroup.getString("F_NAME") );
      group = new DefaultMutableTreeNode(data);
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
    IMBASE_Util.removeIM_rec(group);
    
    // -- Развернуть самый корень дерева --
    jTree.expandRow(0);
  }

  public static void main(String[] args)
  {
    new SelectMatDlg3(null, 1, null);
    System.exit(0);
  }

  private void jbInit() throws Exception
  {
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setMinimumSize(new Dimension(10, 40));
    jPanel2.setPreferredSize(new Dimension(10, 40));
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
//    dbMaterial.setConnection(new com.borland.dx.sql.dataset.ConnectionDescriptor("jdbc:odbc:IMBASE-mat", "sysdba", "masterkey", false, "sun.jdbc.odbc.JdbcOdbcDriver"));
    dbMaterial.setConnection( /* new com.borland.dx.sql.dataset.ConnectionDescriptor(
//    "jdbc:oracle:thin:@simbase:1521:IMBASE","sysdba", "masterkey", false, "oracle.jdbc.driver.OracleDriver"));
      "jdbc:oracle:thin:@"+R.getString("IMBASE.SERVER")+":"+R.getString("IMBASE.PORT")+":"+R.getString("IMBASE.SID"),
      "sysdba", "sysmaster", false, "oracle.jdbc.driver.OracleDriver")); */
      IMBASE_Util.new_IMBASE_Connection(R));

    qMat.setReadOnly(true);
    qMat.setEditable(false);
    qMat.setEnableInsert(false);
    qMat.setEnableUpdate(false);
    qMat.setEnableDelete(false);
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
    this.setTitle("Выбор материала из БД IMBASE");
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
    FGOST.setCaption("ГОСТ");
    FGOST.setColumnName("F7");
    FGOST.setCurrency(false);
    FGOST.setDataType(com.borland.dx.dataset.Variant.STRING);
    FGOST.setPrecision(64);
    FGOST.setWidth(16);
    FGOST.setPreferredOrdinal(4);
    FGOST.setServerColumnName("F7");
    FGOST.setSqlType(12);
    FMatName.setCaption("Наименование");
    FMatName.setColumnName("F5");
    FMatName.setDataType(com.borland.dx.dataset.Variant.STRING);
    FMatName.setPrecision(20);
    FMatName.setWidth(12);
    FMatName.setPreferredOrdinal(3);
    FMatName.setServerColumnName("F5");
    FMatName.setSqlType(12);
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
    //qInner.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbMaterial, "SELECT * FROM TBL000143", null, true, Load.ALL));
    FInnerTable.setCaption("Inner Table");
    FInnerTable.setColumnName("F13");
    FInnerTable.setDataType(com.borland.dx.dataset.Variant.STRING);
    FInnerTable.setPreferredOrdinal(5);
    FInnerTable.setVisible(com.borland.jb.util.TriStateProperty.FALSE);
    FInnerTable.setServerColumnName("F13");
    FInnerTable.setSqlType(0);
    dbtInner.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    dbtInner.setDataSet(qInner);
    dbtInner.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        dbtInner_mouseClicked(e);
      }
    });
    qFields.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(dbMaterial, "select f.* from IM_FIELDS f, IM_TABLES t\nwhere f.F_TABLE_ID=t.F_KEY\n" +
      "and t.F_TABLE=:TABLE_NAME", paramRow, true, Load.ALL));
    parTableName.setColumnName("TABLE_NAME");
    parTableName.setDataType(com.borland.dx.dataset.Variant.STRING);
    parTableName.setPreferredOrdinal(2);
    parTableName.setServerColumnName("NewColumn1");
    parTableName.setSqlType(0);
    FPrim.setCaption("Прим.");
    FPrim.setColumnName("F8");
    FPrim.setDataType(com.borland.dx.dataset.Variant.STRING);
    FPrim.setPreferredOrdinal(2);
    FPrim.setWidth(6);
    FPrim.setServerColumnName("F8");
    FPrim.setSqlType(0);
    jSplitPane1.add(spTree, JSplitPane.LEFT);
    spTree.getViewport().add(jTree, null);
    jPanel2.add(btOk, null);
    jPanel2.add(btCancel, null);
    this.getContentPane().add(jSplitPane1, BorderLayout.CENTER);
    jSplitPane1.add(jPanel1, JSplitPane.RIGHT);
    jPanel1.add(jSplitPane2,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    jSplitPane2.add(tspMaterials, JSplitPane.TOP);
    jSplitPane2.add(tspInner, JSplitPane.BOTTOM);
    this.getContentPane().add(jPanel2, BorderLayout.SOUTH);
    tspInner.getViewport().add(dbtInner, null);
    tspMaterials.getViewport().add(dbtMat, null);
    jSplitPane1.setDividerLocation(250);
    qGroup.setColumns(new Column[] {column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12});
    jSplitPane2.setDividerLocation(100);
    paramRow.setColumns(new Column[] {MatCatID, parTableName});
    qMat.setColumns(new Column[] {FKey, Level, FPrim, FMatName, FGOST, FInnerTable});
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
    if (fDensity <= 0)  fDensity = IMB.getDensity();
    if (sMatName == null || sMatName.length() == 0)
      sMatName = qMat.getString("F5");
    if (sMatName == null || sMatName.length() == 0)
      sMatName = tree_data.name;

    sMatMark = qInner.getString(0); // F2 - первое

    sMatNDMark = qMat.getString("F7");
    
    // -- Шифр материала имени С.Дмитриева -- 
    if (sMatShifr==null) // если сортамент не выбирался, то на 2 позиции будет точное указание марки, на 3-ей - ноль
    {
      sMatShifr = qInner.getString("Марка материала");
      sMatShifr += "-0-0";
    }
    else
      sMatShifr = Integer.toString( qMat.getInt("F_KEY") )+'-'+sMatShifr;
    
    // -- Шифр материала имени IMBASE --
    if (sIMBASE_Code==null) // если сортамент не выбирался, то шифр будет пустой
    {
      sIMBASE_Code = IMB.makeIMBASE_Code(IMBASE_Util.cstCTL_MARK);
    }
    // А иначе, если шифр не пустой, то он уже сформирован в окне сортаментов
    
// -- DEBUG --
/*    MessageBox.post("sMatName="+sMatName+"\n"+ "sMatMark="+sMatMark+"\n"+
                    "sMatNDMark="+sMatNDMark+"\n"+ "sMatSort="+sMatSort+"\n"+
                    "sMatNDSort="+sMatNDSort+"\n"+ "Плотность="+String.valueOf(fDensity),
                    "Результат: "+sMatShifr, MessageBox.INFORMATION);
*/
	iResult = 1;
    DlgExit();
  }

  void btCancel_actionPerformed(ActionEvent e)
  {
    sMatShifr = null; // Закрытие крестом равно отмене
    DlgExit();
  }

  void jTree_valueChanged(TreeSelectionEvent evTreeChange)
  {
    TreePath path = evTreeChange.getPath();
    // Если это не новый компонент стал выделенным, а событие о развыделении старого, выйти
    if (!evTreeChange.isAddedPath(path)) return;
    DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
    tree_data = (MatGroupData)node.getUserObject();
    paramRow.setInt("F_LEVEL",tree_data.index);
    qMat.refresh();
    //IMB.updateInnerTable(null);
    // -- вместо этого - вывод только различных марок
    String sNameTable = qMat.getString(IMB.sfInnerTable);
    // если нет таблицы, просто очистить qInner
    if (sNameTable.length()==0)
      { qInner.close(); return; }

    String sqInner = "SELECT DISTINCT F2 \"Марка материала\"";
    IMB.update_qFields(sNameTable);
    String sField = IMB.askRealField(null, "DENS");
    if (sField!=null)
      sqInner += ','+sField+" плотность";

    sqInner += " FROM "+sNameTable+" ORDER BY F2";

    if (qInner.isOpen()) qInner.close();
    qInner.setQuery(new QueryDescriptor(dbMaterial, sqInner, null, true, Load.AS_NEEDED));
    qInner.open();
  }

  void dbtMat_mouseClicked(MouseEvent e)
  {
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

  void dbtInner_mouseClicked(MouseEvent e)
  {
    if (e.getClickCount()==2)
    {
      //fDensity = IMB.getDensity();
      //btOk_actionPerformed(new ActionEvent(btOk, ActionEvent.ACTION_PERFORMED, "OK"));
      // -- вызвать сортамент с фильтром по марке
      SelectZagDlg2 sortDlg = new SelectZagDlg2(dbtInner, qInner.getString(0), session); //F2 - первый и единственный
      //SelectZagDlg2 sortDlg = new SelectZagDlg2(dbtInner, null);
      sMatSort = sortDlg.sMatSort;
      sMatNDSort = sortDlg.sMatNDSort;
      fDensity = sortDlg.fDensity;
      // -- шифр материала устанавливается так:
      // <марка>-<FKEY qMat Sortament>-<FKEY qInner Sortament>
      // найдя сортамент там есть ссылка IMBASE на материал типа i6 TTTTTT FFFFFF RRRRRR
      // если хочется найти точную марку, так что имеем полную инфу
      if (sortDlg.sMatShifr!=null)
      {
        sMatShifr = sortDlg.sMatShifr;
        sIMBASE_Code = sortDlg.sIMBASE_Code;
        btOk.doClick();
        //btOk_actionPerformed(new ActionEvent(btOk, ActionEvent.ACTION_PERFORMED, "OK")); // DlgExit();
      }
    }
  }

  String makeMatFullName()
  {
    if (sMatShifr==null)
      return "";

    // Сформировать строку для спец-ии
    String sNameSpec = sMatSort;// + " " + sNDSort).trim();
    /* -- Была попытка добавлять в полное маименование компоненты, если их нет
     * но это не правильно, т.к. необходимо строгое формирование как в IMBASE 
     * без волюнтаризма
     * --
    if (sMatSort==null || sMatSort.length()==0)
    {
      sNameSpec = sMatName.trim();
      sNameSpec = (sNameSpec + " " + sMatMark).trim();
      sNameSpec = (sNameSpec + " " + sMatNDMark).trim();
    }*/
    return sNameSpec;
  }

  public String getMaterial()
  {
    String sMaterial = makeMatFullName();
    return sMaterial;
  }

}
