package mg.rova.gamestore.client.request;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import mg.rova.gamestore.client.proxy.UserProxy;
import mg.rova.gamestore.server.domain.dao.UserDao;
import mg.rova.gamestore.server.domain.locator.DAOServiceLocator;

@Service(value = UserDao.class, locator = DAOServiceLocator.class)
public interface UserRequestContext extends RequestContext {

	Request<UserProxy> persist(UserProxy userProxy);

	Request<UserProxy> findById(Long id);

	Request<List<UserProxy>> findAll();

	Request<Boolean> remove(Long id);

}
