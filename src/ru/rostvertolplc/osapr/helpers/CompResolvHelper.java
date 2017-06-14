package ru.rostvertolplc.osapr.helpers;

import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCProperty;

public class CompResolvHelper {
   TCComponent main_component;
   TCComponentItem item;
   TCComponentItemRevision rev;
   TCComponentForm item_form;
   TCComponentForm rev_form;

   void initialize(TCComponent component) {
      if(component instanceof TCComponentItem) {
         this.item = (TCComponentItem)component;

         try {
            this.item_form = (TCComponentForm)this.item.getRelatedComponent("IMAN_master_form");
            this.rev = this.item.getLatestItemRevision();
            this.rev_form = (TCComponentForm)this.rev.getRelatedComponent("IMAN_master_form_rev");
         } catch (TCException var4) {
            var4.printStackTrace();
         }
      } else if(component instanceof TCComponentItemRevision) {
         this.rev = (TCComponentItemRevision)component;

         try {
            this.item = this.rev.getItem();
            this.item_form = (TCComponentForm)this.item.getRelatedComponent("IMAN_master_form");
            this.rev_form = (TCComponentForm)this.rev.getRelatedComponent("IMAN_master_form_rev");
         } catch (TCException var3) {
            var3.printStackTrace();
         }
      } else if(component instanceof TCComponentForm) {
         this.rev_form = (TCComponentForm)component;
      }

      this.main_component = component;
   }

   public CompResolvHelper() {
   }

   public CompResolvHelper(TCComponent component) {
      this.initialize(component);
   }

   public CompResolvHelper(TCComponentItem it, TCComponentForm im, TCComponentItemRevision ir, TCComponentForm rm) {
      if(ir != null) {
         this.initialize(ir);
      } else if(it != null) {
         this.initialize(it);
      } else {
         this.item_form = im;
         this.rev_form = rm;
         if(rm != null) {
            this.main_component = rm;
         }

         if(im != null) {
            this.main_component = im;
         }

      }
   }

   TCComponent getGoodComponent(Object[] arrArg) throws TCException {
      Object comp = null;
      if(arrArg == null) {
         return null;
      } else {
         String sPropName = (String)arrArg[1];
         if(sPropName != null && !sPropName.isEmpty()) {
            if(sPropName.indexOf(46) < 0) {
               arrArg[0] = this.main_component;
               return this.main_component;
            } else {
               String[] arrS = sPropName.split("\\.");
               if(arrS[0].equals("IT")) {
                  comp = this.item;
               }

               if(arrS[0].equals("IM")) {
                  comp = this.item_form;
               }

               if(arrS[0].equals("IR")) {
                  comp = this.rev;
               }

               if(arrS[0].equals("RM")) {
                  comp = this.rev_form;
               }

               arrArg[0] = comp;
               arrArg[1] = arrS[1];
               return (TCComponent)comp;
            }
         } else {
            return null;
         }
      }
   }

   TCProperty getTCProperty(String sPropName) throws TCException {
      Object[] arrArg = new Object[]{null, sPropName};
      TCComponent comp = this.getGoodComponent(arrArg);
      if(comp == null) {
         System.out.println("LNT -- Неизвестный префикс в поле " + sPropName + " или пустой объект!");
         return null;
      } else {
         return comp.getTCProperty((String)arrArg[1]);
      }
   }

   public String getProperty(String sPropName) throws TCException {
      Object[] arrArg = new Object[]{null, sPropName};
      TCComponent comp = this.getGoodComponent(arrArg);
      if(comp == null) {
         System.out.println("LNT -- Неизвестный префикс в поле " + sPropName + " или пустой объект!");
         return null;
      } else {
         return comp.getProperty((String)arrArg[1]);
      }
   }

   public void setProperty(String sPropName, String sVal) throws TCException {
      Object[] arrArg = new Object[]{null, sPropName};
      TCComponent comp = this.getGoodComponent(arrArg);
      if(comp == null) {
         System.out.println("LNT -- Неизвестный префикс в поле " + sPropName + " или пустой объект!");
      } else {
         comp.setProperty((String)arrArg[1], sVal);
      }
   }

   public TCComponentItem getItem() {
      return this.item;
   }
}
