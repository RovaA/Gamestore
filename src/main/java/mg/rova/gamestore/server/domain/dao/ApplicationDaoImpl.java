package mg.rova.gamestore.server.domain.dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

	@Override
	public Application findById(Long id) {
		Session session = GuiceFactory.getInstance(EntityManager.class).unwrap(Session.class);
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(Application.class).add(Restrictions.like("id", id));
		session.beginTransaction().commit();
		return (Application) criteria.list().get(0);
	}

}
