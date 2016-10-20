package mg.rova.gamestore.client.editor;

import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import mg.rova.gamestore.client.proxy.ApplicationProxy;
import mg.rova.gamestore.client.ui.ApplicationDetailsViewImpl;

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
	ApplicationPathEditor path;
	@UiField
	TextArea description;

	@UiField
	@Ignore
	MaterialButton deleteButton;
	@Ignore
	public ApplicationDetailsViewImpl parent;

	public ApplicationEditor(ApplicationDetailsViewImpl parent) {
		this.parent = parent;
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("deleteButton")
	public void onDelete(ClickEvent event) {
		parent.deleteEditor(this);
	}

}
