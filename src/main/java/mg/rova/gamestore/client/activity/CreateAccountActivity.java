package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import mg.rova.gamestore.client.place.HomePlace;
import mg.rova.gamestore.client.place.LoginPlace;
import mg.rova.gamestore.client.proxy.UserProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.request.UserRequestContext;
import mg.rova.gamestore.client.ui.CreateAccountView;
import mg.rova.gamestore.client.ui.CreateAccountView.Driver;

public class CreateAccountActivity extends AbstractActivity implements CreateAccountView.Presenter {

	protected CreateAccountView view;
	protected Driver driver;
	protected AppRequestFactory requestFactory;
	protected UserRequestContext requestContext;
	protected PlaceController placeController;

	@Inject
	public CreateAccountActivity(CreateAccountView view, AppRequestFactory requestFactory, PlaceController placeController) {
		this.view = view;
		this.requestFactory = requestFactory;
		this.placeController = placeController;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);

		driver = GWT.create(Driver.class);
		driver.initialize(view.getUserEditor());

		requestContext = requestFactory.getUserRequestContext();
		final UserProxy userProxy = requestContext.create(UserProxy.class);
		userProxy.setName("");
		userProxy.setFirstname("");
		userProxy.setUsername("");
		userProxy.setPassword("");
		driver.edit(userProxy, requestContext);
		requestContext.persist(userProxy).to(new Receiver<UserProxy>() {

			@Override
			public void onSuccess(UserProxy response) {
				
			}

		});
	}

	@Override
	public void onSend() {
		if (!driver.isDirty()) {
			view.showToast("Must change value.");
			return;
		}
		view.showToast("Account created.");
		driver.flush().fire();
		placeController.goTo(new LoginPlace(""));
	}

	@Override
	public void onCancelling() {
		view.showToast("Cancel creating account.");
		placeController.goTo(new HomePlace(""));
	}

}
