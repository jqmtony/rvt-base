package ru.rostvertolplc.osapr.forms;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JPanel;

import ru.rostvertolplc.osapr.util.*;
import com.teamcenter.rac.aif.AbstractAIFOperation;
import com.teamcenter.rac.aif.kernel.AIFComponentContext;
//import com.teamcenter.rac.form.AbstractTCForm;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;
import com.teamcenter.rac.stylesheet.*;


public class H48PIRVZRevForm extends AbstractRendering {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6277237364524480941L;

//Registry R = Registry.getRegistry("com.LANIT.forms.L-forms");
  NameResolver NR = new NameResolver(); 
	
  TCComponentForm form = null;
  SmartTCEForm sform = null;
  SmartTCEForm sform_item = null;
 //TCComponent sc = null;
  TCSession session;

  InterfaceFormPanel innerPanel;

  DSEUserData data;
  
  boolean isRrefreshed=false;

  class SaveOperation  extends AbstractAIFOperation
  {
    public void executeOperation() throws Exception
    {
//  try {
	innerPanel.saveToUserData();

//	String itemType=form.getType();
//	if (itemType.equals("������ Revision Master")) innpaneDetalRev.saveToUserData();
//	if (itemType.equals("��. ������� Revision Master")) innpaneSbEdRev.saveToUserData();
//	if (itemType.equals("�������� Revision Master")) innpaneMaterialRev.saveToUserData();
//	if (itemType.equals("�������� Revision Master")) innerPanelDocument.saveToUserData();
//	if (itemType.equals("�������� Revision Master")) innerPanelKompleks.saveToUserData();
//	if (itemType.equals("�������� Revision Master")) innerPanelKomplekt.saveToUserData();
//	if (itemType.equals("������ Revision Master")) innerPanelProchee.saveToUserData();
//	if (itemType.equals("����������� ���. Revision Master")) innerPanelStd_izd.saveToUserData();

	form.lock();

        // Revision
	sform.setFormPropertySafe("HR100", data.diametr);
	sform.setFormPropertySafe(NR.fld_DSE_CODE, data.code_dse);
	sform.setFormPropertySafe(NR.fld_FORMAT, data.format);
	sform.setFormPropertySafe(NR.fld_LITER1, data.liter1);
	sform.setFormPropertySafe(NR.fld_LITER2, data.liter2);
	sform.setFormPropertySafe(NR.fld_LITER3, data.liter3);
	
	sform.setFormPropertySafe(NR.fld_kolListov, data.kolListov);
      /*
        double Massa = data.massa;
        if (data.pr_from_model)
          Massa = Massa==0? -1e-100 : -Massa;
        sform.setFormPropertySafe(NR.fld_MASSA).setDoubleValue(Massa);
      */
     sform.setFormPropertySafe(NR.fld_MASSA, data.massa);
     sform.setFormPropertySafe(NR.fld_frommodel, data.pr_from_model );

     sform.setFormPropertySafe(NR.fld_GROUP, data.cons_group);
     sform.setFormPropertySafe(NR.fld_DATE_IZM, data.change_date);
     sform.setFormPropertySafe(NR.fld_NIZV, data.izv_id);
     //sform.setFormPropertySafe(NR.fld_RODITEL, data.roditel);
     sform.setFormPropertySafe(NR.fld_KIM, data.kim);
     sform.setFormPropertySafe(NR.fld_DENSITY, data.density);
     // -- ����� ������� ������� ������� �� MIL_MAT_SPEC, MIL_MATERIAL ��������
      sform.setFormPropertySafe(NR.fld_MAT_SPEC, data.material);
	sform.setFormPropertySafe(NR.fld_MATERIAL, "");
	sform.setFormPropertySafe(NR.fld_MARKA_MAT, data.mater_mark);
	sform.setFormPropertySafe(NR.fld_ND_MARKA, data.mater_mark_nd);
	sform.setFormPropertySafe(NR.fld_ND_SORT, data.mater_sort_nd);
	sform.setFormPropertySafe(NR.fld_VID_ZAGOT, data.mater_zagot);
      sform.setFormPropertySafe(NR.fld_SHIFRMATER, data.mater_shifr);

      sform.setFormPropertySafe(NR.fld_PO, data.pr_otvetstv);
      sform.setFormPropertySafe(NR.fld_ZAGP, data.pr_zag);
      sform.setFormPropertySafe(NR.fld_ZAG, data.zagot);
      sform.setFormPropertySafe(NR.fld_ORIG, data.orig);
      sform.setFormPropertySafe(NR.fld_CADSYS, data.cad_sys);
      sform.setFormPropertySafe(NR.fld_OTDEL, data.otvetstv);
      sform.setFormPropertySafe(NR.fld_GABARIT, data.gabarit);

// �������
	sform.setFormPropertySafe(NR.fld_CREATOR, data.creator+","+LUtil.Date2String(data.date_create));

	sform.setFormPropertySafe(NR.fld_REVIEWER, data.reviewer+","+LUtil.Date2String(data.date_review));
      sform.setFormPropertySafe(NR.fld_NACHBRIG, data.nach_brig+","+LUtil.Date2String(data.date_nach_brig));
	sform.setFormPropertySafe(NR.fld_TEXCONTROL, data.tcontrol+","+LUtil.Date2String(data.date_tcontrol));
	sform.setFormPropertySafe(NR.fld_NCONTROL, data.ncontrol+","+LUtil.Date2String(data.date_ncontrol));
	sform.setFormPropertySafe(NR.fld_NACHOTD, data.nach_otd+","+LUtil.Date2String(data.date_nach_otd));
	sform.setFormPropertySafe(NR.fld_GENCHECK, data.approver+","+LUtil.Date2String(data.date_approve));
	form.save();
	form.unlock();
/*      }
      catch (TCException ex) {
	//ex.printStackTrace();
	MessageBox.post(ex);
      }*/
    }
  }

  public H48PIRVZRevForm(TCComponentForm theForm) throws Exception
  {
    super(theForm);

    form = theForm;

    session = (TCSession)form.getSession();
    loadRendering();
  }
  public void saveRendering()
  {
    SaveOperation operation = new SaveOperation();
    try {
      session.queueOperation(operation); // � ���� ������ �� �� ����� ����� ����� ��������
    }
    catch (Exception ex) {
      MessageBox.post(ex);
    }
  }

  public void loadRendering() throws TCException
  {
	
    data = new DSEUserData();
    data.sc = form.getReferenceProperty("data_file");

    data.NR = NR;
    TCComponentForm item_form = null;

    data.item_rev = (TCComponentItemRevision)form.getReferenceProperty("item_for_form");
    if (data.item_rev!=null)
    {
      data.revision = data.item_rev.getProperty("item_revision_id");
      data.item = data.item_rev.getItem();
      data.date_create_obj = data.item_rev.getDateProperty("creation_date");
      ///�������, ���� ��������� ������� � ����� ������� ChangeNotice
      //AIFComponentContext[] whereRef=data.item_rev.whereReferenced();
      
      AIFComponentContext[] whereRef=data.item_rev.whereReferencedByTypeRelation(new String[] {"ChangeNoticeRevision"}, new String[] {"CMHasSolutionItem"});

      for (int i=0; i<whereRef.length; i++){
    	
    	  if (whereRef[i].getComponent().getType().equals("ChangeNoticeRevision"))
			try {
				data.changeNotice=whereRef[i].getComponent().getProperty("item_id");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
      }
     
      
    }

    data.form = form;
    sform = new SmartTCEForm(form);

    try{
	  if (data.item!=null)
	  {
	    item_form = (TCComponentForm) data.item.getRelatedComponent("IMAN_master_form");
	    sform_item = new SmartTCEForm(item_form);
	    data.indication = (String)sform_item.getFormPropertyObj(NR.fld_DSE);
	    data.name_dse = (String)sform_item.getFormPropertyObj(NR.fld_NAME_DSE);
	    data.gost = (String)sform_item.getFormPropertyObj(NR.fld_GOST);
	  }

      data.code_dse = (String)sform.getFormPropertyObj(NR.fld_DSE_CODE);
      data.format = (String)sform.getFormPropertyObj(NR.fld_FORMAT);
      data.change_date = (Date)sform.getFormPropertyObj(NR.fld_DATE_IZM);
     
      data.izv_id = (String)sform.getFormPropertyObj(NR.fld_NIZV);
      data.liter1 =(String)sform.getFormPropertyObj(NR.fld_LITER1);
      data.liter2 = (String)sform.getFormPropertyObj(NR.fld_LITER2);
      data.liter3 = (String)sform.getFormPropertyObj(NR.fld_LITER3);
      data.kolListov=(String)sform.getFormPropertyObj(NR.fld_kolListov);
      data.diametr=(String)sform.getFormPropertyObj("HR100");

      /*
        double Massa = sform.getFormPropertyObj(NR.fld_MASSA).getDoubleValue();
        if (Massa<0)
        {
          Massa = data.getMassFromModel();
          data.pr_from_model = true;
        }
       data.massa = Massa;
       */
      data.pr_from_model = (Boolean)sform.getFormPropertyObj(NR.fld_frommodel);
      data.massa = data.pr_from_model ?
        data.getMassFromModel() : (Double)sform.getFormPropertyObj(NR.fld_MASSA);

      data.cons_group = (String)sform.getFormPropertyObj(NR.fld_GROUP);
	//data.roditel = sform.getFormPropertyObj(NR.fld_RODITEL).getStringValue();
	//data.trud = sform.getFormPropertyObj(NR.fld_TRUD).getStringValue();
	data.kim = (Double)sform.getFormPropertyObj(NR.fld_KIM);
      data.density = (Double)sform.getFormPropertyObj(NR.fld_DENSITY);
      // -- ����� ������� ������� ������� �� MIL_MAT_SPEC
      data.material = (String)sform.getFormPropertyObj(NR.fld_MAT_SPEC);
      if (data.material.length()==0)
        data.material = (String)sform.getFormPropertyObj(NR.fld_MATERIAL);
	data.mater_mark = (String)sform.getFormPropertyObj(NR.fld_MARKA_MAT);
	data.mater_mark_nd = (String)sform.getFormPropertyObj(NR.fld_ND_MARKA);
	data.mater_sort_nd = (String)sform.getFormPropertyObj(NR.fld_ND_SORT);
	data.mater_zagot = (String)sform.getFormPropertyObj(NR.fld_VID_ZAGOT);
      data.mater_shifr = (String)sform.getFormPropertyObj(NR.fld_SHIFRMATER);

      data.pr_otvetstv = (Boolean)sform.getFormPropertyObj(NR.fld_PO);
      data.pr_zag = (Boolean)sform.getFormPropertyObj(NR.fld_ZAGP);
      data.zagot = (String)sform.getFormPropertyObj(NR.fld_ZAG);
      data.orig = (String)sform.getFormPropertyObj(NR.fld_ORIG);
      data.cad_sys = (String)sform.getFormPropertyObj(NR.fld_CADSYS);
      data.otvetstv = (String)sform.getFormPropertyObj(NR.fld_OTDEL);
      data.gabarit = (String)sform.getFormPropertyObj(NR.fld_GABARIT);

	String strArray[];
	strArray = LUtil.parse2Array((String)sform.getFormPropertyObj(NR.fld_CREATOR));
	data.creator = strArray[0];
	data.date_create = LUtil.String2Date(strArray[1]);

	strArray = LUtil.parse2Array((String)sform.getFormPropertyObj(NR.fld_REVIEWER));
	data.reviewer = strArray[0];
	data.date_review = LUtil.String2Date(strArray[1]);
      strArray = LUtil.parse2Array((String)sform.getFormPropertyObj(NR.fld_NACHBRIG));
      data.nach_brig = strArray[0];
      data.date_nach_brig = LUtil.String2Date(strArray[1]);
	strArray = LUtil.parse2Array((String)sform.getFormPropertyObj(NR.fld_TEXCONTROL));
	data.tcontrol = strArray[0];
	data.date_tcontrol = LUtil.String2Date(strArray[1]);
	strArray = LUtil.parse2Array((String)sform.getFormPropertyObj(NR.fld_NCONTROL));
	data.ncontrol = strArray[0];
	data.date_ncontrol = LUtil.String2Date(strArray[1]);
	strArray = LUtil.parse2Array((String)sform.getFormPropertyObj(NR.fld_NACHOTD));
	data.nach_otd = strArray[0];
	data.date_nach_otd = LUtil.String2Date(strArray[1]);
	strArray = LUtil.parse2Array((String)sform.getFormPropertyObj(NR.fld_GENCHECK));
	data.approver = strArray[0];
	data.date_approve = LUtil.String2Date(strArray[1]);
      /*
//	data.viza = sc.getTCProperty("avid_VIZA").getStringValueArray();
      */
      // ������ ��������
      data.lov_liter = LUtil.getLOVStrings(NR.lov_LITERA, session);
      // ������
      data.lov_format = LUtil.getLOVStrings(NR.lov_FORMAT);
      // ������������
      data.lov_person = LUtil.getLOVStrings("User Names");
      // �������������� ������
      //data.lov_consgroup = LUtil.getLOVStrings(NR.fld_LOV_CONSGROUP");
      // ������� CAD-�������
      //data.lov_cad_sys = LUtil.getLOVStrings(NR.fld_LOV_CADSYS");
      // ����������
      //data.lov_cexa = LUtil.getLOVStrings("MMP_LOV_CEX");
    }
    catch (TCException ex) // ���� ������������ ���� �� �������� �� ����� ������ �� �������
    {
      ex.printStackTrace();
      MessageBox.post(ex);
    }
    setLayout(new BorderLayout());
    // -- ����� ������� �� ����� --
    String sFormType = form.getType();

    if (sFormType.equals(NR.TYPE_Detal+" Revision Master"))
    {
      innerPanel = new DetalRevPanel(data);
      //innerPanel.setHeader("������ - �����������");
    }
    else if (sFormType.equals(NR.TYPE_SE+" Revision Master"))
    {
      innerPanel = new SbEdRevPanel(data);
      //innerPanel.setHeader("�� - �����������");
    }
    else if (sFormType.equals(NR.TYPE_StdIzd+" Revision Master"))
//    || sFormType.equals("���.�����. Revision Master"))
    {
      //innerPanel = innpaneSbEdRev = new SbEdRevPanel(data);
      //innpaneSbEdRev.LHeader.setText("����������� ������� - �����������");
      innerPanel = new StdRevPanel(data);
    }
    else if (sFormType.equals(NR.TYPE_Complect+" Revision Master"))
    {
      innerPanel = new DocRevPanel(data);
      //innerPanel.setHeader("�������� - �����������");
    }
    else if (sFormType.equals(NR.TYPE_Document+" Revision Master"))
    {
      innerPanel = new DocRevPanel(data);
      //innerPanel.setHeader("�������� ��������������� - �����������");
    }
/*    
    else if (sFormType.equals("���.����. Revision Master"))
    {
      innerPanel = new DetalRevPanel(data);
      //innerPanel.setHeader("��������������� ������ - �����������");
    }
    else if (sFormType.equals("�� ����. Revision Master"))
    {
      innerPanel = new SbEdRevPanel(data);
      //innerPanel.setHeader("��������������� ��. ������� - �����������");
    }
    else if (sFormType.equals("�������� Revision Master"))
    {
      innerPanel = new ComplexRevPanel(data);
      //innerPanel.setHeader("�������� - �����������");
    }
    else if (sFormType.equals("���. ���� Revision Master"))
    {
      innerPanel = new SbEdRevPanel(data);
      innerPanel.setHeader("��������������� ���� - �����������");
    }
*/
    innerPanel.setHeader("���������� �� �������");
    // -- ����� ������� �� ����� --
    add((JPanel)innerPanel, BorderLayout.CENTER);
 }
}
