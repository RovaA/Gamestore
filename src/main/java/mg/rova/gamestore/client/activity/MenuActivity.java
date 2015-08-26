package mg.rova.gamestore.client.activity;

import mg.rova.gamestore.client.gin.ClientGinjector;
import mg.rova.gamestore.client.ui.MenuView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MenuActivity extends AbstractActivity implements MenuView.Presenter {

	protected ClientGinjector injector;
	protected MenuView menuView;

	public MenuActivity(ClientGinjector injector) {
		this.injector = injector;
		menuView = injector.getMenuView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		menuView.setPresenter(this);
		panel.setWidget(menuView);
	}
}
