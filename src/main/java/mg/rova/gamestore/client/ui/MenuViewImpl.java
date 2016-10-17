package mg.rova.gamestore.client.ui;

import gwt.material.design.client.ui.MaterialAnchorButton;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.client.ui.MaterialToast;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
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
	protected MaterialNavBar navBar;
	@UiField
	protected MaterialNavBar navBarSearch;
	@UiField
	protected MaterialSearch searchText;
	@UiField
	protected MaterialAnchorButton logButton;

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

	@UiHandler("logButton")
	public void onLog(ClickEvent event) {
		MaterialToast.fireToast("You are log in.");
	}
}
