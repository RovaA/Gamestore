package mg.rova.gamestore.server.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import mg.rova.gamestore.server.guice.GuiceFactory;

public class AppGuiceServletContextListener extends GuiceServletContextListener {

	public static ServletContext servletContext_;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		setServletContext(servletContextEvent.getServletContext());
		
		super.contextInitialized(servletContextEvent);
	}

	
	public static void setServletContext(ServletContext context_) {
		servletContext_ = context_;
	}

	@Override
	protected Injector getInjector() {
		return GuiceFactory.getInjector();
	}
}
