package mg.rova.gamestore.client.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

import mg.rova.gamestore.client.editor.UserEditor;
import mg.rova.gamestore.client.proxy.UserProxy;

public interface CreateAccountView extends IsWidget {
	
	public UserEditor getUserEditor();
	
	public void showToast(String message);
	
	public void setPresenter(Presenter presenter);

	interface Driver extends RequestFactoryEditorDriver<UserProxy, UserEditor> {
	}

	public interface Presenter {
		
		void onSend();
		
		void onCancelling();
		
	}

}
