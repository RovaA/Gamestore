package mg.rova.gamestore.client.mvp;

import mg.rova.gamestore.client.place.AccountPlace;
import mg.rova.gamestore.client.place.CreateAccountPlace;
import mg.rova.gamestore.client.place.HomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
	HomePlace.Tokenizer.class,
	AccountPlace.Tokenizer.class,
	CreateAccountPlace.Tokenizer.class
	})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
