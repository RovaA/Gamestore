package mg.rova.gamestore.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import mg.rova.gamestore.client.gin.ClientGinjector;
import mg.rova.gamestore.client.ui.AccountView;

public class AccountActivity extends AbstractActivity implements AccountView.Presenter {
	
	protected ClientGinjector injector;
	protected AccountView view;

	public AccountActivity(ClientGinjector injector) {
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
