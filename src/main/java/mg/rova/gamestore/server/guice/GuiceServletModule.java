package mg.rova.gamestore.server.guice;

import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

import mg.rova.gamestore.server.servlet.AppRequestFactoryServlet;

public class GuiceServletModule extends ServletModule {

	@Override
	public void configureServlets() {

		bind(ExceptionFilter.class).in(Singleton.class);
		filter("/*").through(ExceptionFilter.class);

		install(new JpaPersistModule("persistenceUnit"));
		filter("/*").through(PersistFilter.class);		

		GuiceShiroWebModule.bindGuiceFilter(binder());
		
		bind(AppRequestFactoryServlet.class).in(Singleton.class);
		serve("/gwtRequest").with(AppRequestFactoryServlet.class);
		
	}
}