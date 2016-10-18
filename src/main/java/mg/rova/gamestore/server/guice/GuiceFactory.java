package mg.rova.gamestore.server.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;

public class GuiceFactory {

	protected static Injector injector;

	static {

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
		injector = Guice.createInjector(new GuiceModule(), new GuiceServletModule());
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
