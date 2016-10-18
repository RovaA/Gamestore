package mg.rova.gamestore.server.rpc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import mg.rova.gamestore.client.rpc.LoginService;
import mg.rova.gamestore.server.shiro.TempRealm;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	protected HttpSession httpSession() {
		HttpServletRequest req = getThreadLocalRequest();
		return req.getSession();
	}
	
	public Boolean login(String login, String pwd) {
		return TempRealm.login(login, pwd, httpSession());
	}

	public Boolean isLoggedIn() {
		return TempRealm.isLoggedIn(httpSession());
	}

	public Boolean logout() {
		return TempRealm.logout(httpSession());
	}
}
