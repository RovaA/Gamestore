package mg.rova.gamestore.client.activity;

import java.util.List;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import mg.rova.gamestore.client.proxy.ApplicationProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.ui.HomeView;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {

	protected HomeView view;
	protected AppRequestFactory requestFactory;

	@Inject
	public HomeActivity(HomeView view, AppRequestFactory requestFactory) {
		this.view = view;
		this.requestFactory = requestFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);

		requestFactory.getApplicationRequestContext().findAll().fire(new Receiver<List<ApplicationProxy>>() {

			@Override
			public void onSuccess(List<ApplicationProxy> response) {
				if (response == null)
					return;
				for (ApplicationProxy application : response) {
					view.addApplication(application);
				}
			}
		});
	}

}
