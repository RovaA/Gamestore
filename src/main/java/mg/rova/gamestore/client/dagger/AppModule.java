package mg.rova.gamestore.client.dagger;

import javax.inject.Singleton;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import dagger.Module;
import dagger.Provides;
import mg.rova.gamestore.client.bundle.Messages;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.rpc.LoginService;
import mg.rova.gamestore.client.rpc.LoginServiceAsync;
import mg.rova.gamestore.client.ui.AccountView;
import mg.rova.gamestore.client.ui.AccountViewImpl;
import mg.rova.gamestore.client.ui.ApplicationDetailsView;
import mg.rova.gamestore.client.ui.ApplicationDetailsViewImpl;
import mg.rova.gamestore.client.ui.ApplicationListView;
import mg.rova.gamestore.client.ui.ApplicationListViewImpl;
import mg.rova.gamestore.client.ui.CreateAccountView;
import mg.rova.gamestore.client.ui.CreateAccountViewImpl;
import mg.rova.gamestore.client.ui.HomeView;
import mg.rova.gamestore.client.ui.HomeViewImpl;
import mg.rova.gamestore.client.ui.LoginView;
import mg.rova.gamestore.client.ui.LoginViewImpl;
import mg.rova.gamestore.client.ui.MenuView;
import mg.rova.gamestore.client.ui.MenuViewImpl;

@Module
public class AppModule {

	@Provides
	@Singleton
	public static SimpleEventBus provideSimpleEventBus() {
		return new SimpleEventBus();
	}

	@Provides
	public static EventBus provideEventBus(SimpleEventBus eventBus) {
		return eventBus;
	}

	@Provides
	public static PlaceController providePlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}

	@Provides
	public static Messages provideMessages() {
		return GWT.create(Messages.class);
	}

	@Provides
	@Singleton
	public static AppRequestFactory provideAppRequestFactory(EventBus eventBus) {
		AppRequestFactory appRequestFactory = GWT.create(AppRequestFactory.class);
		appRequestFactory.initialize(eventBus);
		return appRequestFactory;
	}

	@Provides
	@Singleton
	public static LoginServiceAsync provideLoginService() {
		return GWT.create(LoginService.class);
	}

	@Provides
	public static MainUi provideMainUi() {
		return new MainUi();
	}

	@Provides
	public static MenuView provideMenuView() {
		return new MenuViewImpl();
	}

	@Provides
	public static HomeView provideHomeView() {
		return new HomeViewImpl();
	}

	@Provides
	public static AccountView provideAccountView() {
		return new AccountViewImpl();
	}

	@Provides
	public static LoginView provideLoginView() {
		return new LoginViewImpl();
	}

	@Provides
	public static CreateAccountView provideCreateAccountView() {
		return new CreateAccountViewImpl();
	}

	@Provides
	public static ApplicationListView provideApplicationListView() {
		return new ApplicationListViewImpl();
	}

	@Provides
	public static ApplicationDetailsView provideApplicationDetailsView() {
		return new ApplicationDetailsViewImpl();
	}

}
