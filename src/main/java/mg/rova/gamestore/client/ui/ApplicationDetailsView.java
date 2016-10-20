package mg.rova.gamestore.client.ui;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

import mg.rova.gamestore.client.editor.ApplicationEditor;
import mg.rova.gamestore.client.proxy.ApplicationProxy;

public interface ApplicationDetailsView extends IsWidget {

	void showToast(String string);

	List<ApplicationEditor> getEditors();

	public void setPresenter(Presenter presenter);

	interface Driver extends RequestFactoryEditorDriver<ApplicationProxy, ApplicationEditor> {
	}

	public interface Presenter {

		void addNewApplicationEditor(ApplicationEditor applicationEditor);

		void onSubmit();

		void onCancelling();

	}

}
