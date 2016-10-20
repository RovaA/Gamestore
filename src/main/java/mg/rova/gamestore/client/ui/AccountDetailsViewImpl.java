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

public class AccountDetailsViewImpl extends Composite implements AccountDetailsView {

	private static AccountDetailsViewImplUiBinder uiBinder = GWT.create(AccountDetailsViewImplUiBinder.class);

	interface AccountDetailsViewImplUiBinder extends UiBinder<Widget, AccountDetailsViewImpl> {
	}

	@UiField
	UserEditor userEditor;
	@UiField
	MaterialButton saveButton;
	@UiField
	MaterialButton cancelButton;

	protected Presenter presenter;

	public AccountDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("saveButton")
	void onSave(ClickEvent e) {
		presenter.onSave();
	}

	@UiHandler("cancelButton")
	void onCancel(ClickEvent e) {
		presenter.onCancelling();
	}

	@Override
	public UserEditor getEditor() {
		return userEditor;
	}

	@Override
	public void showToast(String string) {
		MaterialToast.fireToast(string);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
