package mg.rova.gamestore.server.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import mg.rova.gamestore.server.domain.dao.ApplicationDao;
import mg.rova.gamestore.server.domain.dao.ApplicationDaoImpl;
import mg.rova.gamestore.server.domain.dao.UserDao;
import mg.rova.gamestore.server.domain.dao.UserDaoImpl;

public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(UserDao.class).to(UserDaoImpl.class).in(Singleton.class);
		bind(ApplicationDao.class).to(ApplicationDaoImpl.class).in(Singleton.class);
	}

}
