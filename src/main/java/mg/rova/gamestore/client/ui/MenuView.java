package mg.rova.gamestore.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

public interface MenuView extends IsWidget {

	public void showToast(String message);

	public void showLogout(boolean show);

	public void setPresenter(Presenter presenter);

	public interface Presenter {

		void onHome();

		void onAccount();

		void onApplication();

		void onCreate();

		void onLogin();

		void onLogout();

		void search(String searchValue);
	}
}
