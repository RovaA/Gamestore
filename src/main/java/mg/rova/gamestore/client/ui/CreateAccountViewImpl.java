package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialToast;
import mg.rova.gamestore.client.editor.UserEditor;

public class CreateAccountViewImpl extends Composite implements CreateAccountView {

	private static CreateAccountViewImplUiBinder uiBinder = GWT.create(CreateAccountViewImplUiBinder.class);

	interface CreateAccountViewImplUiBinder extends UiBinder<Widget, CreateAccountViewImpl> {
	}

	@UiField
	UserEditor userEditor;
	@UiField
	MaterialButton sendButton;
	@UiField
	MaterialButton cancelButton;

	protected Presenter presenter;

	public CreateAccountViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public UserEditor getUserEditor() {
		return userEditor;
	}

	@UiHandler("sendButton")
	public void onSend(ClickEvent event) {
		presenter.onSend();
	}

	@UiHandler("cancelButton")
	public void onCancel(ClickEvent event) {
		presenter.onCancelling();
	}

	@Override
	public void showToast(String message) {
		MaterialToast.fireToast(message);
	}

}
