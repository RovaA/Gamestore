package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import mg.rova.gamestore.client.event.LoginEvent;
import mg.rova.gamestore.client.event.LoginEventHandler;
import mg.rova.gamestore.client.event.LogoutEvent;
import mg.rova.gamestore.client.event.LogoutEventHandler;
import mg.rova.gamestore.client.event.SearchEvent;
import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.ApplicationListPlace;
import mg.rova.gamestore.client.place.CreateAccountPlace;
import mg.rova.gamestore.client.place.HomePlace;
import mg.rova.gamestore.client.place.LoginPlace;
import mg.rova.gamestore.client.rpc.LoginServiceAsync;
import mg.rova.gamestore.client.ui.MenuView;

public class MenuActivity extends AbstractActivity implements MenuView.Presenter {

	protected MenuView view;
	protected PlaceController placeController;
	protected LoginServiceAsync loginService;
	protected EventBus eventBus;

	@Inject
	public MenuActivity(MenuView view, PlaceController placeController, LoginServiceAsync loginService) {
		this.view = view;
		this.placeController = placeController;
		this.loginService = loginService;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.eventBus = eventBus;
		eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {

			@Override
			public void onLogin() {
				view.showLogout(true);
			}
		});
		eventBus.addHandler(LogoutEvent.TYPE, new LogoutEventHandler() {

			@Override
			public void onLogout() {
				view.showLogout(false);
			}
		});
		view.setPresenter(this);
		panel.setWidget(view);

		loginService.isLoggedIn(new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(Boolean result) {
				if (result == null)
					return;
				view.showLogout(result);
			}
		});
	}

	@Override
	public void onHome() {
		if (placeController.getWhere() instanceof HomePlace)
			return;
		placeController.goTo(new HomePlace(""));
	}

	@Override
	public void onAccount() {
		loginService.isLoggedIn(new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {
				if (!result) {
					view.showToast("You must be logged first");
					return;
				}
				if (placeController.getWhere() instanceof AccountPlace)
					return;
				placeController.goTo(new AccountPlace(""));
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});
	}

	@Override
	public void onApplication() {
		loginService.isLoggedIn(new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {
				if (!result) {
					view.showToast("You must be logged first");
					return;
				}
				if (placeController.getWhere() instanceof ApplicationListPlace)
					return;
				placeController.goTo(new ApplicationListPlace(""));
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});
	}

	@Override
	public void onCreate() {
		placeController.goTo(new CreateAccountPlace(""));
	}

	@Override
	public void onLogin() {
		loginService.isLoggedIn(new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(Boolean result) {
				if (result)
					view.showToast("You are already logged in.");
				else
					placeController.goTo(new LoginPlace(""));
			}
		});
	}

	@Override
	public void onLogout() {
		loginService.logout(new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					view.showLogout(false);
					placeController.goTo(new HomePlace(""));
				} else {
					view.showToast("Cannot logout or already logout.");
				}
			}
		});
	}

	@Override
	public void search(String searchValue) {
		eventBus.fireEvent(new SearchEvent(searchValue));
	}

}
