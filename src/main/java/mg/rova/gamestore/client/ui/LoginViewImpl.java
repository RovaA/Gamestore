package mg.rova.gamestore.client.ui;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialToast;

public class LoginViewImpl extends Composite implements LoginView {

	private static LoginViewImplUiBinder uiBinder = GWT.create(LoginViewImplUiBinder.class);

	interface LoginViewImplUiBinder extends UiBinder<Widget, LoginViewImpl> {
	}

	@UiField
	TextBox usernameTextBox;
	@UiField
	TextBox passwordTextBox;
	@UiField
	MaterialButton loginButton;
	@UiField
	MaterialButton cancelButton;

	protected Presenter presenter;

	public LoginViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("loginButton")
	public void onLogin(ClickEvent event) {
		presenter.onLogin(usernameTextBox.getText(), passwordTextBox.getText());
	}

	@UiHandler("cancelButton")
	public void onCancel(ClickEvent event) {
		presenter.onCancelling();
	}

	@Override
	public void showToast(String message) {
		MaterialToast.fireToast(message);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void clear() {
		usernameTextBox.clear();
		passwordTextBox.clear();
	}

}
