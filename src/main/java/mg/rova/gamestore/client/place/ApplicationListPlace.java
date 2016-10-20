package mg.rova.gamestore.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ApplicationListPlace extends Place {

	protected String token;

	public ApplicationListPlace(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	@Prefix("ApplicationList")
	public static class Tokenizer implements PlaceTokenizer<ApplicationListPlace> {

		@Override
		public ApplicationListPlace getPlace(String token) {
			return new ApplicationListPlace(token);
		}

		@Override
		public String getToken(ApplicationListPlace place) {
			return place.getToken();
		}

	}

}
