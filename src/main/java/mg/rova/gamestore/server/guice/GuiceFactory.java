package mg.rova.gamestore.server.guice;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.guice.aop.ShiroAopModule;
import org.apache.shiro.mgt.SecurityManager;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import mg.rova.gamestore.server.servlet.AppGuiceServletContextListener;
import mg.rova.gamestore.server.shiro.guice.GuiceShiroWebModule;

public class GuiceFactory {

	protected static Injector injector = Guice.createInjector(new GuiceModule(),
			new ShiroAopModule(),
			new GuiceShiroWebModule(AppGuiceServletContextListener.servletContext_),
			new GuiceServletModule());

	static {
		try {
			injector.getInstance(WebInitializer.class);
		} catch (NullPointerException npe_) {
		}
	}
	
	private static class WebInitializer {
		@Inject
		WebInitializer() {
			final SecurityManager securityManager_ = injector.getInstance(SecurityManager.class);
			SecurityUtils.setSecurityManager(securityManager_);	
		}
	}
	
	public static <A> A getInstance(Class<A> clazz) {
		return injector.getInstance(clazz);
	}

	public static Injector getInjector() {
		return injector;
	}
}
