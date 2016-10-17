package mg.rova.gamestore.client.proxy;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

import mg.rova.gamestore.server.domain.User;

@ProxyFor(User.class)
public interface UserProxy extends EntityProxy {

	Long getId();

	Long getVersion();

	String getName();

	String getFirstName();

	String getUsername();

	String getPassword();

	List<ApplicationProxy> getApplications();

}
