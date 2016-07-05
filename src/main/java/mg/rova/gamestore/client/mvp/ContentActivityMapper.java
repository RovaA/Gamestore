package mg.rova.gamestore.client.mvp;

import javax.inject.Inject;
import javax.inject.Singleton;

import mg.rova.gamestore.client.activity.AccountActivity;
import mg.rova.gamestore.client.activity.HomeActivity;
import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.HomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

@Singleton
public class ContentActivityMapper implements ActivityMapper {

	protected HomeActivity homeActivity;
	protected AccountActivity accountActivity;

	@Inject
	public ContentActivityMapper(HomeActivity homeActivity, AccountActivity accountActivity) {
		this.homeActivity = homeActivity;
		this.accountActivity = accountActivity;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return homeActivity;
		}
		if (place instanceof AccountPlace) {
			return accountActivity;
		}
		return null;
	}
}
