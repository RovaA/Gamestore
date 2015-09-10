package mg.rova.gamestore.client.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

import mg.rova.gamestore.server.domain.Application;

@ProxyFor(Application.class)
public interface ApplicationProxy extends EntityProxy {

	Long getId();
	
	String getTitle();
	
	String getKeyword();
	
	String getAuthor();
}
