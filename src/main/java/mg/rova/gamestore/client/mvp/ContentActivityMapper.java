package mg.rova.gamestore.client.mvp;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import mg.rova.gamestore.client.activity.AccountActivity;
import mg.rova.gamestore.client.activity.AccountDetailsActivity;
import mg.rova.gamestore.client.activity.ApplicationDetailsActivity;
import mg.rova.gamestore.client.activity.ApplicationListActivity;
import mg.rova.gamestore.client.activity.CreateAccountActivity;
import mg.rova.gamestore.client.activity.HomeActivity;
import mg.rova.gamestore.client.activity.LoginActivity;
import mg.rova.gamestore.client.place.AccountDetailsPlace;
import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.ApplicationDetailsPlace;
import mg.rova.gamestore.client.place.ApplicationListPlace;
import mg.rova.gamestore.client.place.CreateAccountPlace;
import mg.rova.gamestore.client.place.HomePlace;
import mg.rova.gamestore.client.place.LoginPlace;

@Singleton
public class ContentActivityMapper implements ActivityMapper {

	protected HomeActivity homeActivity;
	protected AccountActivity accountActivity;
	protected AccountDetailsActivity accountDetailsActivity;
	protected CreateAccountActivity createAccountActivity;
	protected LoginActivity loginActivity;
	protected ApplicationListActivity applicationListActivity;
	protected ApplicationDetailsActivity applicationDetailsActivity;

	@Inject
	public ContentActivityMapper(HomeActivity homeActivity, AccountActivity accountActivity, AccountDetailsActivity accountDetailsActivity, CreateAccountActivity createAccountActivity, LoginActivity loginActivity, ApplicationListActivity applicationListActivity,
			ApplicationDetailsActivity applicationDetailsActivity) {
		this.homeActivity = homeActivity;
		this.accountActivity = accountActivity;
		this.accountDetailsActivity = accountDetailsActivity;
		this.createAccountActivity = createAccountActivity;
		this.loginActivity = loginActivity;
		this.applicationListActivity = applicationListActivity;
		this.applicationDetailsActivity = applicationDetailsActivity;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace)
			return homeActivity;
		if (place instanceof AccountPlace)
			return accountActivity;
		if (place instanceof AccountDetailsPlace)
			return accountDetailsActivity;
		if (place instanceof CreateAccountPlace) 
			return createAccountActivity;
		if (place instanceof LoginPlace)
			return loginActivity;
		if (place instanceof ApplicationListPlace)
			return applicationListActivity;
		if (place instanceof ApplicationDetailsPlace)
			return applicationDetailsActivity;
		return null;
	}
}
