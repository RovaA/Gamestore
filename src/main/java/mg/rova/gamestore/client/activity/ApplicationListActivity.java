package mg.rova.gamestore.client.activity;

import java.util.List;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import mg.rova.gamestore.client.place.ApplicationDetailsPlace;
import mg.rova.gamestore.client.proxy.ApplicationProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.rpc.LoginServiceAsync;
import mg.rova.gamestore.client.ui.ApplicationListView;

public class ApplicationListActivity extends AbstractActivity implements ApplicationListView.Presenter {

	protected ApplicationListView view;
	protected PlaceController placeController;
	protected AppRequestFactory requestFactory;
	protected LoginServiceAsync loginService;

	@Inject
	public ApplicationListActivity(ApplicationListView view, PlaceController placeController, AppRequestFactory requestFactory, LoginServiceAsync loginService) {
		this.view = view;
		this.placeController = placeController;
		this.requestFactory = requestFactory;
		this.loginService = loginService;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);

		loginService.getId(new AsyncCallback<Long>() {

			@Override
			public void onSuccess(Long result) {
				if (result == null) {
					view.showToast("Must logged first.");
					return;
				}
				requestFactory.getApplicationRequestContext().findByUserId(result).fire(new Receiver<List<ApplicationProxy>>() {

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

			@Override
			public void onFailure(Throwable caught) {

			}
		});
	}

	@Override
	public void onAdd() {
		placeController.goTo(new ApplicationDetailsPlace(""));
	}

}
