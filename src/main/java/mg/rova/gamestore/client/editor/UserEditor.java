package mg.rova.gamestore.client.editor;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import mg.rova.gamestore.client.proxy.UserProxy;

public class UserEditor extends Composite implements Editor<UserProxy> {

	private static UserEditorUiBinder uiBinder = GWT.create(UserEditorUiBinder.class);

	interface UserEditorUiBinder extends UiBinder<Widget, UserEditor> {
	}
	
	@UiField
	TextBox name;
	@UiField
	TextBox firstname;
	@UiField
	TextBox username;
	@UiField
	TextBox password;
	
	public UserEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
