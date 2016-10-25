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

public class AccountViewImpl extends Composite implements AccountView {

	private static AccountViewImplUiBinder uiBinder = GWT.create(AccountViewImplUiBinder.class);

	interface AccountViewImplUiBinder extends UiBinder<Widget, AccountViewImpl> {
	}

	@UiField
	UserEditor userEditor;
	@UiField
	MaterialButton editButton;
	@UiField
	MaterialButton deleteButton;

	protected Presenter presenter;

	public AccountViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("editButton")
	void onEdit(ClickEvent e) {
		presenter.onEdit();
	}

	@UiHandler("deleteButton")
	void onDelete(ClickEvent e) {
		presenter.onDelete();
	}

	@Override
	public UserEditor getEditor() {
		return userEditor;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void showToast(String string) {
		MaterialToast.fireToast(string);
	}

}
