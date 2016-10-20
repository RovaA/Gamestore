package mg.rova.gamestore.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AccountDetailsPlace extends Place {

	protected String token;

	public AccountDetailsPlace(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	@Prefix("AccountDetails")
	public static class Tokenizer implements PlaceTokenizer<AccountDetailsPlace> {

		@Override
		public AccountDetailsPlace getPlace(String token) {
			return new AccountDetailsPlace(token);
		}

		@Override
		public String getToken(AccountDetailsPlace place) {
			return place.getToken();
		}

	}

}
