package mg.rova.gamestore.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ApplicationPathEditor extends Composite implements LeafValueEditor<String>, ValueAwareEditor<String> {

	protected VerticalPanel verticalPanel = new VerticalPanel();
	private FormPanel formPanel = new FormPanel();
	private FileUpload fileUpload = new FileUpload();
	
	public ApplicationPathEditor() {
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		formPanel.setAction(GWT.getModuleBaseURL() + "fileUpload");
		
		final VerticalPanel panel = new VerticalPanel();
		fileUpload.setName("upload");
		panel.add(fileUpload);
		formPanel.add(panel);
		
		verticalPanel.add(formPanel);
		initWidget(verticalPanel);
	}

	@Override
	public void setValue(String value) {
		
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setDelegate(EditorDelegate<String> delegate) {
		
	}

	@Override
	public void flush() {
		formPanel.submit();
	}

	@Override
	public void onPropertyChange(String... paths) {
		
	}

}
