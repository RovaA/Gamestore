package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuViewImpl extends Composite implements MenuView {

	private static MenuViewImplUiBinder uiBinder = GWT.create(MenuViewImplUiBinder.class);

	interface MenuViewImplUiBinder extends UiBinder<Widget, MenuViewImpl> {
	}

	public MenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	protected Presenter presenter;

	public MenuViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
