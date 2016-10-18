package mg.rova.gamestore.server.guice;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.guice.aop.ShiroAopModule;
import org.apache.shiro.mgt.SecurityManager;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;

import mg.rova.gamestore.server.servlet.AppGuiceServletContextListener;

public class GuiceFactory {

	protected static Injector injector;

	static {

	}

	private static class WebInitializer {
		@Inject
		WebInitializer() {
			final SecurityManager securityManager_ = injector.getInstance(SecurityManager.class);
			SecurityUtils.setSecurityManager(securityManager_);
		}
	}

	/**
	 * Creates the JPA service for Hibernate
	 */
	protected static class JPAInitializer {

		@Inject
		JPAInitializer(PersistService service) {
			service.start();
		}
	}

	protected static void initInjector() {
		injector = Guice.createInjector(new GuiceModule(), new ShiroAopModule(), new GuiceShiroWebModule(AppGuiceServletContextListener.servletContext_), new GuiceServletModule());
		try {
			injector.getInstance(WebInitializer.class);
			// injector.getInstance(JPAInitializer.class);
		} catch (NullPointerException npe_) {
		}
	}

	public static <A> A getInstance(Class<A> clazz) {
		if (injector == null)
			initInjector();
		return injector.getInstance(clazz);
	}

	public static Injector getInjector() {
		if (injector == null)
			initInjector();
		return injector;
	}

	public static void setInjector(Injector injector) {
		GuiceFactory.injector = injector;
	}
}
