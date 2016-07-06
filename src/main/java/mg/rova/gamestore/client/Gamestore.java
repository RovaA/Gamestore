package mg.rova.gamestore.client;

import mg.rova.gamestore.client.dagger.AppComponent;
import mg.rova.gamestore.client.dagger.DaggerAppComponent;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.mvp.AppPlaceHistoryMapper;
import mg.rova.gamestore.client.place.HomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class Gamestore implements EntryPoint {

	public void onModuleLoad() {

		final AppComponent component = DaggerAppComponent.create();

		EventBus eventBus = component.getEventBus();
		MainUi mainUi = component.getMainUi();

		ActivityMapper menuActivityMapper = component.getMenuActivityMapper();
		ActivityManager menuActivityManager = new ActivityManager(menuActivityMapper, eventBus);
		menuActivityManager.setDisplay(mainUi.getNorthLayoutPanel());

		ActivityMapper contentActivityMapper = component.getContentActivityMapper();
		ActivityManager ContentActivityManager = new ActivityManager(contentActivityMapper, eventBus);
		ContentActivityManager.setDisplay(mainUi.getCenterLayoutPanel());

		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(component.getPlaceController(), eventBus, new HomePlace(""));

		RootLayoutPanel.get().add(mainUi);
		
		historyHandler.handleCurrentHistory();
	}
}
