package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AccountViewImpl extends Composite implements AccountView {

	private static AccountViewImplUiBinder uiBinder = GWT.create(AccountViewImplUiBinder.class);

	interface AccountViewImplUiBinder extends UiBinder<Widget, AccountViewImpl> {
	}

	@UiField
	Button button;
	
	protected Presenter presenter;

	public AccountViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText("hello");
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		presenter.onSubmit();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
