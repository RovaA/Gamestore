package mg.rova.gamestore.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void login(String login, String pwd, AsyncCallback<Boolean> asyncCallback);

	void isLoggedIn(AsyncCallback<Boolean> asyncCallback);
	
	void logout(AsyncCallback<Boolean> asyncCallback);

	void getId(AsyncCallback<Long> callback);
	
}
