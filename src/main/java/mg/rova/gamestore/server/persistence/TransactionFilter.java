package mg.rova.gamestore.server.persistence;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.google.inject.Inject;

public class TransactionFilter implements Filter {

	@Inject
	volatile EntityManager em;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			chain.doFilter(req, res);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
		}
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
