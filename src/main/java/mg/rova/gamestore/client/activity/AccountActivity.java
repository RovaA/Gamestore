package mg.rova.gamestore.client.activity;

import mg.rova.gamestore.client.dagger.AppInjector;
import mg.rova.gamestore.client.ui.AccountView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AccountActivity extends AbstractActivity implements AccountView.Presenter {
	
	protected AppInjector injector;
	protected AccountView view;

	public AccountActivity(AppInjector injector) {
		this.injector = injector;
		view = injector.getAccountView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void onSubmit() {
		
	}

}
