package mg.rova.gamestore.client.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import mg.rova.gamestore.client.editor.ApplicationEditor;
import mg.rova.gamestore.client.place.LoginPlace;
import mg.rova.gamestore.client.proxy.ApplicationProxy;
import mg.rova.gamestore.client.proxy.UserProxy;
import mg.rova.gamestore.client.request.AppRequestFactory;
import mg.rova.gamestore.client.request.ApplicationRequestContext;
import mg.rova.gamestore.client.request.UserRequestContext;
import mg.rova.gamestore.client.rpc.LoginServiceAsync;
import mg.rova.gamestore.client.ui.ApplicationDetailsView;
import mg.rova.gamestore.client.ui.ApplicationDetailsView.Driver;

public class ApplicationDetailsActivity extends AbstractActivity implements ApplicationDetailsView.Presenter {

	protected ApplicationDetailsView view;
	protected PlaceController placeController;
	protected List<Driver> drivers = new ArrayList<Driver>();
	protected AppRequestFactory requestFactory;
	protected LoginServiceAsync loginService;
	protected UserProxy currentUser;

	@Inject
	public ApplicationDetailsActivity(ApplicationDetailsView view, PlaceController placeController, AppRequestFactory requestFactory, LoginServiceAsync loginService) {
		this.view = view;
		this.placeController = placeController;
		this.requestFactory = requestFactory;
		this.loginService = loginService;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);

		loginService.getId(new AsyncCallback<Long>() {

			@Override
			public void onSuccess(Long result) {
				if (result == null) {
					view.showToast("Must be logged first");
					placeController.goTo(new LoginPlace(""));
					return;
				}
				requestFactory.getUserRequestContext().findById(result).fire(new Receiver<UserProxy>() {

					@Override
					public void onSuccess(UserProxy user) {
						currentUser = user;
						for (ApplicationEditor editor : view.getEditors()) {
							newEditor(editor, user);
						}
					}
				});
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});
	}

	public void newEditor(ApplicationEditor editor, UserProxy user) {
		Driver driver = GWT.create(Driver.class);
		driver.initialize(editor);
		final ApplicationRequestContext requestContext = requestFactory.getApplicationRequestContext();
		final ApplicationProxy applicationProxy = requestContext.create(ApplicationProxy.class);
		applicationProxy.setTitle("");
		applicationProxy.setKeyword("");
		applicationProxy.setAuthor("");
		applicationProxy.setDate(new Date());
		applicationProxy.setPath("");
		applicationProxy.setDescription("");
		final UserRequestContext userRequestContext = requestFactory.getUserRequestContext();
		applicationProxy.setUser(userRequestContext.edit(user));
		driver.edit(applicationProxy, requestContext);
		requestContext.create(applicationProxy).to(new Receiver<ApplicationProxy>() {

			@Override
			public void onSuccess(ApplicationProxy response) {

			}
		});
		drivers.add(driver);
	}

	@Override
	public void onSubmit() {
		boolean isDirty = true;
		if (drivers.isEmpty()) {
			return;
		}
		for (Driver driver : drivers) {
			if (!driver.isDirty()) {
				isDirty = false;
				view.showToast("Must assign value to form.");
				break;
			}
		}
		if (isDirty) {
			for (Driver driver : drivers) {
				driver.flush().fire();
			}
		}
	}

	@Override
	public void addNewApplicationEditor(ApplicationEditor applicationEditor) {
		newEditor(applicationEditor, currentUser);
	}

}
