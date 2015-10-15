package mg.rova.gamestore.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import mg.rova.gamestore.client.bundle.Messages;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.ui.AccountView;
import mg.rova.gamestore.client.ui.HomeView;
import mg.rova.gamestore.client.ui.MenuView;

@GinModules(ClientGinModule.class)
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();
	
	PlaceController getPlaceController();
	
	AppRequestFactory getAppRequestFactory();
	
	Messages getMessages();
	
	MainUi getMainUi();
	
	MenuView getMenuView();
	
	HomeView getHomeView();
	
	AccountView getAccountView();
}
