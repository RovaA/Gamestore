package mg.rova.gamestore.client.dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

	@Provides
	public static AppMock provideAppMock(Name name) {
		return new AppMock(name);
	}

	@Provides
	public static Name provideName() {
		return new Name() {

			@Override
			public String getName() {
				return "My name";
			}

		};
	}

}
