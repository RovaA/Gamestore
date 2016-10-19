package mg.rova.gamestore.client.editor;

import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.extras.datepicker.client.ui.DatePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import mg.rova.gamestore.client.proxy.ApplicationProxy;

public class ApplicationEditor extends Composite implements Editor<ApplicationProxy> {

	private static ApplicationEditorUiBinder uiBinder = GWT.create(ApplicationEditorUiBinder.class);

	interface ApplicationEditorUiBinder extends UiBinder<Widget, ApplicationEditor> {
	}

	@UiField
	TextBox title;
	@UiField
	TextBox keyword;
	@UiField
	TextBox author;
	@UiField
	DatePicker date;
	@UiField
	ApplicationPathEditor path;
	@UiField
	TextArea description;

	public ApplicationEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
