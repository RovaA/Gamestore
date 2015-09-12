package mg.rova.gamestore.client.ui;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;

public class HomeViewImpl extends Composite implements HomeView {

	private static HomeViewImplUiBinder uiBinder = GWT.create(HomeViewImplUiBinder.class);

	interface HomeViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}

	interface Templates extends SafeHtmlTemplates {

		@SafeHtmlTemplates.Template("<div><h4>{0}</h4><br/><span>{1}</span></div>")
		SafeHtml cell(SafeHtml title, SafeHtml subtitle);
	}

	@UiField(provided = true)
	protected CellTable<String> cellTable = new CellTable<String>();

	protected Presenter presenter;

	public HomeViewImpl() {
		cellTable.addColumn(new Column<String, String>(new ApplicationCell()) {

			@Override
			public String getValue(String arg0) {
				return arg0;
			}

		});
		cellTable.setWidth("100%");
		initWidget(uiBinder.createAndBindUi(this));
	}

	static class ApplicationCell extends AbstractCell<String> {

		private static Templates templates = GWT.create(Templates.class);

		@Override
		public void render(Context context, String value, SafeHtmlBuilder sb) {

			if (value == null) {
				return;
			}

			SafeHtml safeValueTitle = SafeHtmlUtils.fromString(value);
			SafeHtml safeValueSubtitle = SafeHtmlUtils.fromString("Subtitle");
			
			SafeHtml rendered = templates.cell(safeValueTitle, safeValueSubtitle);
			sb.append(rendered);
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasData<String> getHasData() {
		return cellTable;
	}
}
