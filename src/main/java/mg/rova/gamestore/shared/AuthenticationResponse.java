package mg.rova.gamestore.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AuthenticationResponse implements IsSerializable {
	
	public enum LoginState {
		
		LOGGED_IN, NOT_LOGGED_IN;
	}
	
	protected LoginState state; 
	
	public void setState(LoginState state) {
		this.state = state;
	}
	
	public LoginState getState() {
		return state;
	}
}
