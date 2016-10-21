package mg.rova.gamestore.server.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import mg.rova.gamestore.server.domain.User;
import mg.rova.gamestore.server.guice.GuiceFactory;

public class UserDaoImpl implements UserDao {

	@Override
	public User persist(User user) {
		Session session = getSession();
		session.beginTransaction().begin();
		session.persist(user);
		session.flush();
		session.beginTransaction().commit();
		return user;
	}

	@Override
	public User authenticate(String username, String password) {
		Session session = getSession();
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.like("username", username)).add(Restrictions.like("password", password));
		session.beginTransaction().commit();
		if (criteria.list().isEmpty())
			return null;
		return (User) criteria.list().get(0);
	}

	@Override
	public User findById(Long id) {
		Session session = getSession();
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.like("id", id));
		session.beginTransaction().commit();
		if (criteria.list().isEmpty())
			return null;
		return (User) criteria.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Session session = getSession();
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(User.class);
		session.beginTransaction().commit();
		return (List<User>) criteria.list();
	}

	@Override
	public boolean remove(Long id) {
		EntityManager entityManager = getEntityManager();
		Session session = getSession();
		session.beginTransaction().begin();
		entityManager.remove(session.get(User.class, id));
		session.flush();
		session.beginTransaction().commit();
		return true;
	}
	
	protected EntityManager getEntityManager() {
		return  GuiceFactory.getInstance(EntityManager.class);
	}
	
	protected Session getSession() {
		return getEntityManager().unwrap(Session.class);
	}

}
