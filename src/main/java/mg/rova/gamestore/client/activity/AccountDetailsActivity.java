package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.LoginPlace;
import mg.rova.gamestore.client.proxy.UserProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.request.UserRequestContext;
import mg.rova.gamestore.client.rpc.LoginServiceAsync;
import mg.rova.gamestore.client.ui.AccountDetailsView;
import mg.rova.gamestore.client.ui.AccountView.Driver;

public class AccountDetailsActivity extends AbstractActivity implements AccountDetailsView.Presenter {

	protected AccountDetailsView view;
	protected PlaceController placeController;
	protected AppRequestFactory requestFactory;
	protected UserRequestContext requestContext;
	protected UserProxy user;
	protected UserProxy editedUser;
	protected LoginServiceAsync loginService;
	protected Driver driver;

	@Inject
	public AccountDetailsActivity(AccountDetailsView view, PlaceController placeController, AppRequestFactory requestFactory, LoginServiceAsync loginService) {
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
					public void onSuccess(UserProxy resultUser) {
						if (resultUser == null)
							return;
						user = resultUser;
						
						driver = GWT.create(Driver.class);
						driver.initialize(view.getEditor());
						requestContext = requestFactory.getUserRequestContext();
						editedUser = requestContext.edit(user);
						driver.edit(editedUser, requestContext);
						requestContext.persist(editedUser).to(new Receiver<UserProxy>() {

							@Override
							public void onSuccess(UserProxy response) {

							}
						});
					}
				});
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});

	}

	@Override
	public void onSave() {
		if (!driver.isDirty()) {
			view.showToast("Must assign new value.");
			return;
		}
		driver.flush().fire();
		placeController.goTo(new AccountPlace(""));
	}

	@Override
	public void onCancelling() {
		placeController.goTo(new AccountPlace(""));
	}

}
