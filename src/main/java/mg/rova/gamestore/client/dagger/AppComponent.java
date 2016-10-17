package mg.rova.gamestore.client.dagger;

import javax.inject.Singleton;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import dagger.Component;
import mg.rova.gamestore.client.bundle.Messages;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.mvp.ContentActivityMapper;
import mg.rova.gamestore.client.mvp.MenuActivityMapper;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.ui.AccountView;
import mg.rova.gamestore.client.ui.CreateAccountView;
import mg.rova.gamestore.client.ui.HomeView;
import mg.rova.gamestore.client.ui.MenuView;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

	EventBus getEventBus();

	PlaceController getPlaceController();

	Messages getMessages();

	MainUi getMainUi();

	MenuView getMenuView();

	HomeView getHomeView();

	AccountView getAccountView();

	CreateAccountView getCreateAccountView();

	MenuActivityMapper getMenuActivityMapper();

	ContentActivityMapper getContentActivityMapper();

	AppRequestFactory getAppRequestFactory();

}
