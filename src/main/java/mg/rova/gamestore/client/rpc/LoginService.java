package mg.rova.gamestore.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;

import mg.rova.gamestore.shared.AuthenticationResponse;

public interface LoginService extends RemoteService {
	
	String getUsername();

	AuthenticationResponse isLogged();

	void logout();
}
