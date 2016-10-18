package mg.rova.gamestore.server.shiro.guice;

import javax.servlet.ServletContext;

import org.apache.shiro.guice.web.ShiroWebModule;

import com.google.inject.Singleton;

import mg.rova.gamestore.server.shiro.realm.AppRealm;

public class GuiceShiroWebModule extends ShiroWebModule {

	public GuiceShiroWebModule(ServletContext servletContext) {
		super(servletContext);
	}

	@Override
	protected void configureShiroWeb() {
		bindRealm().to(AppRealm.class).in(Singleton.class);
	}
}
