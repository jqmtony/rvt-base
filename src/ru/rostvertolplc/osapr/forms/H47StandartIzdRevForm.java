package ru.rostvertolplc.osapr.forms;

//public class H47StandartIzdRevForm
import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import ru.rostvertolplc.osapr.util.LUtil;
import com.teamcenter.rac.aif.AbstractAIFOperation;
import com.teamcenter.rac.aif.kernel.AIFComponentContext;
import com.teamcenter.rac.commands.newitem.ItemMasterFormPanel;
import com.teamcenter.rac.commands.newitem.ItemRevMasterFormPanel;
import com.teamcenter.rac.commands.newitem.NewItemPanel; //import com.teamcenter.rac.form.AbstractTCForm;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;
import com.teamcenter.rac.stylesheet.*;

public class H47StandartIzdRevForm extends AbstractRendering {

	private static final long serialVersionUID = 4714852363863048902L;

	// Registry R = Registry.getRegistry("com.LANIT.forms.L-forms");
	NameResolver NR = new NameResolver();

	TCComponentForm form = null;
	SmartTCEForm sform = null;
	SmartTCEForm sform_item = null;

	// добавил Стеценко, нужно при оздании нового объекта
	TCComponentForm rev_form = null;
	SmartTCEForm sform_rev = null;
	// ---

	// TCComponent sc = null;
	TCSession session;

	InterfaceFormPanel innerPanel;

	DSEUserData data;

	boolean isRrefreshed = false;

	class SaveOperation extends AbstractAIFOperation {

		protected void doSave(TCComponentForm form1, SmartTCEForm sform1)
				throws Exception {
			form1.lock();
			// Revision
			sform1.setFormPropertySafe("HR100", data.diametr);
			sform1.setFormPropertySafe(NR.fld_DSE_CODE, data.code_dse);
			sform1.setFormPropertySafe(NR.fld_FORMAT, data.format);
			sform1.setFormPropertySafe(NR.fld_LITER1, data.liter1);
			sform1.setFormPropertySafe(NR.fld_LITER2, data.liter2);
			sform1.setFormPropertySafe(NR.fld_LITER3, data.liter3);
			sform1.setFormPropertySafe(NR.fld_kolListov, data.kolListov);
			/*
			 * double Massa = data.massa; if (data.pr_from_model) Massa =
			 * Massa==0? -1e-100 : -Massa;
			 * sform.setFormPropertySafe(NR.fld_MASSA).setDoubleValue(Massa);
			 */
			sform1.setFormPropertySafe(NR.fld_MASSA, data.massa);
			sform1.setFormPropertySafe(NR.fld_frommodel, data.pr_from_model);
			sform1.setFormPropertySafe(NR.fld_GROUP, data.cons_group);
			sform1.setFormPropertySafe(NR.fld_DATE_IZM, data.change_date);
			sform1.setFormPropertySafe(NR.fld_NIZV, data.izv_id);
			// sform.setFormPropertySafe(NR.fld_RODITEL, data.roditel);
			sform1.setFormPropertySafe(NR.fld_KIM, data.kim);
			sform1.setFormPropertySafe(NR.fld_DENSITY, data.density);
			// -- Здесь сделать плавный переход на MIL_MAT_SPEC, MIL_MATERIAL
			// зануляем
			sform1.setFormPropertySafe(NR.fld_MAT_SPEC, data.material);
			sform1.setFormPropertySafe(NR.fld_MATERIAL, "");
			sform1.setFormPropertySafe(NR.fld_MARKA_MAT, data.mater_mark);
			sform1.setFormPropertySafe(NR.fld_ND_MARKA, data.mater_mark_nd);
			sform1.setFormPropertySafe(NR.fld_ND_SORT, data.mater_sort_nd);
			sform1.setFormPropertySafe(NR.fld_VID_ZAGOT, data.mater_zagot);
			sform1.setFormPropertySafe(NR.fld_SHIFRMATER, data.mater_shifr);

			sform1.setFormPropertySafe(NR.fld_PO, data.pr_otvetstv);
			sform1.setFormPropertySafe(NR.fld_ZAGP, data.pr_zag);
			sform1.setFormPropertySafe(NR.fld_ZAG, data.zagot);
			sform1.setFormPropertySafe(NR.fld_ORIG, data.orig);
			sform1.setFormPropertySafe(NR.fld_CADSYS, data.cad_sys);
			sform1.setFormPropertySafe(NR.fld_OTDEL, data.otvetstv);
			sform1.setFormPropertySafe(NR.fld_GABARIT, data.gabarit);

			// Подписи
			sform1.setFormPropertySafe(NR.fld_CREATOR, data.creator + ","
					+ LUtil.Date2String(data.date_create));

			sform1.setFormPropertySafe(NR.fld_REVIEWER, data.reviewer + ","
					+ LUtil.Date2String(data.date_review));
			sform1.setFormPropertySafe(NR.fld_NACHBRIG, data.nach_brig + ","
					+ LUtil.Date2String(data.date_nach_brig));
			sform1.setFormPropertySafe(NR.fld_TEXCONTROL, data.tcontrol + ","
					+ LUtil.Date2String(data.date_tcontrol));
			sform1.setFormPropertySafe(NR.fld_NCONTROL, data.ncontrol + ","
					+ LUtil.Date2String(data.date_ncontrol));
			sform1.setFormPropertySafe(NR.fld_NACHOTD, data.nach_otd + ","
					+ LUtil.Date2String(data.date_nach_otd));
			sform1.setFormPropertySafe(NR.fld_GENCHECK, data.approver + ","
					+ LUtil.Date2String(data.date_approve));
			form1.save();
			form1.unlock();
		}

		public void executeOperation() throws Exception {
			// try {
			innerPanel.saveToUserData();

			// String itemType=form.getType();
			// if (itemType.equals("Деталь Revision Master"))
			// innpaneDetalRev.saveToUserData();
			// if (itemType.equals("Сб. единица Revision Master"))
			// innpaneSbEdRev.saveToUserData();
			// if (itemType.equals("Материал Revision Master"))
			// innpaneMaterialRev.saveToUserData();
			// if (itemType.equals("Документ Revision Master"))
			// innerPanelDocument.saveToUserData();
			// if (itemType.equals("Комплекс Revision Master"))
			// innerPanelKompleks.saveToUserData();
			// if (itemType.equals("Комплект Revision Master"))
			// innerPanelKomplekt.saveToUserData();
			// if (itemType.equals("Прочее Revision Master"))
			// innerPanelProchee.saveToUserData();
			// if (itemType.equals("Стандартное изд. Revision Master"))
			// innerPanelStd_izd.saveToUserData();

			// добавлено Стеценко, нужно для варианта создания нового объекта
			if (sform_rev == null) {
				// открывается для просмотра существующая уже ревизия
				doSave(form, sform);
			} else {
				// создается новая ревизия для нового объекта
				doSave(rev_form, sform_rev);
			}

			/*
			 * } catch (TCException ex) { //ex.printStackTrace();
			 * MessageBox.post(ex); }
			 */
		}
	}

	public H47StandartIzdRevForm(TCComponentForm theForm) throws Exception {
		super(theForm);

		form = theForm;

		session = (TCSession) form.getSession();
		loadRendering();
	}

	public void saveRendering() {

		// добавлено Стеценко, если создается новый объет то item надо брать из
		// формы визарда создания нового объекта
		if (data.item_rev == null) {
			JPanel parentPanel = (JPanel) ((JPanel) this).getParent();
			JViewport enclosing = (JViewport) parentPanel.getParent();
			JScrollPane scrolpan1 = (JScrollPane) enclosing.getParent();
			ItemRevMasterFormPanel irmfp1 = (ItemRevMasterFormPanel) scrolpan1
					.getParent();
			// TCComponentForm s_rev_form =
			// (TCComponentForm)irmfp1.itemRevMasterForm;
			NewItemPanel itemPanel1 = (NewItemPanel) irmfp1.controlWizardPanel;
			data.item = (TCComponentItem) itemPanel1.newComponent;
			// если null то новая модификация, берем форму из текущего компонента
			if (data.item == null) {
				rev_form = (TCComponentForm) this.component;
				sform_rev = new SmartTCEForm(rev_form);
				
			} else {
				try {
					data.item_rev = data.item.getLatestItemRevision();
				} catch (Exception e) {
					// TODO: Обработчик отстутствия item
				}
				/*
				 * System.out.println(parentPanel.toString()+" | "+
				 * enclosing.toString()+ " | " +scrolpan1.toString()+ " | " +
				 * irmfp1.toString() + " | " + itemPanel1.toString());
				 */
				if (data.item_rev != null) {
					try {
						rev_form = (TCComponentForm) data.item_rev
								.getRelatedComponent("IMAN_master_form_rev");
						sform_rev = new SmartTCEForm(rev_form);
					} catch (TCException e) {
						e.printStackTrace();
					}
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

		data = new DSEUserData();
		// добавил Стеценко, так как при создании новобого объекта связи не
		// будет, фактически объекта ещё нет в базе
		try {
			data.sc = form.getReferenceProperty("data_file");
		} catch (Exception e) {
			// TODO: handle exception
		}

		data.NR = NR;
		TCComponentForm item_form = null;

		data.item_rev = (TCComponentItemRevision) form
				.getReferenceProperty("item_for_form");

		if (data.item_rev != null) {
			data.revision = data.item_rev.getProperty("item_revision_id");
			data.item = data.item_rev.getItem();
			data.date_create_obj = data.item_rev
					.getDateProperty("creation_date");
			// /находим, куда ссылается ревизия и потом находим ChangeNotice
			// AIFComponentContext[] whereRef=data.item_rev.whereReferenced();

			AIFComponentContext[] whereRef = data.item_rev
					.whereReferencedByTypeRelation(
							new String[] { "ChangeNoticeRevision" },
							new String[] { "CMHasSolutionItem" });

			for (int i = 0; i < whereRef.length; i++) {

				if (whereRef[i].getComponent().getType().equals(
						"ChangeNoticeRevision"))
					try {
						data.changeNotice = whereRef[i].getComponent()
								.getProperty("item_id");

					} catch (Exception e) {
						e.printStackTrace();
					}
			}

		}

		data.form = form;
		sform = new SmartTCEForm(form);

		try {
			if (data.item != null) {
				item_form = (TCComponentForm) data.item
						.getRelatedComponent("IMAN_master_form");
				sform_item = new SmartTCEForm(item_form);
				data.indication = (String) sform_item
						.getFormPropertyObj(NR.fld_DSE);
				data.name_dse = (String) sform_item
						.getFormPropertyObj(NR.fld_NAME_DSE);
				data.gost = (String) sform_item.getFormPropertyObj(NR.fld_GOST);
			}

			data.code_dse = (String) sform.getFormPropertyObj(NR.fld_DSE_CODE);
			data.format = (String) sform.getFormPropertyObj(NR.fld_FORMAT);
			data.change_date = (Date) sform.getFormPropertyObj(NR.fld_DATE_IZM);

			data.izv_id = (String) sform.getFormPropertyObj(NR.fld_NIZV);
			data.liter1 = (String) sform.getFormPropertyObj(NR.fld_LITER1);
			data.liter2 = (String) sform.getFormPropertyObj(NR.fld_LITER2);
			data.liter3 = (String) sform.getFormPropertyObj(NR.fld_LITER3);
			data.kolListov = (String) sform
					.getFormPropertyObj(NR.fld_kolListov);
			data.diametr = (String) sform.getFormPropertyObj("HR100");

			/*
			 * double Massa =
			 * sform.getFormPropertyObj(NR.fld_MASSA).getDoubleValue(); if
			 * (Massa<0) { Massa = data.getMassFromModel(); data.pr_from_model =
			 * true; } data.massa = Massa;
			 */
			data.pr_from_model = (Boolean) sform
					.getFormPropertyObj(NR.fld_frommodel);
			data.massa = data.pr_from_model ? data.getMassFromModel()
					: (Double) sform.getFormPropertyObj(NR.fld_MASSA);

			data.cons_group = (String) sform.getFormPropertyObj(NR.fld_GROUP);
			// data.roditel =
			// sform.getFormPropertyObj(NR.fld_RODITEL).getStringValue();
			// data.trud =
			// sform.getFormPropertyObj(NR.fld_TRUD).getStringValue();
			data.kim = (Double) sform.getFormPropertyObj(NR.fld_KIM);
			data.density = (Double) sform.getFormPropertyObj(NR.fld_DENSITY);
			// -- Здесь сделать плавный переход на MIL_MAT_SPEC
			data.material = (String) sform.getFormPropertyObj(NR.fld_MAT_SPEC);
			if (data.material.length() == 0)
				data.material = (String) sform
						.getFormPropertyObj(NR.fld_MATERIAL);
			data.mater_mark = (String) sform
					.getFormPropertyObj(NR.fld_MARKA_MAT);
			data.mater_mark_nd = (String) sform
					.getFormPropertyObj(NR.fld_ND_MARKA);
			data.mater_sort_nd = (String) sform
					.getFormPropertyObj(NR.fld_ND_SORT);
			data.mater_zagot = (String) sform
					.getFormPropertyObj(NR.fld_VID_ZAGOT);
			data.mater_shifr = (String) sform
					.getFormPropertyObj(NR.fld_SHIFRMATER);

			data.pr_otvetstv = (Boolean) sform.getFormPropertyObj(NR.fld_PO);
			data.pr_zag = (Boolean) sform.getFormPropertyObj(NR.fld_ZAGP);
			data.zagot = (String) sform.getFormPropertyObj(NR.fld_ZAG);
			data.orig = (String) sform.getFormPropertyObj(NR.fld_ORIG);
			data.cad_sys = (String) sform.getFormPropertyObj(NR.fld_CADSYS);
			data.otvetstv = (String) sform.getFormPropertyObj(NR.fld_OTDEL);
			data.gabarit = (String) sform.getFormPropertyObj(NR.fld_GABARIT);

			String strArray[];
			strArray = LUtil.parse2Array((String) sform
					.getFormPropertyObj(NR.fld_CREATOR));
			data.creator = strArray[0];
			data.date_create = LUtil.String2Date(strArray[1]);

			strArray = LUtil.parse2Array((String) sform
					.getFormPropertyObj(NR.fld_REVIEWER));
			data.reviewer = strArray[0];
			data.date_review = LUtil.String2Date(strArray[1]);
			strArray = LUtil.parse2Array((String) sform
					.getFormPropertyObj(NR.fld_NACHBRIG));
			data.nach_brig = strArray[0];
			data.date_nach_brig = LUtil.String2Date(strArray[1]);
			strArray = LUtil.parse2Array((String) sform
					.getFormPropertyObj(NR.fld_TEXCONTROL));
			data.tcontrol = strArray[0];
			data.date_tcontrol = LUtil.String2Date(strArray[1]);
			strArray = LUtil.parse2Array((String) sform
					.getFormPropertyObj(NR.fld_NCONTROL));
			data.ncontrol = strArray[0];
			data.date_ncontrol = LUtil.String2Date(strArray[1]);
			strArray = LUtil.parse2Array((String) sform
					.getFormPropertyObj(NR.fld_NACHOTD));
			data.nach_otd = strArray[0];
			data.date_nach_otd = LUtil.String2Date(strArray[1]);
			strArray = LUtil.parse2Array((String) sform
					.getFormPropertyObj(NR.fld_GENCHECK));
			data.approver = strArray[0];
			data.date_approve = LUtil.String2Date(strArray[1]);
			/*
			 * // data.viza =
			 * sc.getTCProperty("avid_VIZA").getStringValueArray();
			 */
			// Списки значений
			data.lov_liter = LUtil.getLOVStrings(NR.lov_LITERA, session);
			// Формат
			data.lov_format = LUtil.getLOVStrings(NR.lov_FORMAT);
			// Пользовалели
			data.lov_person = LUtil.getLOVStrings("User Names");
			// Конструктивная группа
			// data.lov_consgroup = LUtil.getLOVStrings(NR.fld_LOV_CONSGROUP");
			// Базовая CAD-система
			// data.lov_cad_sys = LUtil.getLOVStrings(NR.fld_LOV_CADSYS");
			// Расцеховка
			// data.lov_cexa = LUtil.getLOVStrings("MMP_LOV_CEX");
		} catch (TCException ex) // если пользователь прав на создание не имеет
									// ничего не создаем
		{
			ex.printStackTrace();
			MessageBox.post(ex);
		}
		setLayout(new BorderLayout());
		// -- выбор панелей по типам --
		String sFormType = form.getType();

		if (sFormType.equals(NR.TYPE_Detal + " Revision Master")) {
			innerPanel = new DetalRevPanel(data);
			// innerPanel.setHeader("Деталь - Модификация");
		} else if (sFormType.equals(NR.TYPE_SE + " Revision Master")) {
			innerPanel = new SbEdRevPanel(data);
			// innerPanel.setHeader("СЕ - Модификация");
		} else if (sFormType.equals(NR.TYPE_StdIzd + " Revision Master"))
		// || sFormType.equals("Дет.Станд. Revision Master"))
		{
			// innerPanel = innpaneSbEdRev = new SbEdRevPanel(data);
			// innpaneSbEdRev.LHeader.setText("Стандартное изделие - Модификация");
			innerPanel = new StdRevPanel(data);
		} else if (sFormType.equals(NR.TYPE_Complect + " Revision Master")) {
			innerPanel = new DocRevPanel(data);
			// innerPanel.setHeader("Комплект - Модификация");
		} else if (sFormType.equals(NR.TYPE_Document + " Revision Master")) {
			innerPanel = new DocRevPanel(data);
			// innerPanel.setHeader("Документ Конструкторский - Модификация");
		}
		/*
		 * else if (sFormType.equals("Дет.Норм. Revision Master")) { innerPanel
		 * = new DetalRevPanel(data);
		 * //innerPanel.setHeader("Нормализованная Деталь - Модификация"); }
		 * else if (sFormType.equals("СЕ Норм. Revision Master")) { innerPanel =
		 * new SbEdRevPanel(data);
		 * //innerPanel.setHeader("Нормализованная Сб. единица - Модификация");
		 * } else if (sFormType.equals("Комплекс Revision Master")) { innerPanel
		 * = new ComplexRevPanel(data);
		 * //innerPanel.setHeader("Комплекс - Модификация"); } else if
		 * (sFormType.equals("Тех. узел Revision Master")) { innerPanel = new
		 * SbEdRevPanel(data);
		 * innerPanel.setHeader("Технологический узел - Модификация"); }
		 */
		innerPanel.setHeader("Информация об изделии");
		// -- выбор панелей по типам --
		add((JPanel) innerPanel, BorderLayout.CENTER);
	}
}
