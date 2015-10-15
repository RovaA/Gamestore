package mg.rova.gamestore.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AccountPlace extends Place {
	
	protected String token;
	
	public AccountPlace(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	@Prefix("Account")
	public static class Tokenizer implements PlaceTokenizer<AccountPlace> {

		@Override
		public AccountPlace getPlace(String token) {
			return new AccountPlace(token);
		}

		@Override
		public String getToken(AccountPlace place) {
			return place.getToken();
		}
		
	}

}
