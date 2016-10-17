package mg.rova.gamestore.client.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface AppRequestFactory extends RequestFactory {
	
	UserRequestContext getUserRequestContext();

	ApplicationRequestContext getApplicationRequestContext();

}
