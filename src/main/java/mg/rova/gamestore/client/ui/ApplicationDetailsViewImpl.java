package mg.rova.gamestore.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialToast;
import mg.rova.gamestore.client.editor.ApplicationEditor;

public class ApplicationDetailsViewImpl extends Composite implements ApplicationDetailsView {

	private static ApplicationDetailsViewImplUiBinder uiBinder = GWT.create(ApplicationDetailsViewImplUiBinder.class);

	interface ApplicationDetailsViewImplUiBinder extends UiBinder<Widget, ApplicationDetailsViewImpl> {
	}

	@UiField
	VerticalPanel container;
	@UiField
	MaterialButton addButton;
	@UiField
	MaterialButton submitButton;
	@UiField
	MaterialButton cancelButton;

	protected Presenter presenter;
	protected List<ApplicationEditor> applicationsEditors = new ArrayList<ApplicationEditor>();

	public ApplicationDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		final ApplicationEditor applicationEditor = new ApplicationEditor(this);
		container.add(applicationEditor);
		applicationsEditors.add(applicationEditor);
	}

	@UiHandler("addButton")
	public void onAdd(ClickEvent event) {
		final ApplicationEditor applicationEditor = new ApplicationEditor(this);
		container.add(applicationEditor);
		applicationsEditors.add(applicationEditor);
		presenter.addNewApplicationEditor(applicationEditor);
	}

	@UiHandler("submitButton")
	public void onSubmit(ClickEvent event) {
		presenter.onSubmit();
	}

	@UiHandler("cancelButton")
	public void onCancel(ClickEvent event) {
		presenter.onCancelling();
	}

	public void deleteEditor(ApplicationEditor editor) {
		presenter.onDeleteEditor(editor);
		container.remove(editor);
		applicationsEditors.remove(editor);
	}

	@Override
	public List<ApplicationEditor> getEditors() {
		return applicationsEditors;
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
