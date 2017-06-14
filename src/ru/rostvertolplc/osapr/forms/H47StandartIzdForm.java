package ru.rostvertolplc.osapr.forms;

//import com.teamcenter.rac.form.*;
import com.teamcenter.rac.stylesheet.AbstractRendering;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCProperty;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.kernel.TCException;
import java.awt.BorderLayout; //import java.awt.Container;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.teamcenter.rac.aif.AbstractAIFOperation; //import com.teamcenter.rac.aif.kernel.AIFComponentContext;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.commands.newitem.*;

//import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport; //import javax.swing.SwingUtilities;

import ru.rostvertolplc.osapr.util.LUtil;
import com.teamcenter.rac.kernel.TCComponentItemType;
import com.teamcenter.rac.util.Registry;
//import com.teamcenter.tc.kernel.icctstubs.booleanSeq_tHelper;
import com.teamcenter.rac.commands.newitem.ItemMasterFormPanel;

public class H47StandartIzdForm extends AbstractRendering {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	Registry R = Registry.getRegistry("ru.rostvertolplc.osapr.forms.L-forms");
	NameResolver NR = new NameResolver();

	TCComponent form = null;
	TCComponent item_form = null;
	TCComponent form_rev;
	String sFormType;
	// TCComponent sc = null;
	SmartTCEForm sform = null;
	SmartTCEForm sitem_form = null;
	SmartTCEForm sform_rev = null;
	TCSession session;

	InterfaceFormPanel innerPanel;

	DSEUserData data;

	private TCProperty data_indication;
	private TCProperty data_first_use;
	private TCProperty data_code_okp;
	private TCProperty data_doc_postav;
	private TCProperty data_org_postav;
	private TCProperty data_dop_info;
	private TCProperty data_n_protraz;
	private TCProperty data_print_id;
	private TCProperty data_gost; //
	private TCProperty data_type_doc;
	private TCProperty data_name_dse;
	private TCProperty data_sprav_dse;
	private TCProperty data_izdelie;
	private TCProperty data_type_izgot;
	private TCProperty data_vid_pki;
	private TCProperty data_sb;

	String getItemTypeCode() // используем sFormType
	{
		int idx = sFormType.lastIndexOf("Revision Master");
		if (idx < 0)
			idx = sFormType.lastIndexOf("Master");
		String sType = sFormType.substring(0, idx).trim();
		String Result = R.getString(sType + ".SBCODE", "0");
		return Result;
	}

	class SaveOperation extends AbstractAIFOperation {
		public void executeOperation() throws Exception {
			// try {
			// Получаем данные из формы
			innerPanel.saveToUserData();
			// String sFormType=form.getType();
			// if (sFormType.equals("Деталь Master"))
			// innpaneDetal.saveToUserData();
			// if (sFormType.equals("Сб. единица Master"))
			// innpaneDetal.saveToUserData();
			// if (sFormType.equals("Материал Revision Master"))
			// innpaneMaterial.saveToUserData();
			// if (sFormType.equals("Документ Revision Master"))
			// innerPanelDocument.saveToUserData();
			// if (sFormType.equals("Комплекс Revision Master"))
			// innerPanelKompleks.saveToUserData();
			// if (sFormType.equals("Комплект Revision Master"))
			// innerPanelKomplekt.saveToUserData();
			// if (sFormType.equals("Прочее Revision Master"))
			// innerPanelProchee.saveToUserData();
			// if (sFormType.equals("Стандартное изд. Revision Master"))
			// innerPanelStd_izd.saveToUserData();

			if (sitem_form == null) {
				form.lock();
				// form.getFormTCProperty(NR.fld_DSE_CODE).setStringValue(data.code_dse);
				sform.setFormPropertySafe(NR.fld_DSE, data.indication);
				sform.setFormPropertySafe(NR.fld_GOST, data.gost);
				sform.setFormPropertySafe(NR.fld_TIP_DOC, data.type_doc);
				sform.setFormPropertySafe(NR.fld_NAME_DSE, data.name_dse);
				sform.setFormPropertySafe(NR.fld_SPRAV_DSE, data.sprav_dse);
				sform.setFormPropertySafe(NR.fld_FIRST_USE, data.first_use);
				sform.setFormPropertySafe(NR.fld_UOBOZ_IZD, data.izdelie);
				sform.setFormPropertySafe(NR.fld_TIPIZGOT, data.type_izgot);
				sform.setFormPropertySafe(NR.fld_VIDPKI, data.vid_pki);
				sform.setFormPropertySafe(NR.fld_CODEOKP, data.code_okp);
				sform.setFormPropertySafe(NR.fld_DOC_POSTAV, data.doc_postav);
				sform.setFormPropertySafe(NR.fld_ORG_POSTAV, data.org_postav);
				sform.setFormPropertySafe(NR.fld_COMMENT, data.dop_info);
				sform.setFormPropertySafe(NR.fld_PRINTID, data.print_id);
				// поле, кодирующее тип изделия
				sform.setFormPropertySafe(NR.fld_SB, getItemTypeCode());
				sform.setFormPropertySafe(NR.fld_N_PROTRAZ, data.n_protraz
						+ "," + LUtil.Date2String(data.date_protocol));
				Object gg = form.getUid();
				if (gg != null)
					gg.toString();
				form.save();
				form.unlock();
			} else {
				item_form.lock();
				// form.getFormTCProperty(NR.fld_DSE_CODE).setStringValue(data.code_dse);
				sitem_form.setFormPropertySafe(NR.fld_DSE, data.indication);
				sitem_form.setFormPropertySafe(NR.fld_GOST, data.gost);
				sitem_form.setFormPropertySafe(NR.fld_TIP_DOC, data.type_doc);
				sitem_form.setFormPropertySafe(NR.fld_NAME_DSE, data.name_dse);
				sitem_form
						.setFormPropertySafe(NR.fld_SPRAV_DSE, data.sprav_dse);
				sitem_form
						.setFormPropertySafe(NR.fld_FIRST_USE, data.first_use);
				sitem_form.setFormPropertySafe(NR.fld_UOBOZ_IZD, data.izdelie);
				sitem_form
						.setFormPropertySafe(NR.fld_TIPIZGOT, data.type_izgot);
				sitem_form.setFormPropertySafe(NR.fld_VIDPKI, data.vid_pki);
				sitem_form.setFormPropertySafe(NR.fld_CODEOKP, data.code_okp);
				sitem_form.setFormPropertySafe(NR.fld_DOC_POSTAV,
						data.doc_postav);
				sitem_form.setFormPropertySafe(NR.fld_ORG_POSTAV,
						data.org_postav);
				sitem_form.setFormPropertySafe(NR.fld_COMMENT, data.dop_info);
				sitem_form.setFormPropertySafe(NR.fld_PRINTID, data.print_id);
				// поле, кодирующее тип изделия
				sitem_form.setFormPropertySafe(NR.fld_SB, getItemTypeCode());
				sitem_form.setFormPropertySafe(NR.fld_N_PROTRAZ, data.n_protraz
						+ "," + LUtil.Date2String(data.date_protocol));
				Object gg = form.getUid();
				if (gg != null)
					gg.toString();
				item_form.save();
				item_form.unlock();
			}
			// Запись комментария для прочих
			if (form.isTypeOf(NR.TYPE_Prochee + " Master")) {
				data.item.lock();
				data.item.setProperty("object_desc", data.comment);
				data.item.save();
				data.item.unlock();
			}
			// Запись массы и доп.данных для прочих
			if (sFormType.startsWith(NR.TYPE_Prochee + " ")) {
				// double Massa = data.massa;
				// if (data.pr_from_model)
				// Massa = Massa==0? -1 : -Massa;
				sform_rev.setFormPropertySafe(NR.fld_MASSA, data.massa);
				sform_rev.setFormPropertySafe(NR.fld_frommodel,
						data.pr_from_model);

				// Разработчик
				sform_rev.setFormPropertySafe(NR.fld_data2_R, data.creator);
				// Раздел справочника
				sform_rev.setFormPropertySafe(NR.fld_MATERIAL, data.material);
			}
			/*
			 * } catch (TCException ex) { ex.printStackTrace(); MessageBox mb =
			 * new MessageBox(ex); mb.setModal(true); mb.setVisible(true); }
			 */
		}
	}

	public H47StandartIzdForm(TCComponent theForm) throws Exception {
		super(theForm);
		form = theForm;

		session = (TCSession) form.getSession();
		loadRendering();
	}

	public void saveRendering() {
		// добавлено Стеценко, если создается новый объет то item надо брать из
		// формы визарда создания нового объекта
		if (data.item == null) {
			try {
				JPanel parentPanel = (JPanel) ((JPanel) this).getParent();
				JViewport enclosing = (JViewport) parentPanel.getParent();
				JScrollPane scrolpan1 = (JScrollPane) enclosing.getParent();
				ItemMasterFormPanel imfp1 = (ItemMasterFormPanel) scrolpan1
						.getParent();
				NewItemPanel itemPanel1 = (NewItemPanel) imfp1.controlWizardPanel;
				/*
				 * System.out.println(parentPanel.toString()+" | "+
				 * enclosing.toString()+ " | " +scrolpan1.toString()+ " | " +
				 * imfp1.toString() + " | " + itemPanel1.toString());
				 */
				data.item = (TCComponentItem) itemPanel1.newComponent;

				data.item_rev = data.item.getLatestItemRevision();
			} catch (TCException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (data.item != null) {
				try {
					item_form = (TCComponentForm) data.item
							.getRelatedComponent("IMAN_master_form");
					sitem_form = new SmartTCEForm((TCComponentForm)item_form);
				} catch (TCException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		SaveOperation operation = new SaveOperation();
		try {
			session.queueOperation(operation); // в этом случае мы не будет
			// ждать конца операции
		} catch (Exception ex) {
			MessageBox.post(ex);
		}
	}

	public void loadRendering() throws TCException {
		System.out.println("Item load rend");
		data = new DSEUserData();
		data.NR = NR;
		TCComponent comp = form.getReferenceProperty("item_for_form");

		data_indication = form.getTCProperty(NR.fld_DSE);
		data_first_use = form.getTCProperty(NR.fld_FIRST_USE);
		data_code_okp = form.getTCProperty(NR.fld_CODEOKP);
		data_doc_postav = form.getTCProperty(NR.fld_DOC_POSTAV);
		data_org_postav = form.getTCProperty(NR.fld_ORG_POSTAV);
		data_dop_info = form.getTCProperty(NR.fld_COMMENT);
		data_n_protraz = form.getTCProperty(NR.fld_N_PROTRAZ);
		data_print_id = form.getTCProperty(NR.fld_PRINTID);
		data_gost = form.getTCProperty(NR.fld_GOST);
		data_type_doc = form.getTCProperty(NR.fld_TIP_DOC);
		data_name_dse = form.getTCProperty(NR.fld_NAME_DSE);
		data_sprav_dse = form.getTCProperty(NR.fld_SPRAV_DSE);
		data_izdelie = form.getTCProperty(NR.fld_UOBOZ_IZD);
		data_type_izgot = form.getTCProperty(NR.fld_TIPIZGOT);
		data_vid_pki = form.getTCProperty(NR.fld_VIDPKI);
		data_sb = form.getTCProperty(NR.fld_SB);

		TCComponent comp2 = this.getComponent();
		System.out.println(comp2.toString());

		if (comp == null) {
			TCComponentItemType tc_item = (TCComponentItemType) session
					.getTypeComponent("Item");
			// comp = tc_item.find(form.getProperty("object_name"));
			TCComponentItem[] a1;
			a1 = tc_item.findItems(form.getProperty("object_name"));
			if (a1.length > 0)
				comp = a1[0];
		}
		if (comp != null) {
			if (comp instanceof TCComponentItem)
				data.item = (TCComponentItem) comp;
			else if (comp instanceof TCComponentItemRevision) {
				data.item_rev = (TCComponentItemRevision) comp;
				data.item = data.item_rev.getItem();
			}
		}
		sFormType = form.getType();
		// -- Для Прочего основной формой считаем Item Master но надо подчитать
		// массу из Revision --
		form_rev = form;
		if (data.item != null) {
			if (sFormType.equals(NR.TYPE_Prochee + " Master")) {
				form_rev = (TCComponentForm) data.item_rev
						.getRelatedComponent("IMAN_master_form_rev");
			} else if (sFormType.equals(NR.TYPE_Prochee + " Revision Master")) {
				form = (TCComponentForm) data.item
						.getRelatedComponent("IMAN_master_form");
			}
		}
		data.form = (TCComponentForm)form;
		// было, но для формы айтема почему-то не работает
		// data.sc = form.getReferenceProperty("data_file");
		Date createDate = form.getDateProperty("creation_date");

		// vertol
		// при создании новых объектов дат нет
		if (createDate == null) {
			long curTime = System.currentTimeMillis();
			createDate = new Date(curTime);
		}
		// ---
		Date modifyDate = form.getDateProperty("last_mod_date");

		// vertol
		// при создании новых объектов дат нет
		if (modifyDate == null) {
			long curTime = System.currentTimeMillis();
			modifyDate = new Date(curTime);
		}
		// ---

		if (createDate.before(modifyDate)) {
			data.sc = form.getReferenceProperty("data_file");
		}
		sform = new SmartTCEForm((TCComponentForm) form);
		sform_rev = new SmartTCEForm((TCComponentForm)form_rev);

		if (sFormType.startsWith(NR.TYPE_Prochee + " ")) {
			/*
			 * double Massa =
			 * form_rev.getFormTCProperty(NR.fld_MASSA).getDoubleValue(); if
			 * (Massa<0) { Massa = data.getMassFromModel(); data.pr_from_model =
			 * true; } data.massa = Massa;
			 */
			data.pr_from_model = (Boolean) sform_rev
					.getFormPropertyObj(NR.fld_frommodel);
			data.massa = data.pr_from_model ? data.getMassFromModel()
					: (Double) sform_rev.getFormPropertyObj(NR.fld_MASSA);

			// Считывание комментария для Прочих, при создании надо считать в
			// saveRendering!!!
			if (data.item != null)
				data.comment = data.item.getProperty("object_desc");
			// Разработчик
			data.creator = (String) sform_rev
					.getFormPropertyObj(NR.fld_data2_R);
			// Раздел справочника
			data.material = (String) sform_rev
					.getFormPropertyObj(NR.fld_MATERIAL);
		}
		if (data.item != null)
			try {
				// data.code_dse =
				// form.getFormTCProperty(NR.fld_DSE_CODE).getStringValue();
				data.indication = (String) sform.getFormPropertyObj(NR.fld_DSE);
				data.name_dse = (String) sform
						.getFormPropertyObj(NR.fld_NAME_DSE);
				data.first_use = (String) sform
						.getFormPropertyObj(NR.fld_FIRST_USE);
				data.sprav_dse = (String) sform
						.getFormPropertyObj(NR.fld_SPRAV_DSE);
				data.izdelie = (String) sform
						.getFormPropertyObj(NR.fld_UOBOZ_IZD);
				data.gost = (String) sform.getFormPropertyObj(NR.fld_GOST);
				// data.otvetstv =
				// (String)sform.getFormPropertyObj(NR.fld_OTVETSTV);
				data.type_doc = (String) sform
						.getFormPropertyObj(NR.fld_TIP_DOC);
				data.type_izgot = (String) sform
						.getFormPropertyObj(NR.fld_TIPIZGOT);
				data.code_okp = (String) sform
						.getFormPropertyObj(NR.fld_CODEOKP);
				data.doc_postav = (String) sform
						.getFormPropertyObj(NR.fld_DOC_POSTAV);
				data.org_postav = (String) sform
						.getFormPropertyObj(NR.fld_ORG_POSTAV);
				data.vid_pki = (String) sform.getFormPropertyObj(NR.fld_VIDPKI);
				data.print_id = (Boolean) sform
						.getFormPropertyObj(NR.fld_PRINTID);
				data.dop_info = (String) sform
						.getFormPropertyObj(NR.fld_COMMENT);

				String strArray[];
				strArray = LUtil.parse2Array((String) sform
						.getFormPropertyObj(NR.fld_N_PROTRAZ));
				data.n_protraz = strArray[0];
				data.date_protocol = LUtil.String2Date(strArray[1]);

				// Списки
				// (Ответственное подразделение)
				// data.lov_otvetstv = LUtil.getLOVStrings(NR.lov_OTVETSTV,
				// session);
				// Вид ПКИ
				// data.lov_pki = LUtil.getLOVStrings(NR.lov_VIDPKI, session);
				// Изделия
				data.lov_izdelie = LUtil.getLOVStrings(NR.lov_NIZD, session);
				// Тип документа
				data.lov_doctype = LUtil.getLOVStrings(NR.lov_KODDOC);

				// Унаследование обозначения
				data.bNewID = data.indication.equals("") && data.item != null;
				// Унаследование наименования
				data.bNewName = data.name_dse.equals("") && data.item != null;
				if (data.bNewID && data.bNewName) {
					if (data.bNewID)
						data.indication = data.item.getProperty("item_id");
					if (data.bNewName)
						data.name_dse = data.item.getProperty("object_name");
				}
			} catch (TCException ex) // если пользователь прав на создание не
										// имеет
			// ничего не создаем
			{
				ex.printStackTrace();
				MessageBox.post(ex);
			}
		setLayout(new BorderLayout());

		if (sFormType.equals(NR.TYPE_Detal + " Master")) {
			innerPanel = new DetalItemPanel(data);
			innerPanel.setHeader("Деталь");
		} else if (sFormType.equals(NR.TYPE_SE + " Master")) {
			innerPanel = new DetalItemPanel(data);
			innerPanel.setHeader("Сб. единица");
		} else if (sFormType.equals(NR.TYPE_StdIzd + " Master"))
		// || sFormType.equals("СЕ Станд. Master") )
		{
			innerPanel = new StdItemPanel(data);
			innerPanel.setHeader("Стандартное изделие");
		} else if (sFormType.equals(NR.TYPE_Complect + " Master")) {
			innerPanel = new DetalItemPanel(data);
			innerPanel.setHeader("Комплект");
		} else if (sFormType.equals(NR.TYPE_Prochee + " Master")
				|| sFormType.equals(NR.TYPE_Prochee + " Revision Master")) {
			innerPanel = new ProcheeItemPanel(data);
		} else if (sFormType.equals(NR.TYPE_Document + " Master")) {
			innerPanel = new DocItemPanel(data);
			innerPanel.setHeader("Документ Конструкторский");
		}
		/*
		 * else if (sFormType.equals("Комплекс Master")) { innerPanel = new
		 * DetalItemPanel(data); innerPanel.setHeader("Комплекс"); } else if
		 * (sFormType.equals("Тех. узел Master")) { innerPanel = new
		 * DetalItemPanel(data); innerPanel.setHeader("Технологический узел"); }
		 */
		add((JPanel) innerPanel, BorderLayout.CENTER);
	}

	public boolean isRenderingModified() {
		if (data_indication != null	&& !data.indication.equals(data_indication.getStringValue())) {
			return true;
		}
		if (data_gost != null
				&& !data.gost.equals(data_gost.getStringValue())) {
			return true;
		}
		if (data_type_doc != null
				&& !data.type_doc.equals(data_type_doc.getStringValue())) {
			return true;
		}
		if (data_name_dse != null
				&& !data.name_dse.equals(data_name_dse.getStringValue())) {
			return true;
		}
		if (data_sprav_dse != null
				&& !data.sprav_dse.equals(data_sprav_dse.getStringValue())) {
			return true;
		}
		if (data_first_use != null
				&& !data.first_use.equals(data_first_use.getStringValue())) {
			return true;
		}
		if (data_izdelie != null
				&& !data.izdelie.equals(data_izdelie.getStringValue())) {
			return true;
		}
		if (data_type_izgot != null
				&& !data.type_izgot
						.equals(data_type_izgot.getStringValue())) {
			return true;
		}
		if (data_vid_pki != null
				&& !data.vid_pki.equals(data_vid_pki.getStringValue())) {
			return true;
		}
		if (data_code_okp != null
				&& !data.code_okp.equals(data_code_okp.getStringValue())) {
			return true;
		}
		if (data_doc_postav != null
				&& !data.doc_postav
						.equals(data_doc_postav.getStringValue())) {
			return true;
		}
		if (data_org_postav != null
				&& !data.org_postav
						.equals(data_org_postav.getStringValue())) {
			return true;
		}
		if (data_dop_info != null
				&& !data.dop_info.equals(data_dop_info.getStringValue())) {
			return true;
		}
		try {
			if (data_print_id != null
					&& data.print_id != data_print_id.getLogicalValue()) {
				return true;
			} else
				return false;

		} catch (TCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Map getRenderingModified() {
		Map<String, Object> modifiedRendering = new HashMap<String, Object>();
		try {
			if (data_indication != null
					&& !data.indication
							.equals(data_indication.getStringValue())) {
				data_indication.setStringValue(data.indication);
				modifiedRendering.put(NR.fld_DSE, data_indication);
			}
			if (data_gost != null
					&& !data.gost.equals(data_gost.getStringValue())) {
				data_gost.setStringValue(data.gost);
				modifiedRendering.put(NR.fld_GOST, data_gost);
			}
			if (data_type_doc != null
					&& !data.type_doc.equals(data_type_doc.getStringValue())) {
				data_type_doc.setStringValue(data.type_doc);
				modifiedRendering.put(NR.fld_TIP_DOC, data_type_doc);
			}
			if (data_name_dse != null
					&& !data.name_dse.equals(data_name_dse.getStringValue())) {
				data_name_dse.setStringValue(data.name_dse);
				modifiedRendering.put(NR.fld_NAME_DSE, data_name_dse);
			}
			if (data_sprav_dse != null
					&& !data.sprav_dse.equals(data_sprav_dse.getStringValue())) {
				data_sprav_dse.setStringValue(data.sprav_dse);
				modifiedRendering.put(NR.fld_SPRAV_DSE, data_sprav_dse);
			}
			if (data_first_use != null
					&& !data.first_use.equals(data_first_use.getStringValue())) {
				data_first_use.setStringValue(data.first_use);
				modifiedRendering.put(NR.fld_FIRST_USE, data_first_use);
			}
			if (data_izdelie != null
					&& !data.izdelie.equals(data_izdelie.getStringValue())) {
				data_izdelie.setStringValue(data.izdelie);
				modifiedRendering.put(NR.fld_UOBOZ_IZD, data_izdelie);
			}
			if (data_type_izgot != null
					&& !data.type_izgot
							.equals(data_type_izgot.getStringValue())) {
				data_type_izgot.setStringValue(data.type_izgot);
				modifiedRendering.put(NR.fld_TIPIZGOT, data_type_izgot);
			}
			if (data_vid_pki != null
					&& !data.vid_pki.equals(data_vid_pki.getStringValue())) {
				data_vid_pki.setStringValue(data.vid_pki);
				modifiedRendering.put(NR.fld_VIDPKI, data_vid_pki);
			}
			if (data_code_okp != null
					&& !data.code_okp.equals(data_code_okp.getStringValue())) {
				data_code_okp.setStringValue(data.code_okp);
				modifiedRendering.put(NR.fld_CODEOKP, data_code_okp);
			}
			if (data_doc_postav != null
					&& !data.doc_postav
							.equals(data_doc_postav.getStringValue())) {
				data_doc_postav.setStringValue(data.doc_postav);
				modifiedRendering.put(NR.fld_DOC_POSTAV, data_doc_postav);
			}
			if (data_org_postav != null
					&& !data.org_postav
							.equals(data_org_postav.getStringValue())) {
				data_org_postav.setStringValue(data.org_postav);
				modifiedRendering.put(NR.fld_ORG_POSTAV, data_org_postav);
			}
			if (data_dop_info != null
					&& !data.dop_info.equals(data_dop_info.getStringValue())) {
				data_dop_info.setStringValue(data.dop_info);
				modifiedRendering.put(NR.fld_COMMENT, data_dop_info);
			}
			if (data_print_id != null
					&& data.print_id != data_print_id.getLogicalValue()) {
			data_print_id.setLogicalValue(data.print_id);
			modifiedRendering.put(NR.fld_PRINTID, data_print_id);
			}
			/*if (data_n_protraz != null
					&& !(String)data.n_protraz+","+ LUtil.Date2String(data.date_protocol).equals(data_dop_info.getStringValue())) {
			data_n_protraz.setStringValue(data.n_protraz+","+ LUtil.Date2String(data.date_protocol));
			modifiedRendering.put(NR.fld_N_PROTRAZ, data_n_protraz);
			}*/




		} catch (Exception e) {
			// TODO: handle exception
		}
		return modifiedRendering;
	}

	/*
	 * (non-Javadoc)
	 * Опциональный код
	 * Используется если нужна предзагрузка свойств с оригинальной (выбраной) item revision, иначе поля новой модификации будут незаполнены
	 */
	@Override
	public void setValues(String[] props, Object[] values) {
		if (props != null && props.length > 1) {
			for (int i = 0; i < props.length; i++) {
				if (props[i].equals("")) {
					//dfgdhg.settext(values[i])
				}
			}
		}

	}

	/*
	 * Проверка введенной информации до вызова saveRendering
	@Override
	public void checkObject() throws Exception {

	}
	*/

}