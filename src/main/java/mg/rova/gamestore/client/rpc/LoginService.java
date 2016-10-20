package mg.rova.gamestore.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	
	Boolean login(String login, String pwd);

	Boolean isLoggedIn();
	
	Boolean logout();
	
	Long getId();

}
