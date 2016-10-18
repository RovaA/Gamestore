package mg.rova.gamestore.server.domain.locator;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

import mg.rova.gamestore.server.guice.GuiceFactory;

public class DAOServiceLocator implements ServiceLocator {

	@Override
	public Object getInstance(Class<?> clazz) {
		return GuiceFactory.getInstance(clazz);
	}

}
