package mg.rova.gamestore.client.gin;

import mg.rova.gamestore.client.bundle.Messages;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

@GinModules(ClientGinModule.class)
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();
	
	PlaceController getPlaceController();
	
	Messages getMessages();
	
//	MessageBus getMessageBus();
	
//	MainUi getMainUi();
	
//	HomeView getChatListView();
}
