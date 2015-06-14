package mg.rova.gamestore.client.activity;

import mg.rova.gamestore.client.gin.ClientGinjector;
import mg.rova.gamestore.client.ui.NavigationView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class NavigationActivity extends AbstractActivity implements NavigationView.Presenter {

	protected ClientGinjector injector;
	protected NavigationView navigationView;

	public NavigationActivity(ClientGinjector injector) {
		this.injector = injector;
		navigationView = injector.getNavigationView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		navigationView.setPresenter(this);
		panel.setWidget(navigationView);
	}
}
