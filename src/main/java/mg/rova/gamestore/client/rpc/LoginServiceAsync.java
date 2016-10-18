package mg.rova.gamestore.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import mg.rova.gamestore.shared.AuthenticationResponse;

public interface LoginServiceAsync {

	void isLogged(AsyncCallback<AuthenticationResponse> callback);

	void getUsername(AsyncCallback<String> callback);

	void logout(AsyncCallback<Void> callback);
}
