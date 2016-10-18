package mg.rova.gamestore.server.domain.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import mg.rova.gamestore.server.domain.User;
import mg.rova.gamestore.server.guice.GuiceFactory;

public class UserDaoImpl implements UserDao {

	@Override
	public User create(User user) {
		System.out.println("Name : " + user.getName());
		Session session = GuiceFactory.getInstance(EntityManager.class).unwrap(Session.class);
		session.beginTransaction().begin();
		session.persist(user);
		session.flush();
		session.beginTransaction().commit();
		return user;
	}

}
