package mg.rova.gamestore.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;

import mg.rova.gamestore.client.gin.ClientGinjector;
import mg.rova.gamestore.client.ui.HomeView;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {
	
	protected ClientGinjector injector;
	protected HomeView view;
	
	public HomeActivity(ClientGinjector injector) {
		this.injector = injector;
		view = injector.getHomeView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		initHasData();
		panel.setWidget(view);
	}
	
	public void initHasData() {
		final ListDataProvider<String> listDataProvider = new ListDataProvider<String>();
		final List<String> listToWrap = listDataProvider.getList();
		for (int i = 0; i < 5; i++) {
			listToWrap.add(i + "");
		}
		listDataProvider.addDataDisplay(view.getHasData());
	}
}
