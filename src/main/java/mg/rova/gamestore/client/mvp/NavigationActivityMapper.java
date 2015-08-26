package mg.rova.gamestore.client.mvp;

import mg.rova.gamestore.client.activity.NavigationActivity;
import mg.rova.gamestore.client.gin.ClientGinjector;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class NavigationActivityMapper implements ActivityMapper {

	public ClientGinjector injector;
	public NavigationActivity navigationActivity;

	public NavigationActivityMapper(ClientGinjector injector) {
		this.injector = injector;
	}

	@Override
	public Activity getActivity(Place place) {
		if (navigationActivity == null)
			navigationActivity = new NavigationActivity(injector);
		return navigationActivity;
	}

}
