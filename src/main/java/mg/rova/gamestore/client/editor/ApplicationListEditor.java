package mg.rova.gamestore.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

import mg.rova.gamestore.client.proxy.ApplicationProxy;

public class ApplicationListEditor extends Composite implements IsEditor<ListEditor<ApplicationProxy, ApplicationEditor>> {

	private static ApplicationListEditorUiBinder uiBinder = GWT.create(ApplicationListEditorUiBinder.class);

	interface ApplicationListEditorUiBinder extends UiBinder<Widget, ApplicationListEditor> {
	}
	
	public interface Presenter {
		
		ApplicationProxy newApplicationProxy();
		
	}

	private class ApplicationEditorSource extends EditorSource<ApplicationEditor> {
		@Override
		public ApplicationEditor create(final int index) {
			ApplicationEditor subEditor = new ApplicationEditor();
			googleEmails.insert(subEditor, index);
			return subEditor;
		}

		@Override
		public void dispose(ApplicationEditor subEditor) {
			subEditor.removeFromParent();
		}

		@Override
		public void setIndex(ApplicationEditor editor, int index) {
			googleEmails.insert(editor, index);
		}
	}

	@UiField
	FlowPanel pWidget;

	@UiField
	Button add;

	@UiField
	FlowPanel googleEmails;

	@UiField
	HTML listName;

	protected ListEditor<ApplicationProxy, ApplicationEditor> editor = ListEditor.of(new ApplicationEditorSource());
	protected Presenter presenter;

	public ApplicationListEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public ListEditor<ApplicationProxy, ApplicationEditor> asEditor() {
		return editor;
	}

	@UiHandler("add")
	void onAdd(ClickEvent event) {
		ApplicationProxy applicationProxy = presenter.newApplicationProxy();
		Window.alert(applicationProxy + " Proxy");
		editor.getList().add(applicationProxy);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
