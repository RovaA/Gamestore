package mg.rova.gamestore.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

public interface ApplicationDetailsView extends IsWidget {

	public void setPresenter(Presenter presenter);

	public interface Presenter {

		void onSubmit();

	}

}
