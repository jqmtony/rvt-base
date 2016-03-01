package ru.rostvertolplc.osapr.forms;

import ru.rostvertolplc.osapr.util.TextFieldDocument;
import com.teamcenter.rac.util.MessageBox;
import java.awt.*;

import javax.swing.*;

import com.teamcenter.rac.form.label.*;
import java.awt.event.*;
import com.teamcenter.rac.form.lovcombobox.*;
import ru.rostvertolplc.osapr.util.LUtil;
import java.util.Vector;
import com.teamcenter.rac.kernel.*;

public class StdItemPanel extends JPanel implements InterfaceFormPanel {
	DSEUserData data = null;
	// Registry R = Registry.getRegistry("com.avid.forms.forms");

	private JLabel LHeader = new JLabel();
	private GridBagLayout gridBagLayout1 = new GridBagLayout();
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel5 = new JLabel();
	private JLabel jLabel3 = new JLabel();
	private JLabel jLabel16 = new JLabel();
	private BorderLayout borderLayoutHead = new BorderLayout();
	private JTextField edIndication = new TextFieldDocument(128);
	private JTextField edName = new TextFieldDocument(256);
	private JTextField edFirstUse = new TextFieldDocument(128);
	private JLabel jLabel1 = new JLabel();
	private JLabel vrtLogo = new JLabel();
	JLabel jLabel6 = new JLabel();
	FormLabel kod_dse = new FormLabel();
	JLabel jLabel7 = new JLabel();
	JTextField edSpravNo = new TextFieldDocument(128);
	JTextField edGOST = new JTextField();
	JLabel jLabel4 = new JLabel();
	JLabel LDSEKey = new JLabel();
	JTextField edDSEKey = new JTextField();
	JLabel LNotSaved = new JLabel();

	public StdItemPanel() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StdItemPanel(DSEUserData theData) {
		data = theData;
		try {
			jbInit();
			renderData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void renderData() {
		if (data.bNewID)
			edIndication.setForeground(Color.GRAY);
		if (data.bNewName)
			edName.setForeground(Color.GRAY);
		LNotSaved.setVisible(data.sc == null);

		edIndication.setText(data.indication);
		edName.setText(data.name_dse);
		edSpravNo.setText(data.sprav_dse);
		edFirstUse.setText(data.first_use);
		edGOST.setText(data.gost);
		// Списки
		// LUtil.fillComboBoxLOV(cbIzdelie, data.lov_izdelie);
		// cbIzdelie.setSelectedItem(data.izdelie);

		kod_dse.setText(data.code_dse);
		// edDSEKey.setText(data.dse_key);

	}

	public void saveToUserData() {
		// String sObj=null;
		// int len;
		try {
			data.indication = edIndication.getText();
			data.name_dse = edName.getText();
			data.sprav_dse = edSpravNo.getText();
			data.first_use = edFirstUse.getText();
			// data.otvetstv = cbIzdelie.getSelectedItem()==null ? "" :
			// cbIzdelie.getSelectedItem().toString();
			data.gost = edGOST.getText();
		} catch (Exception ex) {
			MessageBox.post(ex);
		}
	}

	public void setHeader(String s) {
		LHeader.setText(s);
	}

	private void jbInit() throws Exception {
		this.setLayout(gridBagLayout1);
		edFirstUse.setMinimumSize(new Dimension(20, 21));
		jLabel5.setText("Обозначение");
		LHeader.setFont(new java.awt.Font("Dialog", 1, 14));
		LHeader.setText("Изделие << Стандартное >>");
		vrtLogo.setText("");
		try {
			vrtLogo = new JLabel(new ImageIcon(getClass().getClassLoader()
					.getResource("resources/images/rostvertol.png")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		jLabel2.setText("Первичная применяемость");
		jLabel3.setText("Справочный номер");
		edSpravNo.setMinimumSize(new Dimension(20, 21));
		edIndication.setMaximumSize(new Dimension(600, 21));
		edIndication.setMinimumSize(new Dimension(20, 21));
		edIndication.setPreferredSize(new Dimension(20, 21));
		edIndication.setText("1");
		edIndication.setHorizontalAlignment(SwingConstants.TRAILING);
		jLabel16.setText("Наименование");
		edName.setPreferredSize(new Dimension(20, 21));
		edName.setMinimumSize(new Dimension(20, 21));
		edName.setOpaque(true);
		edName.setMaximumSize(new Dimension(300, 21));
		this.setMinimumSize(new Dimension(500, 300));
		this.setPreferredSize(new Dimension(500, 300));
		jLabel6.setForeground(UIManager.getColor("Button.shadow"));
		jLabel6.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel6.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabel6.setText("Код ДСЕ");
		kod_dse.setMaximumSize(new Dimension(100, 15));
		kod_dse.setMinimumSize(new Dimension(100, 15));
		kod_dse.setPreferredSize(new Dimension(100, 15));
		kod_dse.setFormProperty("avid_DSE_CODE");
		jLabel7.setText("Справочный номер");
		edSpravNo.setMinimumSize(new Dimension(20, 21));
		jLabel4.setRequestFocusEnabled(true);
		jLabel4.setText("ГОСТ / ОСТ / НОРМАЛЬ");
		edGOST.setText("");
		LDSEKey.setText("Ключ поиска");
		edDSEKey.setEditable(false);
		edDSEKey.setText("");
		LNotSaved.setFont(new java.awt.Font("Dialog", 0, 12));
		LNotSaved.setForeground(Color.red);
		LNotSaved.setText("Карточка не сохранена!");
		this.add(edFirstUse, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 10), 0, 0));
		this.add(jLabel5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						20, 0, 0), 0, 0));
		this.add(jLabel2, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						15, 0, 5), 0, 0));

		/*
		 * JPanel panelHead = new JPanel();
		 * panelHead.setLayout(borderLayoutHead); panelHead.add(LHeader,
		 * BorderLayout.CENTER); panelHead.add(vrtLogo, BorderLayout.EAST);
		 */

		/*original----
		 * this.add(LHeader, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 15, 5), 0, 0));*/
		
		this.add(LHeader, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(
						0, 0, 15, 8), 0, 0));
		this.add(vrtLogo, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(
						0, 0, 15, 0), 0, 0));
		/*
		 * this.add(panelHead, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
		 * GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets( 0, 0,
		 * 15, 5), 0, 0));
		 */

		this.add(jLabel16, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						15, 5, 5), 0, 0));
		this.add(edName, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 10), 0, 0));
		this.add(jLabel1, new GridBagConstraints(0, 7, 1, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 0, 0));
		this.add(jLabel6, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 5), 0, 0));
		this.add(kod_dse, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 5, 5, 0), 0, 0));
		this.add(jLabel7, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(0, 15, 5, 0), 0, 0));
		this.add(edSpravNo, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 10), 0, 0));
		this.add(edIndication, new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 10, 5, 0), 0, 0));
		this.add(jLabel4, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						20, 5, 5), 0, 0));
		this.add(edGOST, new GridBagConstraints(2, 2, 1, 1, 1.5, 0.0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 5, 5, 10), 0, 0));
		this.add(LNotSaved, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0,
				GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(30, 0, 0, 0), 0, 0));
		// this.add(LDSEKey, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
		// ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 15,
		// 0, 5), 0, 0));
		// this.add(edDSEKey, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0
		// ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new
		// Insets(0, 5, 0, 10), 0, 0));
	}
}
