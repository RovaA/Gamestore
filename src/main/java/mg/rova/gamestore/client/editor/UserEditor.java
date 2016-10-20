package mg.rova.gamestore.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialTextBox;
import mg.rova.gamestore.client.proxy.UserProxy;

public class UserEditor extends Composite implements Editor<UserProxy> {

	private static UserEditorUiBinder uiBinder = GWT.create(UserEditorUiBinder.class);

	interface UserEditorUiBinder extends UiBinder<Widget, UserEditor> {
	}
	
	@UiField
	MaterialTextBox name;
	@UiField
	MaterialTextBox firstname;
	@UiField
	MaterialTextBox username;
	@UiField
	MaterialTextBox password;
	
	public UserEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setEnable(boolean enabled) {
		name.setEnabled(enabled);
		firstname.setEnabled(enabled);
		username.setEnabled(enabled);
		password.setEnabled(enabled);
	}

}
