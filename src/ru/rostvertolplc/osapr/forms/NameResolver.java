package ru.rostvertolplc.osapr.forms;

import com.teamcenter.rac.util.Registry;

public class NameResolver {
	
	Registry R = Registry.getRegistry("ru.rostvertolplc.osapr.forms.NameResolver");
	
	public String TYPE_Detal = R.getString("TYPE_Detal");
	  public String TYPE_SE = R.getString("TYPE_SE");
	  public String TYPE_Document = R.getString("TYPE_Document");
	  public String TYPE_Prochee = R.getString("TYPE_Prochee");
	  public String TYPE_StdIzd = R.getString("TYPE_StdIzd");
	  public String TYPE_Complect = R.getString("TYPE_Complect");
	  public String TYPE_Material = R.getString("TYPE_Material");
	  public String TYPE_GeomMaterial = R.getString("TYPE_GeomMaterial");
	  public String TYPE_SoderzhIzm = R.getString("TYPE_Soderzhanie_Izm");
	  public String TYPE_Soderzhanie_Izm = R.getString("TYPE_Soderzhanie_Izm");

	public String fld_DSE_CODE=R.getString("fld_DSE_CODE");
	public String fld_DSE=R.getString("fld_DSE");
	public String fld_GOST=R.getString("fld_GOST");
	public String fld_TIP_DOC=R.getString("fld_TIP_DOC");
	public String fld_NAME_DSE=R.getString("fld_NAME_DSE");
	public String fld_SPRAV_DSE=R.getString("fld_SPRAV_DSE");
	public String fld_FIRST_USE=R.getString("fld_FIRST_USE");
	public String fld_UOBOZ_IZD=R.getString("fld_UOBOZ_IZD");
	public String fld_TIPIZGOT=R.getString("fld_TIPIZGOT");
	public String fld_VIDPKI=R.getString("fld_VIDPKI");
	public String fld_CODEOKP=R.getString("fld_CODEOKP");
	public String fld_DOC_POSTAV=R.getString("fld_DOC_POSTAV");
	public String fld_ORG_POSTAV=R.getString("fld_ORG_POSTAV");
	public String fld_COMMENT=R.getString("fld_COMMENT");
	public String fld_PRINTID=R.getString("fld_PRINTID");
	public String fld_N_PROTRAZ=R.getString("fld_N_PROTRAZ");
	public String fld_SB=R.getString("fld_SB");
	public String fld_frommodel=R.getString("fld_frommodel");
	public String fld_MASSA=R.getString("fld_MASSA");
	public String fld_MATERIAL=R.getString("fld_MATERIAL");
	public String fld_data2=R.getString("fld_data2");

	public String fld_FORMAT=R.getString("fld_FORMAT");
	public String fld_LITER1=R.getString("fld_LITER1");
	public String fld_LITER2=R.getString("fld_LITER2");
	public String fld_LITER3=R.getString("fld_LITER3");
	public String fld_GROUP=R.getString("fld_GROUP");
	public String fld_DATE_IZM=R.getString("fld_DATE_IZM");
	public String fld_NIZV=R.getString("fld_NIZV");
	//public String fld_RODITEL=R.getString("fld_RODITEL");
	public String fld_KIM=R.getString("fld_KIM");
	public String fld_DENSITY=R.getString("fld_DENSITY");
	public String fld_MAT_SPEC=R.getString("fld_MAT_SPEC");
	public String fld_MARKA_MAT=R.getString("fld_MARKA_MAT");
	public String fld_ND_MARKA=R.getString("fld_ND_MARKA");
	public String fld_ND_SORT =R.getString("fld_ND_SORT");
	public String fld_VID_ZAGOT=R.getString("fld_VID_ZAGOT");
	public String fld_GABARIT=R.getString("fld_GABARIT");
	public String fld_SHIFRMATER=R.getString("fld_SHIFRMATER");
	public String fld_PO=R.getString("fld_PO");
	public String fld_ZAGP=R.getString("fld_ZAGP");
	public String fld_ZAG=R.getString("fld_ZAG");
	public String fld_ORIG=R.getString("fld_ORIG");
	public String fld_CADSYS=R.getString("fld_CADSYS");
	public String fld_OTDEL=R.getString("fld_OTDEL");
	public String fld_CREATOR=R.getString("fld_CREATOR");
	public String fld_REVIEWER=R.getString("fld_REVIEWER");
	public String fld_NACHBRIG=R.getString("fld_NACHBRIG");
	public String fld_TEXCONTROL=R.getString("fld_TEXCONTROL");
	public String fld_NCONTROL=R.getString("fld_NCONTROL");
	public String fld_NACHOTD=R.getString("fld_NACHOTD");
	public String fld_GENCHECK=R.getString("fld_GENCHECK");
	public String fld_data2_R=R.getString("fld_data2_R");
	//public String fld_kolListov=R.getString("fld_kolListov");
	public String fld_kolListov="HR112";

	//-- LOVs --
	public String lov_LITERA=R.getString("lov_LITERA");
	public String lov_FORMAT=R.getString("lov_FORMAT");
	public String lov_OTVETSTV=R.getString("lov_OTVETSTV");
	public String lov_VIDPKI=R.getString("lov_VIDPKI");
	public String lov_NIZD=R.getString("lov_NIZD");
	public String lov_KODDOC=R.getString("lov_KODDOC");
	public String lov_IZDIDX = R.getString("lov_IZDIDX");
	public String lov_CONSGROUP = R.getString("lov_CONSGROUP");
	public String lov_CADSYS = R.getString("lov_CADSYS");

	// -- MaterialForm --
	//public String fld_DSE_CODE=R.getString("fld_DSE_CODE");
	//public String fld_DSE_NAME=R.getString("fld_DSE_NAME");
	public String fld_DSE_ID=R.getString("fld_DSE_ID");
	public String fld_M_MARKA_MAT=R.getString("fld_M_MARKA_MAT");
	public String fld_M_ND_MARKA=R.getString("fld_M_ND_MARKA");
	public String fld_M_ND_SORT=R.getString("fld_M_ND_SORT");
	public String fld_M_VID_ZAGOT=R.getString("fld_M_VID_ZAGOT");
	public String fld_M_GABARIT=R.getString("fld_M_GABARIT");
	//public String fld_VID_OBRAB=R.getString("fld_VID_OBRAB");
	public String fld_M_MASSA=R.getString("fld_M_MASSA");
	public String fld_M_frommodel=R.getString("fld_M_frommodel");
	//public String fld_SB=R.getString("fld_SB");

	// -- MRVForm --
	public String fld_MRV_Text=R.getString("fld_MRV_Text");
	public String fld_MRV_DSE=R.getString("fld_MRV_DSE");
	public String fld_MRV_NAME=R.getString("fld_MRV_NAME");

	//-- SlZapFormPanel --
	public String fld_SZ_Index_Izd = R.getString("fld_SZ_Index_Izd");
	public String fld_SZ_Num_Mach = R.getString("fld_SZ_Num_Mach");
	public String fld_SZ_Num = R.getString("fld_SZ_Num");
	public String fld_SZ_Kol_Komplect = R.getString("fld_SZ_Kol_Komplect");
	public String fld_SZ_Num_Zakaz = R.getString("fld_SZ_Num_Zakaz");
	public String fld_SZ_Text = R.getString("fld_SZ_Text");
	public String fld_SZ_Otvetstv = R.getString("fld_SZ_Otvetstv");
	public String fld_SZ_Addresat = R.getString("fld_SZ_Addresat");
	public String fld_SZ_RelateTo = R.getString("fld_SZ_RelateTo");
	
	/*
	 * свойства H48_PIRVZ
	 * 
	 * h47_CN001.                 
h47_CN002.                 
h47_CN003.                 
h47_CN004.                 
h47_CN005.                 
h47_add_reviewers.         
h47_add_revs.              
h47_approver.              
h47_chng_code.             
h47_chng_reason.           
h47_creator.               
h47_nach_okb.              ФИОНачОКБ
h47_nach_otd.              ФИОНачОтд
h47_normocontroler.        ФИОНормоконтрол
h47_note_vnedr.            Запись_Внедр
h47_note_zadel.            Запись_Задел
h47_orig_changer.          Ориг_ченджер
h47_otdel.                 ОтделНазвание
h47_ph_content.            
h47_ph_name.               
h47_pr_zak.                
h47_primechanie.           ТекстПримечание
h47_reg_num.               
h47_reviewer.              
h47_techcontrol.           ТехноконтрольФИО
h47_used_in.               
h47_ved_konst.             ВедущКонструкторФИО
	 * 
	 */
	

}
