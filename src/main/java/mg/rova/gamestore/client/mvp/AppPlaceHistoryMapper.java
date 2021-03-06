package mg.rova.gamestore.client.mvp;

import mg.rova.gamestore.client.place.AccountDetailsPlace;
import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.ApplicationDetailsPlace;
import mg.rova.gamestore.client.place.ApplicationListPlace;
import mg.rova.gamestore.client.place.CreateAccountPlace;
import mg.rova.gamestore.client.place.HomePlace;
import mg.rova.gamestore.client.place.LoginPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
	HomePlace.Tokenizer.class,
	AccountPlace.Tokenizer.class,
	AccountDetailsPlace.Tokenizer.class,
	CreateAccountPlace.Tokenizer.class,
	LoginPlace.Tokenizer.class,
	ApplicationListPlace.Tokenizer.class,
	ApplicationDetailsPlace.Tokenizer.class
	})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
