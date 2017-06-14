package ru.rostvertolplc.osapr.helpers;

import com.teamcenter.rac.aif.AbstractAIFUIApplication;
import com.teamcenter.rac.classification.common.AbstractG4MApplication;
import com.teamcenter.rac.classification.common.G4MInClassDialog;
import com.teamcenter.rac.classification.common.G4MUserAppContext;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentICO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ClassificationHelper {
	protected static boolean cancelClassification;

	public static TCComponent getMaterialFromClassificator(
			TCComponent alreadyClassifiedComponent) {
		try {
			AbstractG4MApplication app = new AbstractG4MApplication() {
				public String getTitle() {
					return "title";
				}
			};
			return getMaterialFromClassificator(alreadyClassifiedComponent,
					app, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static TCComponent getMaterialFromClassificator(
			TCComponent alreadyClassifiedComponent,
			AbstractAIFUIApplication currentApplication, boolean isComponent) {
		try {
			cancelClassification = false;
			G4MInClassDialog dlg = new G4MInClassDialog(currentApplication);
			G4MUserAppContext dialogContext = dlg.getContext();
			if (alreadyClassifiedComponent != null) {
				if (isComponent) {
					if ((alreadyClassifiedComponent instanceof TCComponentICO)) {
						TCComponentICO c = (TCComponentICO) alreadyClassifiedComponent;
						TCComponent classifiedObject = c.getClassifiedObject();
						if (classifiedObject != null) {
							alreadyClassifiedComponent = classifiedObject;
						}
					}
					dialogContext.openComponent(alreadyClassifiedComponent,
							true);
				} else {
					dialogContext.nodeSelected("select",
							alreadyClassifiedComponent.getProperty("cid"));
				}
			}
			Component[] components = dlg.getContentPane().getComponents();
			Component[] components2 = ((JPanel) components[1]).getComponents();
			Component[] components3 = ((JPanel) components2[0]).getComponents();
			((JButton) components3[1]).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClassificationHelper.cancelClassification = true;
				}
			});
			dlg.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent arg0) {
					ClassificationHelper.cancelClassification = true;
					super.windowClosing(arg0);
				}
			});
			dlg.setModal(true);
			dlg.setVisible(true);
			if (cancelClassification) {
				return null;
			}
			return dlg.getContext().getClassifiedComponent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
