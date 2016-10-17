package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.CreateAccountPlace;
import mg.rova.gamestore.client.place.HomePlace;
import mg.rova.gamestore.client.ui.MenuView;

public class MenuActivity extends AbstractActivity implements MenuView.Presenter {

	protected MenuView view;
	protected PlaceController placeController;

	@Inject
	public MenuActivity(MenuView view, PlaceController placeController) {
		this.view = view;
		this.placeController = placeController;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void onHome() {
		if (placeController.getWhere() instanceof HomePlace)
			return;
		placeController.goTo(new HomePlace(""));
	}

	@Override
	public void onAccount() {
		boolean islogged = false;
		if (!islogged) {
			Window.alert("You must be logged first");
			return;
		}
		if (placeController.getWhere() instanceof AccountPlace)
			return;
		placeController.goTo(new AccountPlace(""));
	}

	@Override
	public void onCreate() {
		placeController.goTo(new CreateAccountPlace(""));
	}

	@Override
	public void onLogin() {
		
	}
}
