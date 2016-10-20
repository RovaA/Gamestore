package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;

public class ApplicationListViewImpl extends Composite implements ApplicationListView {

	private static ApplicationListViewImplUiBinder uiBinder = GWT.create(ApplicationListViewImplUiBinder.class);

	interface ApplicationListViewImplUiBinder extends UiBinder<Widget, ApplicationListViewImpl> {
	}
	
	@UiField
	MaterialButton addButton;

	protected Presenter presenter;

	public ApplicationListViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("addButton")
	public void onAdd(ClickEvent event) {
		presenter.onAdd();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
