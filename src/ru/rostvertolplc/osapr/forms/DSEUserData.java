package ru.rostvertolplc.osapr.forms;

import java.util.Date;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCComponentDataset;
import com.teamcenter.rac.util.Registry;
import com.teamcenter.rac.kernel.TCSession;

public class DSEUserData
{
  public DSEUserData() {}
  public DSEUserData(TCSession theSession)
  { session = theSession; }

  public TCSession session = null;
  TCComponentItem item = null;
  TCComponentItemRevision item_rev = null;
  TCComponentForm form = null;
  boolean bNewID=false, bNewName=false;
  TCComponent sc = null;  // storage class
  NameResolver NR = null;
  
  // Item
  String indication = "";
  String code_dse  = "";
  String first_use  = "";
  String trud  = "";
  String otvetstv  = "";
  public String code_okp  = "";
  String doc_postav  = "";
  String org_postav  = "";
  String comment = "";
  String dop_info = "";
  String n_protraz  = "";
  Date date_protocol = null;
  boolean print_id = true;


  // Revision
  String revision = "";
  String name_dse  = "";
  String format    = "";
  Date change_date = null;
  Date date_vnedr = null;
  String izv_id = "";
  String author = "";
  String liter1 = "";
  String liter2 = "";
  String liter3 = "";
  double massa = 0;
  public double density = 0;
  double kim  = 0;
  String roditel = "";
  public String material  = "";
  public String mater_name  = "";
  public String mater_mark  = "";
  public String mater_mark_nd  = "";
  public String mater_sort_nd  = "";
  public String mater_zagot  = "";
  public String mater_shifr  = "";
  String vid_obrab  = "";
  String vid_post  = "";
  //int pages  = 0;
  String rascex  = "";
  String vid_pki  = "";
  String izdelie  = "";
  String type_izgot = "";
  String kolListov = "";
  String changeNotice = "";

  boolean pr_otvetstv = false;
  boolean pr_zag = false;
  boolean pr_from_model = true;
  String zagot = "";
  String orig = "";
  String sprav_dse = "";

  String type_doc = "";
  String gost = "";
  String cons_group = "";
  String cad_sys = "";
  String gabarit = "";
/*
    boolean vr10  = false;
    String vr10_note   = "";
  String vr10_tex_pas   = "";
  String vr7_sod_mark  = "";
  String vr7_spo_nanes  = "";
  String vr7_mesto  = "";
  String vr6_vid   = "";
  String vr6_note  = "";

  boolean vr3_s   = false;
  boolean vr3_p   = false;
  String vr3_note   = "";
  boolean vr18   = false;
  String vr18_note   = "";
 */

  Date date_create_obj = null;
  String creator   = "";
  Date date_create = null;
  String reviewer  = "";
  Date date_review = null;
  String nach_brig  = "";
  Date date_nach_brig = null;
  String tcontrol  = "";
  Date date_tcontrol = null;
  String ncontrol  = "";
  Date date_ncontrol = null;
  String nach_otd  = "";
  Date date_nach_otd = null;
  String approver  = "";
  Date date_approve = null;
  String viza[]  = {};

  //info katr
 // String tr_vname = "";
  //String norm_stage_tr[] = {};

  // LOV
  //String[] lov_otvetstv =null;
  String[] lov_doctype =null;
  //String[] lov_consgroup =null;
  String[] lov_liter =null;
  String[] lov_control =null;
  String[] lov_sposobmark =null;
  String[] lov_sodermark =null;
  String[] lov_format =null;
  String[] lov_person =null;
  String[] lov_cexa =null;
  String[] lov_pki =null;
  String[] lov_izdelie =null;
  String[] saTypeIzgot = {"","Собственное","Покупное"};
  String diametr = "";

  double getMassFromModel()
  {

    // -- Определить массу из модели (именованная ссылка UGPART-MASSPR) --
    double Result = 0;
    try
    {
      TCComponent comps[] = item_rev.getRelatedComponents("IMAN_specification");
      if (comps == null) return 0;
      TCComponentDataset dset = null;
      for (int i = 0; i < comps.length; i++)
        if (comps[i].isTypeOf("UGMASTER"))
        {
          dset = (TCComponentDataset) comps[i];
          break;
        }
      if (dset == null) return 0;
      comps = dset.getNamedRefComponents("UGPART-MASSPR");
      if (comps==null || comps.length==0) return 0;
      TCComponentForm form = (TCComponentForm) comps[0];
      Result = form.getFormTCProperty("mass").getDoubleValue();
    }
    catch (Exception ex)
    {
      Result = 0;
    }
    return Result;
  }

  public static String getItemTypeCode(String sItemType)
  {
    Registry R = Registry.getRegistry("ru.rostvertolplc.osapr.forms.L-forms");
    String Result = R.getString(sItemType+".SBCODE", "0");
    return Result;
  }
  
}  