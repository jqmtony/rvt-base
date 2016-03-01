package ru.rostvertolplc.osapr.forms;



import com.teamcenter.rac.aif.AbstractAIFOperation;
import com.teamcenter.rac.kernel.TCComponent;
import com.teamcenter.rac.kernel.TCComponentForm;
import com.teamcenter.rac.kernel.TCComponentItem;
import com.teamcenter.rac.kernel.TCComponentItemRevision;
import com.teamcenter.rac.kernel.TCComponentItemType;
import com.teamcenter.rac.kernel.TCException;
import com.teamcenter.rac.kernel.TCProperty;
import com.teamcenter.rac.kernel.TCSession;
import com.teamcenter.rac.stylesheet.AbstractRendering;
import com.teamcenter.rac.util.MessageBox;
import com.teamcenter.rac.util.PropertyLayout;
import com.teamcenter.rac.util.Registry;
import com.teamcenter.rac.util.VerticalLayout;

import java.awt.BorderLayout;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JTextField data1_jtextfield;
	private JTextField data2_jtextfield;
	private TCProperty data1_tcproperty;
	private TCProperty data2_tcproperty;

	@Override
	public void loadRendering() throws TCException {
		initializeUI();
		data1_tcproperty = form.getTCProperty("last_mod_date");
		data2_tcproperty = form.getTCProperty("creation_date");
		data1_jtextfield.setText(data1_tcproperty.getStringValue());
		data2_jtextfield.setText(data2_tcproperty.getStringValue());
	}

	@Override
	public void saveRendering() {
		try
		{
		data1_tcproperty.setStringValueData(data1_jtextfield.getText() );
		data2_tcproperty.setStringValueData(data2_jtextfield.getText() );
		TCProperty[] ps = new TCProperty[2];
		ps[0] = data1_tcproperty;
		ps[1] = data2_tcproperty;
		// TcEng legacy used setTCProperties or setFormTCProperties,
		// use compnent.setTCProperties(ps);
		component.setTCProperties( ps );
		}
		catch ( Exception ex )
		{
		MessageBox.post(ex.getMessage(), null, MessageBox.ERROR);
		}

	}
	
	public H48PIRVZForm(TCComponentForm theForm) throws Exception {
		super(theForm);
		this.form = theForm;
		this.session = this.form.getSession();
		loadRendering();
	}
	
	public boolean isRenderingModified() {
		if( data1_tcproperty != null && !data1_jtextfield.getText().equals( data1_tcproperty.getStringValue() ) ) {
			return true;
		}
		if( data2_tcproperty != null && !data2_jtextfield.getText().equals( data2_tcproperty.getStringValue() ) ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public Map getRenderingModified () {
		Map modifiedRendering = new HashMap<String, Object> ();
		if( data1_tcproperty != null && !data1_jtextfield.getText().equals( data1_tcproperty.getStringValue() ) ) {
			data1_tcproperty.setStringValueData(data1_jtextfield.getText() );
			modifiedRendering.put( "last_mod_date", data1_tcproperty );
		}
		if( data2_tcproperty != null && !data2_jtextfield.getText().equals( data2_tcproperty.getStringValue() ) ) {
			data2_tcproperty.setStringValueData( data2_jtextfield.getText() );
			modifiedRendering.put( "creation_date", data2_tcproperty );
		}
		return modifiedRendering;
	}
	
	private void initializeUI() {
		setLayout ( new VerticalLayout() );
		JPanel mainPanel = new JPanel( new PropertyLayout());
		mainPanel.setOpaque(false);
		mainPanel.setEnabled(false);
		// Create all the text fields
		data1_jtextfield = new JTextField(15);
		data2_jtextfield = new JTextField(15);
		// Add components to Panel
		mainPanel.add("1.1.right.center",new JLabel("User Data One"));
		mainPanel.add("1.2.left.center", data1_jtextfield);
		mainPanel.add("2.1.right.center",new JLabel("User Data Two"));
		mainPanel.add("2.2.left.center", data2_jtextfield);
		add("unbound.bind", mainPanel);
	}
	
	
	/**
	*The following code is optional depending on whether you want to pre-load the
	*property data from the original (selected) item revision during a Revise.
	* Without it the values are reset/left blank.
	*/
	@Override
	public void setValues(String[] props, Object[] values) {
		if ( props != null && props.length > 1 ) {
			for( int i=0; i<props.length; i++ )	{
				if( props[i].equals( "last_mod_date" ) ) {
						data1_jtextfield.setText(values[i].toString());
				} else if( props[i].equals( "creation_date" ) ) {
					data2_jtextfield.setText(values[i].toString());
				}
			}
		}
	}



}
