package mg.rova.gamestore.client.gin;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import mg.rova.gamestore.client.bundle.Messages;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.ui.AccountView;
import mg.rova.gamestore.client.ui.AccountViewImpl;
import mg.rova.gamestore.client.ui.HomeView;
import mg.rova.gamestore.client.ui.HomeViewImpl;
import mg.rova.gamestore.client.ui.MenuView;
import mg.rova.gamestore.client.ui.MenuViewImpl;

public class ClientGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(MainUi.class).in(Singleton.class);
		bind(MenuView.class).to(MenuViewImpl.class).in(Singleton.class);
		bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
		bind(AccountView.class).to(AccountViewImpl.class).in(Singleton.class);
	}

	@Provides
	@Singleton
	public EventBus getEventBus() {
		return new SimpleEventBus();
	}

	@Provides
	@Singleton
	@Inject
	public PlaceController getPlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}

	@Provides
	@Singleton
	@Inject
	public AppRequestFactory getAppRequestFactory(EventBus eventBus) {
		AppRequestFactory appRequestFactory = GWT.create(AppRequestFactory.class);
		appRequestFactory.initialize(eventBus);
		return appRequestFactory;
	}

	@Provides
	@Singleton
	public Messages getMessages() {
		return GWT.create(Messages.class);
	}

}
