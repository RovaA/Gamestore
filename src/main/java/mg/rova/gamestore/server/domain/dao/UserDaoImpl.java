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
		Session session = GuiceFactory.getInstance(EntityManager.class).unwrap(Session.class);
		session.beginTransaction().begin();
		session.persist(user);
		session.flush();
		session.beginTransaction().commit();
		return user;
	}

	@Override
	public User authenticate(String username, String password) {
		Session session = GuiceFactory.getInstance(EntityManager.class).unwrap(Session.class);
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.like("username", username)).add(Restrictions.like("password", password));
		session.beginTransaction().commit();
		return (User) criteria.list().get(0);
	}

	@Override
	public User findById(Long id) {
		Session session = GuiceFactory.getInstance(EntityManager.class).unwrap(Session.class);
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.like("id", id));
		session.beginTransaction().commit();
		return (User) criteria.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Session session = GuiceFactory.getInstance(EntityManager.class).unwrap(Session.class);
		session.beginTransaction().begin();
		Criteria criteria = session.createCriteria(User.class);
		session.beginTransaction().commit();
		return (List<User>) criteria.list();
	}

	@Override
	public boolean remove(Long id) {
		EntityManager entityManager = GuiceFactory.getInstance(EntityManager.class);
		Session session = entityManager.unwrap(Session.class);
		session.beginTransaction().begin();
		entityManager.remove(session.get(User.class, id));
		session.flush();
		session.beginTransaction().commit();
		return true;
	}

}
