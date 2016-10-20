package mg.rova.gamestore.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ApplicationDetailsPlace extends Place {

	protected String token;

	public ApplicationDetailsPlace(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	@Prefix("ApplicationDetails")
	public static class Tokenizer implements PlaceTokenizer<ApplicationDetailsPlace> {

		@Override
		public ApplicationDetailsPlace getPlace(String token) {
			return new ApplicationDetailsPlace(token);
		}

		@Override
		public String getToken(ApplicationDetailsPlace place) {
			return place.getToken();
		}

	}

}
