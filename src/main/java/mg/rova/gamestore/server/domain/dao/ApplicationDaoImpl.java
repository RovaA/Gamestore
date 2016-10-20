package mg.rova.gamestore.server.domain.dao;

import java.util.List;

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
		final Session session = getSession();
		session.beginTransaction().begin();
		session.persist(application);
		session.flush();
		session.beginTransaction().commit();
		return application;
	}

	@Override
	public Application findById(Long id) {
		final Session session = getSession();
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(Application.class).add(Restrictions.like("id", id));
		session.beginTransaction().commit();
		return (Application) criteria.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Application> findAll() {
		final Session session = getSession();
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(Application.class);
		session.beginTransaction().commit();
		return (List<Application>) criteria.list();
	}

	@Override
	public boolean remove(Long id) {
		EntityManager entityManager = getEntityManager();
		final Session session = entityManager.unwrap(Session.class);
		session.beginTransaction().begin();
		entityManager.remove(session.get(Application.class, id));
		session.flush();
		session.beginTransaction().commit();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Application> findByUserId(Long userId) {
		final Session session = getSession();
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(Application.class).add(Restrictions.like("user.id", userId));
		session.beginTransaction().commit();
		return (List<Application>) criteria.list();
	}
	
	protected EntityManager getEntityManager() {
		return  GuiceFactory.getInstance(EntityManager.class);
	}
	
	protected Session getSession() {
		return getEntityManager().unwrap(Session.class);
	}

}
