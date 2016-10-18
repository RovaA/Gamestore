package mg.rova.gamestore.server.persistence;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;

public class PersistenceFilter implements Filter {

	private EntityManagerFactory factory;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		factory = Persistence.createEntityManagerFactory("persistenceUnit");
	}

	@Override
	public void destroy() {
		factory.close();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		EntityManager entityManager = factory.createEntityManager();
		ThreadLocalEntityManager.set(entityManager);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			chain.doFilter(request, response);
			entityManager.unwrap(Session.class).flush();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}
}