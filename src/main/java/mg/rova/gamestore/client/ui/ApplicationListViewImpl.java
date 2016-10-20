package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardAction;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;
import mg.rova.gamestore.client.proxy.ApplicationProxy;

public class ApplicationListViewImpl extends Composite implements ApplicationListView {

	private static ApplicationListViewImplUiBinder uiBinder = GWT.create(ApplicationListViewImplUiBinder.class);

	interface ApplicationListViewImplUiBinder extends UiBinder<Widget, ApplicationListViewImpl> {
	}

	@UiField
	MaterialButton addButton;
	@UiField
	VerticalPanel panel;

	protected Presenter presenter;

	public ApplicationListViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("addButton")
	public void onAdd(ClickEvent event) {
		presenter.onAdd();
	}

	@Override
	public void addApplication(final ApplicationProxy application) {
		final MaterialCard materialCard = new MaterialCard();

		final MaterialCardContent content = new MaterialCardContent();
		final MaterialCardTitle title = new MaterialCardTitle();
		title.setText(application.getTitle());
		title.setIconType(IconType.DELETE);
		title.setIconPosition(IconPosition.RIGHT);
		title.getIcon().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.remove(application);
				panel.remove(materialCard);
			}

		});
		content.add(title);
		content.add(new MaterialLabel(application.getDescription()));
		materialCard.add(content);

		final MaterialCardAction action = new MaterialCardAction();
		final MaterialLink downloadLink = new MaterialLink();
		downloadLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String url = GWT.getModuleBaseURL() + "download?file=" + application.getPath();
				Window.open(url, "_blank", "status=0,toolbar=0,menubar=0,location=0");
			}
		});
		downloadLink.setText("Download");
		action.add(downloadLink);
		materialCard.add(action);
		panel.add(materialCard);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void showToast(String string) {
		MaterialToast.fireToast(string);
	}

}
