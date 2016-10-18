package mg.rova.gamestore.server.rpc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import mg.rova.gamestore.client.rpc.LoginService;
import mg.rova.gamestore.shared.AuthenticationResponse;
import mg.rova.gamestore.shared.AuthenticationResponse.LoginState;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public AuthenticationResponse isLogged() {
		final AuthenticationResponse response = new AuthenticationResponse();
		Subject subject = SecurityUtils.getSubject();
		LoginState state = subject.isAuthenticated() ? LoginState.LOGGED_IN : LoginState.NOT_LOGGED_IN;
		response.setState(state);
		return response;
	}

	@Override
	public String getUsername() {
		Subject subject = SecurityUtils.getSubject();
		return String.valueOf(subject.getPrincipal());
	}

	@Override
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated())
			subject.logout();
	}
}
