package mg.rova.gamestore.server.rpc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import mg.rova.gamestore.client.rpc.LoginService;
import mg.rova.gamestore.server.shiro.LoginRealm;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	protected HttpSession httpSession() {
		HttpServletRequest req = getThreadLocalRequest();
		return req.getSession();
	}

	public Boolean login(String login, String pwd) {
		return LoginRealm.login(login, pwd, httpSession());
	}

	public Boolean isLoggedIn() {
		return LoginRealm.isLoggedIn(httpSession());
	}

	public Boolean logout() {
		return LoginRealm.logout(httpSession());
	}

	public Long getId() {
		return LoginRealm.getId(httpSession());
	}
}
