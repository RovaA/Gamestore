package mg.rova.gamestore.client.dagger;

import javax.inject.Singleton;

import mg.rova.gamestore.client.bundle.Messages;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.ui.AccountView;
import mg.rova.gamestore.client.ui.HomeView;
import mg.rova.gamestore.client.ui.MenuView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppInjector {

	EventBus getEventBus();

	PlaceController getPlaceController();

	Messages getMessages();

	MainUi getMainUi();

	MenuView getMenuView();

	HomeView getHomeView();

	AccountView getAccountView();

}
