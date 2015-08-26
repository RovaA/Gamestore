package mg.rova.gamestore.client.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainUi extends Composite {

	private static MainUiUiBinder uiBinder = GWT.create(MainUiUiBinder.class);

	interface MainUiUiBinder extends UiBinder<Widget, MainUi> {
	}

	@UiField
	DockLayoutPanel dockLayoutPanel;
	@UiField
	ScrollPanel northLayoutPanel;
	@UiField
	ScrollPanel centerLayoutPanel;
	@UiField
	ScrollPanel westLayoutPanel;
	@UiField
	ScrollPanel eastLayoutPanel;

	public MainUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public DockLayoutPanel getDockLayoutPanel() {
		return dockLayoutPanel;
	}

	public ScrollPanel getNorthLayoutPanel() {
		return northLayoutPanel;
	}

	public ScrollPanel getCenterLayoutPanel() {
		return centerLayoutPanel;
	}

	public ScrollPanel getWestLayoutPanel() {
		return westLayoutPanel;
	}

	public ScrollPanel getEastLayoutPanel() {
		return eastLayoutPanel;
	}
}
