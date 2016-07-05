package mg.rova.gamestore.client.mvp;

import mg.rova.gamestore.client.activity.MenuActivity;
import mg.rova.gamestore.client.dagger.AppInjector;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class MenuActivityMapper implements ActivityMapper {

	protected AppInjector injector;
	protected MenuActivity menuActivity;

	public MenuActivityMapper(AppInjector injector) {
		this.injector = injector;
	}

	@Override
	public Activity getActivity(Place place) {
		if (menuActivity == null)
			menuActivity = new MenuActivity(injector);
		return menuActivity;
	}
}
