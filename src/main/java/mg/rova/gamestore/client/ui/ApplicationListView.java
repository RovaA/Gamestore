package mg.rova.gamestore.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

import mg.rova.gamestore.client.proxy.ApplicationProxy;

public interface ApplicationListView extends IsWidget {

	void clear();

	void showToast(String string);

	void addApplication(ApplicationProxy application);

	public void setPresenter(Presenter presenter);

	public interface Presenter {

		void onAdd();

		void remove(ApplicationProxy application);

	}

}
