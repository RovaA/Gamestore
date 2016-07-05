package mg.rova.gamestore.client.mvp;

import javax.inject.Inject;
import javax.inject.Singleton;

import mg.rova.gamestore.client.activity.MenuActivity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

@Singleton
public class MenuActivityMapper implements ActivityMapper {

	protected MenuActivity menuActivity;

	@Inject
	public MenuActivityMapper(MenuActivity menuActivity) {
		this.menuActivity = menuActivity;
	}

	@Override
	public Activity getActivity(Place place) {
		return menuActivity;
	}
}
