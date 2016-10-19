package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.Display;
import gwt.material.design.client.ui.MaterialAnchorButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.client.ui.MaterialToast;

public class MenuViewImpl extends Composite implements MenuView {

	private static MenuViewImplUiBinder uiBinder = GWT.create(MenuViewImplUiBinder.class);

	interface MenuViewImplUiBinder extends UiBinder<Widget, MenuViewImpl> {
	}

	@UiField
	protected MaterialNavBar navBar;
	@UiField
	protected MaterialNavBar navBarSearch;
	@UiField
	protected MaterialSearch searchText;
	@UiField
	protected MaterialLink homeMaterialLink;
	@UiField
	protected MaterialLink accountMaterialLink;
	@UiField
	protected MaterialAnchorButton logButton;
	@UiField
	protected MaterialAnchorButton createButton;
	@UiField
	protected MaterialAnchorButton loginButton;
	@UiField
	protected MaterialAnchorButton logoutButton;

	protected Presenter presenter;

	public MenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		searchText.addCloseHandler(new CloseHandler<String>() {

			@Override
			public void onClose(CloseEvent<String> event) {
				navBar.setVisible(true);
				navBarSearch.setVisible(false);
			}
		});
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("searchButton")
	public void onSearch(ClickEvent event) {
		navBar.setVisible(false);
		navBarSearch.setVisible(true);
	}

	@UiHandler("homeMaterialLink")
	public void onHome(ClickEvent event) {
		presenter.onHome();
	}

	@UiHandler("accountMaterialLink")
	public void onAccount(ClickEvent event) {
		presenter.onAccount();
	}

	@UiHandler("createButton")
	public void onCreate(ClickEvent event) {
		presenter.onCreate();
	}

	@UiHandler("loginButton")
	public void onLogin(ClickEvent event) {
		presenter.onLogin();
	}

	@UiHandler("logoutButton")
	public void onLogout(ClickEvent event) {
		presenter.onLogout();
	}

	@Override
	public void showToast(String message) {
		MaterialToast.fireToast(message);
	}

	@Override
	public void showLogout(boolean show) {
		if (show) {
			createButton.setDisplay(Display.NONE);
			loginButton.setDisplay(Display.NONE);
			logoutButton.setDisplay(Display.BLOCK);
		} else {
			createButton.setDisplay(Display.BLOCK);
			loginButton.setDisplay(Display.BLOCK);
			logoutButton.setDisplay(Display.NONE);
		}
	}
}
