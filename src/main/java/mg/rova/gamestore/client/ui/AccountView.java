package mg.rova.gamestore.client.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

import mg.rova.gamestore.client.editor.UserEditor;
import mg.rova.gamestore.client.proxy.UserProxy;

public interface AccountView extends IsWidget {

	UserEditor getEditor();

	void showToast(String string);

	public void setPresenter(Presenter presenter);

	interface Driver extends RequestFactoryEditorDriver<UserProxy, UserEditor> {
	}

	public interface Presenter {

		void onEdit();

		void onCancelling();
	}
}
