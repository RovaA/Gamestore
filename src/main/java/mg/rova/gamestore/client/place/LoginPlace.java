package mg.rova.gamestore.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class LoginPlace extends Place {
	
	protected String token;
	
	public LoginPlace(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	@Prefix("Login")
	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

		@Override
		public LoginPlace getPlace(String token) {
			return new LoginPlace(token);
		}

		@Override
		public String getToken(LoginPlace place) {
			return place.getToken();
		}
		
	}

}
