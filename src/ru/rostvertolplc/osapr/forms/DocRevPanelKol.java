package ru.rostvertolplc.osapr.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
//import javax.swing.text.BadLocationException;

import ru.rostvertolplc.osapr.util.LUtil;
import ru.rostvertolplc.osapr.util.TextFieldDocument;
import com.teamcenter.rac.commands.newitem.ItemRevMasterFormPanel;
//import com.teamcenter.rac.commands.newitem.NewItemPanel;
import com.teamcenter.rac.common.lov.LOVComboBox;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentDataset;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCComponentListOfValues;
import com.teamcenter.rac.kernel.TCComponentListOfValuesType;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCProperty;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.stylesheet.AbstractRendering;
import com.teamcenter.rac.util.DateButton;
import com.teamcenter.rac.commands.newitem.AbstractNewItemPanel;

public class DocRevPanelKol extends AbstractRendering {
	private static final long serialVersionUID = 3313029869567370366L;

	public DocRevPanelKol(TCComponentForm theForm) throws Exception {
		super(theForm);
		// session = theForm.getSession();
		rev_form = theForm;
		item_rev = (TCComponentItemRevision) rev_form
				.getReferenceProperty("item_for_form");
		if (item_rev != null)
			item = item_rev.getItem();
		session = item != null ? (TCSession) item.getSession()
				: (TCSession) rev_form.getSession();
		loadRendering();
	}

	public JLabel LHeader = new JLabel();
	TCSession session;
	private JLabel LTrud = new JLabel();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel5 = new JLabel();
	private JLabel jLabel10 = new JLabel();
	private JTextField dateCreate = new JTextField();
	private JTextField edIndication = new TextFieldDocument(128);
	JComboBox<String> cbLiter1 = new JComboBox<String>();
	JTabbedPane TabbedPane = new JTabbedPane();
	JPanel MainPanel = new JPanel();
	GridBagLayout gridBagLayout3 = new GridBagLayout();
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;
	TitledBorder titledBorder4;
	private JLabel jLabel26 = new JLabel();
	private JLabel jLabel14 = new JLabel();
	private JTextField edCodeDSE = new TextFieldDocument(15);
	BorderLayout borderLayout1 = new BorderLayout();
	private JLabel jLabel21 = new JLabel();
	private JTextField edNameFull = new TextFieldDocument(256);
	private JTextField edTrud = new TextFieldDocument(10);
	private JLabel jLabel110 = new JLabel();
	private DateButton dateChange = new DateButton();
	private JLabel LReviewer = new JLabel();
	private JPanel jpSignOffs = new JPanel();
	private DateButton dateNK = new DateButton();
	private JTextField edNormocontrol = new JTextField();
	private JLabel LApprover2 = new JLabel();
	private DateButton dateTK = new DateButton();
	private JLabel LApprover1 = new JLabel();
	private DateButton dateApprove = new DateButton();
	private JLabel LCreator = new JLabel();
	private JTextField edReviewer = new JTextField();
	private JTextField edNachOtd = new JTextField();
	private JLabel LNormo = new JLabel();
	private JTextArea edAdditional = new JTextArea();
	private JLabel LApprover = new JLabel();
	private DateButton dateCreator = new DateButton();
	private JLabel jLabel12 = new JLabel();
	private GridBagLayout gridbagLayout1 = new GridBagLayout();
	private DateButton dateReview = new DateButton();
	private JTextField edTechcontrol = new JTextField();
	public JTextField edKolListov = new JTextField();
	private DateButton dateNachOtd = new DateButton();
	private JTextField edApprover = new JTextField();
	private JLabel jLabel23 = new JLabel();
	private JComboBox<String> cbFormat = new JComboBox<String>();
	private JLabel jLabel24 = new JLabel();
	private JTextField edN_Izv = new TextFieldDocument(32);
	private JTextField edFormat = new TextFieldDocument(20);
	private JButton btClrFmt = new JButton();
	JComboBox<String> cbLiter2 = new JComboBox<String>();
	JComboBox<String> cbLiter3 = new JComboBox<String>();
	JLabel jLabel8 = new JLabel();
	JTextField edType = new JTextField();
	JTextField edRev = new JTextField();
	JLabel jLabel9 = new JLabel();
	JLabel LNotSaved = new JLabel();
	JLabel LApprover3 = new JLabel();
	JTextField edNachBrig = new JTextField();
	DateButton dateNachBrig = new DateButton();
	JLabel jLabel15 = new JLabel();
	LOVComboBox cbOtdel = new LOVComboBox();
	LOVComboBox cbCreator = new LOVComboBox();
	JLabel LMassa = new JLabel();
	JTextField edMassa = new JTextField();
	TCComponentForm rev_form = null;
	NameResolver NR = new NameResolver();
	TCComponentListOfValues formatLov;
	TCProperty property_format;
	TCComponentItemRevision item_rev;
	TCComponentItem item;
	private JLabel vrtLogo = new JLabel();
	BorderLayout borderLayoutHead = new BorderLayout();

	/*
	 * public DocRevPanel(TCComponentForm theForm) { try { jbInit();
	 * renderData(); } catch(Exception e) { e.printStackTrace(); } }
	 */

	protected void doSave(TCComponentForm form1) throws Exception {
		form1.lock();
		form1.setStringProperty(NR.fld_DSE_CODE, edCodeDSE.getText());
		form1.setStringProperty(NR.fld_FORMAT, edFormat.getText());
		form1.setStringProperty(NR.fld_LITER1, cbLiter1.getSelectedItem()
				.toString());
		form1.setStringProperty(NR.fld_LITER2, cbLiter2.getSelectedItem()
				.toString());
		form1.setStringProperty(NR.fld_LITER3, cbLiter3.getSelectedItem()
				.toString());
		form1.setStringProperty(NR.fld_kolListov, edKolListov.getText());
		// Revision
		form1.setDoubleProperty(NR.fld_MASSA, LUtil.string2float(edMassa
				.getText()));
		form1.setDateProperty(NR.fld_DATE_IZM, dateChange.getDate());
		form1.setStringProperty(NR.fld_NIZV, edN_Izv.getText());
		form1.setDoubleProperty(NR.fld_KIM, 0);
		form1.setDoubleProperty(NR.fld_DENSITY, 0);
		// -- Здесь сделать плавный переход на MIL_MAT_SPEC, MIL_MATERIAL зануляем
		form1.setStringProperty(NR.fld_MAT_SPEC, "");
		form1.setStringProperty(NR.fld_MATERIAL, "");
		form1.setStringProperty(NR.fld_MARKA_MAT, "");
		form1.setStringProperty(NR.fld_ND_MARKA, "");
		form1.setStringProperty(NR.fld_ND_SORT, "");
		form1.setStringProperty(NR.fld_VID_ZAGOT, "");
		form1.setStringProperty(NR.fld_SHIFRMATER, "");
		form1.setStringProperty(NR.fld_OTDEL, cbOtdel.getSelectedItem()
				.toString());
		form1.setStringProperty(NR.fld_GABARIT, "");
		// РџРѕРґРїРёСЃРё
		form1.setStringProperty(NR.fld_CREATOR, cbCreator.getSelectedItem()
				.toString()
				+ "," + LUtil.Date2String(dateCreator.getDate()));
		form1.setStringProperty(NR.fld_REVIEWER, edReviewer.getText() + ","
				+ LUtil.Date2String(dateReview.getDate()));
		form1.setStringProperty(NR.fld_NACHBRIG, edNachBrig.getText() + ","
				+ LUtil.Date2String(dateNachBrig.getDate()));
		form1.setStringProperty(NR.fld_TEXCONTROL, edTechcontrol.getText()
				+ "," + LUtil.Date2String(dateTK.getDate()));
		form1.setStringProperty(NR.fld_NCONTROL, edNormocontrol.getText() + ","
				+ LUtil.Date2String(dateNK.getDate()));
		form1.setStringProperty(NR.fld_NACHOTD, edNachOtd.getText() + ","
				+ LUtil.Date2String(dateNachOtd.getDate()));
		form1.setStringProperty(NR.fld_GENCHECK, edApprover.getText() + ","
				+ LUtil.Date2String(dateApprove.getDate()));

		form1.save();
		form1.unlock();

	}



	public String getKolich() {
		return edKolListov.getText();
	}

	public void setHeader(String s) {
		LHeader.setText(s);
	}

	private void jbInit() throws Exception {
		this.setLayout(borderLayout1);
	    jLabel5.setText("Обозначение");
	    jLabel1.setText("Наименование");
	    LTrud.setText("Трудоёмкость");
	    jLabel10.setText("Дата создания");
	    dateCreate.setBorder(BorderFactory.createLineBorder(Color.black));
	    dateCreate.setMinimumSize(new Dimension(150, 21));
	    dateCreate.setPreferredSize(new Dimension(150, 21));
	    dateCreate.setToolTipText("");
	    dateCreate.setEditable(false);
	    dateCreate.setText("< Дата не задана >");
	    dateCreate.setHorizontalAlignment(SwingConstants.CENTER);
	    edIndication.setBackground(new Color(255, 217, 217));
	    edIndication.setMaximumSize(new Dimension(400, 21));
	    edIndication.setMinimumSize(new Dimension(350, 21));
	    edIndication.setPreferredSize(new Dimension(350, 21));
	    edIndication.setEditable(false);
	    TabbedPane.setEnabled(true);
	    TabbedPane.setMinimumSize(new Dimension(500, 400));
	    TabbedPane.setPreferredSize(new Dimension(500, 400));
	    MainPanel.setLayout(gridBagLayout3);
	    jLabel26.setText(".");
	    LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
	    LHeader.setAlignmentX((float) 0.5);
	    LHeader.setHorizontalAlignment(SwingConstants.CENTER);
	    LHeader.setHorizontalTextPosition(SwingConstants.CENTER);
	    LHeader.setText("Конструкторский документ - модификация");
		vrtLogo.setText("");
	    try {
			vrtLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(FormConsts.sVertolLogo)));
		} catch (Exception e) {
			// TODO: handle exception
		}
		vrtLogo.setAlignmentX((float) 0.5);
	    vrtLogo.setHorizontalAlignment(SwingConstants.CENTER);
	    vrtLogo.setHorizontalTextPosition(SwingConstants.CENTER);
	    MainPanel.setMinimumSize(new Dimension(400, 320));
	    MainPanel.setPreferredSize(new Dimension(400, 320));
	    jLabel14.setForeground(Color.gray);
	    jLabel14.setText("Код ДСЕ");
	    jLabel21.setText("Литеры");
	    edNameFull.setBackground(new Color(255, 217, 217));
	    edNameFull.setMinimumSize(new Dimension(20, 21));
	    edNameFull.setPreferredSize(new Dimension(150, 21));
	    edNameFull.setEditable(false);
	    edNameFull.setColumns(0);
	    //edKolListov.setBackground(new Color(255, 217, 217));
	    edKolListov.setMinimumSize(new Dimension(20, 21));
	    edKolListov.setPreferredSize(new Dimension(100, 21));
	    cbLiter1.setMinimumSize(new Dimension(50, 21));
	    cbLiter1.setPreferredSize(new Dimension(50, 21));
	    edTrud.setPreferredSize(new Dimension(100, 21));
	    edTrud.setMinimumSize(new Dimension(100, 21));
	    jLabel110.setText("Дата изменения");
	    dateChange.setTitle("sas");
	    dateChange.setDisplayFormat("dd.MM.yyyy");
	    dateChange.setText("< Дата не задана >");
	    dateChange.setToolTipText("");
	    dateChange.setPreferredSize(new Dimension(150, 21));
	    dateChange.setMinimumSize(new Dimension(150, 21));
	    LReviewer.setText("Проверил");
	    jpSignOffs.setLayout(gridbagLayout1);
	    dateNK.setDisplayFormat("dd-MM-yyyy");
	    dateNK.setText("Дата не установлена");
	    edNormocontrol.setMinimumSize(new Dimension(140, 21));
	    edNormocontrol.setPreferredSize(new Dimension(140, 21));
	    LApprover2.setText("Нач. Отдела");
	    dateTK.setDisplayFormat("dd-MM-yyyy");
	    dateTK.setText("Дата не установлена");
	    LApprover1.setText("Тех. Контроль");
	    dateApprove.setText("Дата не установлена");
	    dateApprove.setDisplayFormat("dd-MM-yyyy");
	    LCreator.setText("Разработал");
	    edReviewer.setMinimumSize(new Dimension(140, 21));
	    edReviewer.setPreferredSize(new Dimension(140, 21));
	    edNachOtd.setMinimumSize(new Dimension(140, 21));
	    edNachOtd.setPreferredSize(new Dimension(140, 21));
	    LNormo.setText("Нормоконтроль");
	    edAdditional.setBorder(null);
	    edAdditional.setMinimumSize(new Dimension(82, 64));
	    edAdditional.setPreferredSize(new Dimension(82, 64));
	    edAdditional.setRows(3);
	    LApprover.setText("Утвердил");
	    dateCreator.setText("Дата не установлена");
	    dateCreator.setDisplayFormat("dd-MM-yyyy");
	    jLabel12.setText("Дополнительные согласующие лица");
	    dateReview.setText("Дата не установлена");
	    dateReview.setDisplayFormat("dd-MM-yyyy");
	    edTechcontrol.setMinimumSize(new Dimension(140, 21));
	    edTechcontrol.setPreferredSize(new Dimension(140, 21));
	    dateNachOtd.setDisplayFormat("dd-MM-yyyy");
	    dateNachOtd.setText("Дата не установлена");
	    edApprover.setMinimumSize(new Dimension(140, 21));
	    edApprover.setPreferredSize(new Dimension(140, 21));
//	    edCreator.setMinimumSize(new Dimension(140, 21));
//	    edCreator.setPreferredSize(new Dimension(140, 21));
	    jLabel23.setText("Формат");
	    cbFormat.setPreferredSize(new Dimension(60, 21));
	    cbFormat.addItemListener(new java.awt.event.ItemListener() {
	      public void itemStateChanged(ItemEvent e) {
	        cbFormat_itemStateChanged(e);
	      }
	    });
	    cbFormat.setMinimumSize(new Dimension(60, 21));
	    jLabel24.setText(" N ИИ (ПИ)");
	    edN_Izv.setMinimumSize(new Dimension(100, 21));
	    edN_Izv.setPreferredSize(new Dimension(100, 21));
	    edCodeDSE.setBackground(UIManager.getColor("Button.background"));
	    edCodeDSE.setForeground(Color.gray);
	    edCodeDSE.setBorder(null);
	    edCodeDSE.setEditable(false);
	    edFormat.setMinimumSize(new Dimension(100, 21));
	    edFormat.setColumns(20);
	    btClrFmt.setBackground(Color.pink);
	    btClrFmt.setFont(new java.awt.Font("Dialog", 1, 12));
	    btClrFmt.setMaximumSize(new Dimension(21, 21));
	    btClrFmt.setMinimumSize(new Dimension(21, 21));
	    btClrFmt.setPreferredSize(new Dimension(21, 21));
	    btClrFmt.setMargin(new Insets(0, 0, 0, 0));
	    btClrFmt.setText("x");
	    btClrFmt.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        btClrFmt_actionPerformed(e);
	      }
	    });
	    cbLiter2.setPreferredSize(new Dimension(50, 21));
	    cbLiter2.setMinimumSize(new Dimension(50, 21));
	    cbLiter3.setPreferredSize(new Dimension(50, 21));
	    cbLiter3.setMinimumSize(new Dimension(50, 21));
	    jLabel8.setText("Вид изделия");
	    edType.setFont(new java.awt.Font("Dialog", 1, 11));
	    edType.setEditable(false);
	    edType.setText("");
	    edRev.setText("");
	    edRev.setEditable(false);
	    jLabel9.setText("Ревизия");
	    LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
	    LNotSaved.setForeground(Color.red);
	    LNotSaved.setText("Карточка не сохранена!");
	    LApprover3.setText("Нач. Бригады");
	    edNachBrig.setPreferredSize(new Dimension(140, 21));
	    edNachBrig.setMinimumSize(new Dimension(140, 21));
	    dateNachBrig.setDisplayFormat("dd-MM-yyyy");
	    dateNachBrig.setText("Дата не установлена");
	    jLabel15.setText("Отдел");
	    cbOtdel.setMinimumSize(new Dimension(100, 19));
	    LMassa.setBackground(UIManager.getColor("Viewport.background"));
	    LMassa.setDebugGraphicsOptions(0);
	    LMassa.setText("Масса");
	    edMassa.setMinimumSize(new Dimension(140, 21));
	    edMassa.setPreferredSize(new Dimension(140, 21));
	    edMassa.setHorizontalAlignment(SwingConstants.LEADING);
		MainPanel.add(cbFormat, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 2, 5, 0), 0, 0));
		MainPanel.add(edN_Izv, new GridBagConstraints(1, 6, 5, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel23, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel24, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		MainPanel.add(jLabel5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		MainPanel.add(jLabel1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 5), 0, 0));
		MainPanel.add(edIndication, new GridBagConstraints(1, 1, 6, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel26, new GridBagConstraints(0, 10, 2, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 0, 0));
		MainPanel.add(jLabel14, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 5, 5), 0, 0));
		MainPanel.add(edCodeDSE, new GridBagConstraints(1, 9, 3, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 5), 0, 0));
		MainPanel.add(jLabel21, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 5, 5, 0), 0, 0));
		MainPanel.add(edNameFull, new GridBagConstraints(1, 2, 6, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(cbLiter1, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(10, 5, 5, 0), 0, 0));
		// MainPanel.add(LTrud, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5,
		// 5, 5), 0, 0));
		// MainPanel.add(edTrud, new GridBagConstraints(1, 7, 3, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5,
		// 5, 0), 0, 0));
		MainPanel.add(jLabel10, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		MainPanel.add(dateCreate, new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 5, 0), 0, 0));
		MainPanel.add(jLabel110, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 5, 0), 0, 0));
		MainPanel.add(dateChange, new GridBagConstraints(1, 5, 3, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 5, 0), 0, 0));
		MainPanel.add(edFormat, new GridBagConstraints(1, 7, 3, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 5, 5, 0), 0, 0));
		MainPanel.add(btClrFmt, new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 2, 5, 0), 0, 0));
		MainPanel.add(cbLiter2, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 0, 5, 0), 0, 0));
		MainPanel.add(cbLiter3, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 0, 5, 0), 0, 0));
		MainPanel.add(jLabel8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 5, 5, 0), 0, 0));
		MainPanel.add(edType, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(20, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel9, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(edRev, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(LNotSaved, new GridBagConstraints(2, 10, 3, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		MainPanel.add(LMassa, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 5), 0, 0));
		MainPanel.add(edMassa, new GridBagConstraints(5, 8, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));

		MainPanel.add(edKolListov, new GridBagConstraints(5, 9, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		MainPanel.add(new JLabel("Кол-во листов"), new GridBagConstraints(4, 9,
				1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		TabbedPane.add(MainPanel, "Общие данные");

		//this.add(LHeader, BorderLayout.NORTH);
		JPanel panelHead = new JPanel();
	    panelHead.setLayout(borderLayoutHead);
	    panelHead.add(LHeader, BorderLayout.CENTER);
	    panelHead.add(vrtLogo, BorderLayout.EAST);
	    this.add(panelHead, BorderLayout.NORTH);
		this.add(TabbedPane, BorderLayout.CENTER);
		jpSignOffs.add(LCreator, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		jpSignOffs.add(LReviewer, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		// jpSignOffs.add(edCreator, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new
		// Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(edReviewer, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(dateCreator, new GridBagConstraints(2, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
		// jpSignOffs.add(edAdditional, new GridBagConstraints(0, 7, 3, 1, 0.0,
		// 0.0
		// ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new
		// Insets(0, 5, 5, 5), 0, 0));
		// jpSignOffs.add(jLabel12, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0
		// ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20,
		// 0, 5, 0), 0, 0));
		TabbedPane.add(jpSignOffs, "Подписи");
		jpSignOffs.add(LNormo, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		jpSignOffs.add(LApprover1, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		jpSignOffs.add(LApprover2, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		jpSignOffs.add(edApprover, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(edNormocontrol, new GridBagConstraints(1, 6, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(edTechcontrol, new GridBagConstraints(1, 5, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(edNachOtd, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(LApprover, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		jpSignOffs.add(dateApprove, new GridBagConstraints(2, 7, 1, 1, 0.0,
				0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(dateNK, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(dateTK, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(dateReview, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(dateNachOtd, new GridBagConstraints(2, 4, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(LApprover3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		jpSignOffs.add(edNachBrig, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(dateNachBrig, new GridBagConstraints(2, 3, 1, 1, 0.0,
				0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
		jpSignOffs.add(jLabel15, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 5, 0), 0, 0));
		jpSignOffs.add(cbOtdel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 5), 0, 0));
		jpSignOffs.add(cbCreator, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
	}

	void btClrFmt_actionPerformed(ActionEvent e) {
		edFormat.setText("");
	}

	void cbFormat_itemStateChanged(ItemEvent e) {
		if (e.getStateChange() != 1)
			return;
		String code = cbFormat.getSelectedItem().toString();
		if (code.equals(""))
			return;
		String old = edFormat.getText();
		if (!old.equals(""))
			old = old + ",";
		old = old + code;
		edFormat.setText(old);
	}

	@Override
	public void loadRendering() throws TCException {

		try {
			jbInit();

			TCComponentListOfValuesType lovFormatType = (TCComponentListOfValuesType) session
					.getTypeComponent("ListOfValues");
			TCComponentListOfValues[] lovFormat = lovFormatType
					.find("MIL_LOV_FORMAT");
			TCComponentListOfValues[] lovLitera = lovFormatType
					.find("MIL_LOV_LITERA");

			String[]temp={"O","O1","A"};
			String[]format={"БЧ","А0","A1","А2","А3","A4","А5","А0x2","А0x3","А1x3","А1x4","А2x3","А2x4","А2x5","А3x3","А3x4","А3x5","А3x6","А3x7","А4x3","А4x4","А4x5","А4x6","А4x7","А4x8","А4x9"};
			LUtil.fillComboBoxLOV(cbLiter1, temp);
			LUtil.fillComboBoxLOV(cbLiter2, temp);
			LUtil.fillComboBoxLOV(cbLiter3, temp);
			LUtil.fillComboBoxLOV(cbFormat, format);
			TCComponentForm item_form = null;
			if (item != null)
				item_form = (TCComponentForm) item
						.getRelatedComponent("IMAN_master_form");

			cbCreator.setLOVComponent("User Names");

			// edIndication.setText("edCodeDSE");
			// edCodeDSE.setText(rev_form.getStringProperty(NR.fld_DSE_CODE));
			edFormat.setText(rev_form.getStringProperty(NR.fld_FORMAT));

			cbLiter1.setSelectedItem(rev_form.getStringProperty(NR.fld_LITER1));
			cbLiter2.setSelectedItem(rev_form.getStringProperty(NR.fld_LITER2));
			cbLiter3.setSelectedItem(rev_form.getStringProperty(NR.fld_LITER3));

			// Отображаемое поле
			edType.setText("H47_Document");
			if (item_form != null) {
				edIndication.setText(item_form.getStringProperty(NR.fld_DSE));
				edCodeDSE.setText(item_form.getStringProperty(NR.fld_DSE_CODE));
				edNameFull
						.setText(item_form.getStringProperty(NR.fld_NAME_DSE));
			}
			edRev.setText(item_rev.getProperty("item_revision_id"));
			LNotSaved
					.setVisible(rev_form.getReferenceProperty("data_file") == null);
			// Реальные поля
			dateCreate.setText(LUtil.Date2String(item_rev
					.getDateProperty("creation_date")));
			dateChange.setDate(rev_form.getDateProperty(NR.fld_DATE_IZM));
			// dateChange.setDate(data.change_date);
			edKolListov.setText(rev_form.getStringProperty(NR.fld_kolListov));
			edN_Izv.setText(rev_form.getStringProperty(NR.fld_NIZV));

			// edTrud.setText( data.trud );

			Double mass = (Boolean) rev_form
					.getLogicalProperty(NR.fld_frommodel) ? getMassFromModel()
					: (Double) rev_form.getDoubleProperty(NR.fld_MASSA);
			edMassa.setText(LUtil.float2string(mass, 6));

			String strArray[];
			strArray = LUtil.parse2Array((String) rev_form
					.getStringProperty(NR.fld_CREATOR));
			String creator = strArray[0];
			Date date_create = LUtil.String2Date(strArray[1]);
			cbCreator.setSelectedItem(creator);
			dateCreator.setDate(date_create);
			cbOtdel.setLOVComponent("Group Names");
			cbOtdel.setSelectedItem(rev_form.getStringProperty(NR.fld_OTDEL));

			strArray = LUtil.parse2Array((String) rev_form
					.getStringProperty(NR.fld_REVIEWER));
			edReviewer.setText(strArray[0]);
			dateReview.setDate(LUtil.String2Date(strArray[1]));

			strArray = LUtil.parse2Array((String) rev_form
					.getStringProperty(NR.fld_NACHBRIG));
			edNachBrig.setText(strArray[0]);
			dateNachBrig.setDate(LUtil.String2Date(strArray[1]));

			strArray = LUtil.parse2Array((String) rev_form
					.getStringProperty(NR.fld_TEXCONTROL));
			edTechcontrol.setText(strArray[0]);
			dateTK.setDate(LUtil.String2Date(strArray[1]));

			strArray = LUtil.parse2Array((String) rev_form
					.getStringProperty(NR.fld_NCONTROL));
			edNormocontrol.setText(strArray[0]);
			dateNK.setDate(LUtil.String2Date(strArray[1]));

			strArray = LUtil.parse2Array((String) rev_form
					.getStringProperty(NR.fld_NACHOTD));
			edNachOtd.setText(strArray[0]);
			dateNachOtd.setDate(LUtil.String2Date(strArray[1]));
			strArray = LUtil.parse2Array((String) rev_form
					.getStringProperty(NR.fld_GENCHECK));
			edApprover.setText(strArray[0]);
			dateApprove.setDate(LUtil.String2Date(strArray[1]));

			edAdditional.setText("");
			// for (int i=0; i<data.viza.length; i++)
			// edAdditional.append(data.viza[i]+"\n");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	double getMassFromModel() {
		// -- Определить массу из модели (именованная ссылка UGPART-MASSPR) --
		double Result = 0;
		try {
			TCComponent comps[] = item_rev
					.getRelatedComponents("IMAN_specification");
			if (comps == null)
				return 0;
			TCComponentDataset dset = null;
			for (int i = 0; i < comps.length; i++)
				if (comps[i].isTypeOf("UGMASTER")) {
					dset = (TCComponentDataset) comps[i];
					break;
				}
			if (dset == null)
				return 0;
			comps = dset.getNamedRefComponents("UGPART-MASSPR");
			if (comps == null || comps.length == 0)
				return 0;
			TCComponentForm form = (TCComponentForm) comps[0];
			Result = form.getFormTCProperty("mass").getDoubleValue();
		} catch (TCException ex) {
			Result = 0;
		}
		return Result;
	}

	@Override
	public void saveRendering() {
		try {
			if (item_rev == null) {
				JPanel parentPanel = (JPanel) ((JPanel) this).getParent();
				JViewport enclosing = (JViewport) parentPanel.getParent();
				JScrollPane scrolpan1 = (JScrollPane) enclosing.getParent();
				ItemRevMasterFormPanel irmfp1 = (ItemRevMasterFormPanel) scrolpan1
						.getParent();
				// TCComponentForm s_rev_form =
				// (TCComponentForm)irmfp1.itemRevMasterForm;
				//**NewItemPanel itemPanel1 = (NewItemPanel) irmfp1.controlWizardPanel;
				item = (TCComponentItem) ((AbstractNewItemPanel) irmfp1.controlWizardPanel).newComponent;
				if (item == null)
					rev_form = (TCComponentForm) this.component;
				 else {
					try {
						item_rev = item.getLatestItemRevision();
					} catch (Exception e) {
						// TODO:
					}
					if (item_rev != null) {
						try {
							rev_form = (TCComponentForm)item_rev
									.getRelatedComponent("IMAN_master_form_rev");
						} catch (TCException e) {
							e.printStackTrace();
						}
					}
				}
			}
			doSave(rev_form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}