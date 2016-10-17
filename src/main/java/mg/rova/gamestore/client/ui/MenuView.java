package mg.rova.gamestore.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

public interface MenuView extends IsWidget {
	
	public void setPresenter(Presenter presenter);

	public interface Presenter {
		
		void onHome();
		
		void onAccount();
		
		void onCreate();
		
		void onLogin();
	}
}
