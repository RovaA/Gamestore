package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import mg.rova.gamestore.client.place.HomePlace;
import mg.rova.gamestore.client.rpc.LoginServiceAsync;
import mg.rova.gamestore.client.ui.LoginView;

public class LoginActivity extends AbstractActivity implements LoginView.Presenter {

	protected LoginView view;
	protected PlaceController placeController;
	protected LoginServiceAsync loginService;

	@Inject
	public LoginActivity(LoginView view, PlaceController placeController, LoginServiceAsync loginService) {
		this.view = view;
		this.placeController = placeController;
		this.loginService = loginService;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void onLogin(String username, String password) {
		loginService.login(username, password, new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					view.showToast("You are logged in.");
					placeController.goTo(new HomePlace(""));
				} else {
					view.showToast("Wrong username or password.");
					view.clear();
				}
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});
	}

	@Override
	public void onCancelling() {
		placeController.goTo(new HomePlace(""));
	}

}
