package mg.rova.gamestore.client.ui;

import org.gwtbootstrap3.client.ui.LinkedGroupItem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuViewImpl extends Composite implements MenuView {

	private static MenuViewImplUiBinder uiBinder = GWT.create(MenuViewImplUiBinder.class);

	interface MenuViewImplUiBinder extends UiBinder<Widget, MenuViewImpl> {
	}

	@UiField
	LinkedGroupItem home;
	@UiField
	LinkedGroupItem account;
	
	protected Presenter presenter;

	public MenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("home")
	public void onClickHome(ClickEvent event) {
		presenter.onHome();
	}
	
	@UiHandler("account")
	public void onClickAccount(ClickEvent event) {
		presenter.onAccount();
	}
}
