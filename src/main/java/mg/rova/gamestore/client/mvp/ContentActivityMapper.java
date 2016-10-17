package mg.rova.gamestore.client.mvp;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import mg.rova.gamestore.client.activity.AccountActivity;
import mg.rova.gamestore.client.activity.CreateAccountActivity;
import mg.rova.gamestore.client.activity.HomeActivity;
import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.CreateAccountPlace;
import mg.rova.gamestore.client.place.HomePlace;

@Singleton
public class ContentActivityMapper implements ActivityMapper {

	protected HomeActivity homeActivity;
	protected AccountActivity accountActivity;
	protected CreateAccountActivity createAccountActivity;

	@Inject
	public ContentActivityMapper(HomeActivity homeActivity, AccountActivity accountActivity, CreateAccountActivity createAccountActivity) {
		this.homeActivity = homeActivity;
		this.accountActivity = accountActivity;
		this.createAccountActivity = createAccountActivity;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return homeActivity;
		}
		if (place instanceof AccountPlace) {
			return accountActivity;
		}
		if (place instanceof CreateAccountPlace) {
			return createAccountActivity;
		}
		return null;
	}
}
