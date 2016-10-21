package mg.rova.gamestore.client.request;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import mg.rova.gamestore.client.proxy.ApplicationProxy;
import mg.rova.gamestore.server.domain.dao.ApplicationDao;
import mg.rova.gamestore.server.domain.locator.DAOServiceLocator;

@Service(value = ApplicationDao.class, locator = DAOServiceLocator.class)
public interface ApplicationRequestContext extends RequestContext {

	Request<ApplicationProxy> create(ApplicationProxy applicationProxy);

	Request<ApplicationProxy> findById(Long id);

	Request<List<ApplicationProxy>> findByUserId(Long userId);

	Request<List<ApplicationProxy>> findByTitle(String title);

	Request<List<ApplicationProxy>> findAll();

	Request<Boolean> remove(Long id);

}
