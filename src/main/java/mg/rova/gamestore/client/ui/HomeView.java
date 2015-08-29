package mg.rova.gamestore.client.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.HasData;

public interface HomeView extends IsWidget {
	
	public HasData<String> getHasData();
	
	public void setPresenter(Presenter presenter);

	public interface Presenter {
		
	}
}
