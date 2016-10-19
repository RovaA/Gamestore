package mg.rova.gamestore.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

public interface LoginView extends IsWidget {

	public void showToast(String message);

	public void clear();

	public void setPresenter(Presenter presenter);

	public interface Presenter {

		void onLogin(String username, String password);

		void onCancelling();

	}

}
