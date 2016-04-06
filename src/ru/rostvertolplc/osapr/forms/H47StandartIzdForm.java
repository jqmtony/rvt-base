package ru.rostvertolplc.osapr.forms;

//import com.teamcenter.rac.form.*;
import com.teamcenter.rac.stylesheet.*;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.kernel.TCException;
import java.awt.BorderLayout;
//import java.awt.Container;
import java.util.Date;

import com.teamcenter.rac.aif.AbstractAIFOperation;
//import com.teamcenter.rac.aif.kernel.AIFComponentContext;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.commands.newitem.*;

//import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
//import javax.swing.SwingUtilities;

import ru.rostvertolplc.osapr.util.LUtil;
import com.teamcenter.rac.kernel.TCComponentItemType;
import com.teamcenter.rac.util.Registry;

public class H47StandartIzdForm extends AbstractRendering {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 555927111218720814L;
	
	
	Registry R = Registry.getRegistry("ru.rostvertolplc.osapr.forms.L-forms");
	NameResolver NR = new NameResolver();

	TCComponentForm form = null;
	TCComponentForm item_form = null;
	TCComponentForm form_rev;
	String sFormType;
	// TCComponent sc = null;
	SmartTCEForm sform = null;
	SmartTCEForm sitem_form = null;
	SmartTCEForm sform_rev = null;
	TCSession session;

	InterfaceFormPanel innerPanel;

	DSEUserData data;

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

	public H47StandartIzdForm(TCComponentForm theForm) throws Exception {
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
					sitem_form = new SmartTCEForm(item_form);
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
		System.out.println("Item load rend") при создании нового прочего передается ревизия надо получить её
		data = new DSEUserData();
		data.NR = NR;
		TCComponent comp = form.getReferenceProperty("item_for_form");

		TCComponent comp2 = this.getComponent();
		System.out.println(comp2.toString());

		if (comp == null) {
			TCComponentItemType tc_item = (TCComponentItemType) session
					.getTypeComponent("Item");
			comp = tc_item.find(form.getProperty("object_name"));
		}
		if ((comp instanceof TCComponentItem) || (comp == null)) {
			data.item = (TCComponentItem) comp;

		}
		if (comp instanceof TCComponentItemRevision) {
			data.item_rev = (TCComponentItemRevision) comp;
			data.item = data.item_rev.getItem();

		}
		sFormType = form.getType();
		// -- Для Прочего основной формой считаем Item Master но надо подчитать
		// массу из Revision --
		form_rev = form;
		if (sFormType.equals(NR.TYPE_Prochee + " Master")) {
			form_rev = (TCComponentForm) data.item_rev
					.getRelatedComponent("IMAN_master_form_rev");
		} else if (sFormType.equals(NR.TYPE_Prochee + " Revision Master")) {
			form = (TCComponentForm) data.item
					.getRelatedComponent("IMAN_master_form");
		}
		data.form = form;
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
		sform = new SmartTCEForm(form);
		sform_rev = new SmartTCEForm(form_rev);

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

			// Считывание комментария для Прочих
			data.comment = data.item.getProperty("object_desc");
			// Разработчик
			data.creator = (String) sform_rev
					.getFormPropertyObj(NR.fld_data2_R);
			// Раздел справочника
			data.material = (String) sform_rev
					.getFormPropertyObj(NR.fld_MATERIAL);
		}

		try {
			// data.code_dse =
			// form.getFormTCProperty(NR.fld_DSE_CODE).getStringValue();
			data.indication = (String) sform.getFormPropertyObj(NR.fld_DSE);
			data.name_dse = (String) sform.getFormPropertyObj(NR.fld_NAME_DSE);
			data.first_use = (String) sform
					.getFormPropertyObj(NR.fld_FIRST_USE);
			data.sprav_dse = (String) sform
					.getFormPropertyObj(NR.fld_SPRAV_DSE);
			data.izdelie = (String) sform.getFormPropertyObj(NR.fld_UOBOZ_IZD);
			data.gost = (String) sform.getFormPropertyObj(NR.fld_GOST);
			// data.otvetstv =
			// (String)sform.getFormPropertyObj(NR.fld_OTVETSTV);
			data.type_doc = (String) sform.getFormPropertyObj(NR.fld_TIP_DOC);
			data.type_izgot = (String) sform
					.getFormPropertyObj(NR.fld_TIPIZGOT);
			data.code_okp = (String) sform.getFormPropertyObj(NR.fld_CODEOKP);
			data.doc_postav = (String) sform
					.getFormPropertyObj(NR.fld_DOC_POSTAV);
			data.org_postav = (String) sform
					.getFormPropertyObj(NR.fld_ORG_POSTAV);
			data.vid_pki = (String) sform.getFormPropertyObj(NR.fld_VIDPKI);
			data.print_id = (Boolean) sform.getFormPropertyObj(NR.fld_PRINTID);
			data.dop_info = (String) sform.getFormPropertyObj(NR.fld_COMMENT);

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
		} catch (TCException ex) // если пользователь прав на создание не имеет
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
}