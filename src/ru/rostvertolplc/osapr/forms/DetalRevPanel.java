package ru.rostvertolplc.osapr.forms;

import java.awt.*;
//import java.awt.datatransfer.*;
import java.awt.event.*;
//import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

//import com.teamcenter.rac.aif.*;
import com.teamcenter.rac.kernel.*;
import com.teamcenter.rac.util.*; //import com.LANIT.extmaterial.*;

import com.teamcenter.rac.common.lov.*; //import com.teamcenter.rac.form.lovcombobox.*;
//import com.teamcenter.rac.form.datebutton.*;
//import com.teamcenter.rac.kernel.TCUserService;

import ru.rostvertolplc.osapr.util.*;
import ru.rostvertolplc.osapr.extmaterial.*;
import ru.rostvertolplc.osapr.regbook.*;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class DetalRevPanel extends JPanel implements InterfaceFormPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 499452610402566806L;
	DSEUserData data = null;
	TCSession session = null;

	private JLabel LHeader = new JLabel();
	FloatVerifier floatVerifier = new FloatVerifier();
	// java.util.Timer timer;

	private JLabel LTrud = new JLabel();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel5 = new JLabel();
	private JLabel jLabel9 = new JLabel();
	private TextFieldDocument edRoditel = new TextFieldDocument(128);
	private JLabel jLabel10 = new JLabel();
	private JTextField dateCreate = new JTextField();
	private JLabel LMat2 = new JLabel();
	private TextFieldDocument edNameMat = new TextFieldDocument(256);
	private TextFieldDocument edMarkMat = new TextFieldDocument(64);
	private TextFieldDocument edNDSort = new TextFieldDocument(64);
	private TextFieldDocument edNDMark = new TextFieldDocument(64);
	private TextFieldDocument edVidZagot = new TextFieldDocument(128);
	private TextFieldDocument edIndication = new TextFieldDocument(128);
	JComboBox cbLiter1 = new JComboBox();
	JLabel LMat3 = new JLabel();
	JLabel LMat4 = new JLabel();
	JTabbedPane TabbedPane = new JTabbedPane();
	JPanel MainPanel = new JPanel();
	GridBagLayout gridBagLayout3 = new GridBagLayout();
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;
	TitledBorder titledBorder4;
//	private JLabel jLabel26 = new JLabel();
	BorderLayout borderLayout1 = new BorderLayout();
	private JLabel jLabel21 = new JLabel();
	private JTextField jTextField1;
	private TextFieldDocument edNameFull = new TextFieldDocument(256);
	private JLabel LMassa = new JLabel();
	private JTextField edMassa = new JTextField();
	private TextFieldDocument edTrud = new TextFieldDocument(10);
	private JLabel LKIM = new JLabel();
	private TextFieldDocument edKIM = new TextFieldDocument(10);
	private JLabel jLabel110 = new JLabel();
	private DateButton dateChange = new DateButton();
	private JPanel jpMaterial = new JPanel();
	private GridBagLayout gridBagLayout7 = new GridBagLayout();
	private JLabel LMatName = new JLabel();
	private TitledBorder titledBorder1;
	private JLabel LMat1 = new JLabel();
	private JButton btMaterialClr = new JButton();
	private JButton btMaterial = new JButton();
	private JLabel LReviewer = new JLabel();
	private JPanel jpSignOffs = new JPanel();
	private DateButton dateTK = new DateButton();
	private JTextField edNormocontrol = new JTextField();
	private JLabel LApprover2 = new JLabel();
	private DateButton dateNachOtd = new DateButton();
	private JLabel LApprover1 = new JLabel();
	private DateButton dateNK = new DateButton();
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
	private DateButton dateApprove = new DateButton();
	private JTextField edApprover = new JTextField();
	private JTextField edCreator = new JTextField();
	private TitledBorder titledBorder5;
	private JLabel jLabel23 = new JLabel();
	private JComboBox cbFormat = new JComboBox();
	private JLabel jLabel24 = new JLabel();
	private TextFieldDocument edN_Izv = new TextFieldDocument(32);
	private JLabel jLabel3 = new JLabel();
	private TextFieldDocument edFormat = new TextFieldDocument(20);
	private JButton btClrFmt = new JButton();
	private JPanel infoKart = new JPanel();
	private GridBagLayout gridBagLayout8 = new GridBagLayout();
	private JLabel jLabel4 = new JLabel();
	private JLabel jLabel25 = new JLabel();
	JLabel jLabel27 = new JLabel();
	JLabel jLabel28 = new JLabel();
	JComboBox cbNameProc = new JComboBox();
	JLabel jLabel30 = new JLabel();
	JComboBox cbCexa = new JComboBox();
	JLabel jLabel29 = new JLabel();
	JPanel jpRascex = new JPanel();
	JLabel jLabel32 = new JLabel();
	JTextField edRascex = new JTextField();
	GridBagLayout gridBagLayout9 = new GridBagLayout();
	GridBagLayout gridBagLayout6 = new GridBagLayout();
	JCheckBox chbVR3_p = new JCheckBox();
	GridBagLayout gridBagLayout10 = new GridBagLayout();
	JPanel jpVR18 = new JPanel();
	JScrollPane spVR18 = new JScrollPane();
	JLabel LVR18_Note = new JLabel();
	JLabel LVR3_Note = new JLabel();
	JCheckBox chbVR3_s = new JCheckBox();
	JCheckBox chbVR18 = new JCheckBox();
	TextAreaDocument edVR18_Note = new TextAreaDocument(256);
	JPanel jpVR = new JPanel();
	JPanel jpVR3 = new JPanel();
	GridBagLayout gridBagLayout5 = new GridBagLayout();
	JScrollPane spVR3 = new JScrollPane();
	TextAreaDocument edVR3_Note = new TextAreaDocument(256);
	JLabel LDateVnedr = new JLabel();
	DateButton dateVnedrII = new DateButton();
	JComboBox cbLiter2 = new JComboBox();
	JComboBox cbLiter3 = new JComboBox();
	JLabel LTypeIzgot = new JLabel();
	JComboBox cbTypeIzgot = new JComboBox();
	JLabel LVR10_Note = new JLabel();
	JCheckBox chbVR10 = new JCheckBox();
	JScrollPane spVR10 = new JScrollPane();
	GridBagLayout gridBagLayout4 = new GridBagLayout();
	TextAreaDocument edVR10_Note = new TextAreaDocument(256);
	JPanel jpVR10 = new JPanel();
	JButton btMaterial1 = new JButton();
	JCheckBox chbFromModel = new JCheckBox();
	JLabel jLabel2 = new JLabel();
	JCheckBox chbOsobo = new JCheckBox();
	LOVComboBox cbConsGroup = new LOVComboBox();
	JRadioButton rbZagot = new JRadioButton();
	JRadioButton rbMat = new JRadioButton();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel13 = new JLabel();
	JCheckBox chbZag = new JCheckBox();
	TextFieldDocument edOrigin = new TextFieldDocument(128);
	TextFieldDocument edZag = new TextFieldDocument(64);
	ButtonGroup bgMat = new ButtonGroup();
	JLabel jLabel8 = new JLabel();
	JTextField edType = new JTextField();
	JTextField edRev = new JTextField();
	JLabel jLabel11 = new JLabel();
	JLabel jLabel14 = new JLabel();
	LOVComboBox cbCAD = new LOVComboBox();
	JPanel jpMilx = new JPanel();
	GridBagLayout gridBagLayout1 = new GridBagLayout();
	LOVComboBox cbCreator = new LOVComboBox();
	JPanel jPanel1 = new JPanel();
	Border border1;
	TitledBorder titledBorder6;
	GridBagLayout gridBagLayout2 = new GridBagLayout();
	JLabel jLabel16 = new JLabel();
	JTextField edLength = new JTextField();
	JLabel jLabel17 = new JLabel();
	JLabel jLabel18 = new JLabel();
	JTextField edWidth = new JTextField();
	JTextField edDepth = new JTextField();
	JLabel jLabel19 = new JLabel();
	JTextField edDensity = new JTextField();
	JLabel LNotSaved = new JLabel();
	JLabel jLabel6 = new JLabel();
	DateButton dateNachBrig = new DateButton();
	JLabel LApprover3 = new JLabel();
	JTextField edNachBrig = new JTextField();
	JLabel jLabel15 = new JLabel();
	LOVComboBox cbOtdel = new LOVComboBox();
	JTextField edMatShifr = new JTextField();
	JTextField edChangeNotice = new JTextField();
	private JLabel vrtLogo = new JLabel();
	BorderLayout borderLayoutHead = new BorderLayout();

	public DetalRevPanel() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DetalRevPanel(DSEUserData theData) {
		data = theData;
		try {
			System.out.println("DetalRevPanel");		
			jbInit();
			renderData();

			// timer = new java.util.Timer();
			// timer.scheduleAtFixedRate(new CheckTask(data.form), 100, 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void setMassColor(double flag) {
		if (flag == 1) {
			edMassa.setBackground(new Color(255, 200, 200));
			edMassa.setForeground(Color.RED);
			edMassa.setDisabledTextColor(Color.MAGENTA);
		}
		if (flag == 0) {
			edMassa.setBackground(edDensity.getBackground());
			edMassa.setForeground(Color.BLACK);
			edMassa.setDisabledTextColor(Color.GRAY);
		}
	}

	public void renderData() {

		// Отображаемое поле
		// vertol так как item может быть не определен при создании
		// нового объекта
		if (data.item != null) {
			edType.setText(data.item.getType());
		}
		edIndication.setText(data.indication);
		edNameFull.setText(data.name_dse);
		edNameFull.updateUI();
		edRev.setText(data.revision);
		LNotSaved.setVisible(data.sc == null);
		edChangeNotice.setText(data.changeNotice);
		// Реальные поля
		edRoditel.setText(data.first_use);
		dateCreate.setText(LUtil.Date2String(data.date_create_obj));
		dateChange.setDate(data.change_date);
		dateVnedrII.setDate(data.date_vnedr);
		edN_Izv.setText(data.izv_id);
		chbOsobo.setSelected(data.pr_otvetstv);
		edDensity.setText(LUtil.float2string(data.density, 8));
		jTextField1.setText(data.diametr);

		// vertol
		// при создании item_rev отсутствует, массу не определяем

		if (data.item_rev != null) {

			// По умолчанию для Детали массу брать из модели
			if (data.sc == null) {
				data.pr_from_model = true;
				// Данный Event включает в себя edMassa.setText,
				// edMassa.setEnabled
				chbFromModel_actionPerformed(new ActionEvent(chbFromModel, 0,
						"Set"));
			} else {
				edMassa.setText(LUtil.float2string(data.massa, 6));
				edMassa.setEnabled(!data.pr_from_model);
			}
			chbFromModel.setSelected(data.pr_from_model);

			// edKIM.setText( String.valueOf(data.kim) );

			setMassColor(data.kim);
		} else {
			// edMassa.setVisible(false);
		}
		edNameMat.setText(data.material);
		edMatShifr.setText(data.mater_shifr);

		edOrigin.setText(data.orig);
		edZag.setText(data.zagot);
		chbZag.setSelected(data.pr_zag);

		String saGab[] = data.gabarit.split("x", 3);
		if (saGab.length < 3)
			saGab = new String[] { "", "", "" };
		edLength.setText(saGab[0]);
		edWidth.setText(saGab[1]);
		edDepth.setText(saGab[2]);
		/*
		 * edTrud.setText( data.trud ); edMarkMat.setText(data.mater_mark);
		 * edNDMark.setText(data.mater_mark_nd);
		 * edNDSort.setText(data.mater_sort_nd);
		 * edVidZagot.setText(data.mater_zagot);
		 * chbVR3_p.setSelected(data.vr3_s); chbVR3_s.setSelected(data.vr3_p);
		 * edVR3_Note.setText(data.vr3_note); chbVR18.setSelected(data.vr18);
		 * edVR18_Note.setText(data.vr18_note);
		 * //edVR10_TechPas.setText(data.vr10_tex_pas);
		 * chbVR10.setSelected(data.vr10); edVR10_Note.setText(data.vr10_note);
		 * 
		 * edMarkPlace.setText(data.vr7_mesto);
		 * edVR6_Note.setText(data.vr6_note);
		 */


		// session = (TCSession)data.item.getSession();
		// vertol так как item может быть не определен
		session = data.item != null ? (TCSession) data.item.getSession()
				: (TCSession) data.form.getSession();

		cbCreator.setLOVComponent(session, "User Names");
		cbCreator.setSelectedItem(data.creator);
		dateCreator.setDate(data.date_create);
		cbOtdel.setLOVComponent(session, "Group Names");
		cbOtdel.setSelectedItem(data.otvetstv);

		// edCreator.setText(data.creator);
		// dateCreator.setDate(data.date_create);
		edReviewer.setText(data.reviewer);
		dateReview.setDate(data.date_review);
		edNachBrig.setText(data.nach_brig);
		dateNachBrig.setDate(data.date_nach_brig);
		edTechcontrol.setText(data.tcontrol);
		dateTK.setDate(data.date_tcontrol);
		edNormocontrol.setText(data.ncontrol);
		dateNK.setDate(data.date_ncontrol);
		edApprover.setText(data.approver);
		dateApprove.setDate(data.date_approve);
		edNachOtd.setText(data.nach_otd);
		dateNachOtd.setDate(data.date_nach_otd);
		/*
		 * edAdditional.setText(""); for (int i=0; i<data.viza.length; i++)
		 * edAdditional.append(data.viza[i]+"\n");
		 */
		// Литера
		LUtil.fillComboBoxLOV(cbLiter1, data.lov_liter);
		cbLiter1.setSelectedItem(data.liter1);
		// Конструктивная группа
		// LUtil.fillComboBoxLOV(cbConsGroup, data.lov_consgroup);
		cbConsGroup.setLOVComponent(session, data.NR.lov_CONSGROUP);

		cbConsGroup.setSelectedItem(data.cons_group);
		// Базовая CAD-система
		cbCAD.setLOVComponent(session, data.NR.lov_CADSYS);
		cbCAD.setSelectedItem(data.cad_sys);

		// Формат
		LUtil.fillComboBoxLOV(cbFormat, data.lov_format);
		edFormat.setText(data.format);
		edFormat.updateUI();
		// Расцеховка
		LUtil.fillComboBoxLOV(cbCexa, data.lov_cexa);
		edRascex.setText(data.rascex);
		/*
		 * LUtil.fillComboBoxLOV(cbLiter2, data.lov_liter);
		 * LUtil.fillComboBoxLOV(cbLiter3, data.lov_liter);
		 * cbLiter2.setSelectedItem(data.liter2);
		 * cbLiter3.setSelectedItem(data.liter3);
		 * 
		 * // Содержание маркировки cbSoderMark.addItem(""); for (int i=0;
		 * i<data.lov_sodermark.length; i++) {
		 * cbSoderMark.addItem(data.lov_sodermark[i]); }
		 * cbSoderMark.setSelectedItem(data.vr7_sod_mark); // Способ нанесения
		 * маркировки cbSposobMark.addItem(""); for (int i=0;
		 * i<data.lov_sposobmark.length; i++) {
		 * cbSposobMark.addItem(data.lov_sposobmark[i]); }
		 * cbSposobMark.setSelectedItem(data.vr7_spo_nanes); // Вид
		 * неразрушающего контроля cbControl.addItem(""); for (int i=0;
		 * i<data.lov_control.length; i++) {
		 * cbControl.addItem(data.lov_control[i]); }
		 * cbControl.setSelectedItem(data.vr6_vid); // Формат
		 * cbFormat.addItem(""); for (int i=0; i<data.lov_format.length; i++) {
		 * cbFormat.addItem(data.lov_format[i]); }
		 * cbFormat.setSelectedItem(data.format);
		 * cbNameProc.addItem("");//Наименование процесса for(int i=0;
		 * i<vremennoIdPr.length; i++) { cbNameProc.addItem(vremennoIdPr[i]);}
		 */
		// Тип изготовления
		// LUtil.fillComboBoxLOV2(cbTypeIzgot, data.saTypeIzgot);
		// cbTypeIzgot.setSelectedItem(data.type_izgot);
	}

	public void saveToUserData() {
		// String sObj=null;
		// int len;
		try {
			// data.indication = edIndication.getText();
			// data.name_dse = edNameFull.getText();
			// data.code_dse = edCodeDSE.getText();
			data.change_date = dateChange.getDate();
			data.date_vnedr = dateVnedrII.getDate();
			data.izv_id = edN_Izv.getText();
			data.massa = LUtil.string2float(edMassa.getText());
			data.pr_from_model = chbFromModel.isSelected();
			data.roditel = edRoditel.getText();
			data.density = LUtil.string2float(edDensity.getText());
			// data.type_izgot = LUtil.getSelectedStrCB(cbTypeIzgot);
			// data.kim = LUtil.string2float(edKIM.getText());
			data.cons_group = LUtil.getSelectedStrCB(cbConsGroup);
			data.pr_otvetstv = chbOsobo.isSelected();

			data.material = edNameMat.getText();
			data.mater_shifr = edMatShifr.getText();
			data.orig = edOrigin.getText();
			data.pr_zag = chbZag.isSelected();
			data.zagot = edZag.getText();
			data.cad_sys = LUtil.getSelectedStrCB(cbCAD);
			data.gabarit = edLength.getText() + 'x' + edWidth.getText() + 'x'
					+ edDepth.getText();
			data.diametr = jTextField1.getText();

			/*
			 * data.trud = edTrud.getText(); data.mater_mark =
			 * edMarkMat.getText(); data.mater_mark_nd = edNDMark.getText();
			 * data.mater_sort_nd = edNDSort.getText(); data.mater_zagot =
			 * edVidZagot.getText(); data.vr7_mesto = edMarkPlace.getText();
			 * //data.vr10_tex_pas = edVR10_TechPas.getText(); data.vr10 =
			 * chbVR10.isSelected(); data.vr10_note = edVR10_Note.getText();
			 * data.vr3_s = chbVR3_s.isSelected(); data.vr3_p =
			 * chbVR3_p.isSelected(); data.vr3_note = edVR3_Note.getText();
			 * data.vr18 = chbVR18.isSelected(); data.vr18_note =
			 * edVR18_Note.getText();
			 */
			// data.creator = edCreator.getText(); data.date_create =
			// dateCreator.getDate();
			data.reviewer = edReviewer.getText();
			data.date_review = dateReview.getDate();
			data.nach_brig = edNachBrig.getText();
			data.date_nach_brig = dateNachBrig.getDate();
			data.tcontrol = edTechcontrol.getText();
			data.date_tcontrol = dateTK.getDate();
			data.ncontrol = edNormocontrol.getText();
			data.date_ncontrol = dateNK.getDate();
			data.approver = edApprover.getText();
			data.date_approve = dateApprove.getDate();
			data.nach_otd = edNachOtd.getText();
			data.date_nach_otd = dateNachOtd.getDate();

			data.creator = LUtil.getSelectedStrCB(cbCreator);
			data.date_create = dateCreator.getDate();
			data.otvetstv = LUtil.getSelectedStrCB(cbOtdel);

			/*
			 * int n = edAdditional.getLineCount(); data.viza = new String[n];
			 * try { for (int i=0; i<n; i++) { int a =
			 * edAdditional.getLineStartOffset(i); int b =
			 * edAdditional.getLineEndOffset(i); data.viza[i] =
			 * edAdditional.getText(a,b-a-1); } } catch (BadLocationException
			 * ex) { }
			 */
			data.liter1 = LUtil.getSelectedStrCB(cbLiter1);
			/*
			 * data.liter2 = LUtil.getSelectedStrCB(cbLiter2); data.liter3 =
			 * LUtil.getSelectedStrCB(cbLiter3); data.vr7_sod_mark =
			 * cbSoderMark.getSelectedItem()==null ? "" :
			 * cbSoderMark.getSelectedItem().toString(); data.vr7_spo_nanes =
			 * cbSposobMark.getSelectedItem()==null ? "" :
			 * cbSposobMark.getSelectedItem().toString(); data.vr6_vid =
			 * cbControl.getSelectedItem()==null ? "" :
			 * cbControl.getSelectedItem().toString();
			 */
			// data.format = cbFormat.getSelectedItem()==null ? "" :
			// cbFormat.getSelectedItem().toString();
			data.format = edFormat.getText();
			data.rascex = edRascex.getText();
			data.kim = 0.0;
		} catch (Exception ex) {
			MessageBox.post(ex);
		}
	}

	public void setHeader(String s) {
		LHeader.setText(s);
	}

	private void jbInit() throws Exception {

		titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(
				Color.white, new Color(134, 134, 134)), " Материал ");
		titledBorder5 = new TitledBorder(BorderFactory.createEtchedBorder(
				Color.white, new Color(134, 134, 134)),
				"ВР 6 - Контроль ДСЕ после испытаний");
		border1 = BorderFactory.createEtchedBorder(Color.white, new Color(165,
				163, 151));
		titledBorder6 = new TitledBorder(border1, "Габаритные размеры");
		this.setLayout(borderLayout1);
		this.setPreferredSize(new java.awt.Dimension(500, 543));
		edMatShifr.setEditable(false);
		edMatShifr.setEnabled(false);
		edNameMat.setEditable(false);
		edNameMat.setEnabled(false);
		jLabel5.setText("Обозначение");
		jLabel1.setText("Наименование");
		LTrud.setText("Трудоёмкость");
		jLabel9
				.setText("\u0414\u0438\u0430\u043c\u0435\u0442\u0440, \u043c\u043c");
		edRoditel.setBackground(new Color(204, 204, 204));
		edRoditel.setMinimumSize(new Dimension(20, 21));
		edRoditel.setPreferredSize(new Dimension(100, 21));
		edRoditel.setColumns(64);
		jLabel10.setText("Дата создания");
		dateCreate.setBorder(BorderFactory.createLineBorder(Color.black));
		dateCreate.setMinimumSize(new Dimension(120, 21));
		dateCreate.setPreferredSize(new Dimension(120, 21));
		dateCreate.setToolTipText("");
		dateCreate.setEditable(false);
		dateCreate.setText("< Дата не задана >");
		dateCreate.setHorizontalAlignment(SwingConstants.CENTER);
		edMarkMat.setMinimumSize(new Dimension(100, 21));
		LMat2.setText("НД на сортамент");
		edNDSort.setMinimumSize(new Dimension(100, 21));
		edNDSort.setPreferredSize(new Dimension(100, 21));
		edIndication.setBackground(new Color(255, 217, 217));
		edIndication.setMaximumSize(new Dimension(400, 21));
		edIndication.setMinimumSize(new Dimension(350, 21));
		edIndication.setPreferredSize(new Dimension(350, 21));
		edIndication.setEditable(false);
		LMat3.setText("Марка материала");
		LMat4.setText("Вид заготовки");
		TabbedPane.setEnabled(true);
		TabbedPane.setMinimumSize(new Dimension(500, 510));
		TabbedPane.setPreferredSize(new Dimension(500, 510));
		MainPanel.setLayout(gridBagLayout3);
		LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
		LHeader.setAlignmentX((float) 0.5);
		LHeader.setHorizontalAlignment(SwingConstants.CENTER);
		LHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		LHeader.setText("Модификация изделия << Деталь >>");
		vrtLogo.setText("");
		try {
			vrtLogo = new JLabel(new ImageIcon(getClass().getClassLoader()
					.getResource(FormConsts.sVertolLogo)));
		} catch (Exception e) {
			// TODO: handle exception
		}
		vrtLogo.setAlignmentX((float) 0.5);
		vrtLogo.setHorizontalAlignment(SwingConstants.CENTER);
		vrtLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		MainPanel.setDebugGraphicsOptions(0);
		MainPanel.setMinimumSize(new Dimension(400, 320));
		MainPanel.setPreferredSize(new Dimension(400, 320));
		jLabel21.setText("Литера");
		edNameFull.setBackground(new Color(255, 217, 217));
		edNameFull.setMinimumSize(new Dimension(20, 21));
		edNameFull.setPreferredSize(new Dimension(150, 21));
		edNameFull.setEditable(false);
		edNameFull.setColumns(0);
		cbLiter1.setMinimumSize(new Dimension(50, 21));
		cbLiter1.setPreferredSize(new Dimension(50, 21));
		LMassa.setBackground(UIManager.getColor("Viewport.background"));
		LMassa.setDebugGraphicsOptions(0);
		LMassa.setText("Масса");
		edMassa.setMinimumSize(new Dimension(140, 21));
		edMassa.setPreferredSize(new Dimension(140, 21));
		edMassa.setHorizontalAlignment(SwingConstants.LEADING);
		edTrud.setPreferredSize(new Dimension(100, 21));
		edTrud.setMinimumSize(new Dimension(100, 21));
		LKIM.setText("КИМ");
		edKIM.setPreferredSize(new Dimension(100, 21));
		edKIM.setMinimumSize(new Dimension(100, 21));
		jLabel110.setText("Дата изменения");
		dateChange.setTitle("sas");
		dateChange.setDisplayFormat("dd.MM.yyyy");
		dateChange.setText("< Дата не задана >");
		dateChange.setToolTipText("");
		dateChange.setPreferredSize(new Dimension(150, 21));
		dateChange.setMinimumSize(new Dimension(150, 21));
		jpMaterial.setBorder(titledBorder1);
		jpMaterial.setMinimumSize(new Dimension(500, 100));
		jpMaterial.setOpaque(true);
		jpMaterial.setPreferredSize(new Dimension(500, 100));
		jpMaterial.setLayout(gridBagLayout7);
		LMatName.setText("Наименование");
		edNameMat.setMinimumSize(new Dimension(250, 21));
		edNameMat.setPreferredSize(new Dimension(250, 21));
		LMat1.setText("НД на марку");
		edVidZagot.setMinimumSize(new Dimension(100, 21));
		edVidZagot.setPreferredSize(new Dimension(100, 21));
		btMaterialClr.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btMaterialClr_actionPerformed(e);
			}
		});
		btMaterialClr.setText("x");
		btMaterialClr.setMargin(new Insets(0, 0, 0, 0));
		btMaterialClr.setHorizontalTextPosition(SwingConstants.CENTER);
		btMaterialClr.setToolTipText("Удалить");
		btMaterialClr.setPreferredSize(new Dimension(25, 21));
		btMaterialClr.setMinimumSize(new Dimension(21, 21));
		btMaterialClr.setMaximumSize(new Dimension(100, 21));
		btMaterialClr.setFont(new java.awt.Font("Dialog", 1, 12));
		btMaterialClr.setBackground(Color.pink);
		btMaterial.setBackground(new Color(160, 204, 153));
		btMaterial.setFont(new java.awt.Font("Dialog", 1, 12));
		btMaterial.setMaximumSize(new Dimension(100, 21));
		btMaterial.setMinimumSize(new Dimension(21, 21));
		btMaterial.setPreferredSize(new Dimension(25, 21));
		btMaterial
				.setToolTipText("Вставить обозначение объекта (Материала/Заготовки) из буфера обмена");
		btMaterial.setHorizontalTextPosition(SwingConstants.CENTER);
		btMaterial.setMargin(new Insets(0, 0, 0, 0));
		btMaterial.setText("<");
		btMaterial.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btMaterial_actionPerformed(e);
			}
		});
		btMaterialClr.setBackground(Color.pink);
		btMaterialClr.setFont(new java.awt.Font("Dialog", 1, 12));
		btMaterialClr.setMaximumSize(new Dimension(21, 21));
		btMaterialClr.setMinimumSize(new Dimension(21, 21));
		btMaterialClr.setPreferredSize(new Dimension(21, 21));
		btMaterialClr.setMargin(new Insets(0, 0, 0, 0));
		btMaterialClr.setText("x");
		btMaterial.setBackground(Color.green);
		btMaterial.setFont(new java.awt.Font("Dialog", 1, 12));
		btMaterial.setMaximumSize(new Dimension(21, 21));
		btMaterial.setMinimumSize(new Dimension(21, 21));
		btMaterial.setPreferredSize(new Dimension(21, 21));
		btMaterial.setMargin(new Insets(0, 0, 0, 0));
		btMaterial.setText("<");
		LReviewer.setText("Проверил");
		jpSignOffs.setLayout(gridbagLayout1);
		dateTK.setDisplayFormat("dd.MM.yyyy");
		dateTK.setText("Дата не установлена");
		edNormocontrol.setMinimumSize(new Dimension(140, 21));
		edNormocontrol.setPreferredSize(new Dimension(140, 21));
		LApprover2.setText("Нач. отдела");
		dateNachOtd.setDisplayFormat("dd.MM.yyyy");
		dateNachOtd.setText("Дата не установлена");
		LApprover1.setText("Тех.Контроль");
		dateNK.setText("Дата не установлена");
		dateNK.setDisplayFormat("dd.MM.yyyy");
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
		dateCreator.setDisplayFormat("dd.MM.yyyy");
		jLabel12.setText("Дополнительные согласующие лица");
		dateReview.setText("Дата не установлена");
		dateReview.setDisplayFormat("dd.MM.yyyy");
		edTechcontrol.setMinimumSize(new Dimension(140, 21));
		edTechcontrol.setPreferredSize(new Dimension(140, 21));
		dateApprove.setDisplayFormat("dd.MM.yyyy");
		dateApprove.setText("Дата не установлена");
		edApprover.setMinimumSize(new Dimension(140, 21));
		edApprover.setPreferredSize(new Dimension(140, 21));
		edCreator.setMinimumSize(new Dimension(140, 21));
		edCreator.setPreferredSize(new Dimension(140, 21));
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
		jpSignOffs.setMaximumSize(new Dimension(2147483647, 2147483647));
		jpSignOffs.setMinimumSize(new Dimension(395, 300));
		jpSignOffs.setPreferredSize(new Dimension(395, 300));
		infoKart.setLayout(gridBagLayout8);
		infoKart.setMinimumSize(new Dimension(300, 300));
		infoKart.setPreferredSize(new Dimension(300, 300));
		infoKart.setRequestFocusEnabled(true);
		infoKart.setToolTipText("");
		jLabel4.setText("Карточка не сохранена!");
		jLabel25.setText("jLabel25");
		jLabel27.setText("jLabel27");
		jLabel28.setText("jLabel28");
		cbNameProc.setMinimumSize(new Dimension(50, 21));
		jLabel30.setText("Подразделения");
		cbCexa.setMinimumSize(new Dimension(50, 21));
		cbCexa.setPreferredSize(new Dimension(50, 21));
		cbCexa.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbCexa_itemStateChanged(e);
			}
		});
		jLabel29.setText("Расцеховка");
		jpRascex.setLayout(gridBagLayout9);
		jLabel32.setText("-");
		edRascex.setMinimumSize(new Dimension(26, 21));
		edRascex.setPreferredSize(new Dimension(26, 21));
		edRascex.setText("");
		cbCexa.setMinimumSize(new Dimension(50, 21));
		cbCexa.setPreferredSize(new Dimension(50, 21));
		chbVR3_p.setText("Переборка");
		chbVR3_p.setText("Переборка");
		jpVR18.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(
				Color.white, new Color(148, 145, 140)),
				"ВР 18 - Детали по директивным технологиям"));
		jpVR18.setMinimumSize(new Dimension(100, 100));
		jpVR18.setPreferredSize(new Dimension(434, 100));
		jpVR18.setLayout(gridBagLayout5);
		LVR18_Note.setEnabled(false);
		LVR18_Note.setText("Примечание ВР 18");
		LVR3_Note.setText("Примечание ВР 3");
		LVR3_Note.setText("Примечание ВР3");
		chbVR3_s.setText("Сдаточные испытания");
		chbVR3_s.setHorizontalTextPosition(SwingConstants.RIGHT);
		chbVR3_s.setText("Сдаточные испытания");
		chbVR18.setText("Признак вхождения в ВР 18");
		chbVR18.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				chbVR_stateChanged(e);
			}
		});
		edVR18_Note.setEnabled(false);
		jpVR.setLayout(gridBagLayout6);
		jpVR.setMinimumSize(new Dimension(110, 400));
		jpVR.setPreferredSize(new Dimension(444, 400));
		jpVR3.setMinimumSize(new Dimension(100, 100));
		jpVR3.setPreferredSize(new Dimension(444, 100));
		jpVR3.setLayout(gridBagLayout10);
		jpVR3
				.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(
						Color.white, new Color(148, 145, 140)),
						"ВР 3 - Детали, подлежащие обязательной замене при переборках"));
		LDateVnedr.setText("Дата внедрения ИИ");
		dateVnedrII.setMinimumSize(new Dimension(150, 21));
		dateVnedrII.setPreferredSize(new Dimension(150, 21));
		dateVnedrII.setText("< Дата не задана >");
		dateVnedrII.setDisplayFormat("dd.MM.yyyy");
		cbLiter2.setPreferredSize(new Dimension(50, 21));
		cbLiter2.setMinimumSize(new Dimension(50, 21));
		cbLiter3.setPreferredSize(new Dimension(50, 21));
		cbLiter3.setMinimumSize(new Dimension(50, 21));
		LTypeIzgot.setText("Тип изготовления");
		LVR10_Note.setEnabled(false);
		LVR10_Note.setText("Примечание ВР 10");
		chbVR10.setHorizontalTextPosition(SwingConstants.RIGHT);
		chbVR10.setText("Признак вхождения в ВР 10");
		chbVR10.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				chbVR_stateChanged(e);
			}
		});
		edVR10_Note.setEnabled(false);
		jpVR10.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(
				Color.white, new Color(148, 145, 140)),
				"ВР 10 - Технологический паспорт"));
		jpVR10.setMinimumSize(new Dimension(100, 100));
		jpVR10.setPreferredSize(new Dimension(444, 100));
		jpVR10.setLayout(gridBagLayout4);
		btMaterial1.setText("<");
		btMaterial1.setMargin(new Insets(0, 0, 0, 0));
		btMaterial1.setPreferredSize(new Dimension(21, 21));
		btMaterial1.setMinimumSize(new Dimension(21, 21));
		btMaterial1.setMaximumSize(new Dimension(21, 21));
		btMaterial1.setFont(new java.awt.Font("Dialog", 1, 12));
		btMaterial1.setBackground(Color.green);
		btMaterial1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btMaterial1_actionPerformed(e);
			}
		});
		btMaterial1.setText("M");
		btMaterial1.setMargin(new Insets(0, 0, 0, 0));
		btMaterial1.setHorizontalTextPosition(SwingConstants.CENTER);
		btMaterial1.setToolTipText("Вставить Материал из внешней БД");
		btMaterial1.setPreferredSize(new Dimension(25, 21));
		btMaterial1.setMinimumSize(new Dimension(21, 21));
		btMaterial1.setMaximumSize(new Dimension(100, 21));
		btMaterial1.setFont(new java.awt.Font("Dialog", 1, 12));
		btMaterial1.setBackground(new Color(177, 224, 224));
		btMaterial1.setBackground(new Color(142, 230, 230));
		btMaterial1.setFont(new java.awt.Font("Dialog", 1, 12));
		btMaterial1.setMaximumSize(new Dimension(21, 21));
		btMaterial1.setMinimumSize(new Dimension(21, 21));
		btMaterial1.setPreferredSize(new Dimension(21, 21));
		btMaterial1.setMargin(new Insets(0, 0, 0, 0));
		btMaterial1.setText("M");
		chbFromModel.setText("Из модели");
		chbFromModel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chbFromModel_actionPerformed(e);
			}
		});
		jLabel2.setText("Конструктивная группа");
		chbOsobo.setHorizontalTextPosition(SwingConstants.LEADING);
		chbOsobo.setText("Особо ответственная");
		rbZagot.setText("Вспомогательный материал");
		rbMat.setSelected(true);
		rbMat.setText("Материал");
		jLabel7.setText("для");
		jLabel13.setText("Размещение оригинала");
		chbZag.setText("Заготовка");
		chbZag.setHorizontalTextPosition(SwingConstants.LEADING);
		chbZag.setHorizontalAlignment(SwingConstants.LEADING);
		edOrigin.setText("");
		edZag.setText("");
		jLabel8.setText("Вид изделия");
		edType.setFont(new java.awt.Font("Dialog", 1, 11));
		edType.setEditable(false);
		edType.setText("");
		edRev.setEditable(false);
		edRev.setText("");
		jLabel11.setText("Ревизия");
		jLabel14.setToolTipText("");
		jLabel14.setText("Базовая CAD-система");
		jpMilx.setLayout(gridBagLayout1);
		jpMilx.setMinimumSize(new Dimension(400, 189));
		jpMilx.setPreferredSize(new Dimension(400, 189));
		jPanel1.setBorder(titledBorder6);
		jPanel1.setMinimumSize(new Dimension(300, 150));
		jPanel1.setPreferredSize(new Dimension(300, 150));
		jPanel1.setToolTipText("");
		jPanel1.setLayout(gridBagLayout2);
		jLabel16.setText("Длина, (мм)");
		edLength.setMinimumSize(new Dimension(62, 20));
		edLength.setPreferredSize(new Dimension(62, 20));
		edLength.setInputVerifier(floatVerifier);
		edLength.setText("");
		jLabel17.setText("Ширина, (мм)");
		jLabel18.setText("Глубина, (мм)");
		edWidth.setInputVerifier(floatVerifier);
		edWidth.setText("");
		edDepth.setInputVerifier(floatVerifier);
		edDepth.setText("");
		jLabel19.setText("Плотность");
		edDensity.setMinimumSize(new Dimension(80, 20));
		edDensity.setPreferredSize(new Dimension(80, 20));
		edDensity.setInputVerifier(floatVerifier);
		edDensity.setText("");
		edDensity.setEnabled(false);
		edDensity.setEditable(false);
		LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
		LNotSaved.setForeground(Color.red);
		LNotSaved.setText("Карточка не сохранена!");
		jLabel6.setText(".");
		dateNachBrig.setDisplayFormat("dd-MM-yyyy");
		dateNachBrig.setText("Дата не установлена");
		LApprover3.setText("Нач. Бригады");
		edNachBrig.setPreferredSize(new Dimension(140, 21));
		edNachBrig.setMinimumSize(new Dimension(140, 21));
		jLabel15.setText("Отдел");
		cbOtdel.setMinimumSize(new Dimension(100, 19));
		edMatShifr.setEnabled(false);
		edMatShifr.setMinimumSize(new Dimension(150, 20));
		edMatShifr.setPreferredSize(new Dimension(150, 20));
		edMatShifr.setText("");
		edChangeNotice.setMinimumSize(new Dimension(130, 21));
		edChangeNotice.setPreferredSize(new Dimension(130, 21));
		edChangeNotice.setEnabled(false);
		TabbedPane.add(MainPanel, "Общие данные");

		jpMaterial.add(rbZagot, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 5), 0, 0));
		jpMaterial.add(rbMat, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 5), 0, 0));
		jpMaterial.add(jLabel19, new GridBagConstraints(2, 2, 1, 1, 1.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 5), 0, 0));
		jpMaterial.add(edDensity, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		jpMaterial.add(btMaterial, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		jpMaterial.add(btMaterial1, new GridBagConstraints(4, 1, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 5, 0), 0, 0));
		jpMaterial.add(btMaterialClr, new GridBagConstraints(5, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		jpMaterial.add(edNameMat, new GridBagConstraints(1, 0, 3, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 5), 0, 0));
		// -- шифр материала пусть будет не виден
		jpMaterial.add(edMatShifr, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 0), 0, 0));

		// jpMilx.add(LCreator, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 5,
		// 5, 5), 0, 0));
		// jpMilx.add(cbCreator, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20,
		// 0, 0, 0), 0, 0));
		// jpMilx.add(dateCreator, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new
		// Insets(20, 5, 5, 5), 0, 0));
		jpMilx.add(jLabel3, new GridBagConstraints(0, 7, 1, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 0, 0));
		jpMilx.add(jPanel1, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 0, 0, 0), 0, 0));
		jPanel1.add(jLabel16, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 1, 5), 0, 0));
		jPanel1.add(jLabel9, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 5, 5), 0, 0));
		jPanel1.add(edLength, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 0), 0, 0));
		jPanel1.add(jLabel17, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 1, 5), 0, 0));
		jPanel1.add(jLabel18, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 1, 5), 0, 0));
		jPanel1.add(edWidth, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));
		jPanel1.add(edDepth, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));
		{
			jLabel9 = new JLabel();

		}
		{
			jTextField1 = new JTextField();
			jPanel1.add(jTextField1,
					new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5,
									0), 0, 0));
		}
		MainPanel.add(jLabel14, new GridBagConstraints(0, 11, 2, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 0), 0, 0));
		MainPanel.add(cbCAD, new GridBagConstraints(2, 11, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 0), 0, 0));
		// ///////////////////
		MainPanel.add(new JLabel("Извещение"), new GridBagConstraints(0, 12, 2,
				1, 0.0, 0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 0), 0, 0));
		MainPanel.add(edChangeNotice, new GridBagConstraints(1, 12, 1, 1, 0.0,
				0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));

		// ////////
		MainPanel.add(jLabel11, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(edRev, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 5, 5, 0), 0, 0));
		MainPanel.add(edType, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(20, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel13, new GridBagConstraints(0, 9, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 5, 5, 0), 0, 0));
		MainPanel.add(chbZag, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		MainPanel.add(edOrigin, new GridBagConstraints(2, 9, 4, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel7, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		MainPanel.add(edZag, new GridBagConstraints(2, 10, 4, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel2, new GridBagConstraints(3, 4, 2, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
						0, 5, 0), 0, 0));
		MainPanel.add(chbOsobo, new GridBagConstraints(4, 5, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 0), 0, 0));
		MainPanel.add(cbConsGroup, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(LMassa, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(
						10, 0, 5, 0), 0, 0));

		// MainPanel.add(LKIM, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0,
		// 5, 0), 0, 0));
		// MainPanel.add(edKIM, new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new
		// Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(chbFromModel, new GridBagConstraints(5, 8, 1, 1, 0.0,
				0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 5, 5, 0), 0, 0));
		// MainPanel.add(LTypeIzgot, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5,
		// 5, 0), 0, 0));
		// MainPanel.add(cbTypeIzgot, new GridBagConstraints(2, 9, 2, 1, 0.0,
		// 0.0
		// ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new
		// Insets(0, 5, 5, 0), 0, 0));
		// MainPanel.add(cbLiter2, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0,
		// 0, 5, 0), 0, 0));
		// MainPanel.add(cbLiter3, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0,
		// 0, 5, 0), 0, 0));
		// MainPanel.add(LDateVnedr, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5,
		// 0, 0), 0, 0));
		// MainPanel.add(dateVnedrII, new GridBagConstraints(2, 5, 2, 1, 0.0,
		// 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5,
		// 0, 0), 0, 0));
		MainPanel.add(btClrFmt, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 2, 5, 0), 0, 0));
		MainPanel.add(edFormat, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 5, 5, 0), 0, 0));
		MainPanel.add(cbFormat, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(
						10, 5, 5, 0), 0, 0));
		// MainPanel.add(edChangeNotice, new GridBagConstraints(1, 6, 4, 1, 0.0,
		// 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new
		// Insets(0, 5, 5, 0), 0, 0));

		// извещение
		MainPanel.add(edN_Izv, new GridBagConstraints(1, 6, 4, 1, 0.0, 0.0,
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
		// MainPanel.add(jLabel9, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 5,
		// 0, 0), 0, 0));
		// MainPanel.add(edRoditel, new GridBagConstraints(1, 9, 4, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new
		// Insets(10, 5, 5, 0), 0, 0));
		MainPanel.add(edIndication, new GridBagConstraints(1, 1, 5, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel21, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 5, 5, 0), 0, 0));
		MainPanel.add(edNameFull, new GridBagConstraints(1, 2, 5, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(cbLiter1, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(10, 5, 5, 0), 0, 0));
		MainPanel.add(edMassa, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(10, 5, 5, 0), 0, 0));
		// MainPanel.add(LTrud, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5,
		// 5, 5), 0, 0));
		// MainPanel.add(edTrud, new GridBagConstraints(1, 8, 3, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5,
		// 5, 0), 0, 0));
		MainPanel.add(jLabel10, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 0, 0), 0, 0));
		MainPanel.add(dateCreate, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 0), 0, 0));
		MainPanel.add(jLabel110, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 5, 0), 0, 0));
		MainPanel.add(dateChange, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						5, 5, 0), 0, 0));
		MainPanel.add(LNotSaved, new GridBagConstraints(3, 13, 2, 1, 0.0, 0.0,
				GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(
						20, 0, 0, 0), 0, 0));
		{
			jLabel4 = new JLabel();
			MainPanel.add(jLabel4, new GridBagConstraints(3, 13, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
					new Insets(0, 0, 0, 0), 0, 0));
			jLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
			jLabel4.setForeground(Color.red);
		}
		TabbedPane.add(jpMilx, "Прочее");

		// MainPanel.add(jpMaterial, new GridBagConstraints(0, 9, 6, 1, 0.0, 0.0
		// ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new
		// Insets(0, 0, 0, 0), 0, 0));

		// this.add(LHeader, BorderLayout.NORTH);

		JPanel panelHead = new JPanel();
		panelHead.setLayout(borderLayoutHead);
		panelHead.add(LHeader, BorderLayout.CENTER);
		panelHead.add(vrtLogo, BorderLayout.EAST);
		// this.add(LHeader, BorderLayout.NORTH);
		// this.add(vrtLogo, BorderLayout.);
		this.add(panelHead, BorderLayout.NORTH);

		this.add(TabbedPane, BorderLayout.CENTER);

		jpMilx.add(jpMaterial, new GridBagConstraints(2, 6, 4, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));

		jpSignOffs.add(cbCreator, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(25, 5, 5, 5), 0, 0));
		jpSignOffs.add(dateCreator, new GridBagConstraints(2, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(25, 5, 5, 5), 0, 0));
		jpSignOffs.add(LReviewer, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 5, 5, 5), 0, 0));
		jpSignOffs.add(edReviewer, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(15, 5, 5, 5), 0, 0));
		jpSignOffs.add(dateReview, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(15, 5, 5, 5), 0, 0));
		jpSignOffs.add(dateNK, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(dateNachOtd, new GridBagConstraints(2, 4, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(dateTK, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(dateApprove, new GridBagConstraints(2, 7, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		// jpSignOffs.add(edAdditional, new GridBagConstraints(0, 7, 3, 1, 0.0,
		// 0.0
		// ,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new
		// Insets(0, 5, 5, 5), 0, 0));
		// jpSignOffs.add(jLabel12, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0
		// ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20,
		// 0, 5, 0), 0, 0));
		jpSignOffs.add(LNormo, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 5), 0, 0));
		jpSignOffs.add(LApprover1, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 5), 0, 0));
		jpSignOffs.add(LApprover2, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 5), 0, 0));
		jpSignOffs.add(edApprover, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(edNormocontrol, new GridBagConstraints(1, 6, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(edTechcontrol, new GridBagConstraints(1, 5, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(edNachOtd, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(LApprover, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 5), 0, 0));
		jpSignOffs.add(jLabel6, new GridBagConstraints(0, 8, 1, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		jpSignOffs.add(dateNachBrig, new GridBagConstraints(2, 3, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(LApprover3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 0), 0, 0));
		jpSignOffs.add(edNachBrig, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jpSignOffs.add(LCreator, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						25, 5, 0, 5), 0, 0));
		jpSignOffs.add(jLabel15, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		jpSignOffs.add(cbOtdel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 0, 5), 0, 0));
		// jpSignOffs.add(jLabel3, new GridBagConstraints(0, 8, 1, 1, 0.0, 1.0
		// ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0,
		// 0, 0), 0, 0));

		/*
		 * jpRascex.add(edRascex, new GridBagConstraints(0, 1, 3, 1, 1.0, 0.0
		 * ,GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL, new
		 * Insets(0, 20, 30, 0), 0, 0)); jpRascex.add(cbCexa, new
		 * GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
		 * ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0,
		 * 5, 30, 20), 0, 0)); jpRascex.add(jLabel29, new GridBagConstraints(0,
		 * 0, 2, 1, 0.0, 0.0 ,GridBagConstraints.SOUTH, GridBagConstraints.NONE,
		 * new Insets(50, 20, 5, 0), 0, 0)); jpRascex.add(jLabel30, new
		 * GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
		 * ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0,
		 * 5, 5, 20), 0, 0)); jpRascex.add(jLabel32, new GridBagConstraints(0,
		 * 3, 1, 1, 0.0, 1.0 ,GridBagConstraints.CENTER,
		 * GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		 * 
		 * //TabbedPane.add(jpVR, "Ведомости"); jpVR18.add(chbVR18, new
		 * GridBagConstraints(0, 0, 2, 1, 0.0, 0.0 ,GridBagConstraints.WEST,
		 * GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		 * jpVR18.add(LVR18_Note, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
		 * ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5,
		 * 5, 5), 0, 0)); jpVR18.add(spVR18, new GridBagConstraints(1, 1, 1, 1,
		 * 1.0, 1.0 ,GridBagConstraints.WEST, GridBagConstraints.BOTH, new
		 * Insets(0, 0, 0, 0), 0, 0)); jpVR.add(jpVR10, new
		 * GridBagConstraints(0, 1, 1, 1, 1.0, 1.0 ,GridBagConstraints.CENTER,
		 * GridBagConstraints.BOTH, new Insets(5, 10, 5, 10), 0, 0));
		 * jpVR10.add(chbVR10, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
		 * ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5,
		 * 5, 5), 0, 0)); jpVR10.add(LVR10_Note, new GridBagConstraints(0, 1, 1,
		 * 1, 0.0, 0.0 ,GridBagConstraints.WEST, GridBagConstraints.NONE, new
		 * Insets(0, 5, 5, 5), 0, 0)); jpVR10.add(spVR10, new
		 * GridBagConstraints(1, 1, 1, 1, 1.0, 1.0 ,GridBagConstraints.WEST,
		 * GridBagConstraints.BOTH, new Insets(0, 5, 0, 0), 0, 0));
		 * spVR10.getViewport().add(edVR10_Note, null); jpVR.add(jpVR3, new
		 * GridBagConstraints(0, 0, 1, 1, 1.0, 1.0 ,GridBagConstraints.CENTER,
		 * GridBagConstraints.BOTH, new Insets(10, 10, 5, 10), 0, 0));
		 * spVR18.getViewport().add(edVR18_Note, null); jpVR.add(jpVR18, new
		 * GridBagConstraints(0, 2, 1, 1, 1.0, 1.0 ,GridBagConstraints.CENTER,
		 * GridBagConstraints.BOTH, new Insets(10, 10, 5, 10), 0, 0));
		 * jpVR3.add(chbVR3_s, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
		 * ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(5,
		 * 5, 5, 0), 0, 0)); jpVR3.add(LVR3_Note, new GridBagConstraints(0, 1,
		 * 1, 1, 0.0, 0.0 ,GridBagConstraints.CENTER, GridBagConstraints.NONE,
		 * new Insets(0, 5, 0, 5), 0, 0)); jpVR3.add(chbVR3_p, new
		 * GridBagConstraints(2, 0, 1, 1, 0.0, 0.0 ,GridBagConstraints.WEST,
		 * GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 5), 0, 0));
		 * jpVR3.add(spVR3, new GridBagConstraints(1, 1, 3, 1, 1.0, 1.0
		 * ,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 5,
		 * 0, 0), 0, 0)); spVR3.getViewport().add(edVR3_Note, null);
		 */

		TabbedPane.add(jpSignOffs, "Подписи");
		// TabbedPane.add(jpRascex, "Расцеховка");

		infoKart.add(jLabel28, new GridBagConstraints(2, 0, 1, 2, 0.0, 0.0,
				GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		infoKart.add(jLabel27, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		infoKart.add(jLabel25, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		infoKart.add(cbNameProc, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 55, 0));
		// TabbedPane.add(infoKart, "Информационная карточка");
		bgMat.add(rbMat);
		bgMat.add(rbZagot);
	}

	void chbVR_stateChanged(ChangeEvent e) {
		boolean b = false;

		if (e.getSource() == chbVR10) {
			b = chbVR10.isSelected();
			LVR10_Note.setEnabled(b);
			edVR10_Note.setEnabled(b);
			// LVR10_TechPas.setEnabled(b); edVR10_TechPas.setEnabled(b);
		} else if (e.getSource() == chbVR18) {
			b = chbVR18.isSelected();
			LVR18_Note.setEnabled(b);
			edVR18_Note.setEnabled(b);
		}
	}

	void btMaterialClr_actionPerformed(ActionEvent e) {
		edNameMat.setText("");
		edDensity.setText("0");
		edMatShifr.setText("");
	}

	void btMaterial_actionPerformed(ActionEvent e) {
		/*
		 * AIFClipboard clipboard = AIFPortal.getClipboard(); Transferable
		 * content = clipboard.getContents ( this ); if ( content == null )
		 * return;
		 * 
		 * Vector childComponents = new Vector(); try { childComponents =
		 * (Vector)content.getTransferData ( new DataFlavor ( Vector.class,
		 * "AIF Vector" ) ); } catch ( Exception ex ) { MessageBox.post ( ex );
		 * return; }
		 * 
		 * TCComponent childComponent = (TCComponent)childComponents.get(0);
		 * TCComponentItem item=null; TCComponentItemRevision ir=null;
		 * 
		 * try{ if (childComponent instanceof TCComponentItem) {
		 * item=(TCComponentItem)childComponent; // TCComponent components[] =
		 * item.getTCProperty("revision_list").getReferenceValueArray(); // if
		 * (components!=null) ir = (TCComponentItemRevision)components[0];
		 * 
		 * // ir = item.getLatestItemRevision(); } if (childComponent instanceof
		 * TCComponentItemRevision) {
		 * ir=(TCComponentItemRevision)childComponent; item=ir.getItem(); } }
		 * catch ( Exception ex ) { ex.printStackTrace(); }
		 * 
		 * // String s = ""; try{ TCComponentForm
		 * form=(TCComponentForm)item.getRelatedComponent("IMAN_master_form");
		 * if (item.getType().equals("Материал")) { if
		 * (MaterialForm.fillDataIfClassified(data, item)) {
		 * edNameMat.setText(data.material);
		 * edNDMark.setText(data.mater_mark_nd);
		 * edNDSort.setText(data.mater_sort_nd);
		 * edMarkMat.setText(data.mater_mark);
		 * edVidZagot.setText(data.mater_zagot); } else {
		 * edNameMat.setText(form.
		 * getFormTCProperty("MIL_NAME_DSE").getStringValue());
		 * edNDMark.setText(
		 * form.getFormTCProperty("MIL_ND_MARKA").getStringValue());
		 * edNDSort.setText
		 * (form.getFormTCProperty("MIL_ND_SORT").getStringValue());
		 * edMarkMat.setText
		 * (form.getFormTCProperty("MIL_MARKA_MAT").getStringValue());
		 * edVidZagot
		 * .setText(form.getFormTCProperty("MIL_VID_ZAGOT").getStringValue());
		 * edMatShifr
		 * .setText(form.getFormTCProperty("MIL_DSE_CODE").getStringValue());
		 * edDensity
		 * .setText(form.getFormTCProperty("MIL_MASSA").getStringValue()); }
		 * //setNameSpec(); } elseMessageBox.post(
		 * "Невозможно вставить данные о материале, в буфере обмена не Материал!"
		 * ,"LANIT",MessageBox.WARNING); } catch ( Exception ex ) {
		 * MessageBox.post ( ex ); }
		 */
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

	void cbCexa_itemStateChanged(ItemEvent e) {
		if (e.getStateChange() != 1)
			return;
		String code = cbCexa.getSelectedItem().toString();
		if (code.equals(""))
			return;
		String old = edRascex.getText();
		if (!old.equals(""))
			old = old + "-";
		old = old + code;
		edRascex.setText(old);
	}

	/*
	 * -- Устарело public void setNameSpec() { String sNDSort =
	 * edNDSort.getText(); String sNDMark = edNDMark.getText(); String sVidZagot
	 * = edVidZagot.getText(); // Сформировать строку для спец-ии String
	 * sNameSpec = (sVidZagot);// + " " + sNDSort).trim(); if
	 * (sVidZagot.length()==0) sNameSpec = (sNameSpec + " " +
	 * edNameMat.getText()).trim(); sNameSpec = (sNameSpec + " " +
	 * edMarkMat.getText()).trim(); if (sNDSort.length()==0) sNameSpec =
	 * (sNameSpec + " " + sNDMark).trim(); edNameMat.setText(sNameSpec); }
	 */

	void btMaterial1_actionPerformed(ActionEvent e) {
		CrMat_Command cmd = new CrMat_Command(session);
		abstractSelMatDlg dlg = null;

		if (rbMat.isSelected()) {
			dlg = new SelectMatDlg3(btMaterial1, 1, session); // 1 - обычные
																// материалы
		}
		// -- Выбор (заготовки) чистого сортамента
		else if (rbZagot.isSelected()) // вспомогательные материалы
		{
			dlg = new SelectZagDlg2(btMaterial1, SelectZagDlg2.cstAuxMat,
					session);

			dlg.sMatMark = "";
			dlg.sMatNDMark = "";
			dlg.sMatShifr = "0-" + dlg.sMatShifr;
		}
		if (dlg.iResult != 0) {
			DSEUserData mat_data = new DSEUserData(session);
			mat_data.mater_name = dlg.sMatName;
			mat_data.mater_mark_nd = dlg.sMatNDMark;
			mat_data.mater_sort_nd = dlg.sMatNDSort;
			mat_data.mater_mark = dlg.sMatMark;
			mat_data.mater_zagot = dlg.sMatSort;
			mat_data.mater_shifr = dlg.sIMBASE_Code;// dlg.sMatShifr;
			mat_data.density = dlg.fDensity;
			mat_data.code_okp = dlg.sMatShifr;
			dlg.makeMatString(mat_data);

			// проверить наличие материала, а если нет, то готовность его
			// создать
			if (!cmd.checkMatTCE(mat_data))
				return;

			edNameMat.setText(dlg.sMatName);
			edNDMark.setText(dlg.sMatNDMark);
			edNDSort.setText(dlg.sMatNDSort);
			edMarkMat.setText(dlg.sMatMark);
			edVidZagot.setText(dlg.sMatSort);
			edDensity.setText(LUtil.float2string(dlg.fDensity, 8));
			edMatShifr.setText(dlg.sIMBASE_Code);

			// lockMatProps();
			if (dlg.sMatSort != null) // выбор материала вместе с сортаментом
				edNameMat.setText(dlg.sMatSort);
			else
				edNameMat.setText(mat_data.material);
			// -- изменить цвет поля массы, сигнал что материал изменился
			data.kim = 1;
			setMassColor(1);
		}
	}

	void chbFromModel_actionPerformed(ActionEvent e) {
		if (e.getSource() == chbFromModel) {
			boolean bFromModel = chbFromModel.isSelected();
			if (e.getActionCommand().equals("Set"))
				bFromModel = data.pr_from_model;
			double Massa;
			// String sMassa;
			edMassa.setEnabled(!bFromModel);
			Massa = bFromModel ? data.getMassFromModel() : data.massa;
			// sMassa = Double.toString(Massa);
			// edMassa.setText(sMassa);
			edMassa.setText(LUtil.float2string(Massa, 6));
		}
	}
}
