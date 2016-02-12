package ru.rostvertolplc.osapr.forms;

import java.awt.BorderLayout;

import com.teamcenter.rac.aif.AbstractAIFOperation;
import com.teamcenter.rac.form.AbstractTCForm;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.stylesheet.AbstractRendering;
import com.teamcenter.rac.util.MessageBox;
import java.util.Hashtable;
import java.util.Map;

import com.teamcenter.rac.util.Registry;


public class MaterialForm extends AbstractRendering
{
  /**
	 * 
	 */
  private static final long serialVersionUID = 4666357845053416560L;

  //Registry R = Registry.getRegistry("com.LANIT.forms.L-forms");
  NameResolver NR = new NameResolver(); 
	
  TCComponentForm form = null;
  TCComponentForm item_form = null;
  SmartTCEForm sform = null;

  TCSession session;

  MaterialItemPanel innpaneMaterial;
  //MaterialRevPanel  innpaneMaterialRev;

  DSEUserData data;

  class SaveOperation  extends AbstractAIFOperation
  {
    public void executeOperation() throws Exception
    {
      try {
        innpaneMaterial.saveToUserData();

//	String sFormType=form.getType();
//	if (sFormType.equals("Деталь Master")) innpaneDetal.saveToUserData();
//        if (sFormType.equals("Материал Master")) innpaneMaterial.saveToUserData();

      item_form.lock();
	sform.setFormPropertySafe( NR.fld_DSE_CODE, data.code_dse);
	sform.setFormPropertySafe( NR.fld_NAME_DSE, data.material);
	sform.setFormPropertySafe( NR.fld_M_MARKA_MAT, data.mater_mark);
	sform.setFormPropertySafe( NR.fld_M_ND_MARKA, data.mater_mark_nd);
	sform.setFormPropertySafe( NR.fld_M_ND_SORT, data.mater_sort_nd);
	sform.setFormPropertySafe( NR.fld_M_VID_ZAGOT, data.mater_zagot);
	sform.setFormPropertySafe( NR.fld_M_GABARIT, data.gabarit);
	sform.setFormPropertySafe( NR.fld_DSE_ID, data.vid_obrab);
	sform.setFormPropertySafe( NR.fld_M_MASSA, new Double(data.density));
    sform.setFormPropertySafe( NR.fld_SB, DSEUserData.getItemTypeCode(NR.TYPE_Material));

    item_form.getFormTCProperty( NR.fld_M_frommodel).setLogicalValue(data.pr_from_model);
    item_form.save();
    item_form.unlock();

    form.lock();
      // масса хранится в item revision form
    saveMassa();
	form.save();
	form.unlock();
      }
      catch (TCException ex) {
	ex.printStackTrace();
	MessageBox.post(ex);
      }
    }
  }

  public MaterialForm(TCComponentForm theForm) throws Exception
  {
    super(theForm);
    form = theForm;
    session = (TCSession)form.getSession();

    data = new DSEUserData();
    data.NR = NR;
    TCComponent comp = form.getReferenceProperty("item_for_form");
    if (comp instanceof TCComponentItem)
      data.item = (TCComponentItem)comp;
    if (comp instanceof TCComponentItemRevision)
    {
      data.item_rev = (TCComponentItemRevision) comp;
      data.item = data.item_rev.getItem();
    }
    item_form = (TCComponentForm)data.item.getRelatedComponent("IMAN_master_form");

    //sform = new SmartTCEForm(form);
    sform = new SmartTCEForm(item_form);  // храним все общие данные в карточке ITEM

    loadRendering();
  }

  void saveMassa() throws TCException
  {
    double Massa = data.massa;
    /*
    if (data.pr_from_model)
      Massa = Massa==0? -1e-100 : -Massa;
    */
    form.getFormTCProperty(NR.fld_M_frommodel).setLogicalValue(data.pr_from_model);
    form.getFormTCProperty(NR.fld_M_MASSA).setDoubleValue(Massa);
  }

  public void saveRendering()
  {
    boolean bDontChange = data.code_dse != null && data.code_dse.length() != 0;

    innpaneMaterial.saveToUserData();

    try
    {
      if (bDontChange)
      {
        item_form.lock();
        sform.setFormPropertySafe( NR.fld_M_GABARIT, data.gabarit);
        sform.setFormPropertySafe( NR.fld_M_MASSA, new Double(data.density));
        item_form.save();
        item_form.unlock();

        form.lock();
        saveMassa();
        form.save();
        form.unlock();

      //  MessageBox.post("Изменена только Масса, Плотность и Габариты, т.к. прочие параметры заполняются единожды и \n"+
       //                 "должны строго соответствовать материалу IMBASE с заданным шифром!",
      //                  data.material, MessageBox.WARNING);
      }
      else
      {
        SaveOperation operation = new SaveOperation();
        session.queueOperation(operation); // в этом случае мы не будем ждать конца операции
      }
    }
    catch (Exception ex)
    {
      MessageBox.post(ex);
    }
  }

  public void loadRendering() throws TCException
  {
    try{
      if (!fillDataIfClassified(data, data.item))
      {
        //data.name_dse = sc.getTCProperty("name_dse").getStringValue();
        //data.code_dse = form.getFormTCProperty( cstDSE_CODE ).getStringValue();
        data.code_dse = (String) sform.getFormPropertyObj(NR.fld_DSE_CODE);
        data.material = (String) sform.getFormPropertyObj(NR.fld_NAME_DSE);
        data.mater_mark = (String) sform.getFormPropertyObj(NR.fld_M_MARKA_MAT);
        data.mater_mark_nd = (String) sform.getFormPropertyObj(NR.fld_M_ND_MARKA);
        data.mater_sort_nd = (String) sform.getFormPropertyObj(NR.fld_M_ND_SORT);
        data.mater_zagot = (String) sform.getFormPropertyObj(NR.fld_M_VID_ZAGOT);
        data.gabarit = (String) sform.getFormPropertyObj(NR.fld_M_GABARIT);
        data.vid_obrab = (String) sform.getFormPropertyObj(NR.fld_DSE_ID);
        data.density = ( (Double) sform.getFormPropertyObj(NR.fld_M_MASSA)).doubleValue();

        data.pr_from_model = form.getFormTCProperty(NR.fld_M_frommodel).getLogicalValue();
        data.massa = data.pr_from_model ?
          data.getMassFromModel() : form.getFormTCProperty(NR.fld_M_MASSA).getDoubleValue();
      }
    }
    catch (TCException ex) // если пользователь прав на создание не имеет ничего не создаем
    {
      ex.printStackTrace();
      MessageBox.post(ex);
    }
    setLayout(new BorderLayout());

    innpaneMaterial = new MaterialItemPanel(data);
    add(innpaneMaterial, BorderLayout.CENTER);
 }

 static boolean fillDataIfClassified(DSEUserData data, TCComponentItem item)
 {
   boolean Result = false;
   Registry R = Registry.getRegistry("com.LANIT.forms.L-forms");
   try
   {
 
     Map attrs;
     Result = (item.getProperty("ics_classified").equals("YES"));
     if (Result)
     {
       attrs = item.getClassificationAttributes();
       data.material = (String) attrs.get(R.getString("MATERIAL.material"));
       data.mater_mark = (String) attrs.get(R.getString("MATERIAL.mater_mark"));
       data.mater_mark_nd = (String) attrs.get(R.getString("MATERIAL.mater_mark_nd"));
       data.mater_sort_nd = (String) attrs.get(R.getString("MATERIAL.mater_sort_nd"));
       data.mater_zagot = (String) attrs.get(R.getString("MATERIAL.mater_zagot"));
     }
   }
   catch (TCException ex)
   { }

   return Result;
 }
}
