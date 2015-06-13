package mg.rova.gamestore.client.activity;

import mg.rova.gamestore.client.gin.ClientGinjector;
import mg.rova.gamestore.client.ui.HomeView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {
	
	protected ClientGinjector injector;
	protected HomeView view;
	
	public HomeActivity(ClientGinjector injector) {
		this.injector = injector;
		view = injector.getChatListView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}
}
