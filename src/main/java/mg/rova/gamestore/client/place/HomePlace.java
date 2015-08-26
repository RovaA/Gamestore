package mg.rova.gamestore.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class HomePlace extends Place {
	
	protected String token;
	
	public HomePlace(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	@Prefix("Home")
	public static class Tokenizer implements PlaceTokenizer<HomePlace> {

		@Override
		public HomePlace getPlace(String token) {
			return new HomePlace(token);
		}

		@Override
		public String getToken(HomePlace place) {
			return place.getToken();
		}
		
	}
}
