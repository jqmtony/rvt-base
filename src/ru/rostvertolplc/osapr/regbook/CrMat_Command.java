package ru.rostvertolplc.osapr.regbook;

import java.awt.*;

import ru.rostvertolplc.osapr.util.*;
import com.teamcenter.rac.aif.*;
import com.teamcenter.rac.kernel.*;
import com.teamcenter.rac.util.*;
import java.util.Vector;
//import com.teamcenter.rac.util.MessageBox;
import ru.rostvertolplc.osapr.forms.*;
import javax.swing.*;
import com.teamcenter.rac.aif.kernel.*;

/**
 * <p>Title: ������� �������� �� IMBASE</p>
 * <p>Description: 05.03.2008 - Command</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: LANIT</p>
 * @author SIMiX
 * @version 2.3
 */

// ���������� ��� ������� ������ ��� ��������� ������, ����� �� ������ �����

public class CrMat_Command extends AbstractAIFCommand
{
  NameResolver NR = new NameResolver(); 
  TCSession session = null;
  Registry registry = null;
  Frame parent = null;
  TCComponentFolder insertFolder = null;

  CrMat_Dlg newDialog = null;

  final String cstAttachRelation = "contents";
/*
  void paste(TCComponent where, TCComponent what) throws Exception
  {
    TCComponent[] objArray = new TCComponent[] { what };
    TCComponent[] pasteTargets = new TCComponent[] { where };
    PasteCommand paste = (PasteCommand) registry.newInstanceForEx(
	"pasteCommand", new Object [] {objArray, pasteTargets, ErrorDialog.digParentFrame()});

    paste.setFailBackFlag(true);
    paste.executeModal();
  }
*/
  public static String makeMatItemID(DSEUserData mat_data)
  {
    String sShifr = mat_data.code_okp;  // ������ ����
    if (sShifr==null || sShifr.length()==0)
      sShifr = "0-0-0";
    String sMatMark = mat_data.mater_mark;
    if (sMatMark==null || sMatMark.equals("") // ����� ����� �� ������ ���
        || sShifr.startsWith("0-"))           // � ������ ���������������� ���������
      return sShifr;                          // ������� ������ ����
    if (sShifr.endsWith("-0-0"))	// ���� ���� ������������ �� -0-0 ��� ������ �����
      return sShifr;				// ������ ���� ��� �����������
    // �� ����� "���-���-���" �������� 2 ��������� ���� ���������� "-���-���"
    sShifr = sShifr.substring(sShifr.indexOf('-'));

    // ItemID = ����� + 2 ���� ���������� = "�����-���-���"
    String sItemID = sMatMark.trim();
    // ��������� ����� ����� �� ������ � 32 ������� (��� ������ ������)
    sItemID = LUtil.safeSubstr(sItemID, 0, 32-sShifr.length());
    return sItemID + sShifr;
  }


  // -- ��������� ������� Item ��������� � ��� (true),
  // � ���� ��� � �������, �� ���������� ������������ ��� ������� (true)

  public boolean checkMatTCE(DSEUserData data)
  {
    TCComponentItemType tc_item = null;
    try
    {
      String sItemID = Transliterator.Decode_RUS_LAT(CrMat_Command.makeMatItemID(data));
      tc_item = (TCComponentItemType) session.getTypeComponent("Item");
      TCComponentItem item = tc_item.find(sItemID);
      if (item==null)
      {
        // �������� �� ������, �������?
        int rez = JOptionPane.showConfirmDialog(null, "�������� � ��� �� ������, ��� ������������� �� ������ ������� ���.",
                                      "������� �������� � ���?", JOptionPane.YES_NO_OPTION);
        if (rez!=JOptionPane.YES_OPTION) return false;
        data.session = session;
        return createMaterial(data);
      }
      return true;
    }
    catch (TCException ex)
    {
      ex.printStackTrace();
    }
    return false;
  }

  // -----------------------------------------

  public CrMat_Command(TCSession theSession)
  {
    session = theSession;
  }

  public CrMat_Command(Frame theParent, TCComponentFolder c_folder)
  {
    //registry = Registry.getRegistry("com.LANIT.technology.technology");
    session = c_folder.getSession();
    parent = theParent;
    insertFolder = c_folder;
  }

  public void executeCommand()
  {
    createMaterial(null);
  }
  // -----------------------------------------

  protected boolean createMaterial(DSEUserData theData) // theData ������ ��������� session
  {
    try {
      if (theData!=null)
      {
        newDialog = new CrMat_Dlg(parent, theData);
      }
      else
      {
        newDialog = new CrMat_Dlg(parent, session);
      }
      //newDialog = new CrDoc_Dlg(parent, c_folder);
      //setRunnable(newDialog);
      newDialog.setVisible(true);
      if (!newDialog.isOk) return false;
      //MessageBox.post(newDialog.data.material, "�������� ��������� �� IMBASE", MessageBox.INFORMATION);
      // -- ���������� � ������

/*    // -- �������� � ������� makeMatItemID()
      // �� ����� "���-���-���" �������� 2 ��������� ���� ���������� "-���-���"
      String sShifr = newDialog.data.mater_shifr;
      sShifr = sShifr.substring(sShifr.indexOf('-'));
      // ItemID = ����� + 2 ���� ���������� = "�����-���-���"
      String sItemID = newDialog.data.mater_mark.trim();
      // ��������� ����� ����� �� ������ � 32 ������� (��� ������ ������)
      sItemID = LUtil.safeSubstr(sItemID, 0, 32-sShifr.length());
      sItemID += sShifr;
*/
      String sItemID = makeMatItemID(newDialog.data);

      // � ��� 2008 object_name ����� ���� �� 128 ��������  
      String sItemName = LUtil.safeSubstr(newDialog.data.material, 0,128); //32);
      String sItemType = NR.TYPE_Material;
      // ������� Item
      TCComponentItemType tc_item = (TCComponentItemType)session.getTypeComponent("Item");
      TCComponentItem c_item = null;
      TCComponentItemRevision c_item_rev = null;
      session.getTypeComponent(sItemType);  // �������� ������� ����
      // � ��� 2008 item_id ����� ���� �� 128 ��������  
      c_item = tc_item.create(LUtil.safeSubstr(Transliterator.Decode_RUS_LAT(sItemID) ,0,128), //32),
                              "A", sItemType, sItemName, null, null);
      c_item_rev = c_item.getLatestItemRevision();

      // ���� ����� �� ������, �������� � NewStuff
      if (insertFolder==null)
        insertFolder = session.getUser().getNewStuffFolder();

      LUtil.AttachOnce(insertFolder, "contents", c_item);

      // �������� � �������� �����������, ����.
      TCComponentForm form = (TCComponentForm) c_item.getRelatedComponent("IMAN_master_form");
      // ���������� - ���� �� � ����� ���� � ������ ������������
      Vector vPropNames = new Vector( java.util.Arrays.asList(form.getFormPropertyNames()) );
      boolean bCustomType = vPropNames.indexOf(NR.fld_DSE) > -1;
      if (bCustomType)
      {
      	SmartTCEForm sform = new SmartTCEForm(form);
        form.lock();
        sform.setFormPropertySafe(NR.fld_DSE_CODE, newDialog.data.mater_shifr);
        sform.setFormPropertySafe(NR.fld_NAME_DSE, LUtil.safeSubstr(newDialog.data.material, 0,256));
        sform.setFormPropertySafe(NR.fld_DSE_ID, newDialog.data.mater_name);
        sform.setFormPropertySafe(NR.fld_M_MARKA_MAT, newDialog.data.mater_mark);
        sform.setFormPropertySafe(NR.fld_M_ND_MARKA, newDialog.data.mater_mark_nd);
        sform.setFormPropertySafe(NR.fld_M_VID_ZAGOT, LUtil.safeSubstr(newDialog.data.mater_zagot, 0,32));
        sform.setFormPropertySafe(NR.fld_M_ND_SORT, newDialog.data.mater_sort_nd);
        sform.setFormPropertySafe(NR.fld_M_MASSA, newDialog.data.density);
        sform.setFormPropertySafe(NR.fld_SB, DSEUserData.getItemTypeCode("��������"));
        form.save();
        form.unlock();
      }
      insertFolder.refresh();
      MessageBox.post("�������� ������� �������� � ����� '"+insertFolder.toString()+"'",
                      c_item.toString(), MessageBox.INFORMATION);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      MessageBox.post(ex);
      return false;
    }
    if (newDialog!=null) newDialog.dispose();
    return true;
  }

}

