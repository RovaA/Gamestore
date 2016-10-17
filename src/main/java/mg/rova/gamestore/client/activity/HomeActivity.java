package mg.rova.gamestore.client.activity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.ui.HomeView;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {

	protected HomeView view;
	protected AsyncDataProvider<String> dataProvider;
	protected HasData<String> dataDisplay;
	protected AppRequestFactory requestFactory;

	@Inject
	public HomeActivity(HomeView view, AppRequestFactory requestFactory) {
		this.view = view;
		this.requestFactory = requestFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		dataProvider = new AsyncDataProvider<String>() {

			@Override
			protected void onRangeChanged(HasData<String> hasData) {
				if (dataDisplay == null)
					dataDisplay = hasData;
				findData();
			}
		};
		dataProvider.addDataDisplay(view.getHasData());
		panel.setWidget(view);
	}

	protected void findData() {
		final List<String> listToWrap = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			listToWrap.add(i + " " + i + "" + i + "" + i + "" + i + "" + i + "");
		}
		dataDisplay.setRowData(0, listToWrap);
		dataDisplay.setRowCount(listToWrap.size());
	}
}
