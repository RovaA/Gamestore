package mg.rova.gamestore.client.dagger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppMock {

	private Name name;

	@Inject
	public AppMock(Name name) {
		this.name = name;
	}

	public Name getName() {
		return name;
	}

}
