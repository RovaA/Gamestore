package mg.rova.gamestore.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class CreateAccountPlace extends Place {

	protected String token;

	public CreateAccountPlace(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	@Prefix("CreateAccount")
	public static class Tokenizer implements PlaceTokenizer<CreateAccountPlace> {

		@Override
		public CreateAccountPlace getPlace(String token) {
			return new CreateAccountPlace(token);
		}

		@Override
		public String getToken(CreateAccountPlace place) {
			return place.getToken();
		}

	}

}
