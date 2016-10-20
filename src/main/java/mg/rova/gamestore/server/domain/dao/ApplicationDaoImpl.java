package mg.rova.gamestore.server.domain.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import mg.rova.gamestore.server.domain.Application;
import mg.rova.gamestore.server.guice.GuiceFactory;

public class ApplicationDaoImpl implements ApplicationDao {

	public ApplicationDaoImpl() {

	}

	@Override
	public Application create(Application application) {
		Session session = GuiceFactory.getInstance(EntityManager.class).unwrap(Session.class);
		session.beginTransaction().begin();
		session.persist(application);
		session.flush();
		session.beginTransaction().commit();
		return application;
	}

}
