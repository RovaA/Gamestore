package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import mg.rova.gamestore.client.proxy.UserProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.request.UserRequestContext;
import mg.rova.gamestore.client.ui.CreateAccountView;
import mg.rova.gamestore.client.ui.CreateAccountView.Driver;

public class CreateAccountActivity extends AbstractActivity implements CreateAccountView.Presenter {

	protected CreateAccountView view;
	protected AppRequestFactory requestFactory;
	protected UserRequestContext requestContext;

	@Inject
	public CreateAccountActivity(CreateAccountView view, AppRequestFactory requestFactory) {
		this.view = view;
		this.requestFactory = requestFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
		
		Driver driver = GWT.create(Driver.class);
		driver.initialize(view.getUserEditor());
		
		requestContext = requestFactory.getUserRequestContext();
		UserProxy userProxy = requestContext.create(UserProxy.class);
		driver.edit(userProxy, requestContext);
	}

	@Override
	public void onSend() {
		
	}

	@Override
	public void onCancelling() {
		
	}

}
