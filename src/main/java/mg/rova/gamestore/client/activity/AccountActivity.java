package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import mg.rova.gamestore.client.ui.AccountView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AccountActivity extends AbstractActivity implements AccountView.Presenter {

	protected AccountView view;

	@Inject
	public AccountActivity(AccountView view) {
		this.view = view;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void onEdit() {

	}

}
