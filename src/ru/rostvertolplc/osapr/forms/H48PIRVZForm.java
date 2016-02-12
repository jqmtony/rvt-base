package ru.rostvertolplc.osapr.forms;



import com.teamcenter.rac.aif.AbstractAIFOperation;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCComponentItemType;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.stylesheet.AbstractRendering;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.Registry;
import java.awt.BorderLayout;
import java.io.PrintStream;
import java.util.Date;
import javax.swing.JPanel;

public class H48PIRVZForm extends AbstractRendering {

	private static final long serialVersionUID = 1292364185428498445L;
	
	Registry R = Registry.getRegistry("ru.rostvertolplc.osapr.forms.L-forms");
	NameResolver NR = new NameResolver();
	TCComponentForm form = null;
	TCComponentForm form_rev;
	String sFormType;
	SmartTCEForm sform = null;
	SmartTCEForm sform_rev = null;
	TCSession session;
	InterfaceFormPanel innerPanel;
	DSEUserData data;

	@Override
	public void loadRendering() throws TCException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveRendering() {
		// TODO Auto-generated method stub

	}
	
	public H48PIRVZForm(TCComponentForm theForm) throws Exception {
		super(theForm);
		this.form = theForm;
		this.session = this.form.getSession();
		loadRendering();
	}

}
