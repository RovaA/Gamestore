package mg.rova.gamestore.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import mg.rova.gamestore.client.ui.CreateAccountView;

public class CreateAccountActivity extends AbstractActivity implements CreateAccountView.Presenter {

	protected CreateAccountView view;

	@Inject
	public CreateAccountActivity(CreateAccountView view) {
		this.view = view;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

}
