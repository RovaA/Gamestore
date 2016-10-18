package mg.rova.gamestore.server.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import mg.rova.gamestore.server.domain.dao.ApplicationDao;
import mg.rova.gamestore.server.domain.dao.UserDao;

public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(UserDao.class).in(Singleton.class);
		bind(ApplicationDao.class).in(Singleton.class);
	}

}
