package mg.rova.gamestore.client.activity;

import java.util.List;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import mg.rova.gamestore.client.event.SearchEvent;
import mg.rova.gamestore.client.event.SearchEventHandler;
import mg.rova.gamestore.client.proxy.ApplicationProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.ui.HomeView;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {

	protected HomeView view;
	protected AppRequestFactory requestFactory;
	protected List<ApplicationProxy> applications;

	@Inject
	public HomeActivity(HomeView view, AppRequestFactory requestFactory) {
		this.view = view;
		this.requestFactory = requestFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		eventBus.addHandler(SearchEvent.TYPE, new SearchEventHandler() {

			@Override
			public void onSearch(String search) {
				if (search == null)
					return;
				if (search.equals("")) {
					view.clear();
					for (ApplicationProxy application : applications) {
						view.addApplication(application);
					}
					return;
				}
				view.clear();
				requestFactory.getApplicationRequestContext().findByTitle(search).fire(new Receiver<List<ApplicationProxy>>() {

					@Override
					public void onSuccess(List<ApplicationProxy> response) {
						if (response == null) {
							return;
						}
						for (ApplicationProxy application : response) {
							view.addApplication(application);
						}
					}
				});
			}
		});
		view.setPresenter(this);
		panel.setWidget(view);

		requestFactory.getApplicationRequestContext().findAll().fire(new Receiver<List<ApplicationProxy>>() {

			@Override
			public void onSuccess(List<ApplicationProxy> response) {
				if (response == null)
					return;
				applications = response;
				for (ApplicationProxy application : response) {
					view.addApplication(application);
				}
			}
		});
	}

	@Override
	public void onStop() {
		super.onStop();
		view.clear();
	}

}
