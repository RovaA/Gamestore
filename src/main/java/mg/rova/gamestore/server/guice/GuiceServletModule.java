package mg.rova.gamestore.server.guice;

import com.google.inject.Singleton;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

import mg.rova.gamestore.server.rpc.LoginServiceImpl;
import mg.rova.gamestore.server.servlet.AppRequestFactoryServlet;
import mg.rova.gamestore.server.servlet.ServiceServlet;
import mg.rova.gamestore.server.shiro.guice.GuiceShiroWebModule;

public class GuiceServletModule extends ServletModule {

	@Override
	public void configureServlets() {
		
		install(new JpaPersistModule("persistenceUnit"));
		
		GuiceShiroWebModule.bindGuiceFilter(binder());
		
		bind(AppRequestFactoryServlet.class).in(Singleton.class);
		serve("/gwtRequest").with(AppRequestFactoryServlet.class);
		
		bind(ServiceServlet.class).in(Singleton.class);
		serve("/serviceServlet").with(ServiceServlet.class);
		
		bind(LoginServiceImpl.class).in(Singleton.class);
		serve("/loginRequest").with(LoginServiceImpl.class);
	}
}
