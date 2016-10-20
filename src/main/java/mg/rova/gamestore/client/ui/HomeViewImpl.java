package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardAction;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import mg.rova.gamestore.client.proxy.ApplicationProxy;

public class HomeViewImpl extends Composite implements HomeView {

	private static HomeViewImplUiBinder uiBinder = GWT.create(HomeViewImplUiBinder.class);

	interface HomeViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}

	@UiField
	protected VerticalPanel panel;

	protected Presenter presenter;

	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public VerticalPanel getPanel() {
		return panel;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void addApplication(ApplicationProxy application) {
		final MaterialCard materialCard = new MaterialCard();

		final MaterialCardContent content = new MaterialCardContent();
		final MaterialCardTitle title = new MaterialCardTitle();
		title.setText(application.getTitle());
		content.add(title);
		content.add(new MaterialLabel(application.getDescription()));
		materialCard.add(content);

		final MaterialCardAction action = new MaterialCardAction();
		final MaterialLink downloadLink = new MaterialLink();
		downloadLink.setText("Download");
		action.add(downloadLink);
		materialCard.add(action);
		panel.add(materialCard);
	}

}
