package mg.rova.gamestore.client.dagger;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {

	AppMock maker();
	 
}
