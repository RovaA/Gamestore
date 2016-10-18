package mg.rova.gamestore.server.persistence;

import javax.persistence.EntityManager;

public class ThreadLocalEntityManager {

	private static ThreadLocal<EntityManager> holder = new ThreadLocal<EntityManager>();

	private ThreadLocalEntityManager() {
	}

	public static EntityManager get() {
		return holder.get();
	}

	public static void set(EntityManager em) {
		holder.set(em);
	}
}