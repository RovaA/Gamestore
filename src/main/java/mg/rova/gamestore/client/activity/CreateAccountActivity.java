package mg.rova.gamestore.client.activity;

import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import mg.rova.gamestore.client.proxy.ApplicationProxy;
import mg.rova.gamestore.client.proxy.UserProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.request.UserRequestContext;
import mg.rova.gamestore.client.ui.CreateAccountView;
import mg.rova.gamestore.client.ui.CreateAccountView.Driver;

public class CreateAccountActivity extends AbstractActivity implements CreateAccountView.Presenter {

	protected CreateAccountView view;
	protected Driver driver;
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
		
		driver = GWT.create(Driver.class);
		driver.initialize(view.getUserEditor());
		
		requestContext = requestFactory.getUserRequestContext();
		UserProxy userProxy = requestContext.create(UserProxy.class);
		userProxy.setName("name");
		userProxy.setFirstname("firstname");
		userProxy.setUsername("username");
		userProxy.setPassword("password");
		userProxy.setApplications(new ArrayList<ApplicationProxy>());
		driver.edit(userProxy, requestContext);
		requestContext.create(userProxy).to(new Receiver<UserProxy>() {

			@Override
			public void onSuccess(UserProxy response) {
				Window.alert("User : " + response.getName());
			}
			
		});
	}

	@Override
	public void onSend() {
		if (driver.isDirty())
			driver.flush().fire();
	}

	@Override
	public void onCancelling() {
		
	}

}
