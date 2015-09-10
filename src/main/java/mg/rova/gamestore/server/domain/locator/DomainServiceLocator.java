package mg.rova.gamestore.server.domain.locator;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class DomainServiceLocator implements ServiceLocator {

	@Override
	public Object getInstance(Class<?> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
