package mg.rova.gamestore.client.mvp;

import mg.rova.gamestore.client.activity.AccountActivity;
import mg.rova.gamestore.client.activity.HomeActivity;
import mg.rova.gamestore.client.gin.ClientGinjector;
import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.HomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class ContentActivityMapper implements ActivityMapper {
	
	protected ClientGinjector injector;
	
	public ContentActivityMapper(ClientGinjector injector) {
		this.injector = injector;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return new HomeActivity(injector);
		}
		if (place instanceof AccountPlace) {
			return new AccountActivity(injector);
		}
		return null;
	}
}
