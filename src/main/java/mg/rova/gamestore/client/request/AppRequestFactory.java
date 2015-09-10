package mg.rova.gamestore.client.request;

import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

import mg.rova.gamestore.server.domain.dao.ApplicationDAO;
import mg.rova.gamestore.server.domain.locator.DomainServiceLocator;

public interface AppRequestFactory extends RequestFactory {

	@Service(value = ApplicationDAO.class, locator = DomainServiceLocator.class)
	interface ApplicationRequestContext extends RequestContext {
	
	}
	
	ApplicationRequestContext getApplicationRequestContext();
}
