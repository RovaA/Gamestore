package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import mg.rova.gamestore.client.place.AccountDetailsPlace;
import mg.rova.gamestore.client.place.LoginPlace;
import mg.rova.gamestore.client.proxy.UserProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.rpc.LoginServiceAsync;
import mg.rova.gamestore.client.ui.AccountView;
import mg.rova.gamestore.client.ui.AccountView.Driver;

public class AccountActivity extends AbstractActivity implements AccountView.Presenter {

	protected AccountView view;
	protected PlaceController placeController;
	protected AppRequestFactory requestFactory;
	protected LoginServiceAsync loginService;
	protected Driver driver;
	protected UserProxy currentUser;

	@Inject
	public AccountActivity(AccountView view, PlaceController placeController, AppRequestFactory requestFactory, LoginServiceAsync loginService) {
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
					view.showToast("Must logged first");
					placeController.goTo(new LoginPlace(""));
					return;
				}
				requestFactory.getUserRequestContext().findById(result).fire(new Receiver<UserProxy>() {

					@Override
					public void onSuccess(UserProxy user) {
						if (user == null)
							return;
						currentUser = user;
						final Driver driver = GWT.create(Driver.class);
						view.getEditor().setEnable(false);
						driver.initialize(view.getEditor());
						driver.display(user);
					}

				});
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});

	}

	@Override
	public void onEdit() {
		placeController.goTo(new AccountDetailsPlace(""));
	}

	@Override
	public void onCancelling() {
		requestFactory.getUserRequestContext().remove(currentUser.getId()).fire(new Receiver<Boolean>() {

			@Override
			public void onSuccess(Boolean response) {
				if (!response)
					return;
				view.showToast("Profile deleted successfully!");
				placeController.goTo(new LoginPlace(""));
			}
		});
	}

}
