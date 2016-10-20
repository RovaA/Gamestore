package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationDetailsViewImpl extends Composite implements ApplicationDetailsView {

	private static ApplicationDetailsViewImplUiBinder uiBinder = GWT.create(ApplicationDetailsViewImplUiBinder.class);

	interface ApplicationDetailsViewImplUiBinder extends UiBinder<Widget, ApplicationDetailsViewImpl> {
	}
	
	protected Presenter presenter;

	public ApplicationDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
