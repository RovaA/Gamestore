package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import mg.rova.gamestore.client.place.ApplicationDetailsPlace;
import mg.rova.gamestore.client.ui.ApplicationListView;

public class ApplicationListActivity extends AbstractActivity implements ApplicationListView.Presenter {

	protected ApplicationListView view;
	protected PlaceController placeController;

	@Inject
	public ApplicationListActivity(ApplicationListView view, PlaceController placeController) {
		this.view = view;
		this.placeController = placeController;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void onAdd() {
		placeController.goTo(new ApplicationDetailsPlace(""));
	}

}
