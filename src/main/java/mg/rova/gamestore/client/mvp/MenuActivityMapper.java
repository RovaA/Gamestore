package mg.rova.gamestore.client.mvp;

import mg.rova.gamestore.client.activity.MenuActivity;
import mg.rova.gamestore.client.gin.ClientGinjector;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class MenuActivityMapper implements ActivityMapper {

	protected ClientGinjector injector;
	protected MenuActivity menuActivity;

	public MenuActivityMapper(ClientGinjector injector) {
		this.injector = injector;
	}

	@Override
	public Activity getActivity(Place place) {
		if (menuActivity == null)
			menuActivity = new MenuActivity(injector);
		return menuActivity;
	}
}
