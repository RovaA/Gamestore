package mg.rova.gamestore.client.editor;

import org.gwtbootstrap3.client.ui.Button;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class FileUploader{

    private VerticalPanel cp;
    private FormPanel form = new FormPanel();
    private FileUpload fu =  new FileUpload();

    public FileUploader(VerticalPanel cp) {
    	this.cp = cp;
    	this.cp.add(getFileUploaderWidget());
    }

    @SuppressWarnings("deprecation")
    public Widget getFileUploaderWidget() {
    	form.setEncoding(FormPanel.ENCODING_MULTIPART);
    	form.setMethod(FormPanel.METHOD_POST);
    	// form.setAction(/* WHAT SHOULD I PUT HERE */);

    	VerticalPanel holder = new VerticalPanel();

    	fu.setName("upload");
    	holder.add(fu);
    	holder.add(new Button("Submit", new ClickHandler() {
    		public void onClick(ClickEvent event) {
    			GWT.log("You selected: " + fu.getFilename(), null);
    			form.submit();
    		}
    	}));

    	form.addSubmitHandler(new FormPanel.SubmitHandler() {
    		public void onSubmit(SubmitEvent event) {
    			if (!"".equalsIgnoreCase(fu.getFilename())) {
    				GWT.log("UPLOADING FILE????", null);
                                        // NOW WHAT????
    			}
    			else{
    				event.cancel(); // cancel the event
    			}

    		}
    	});

    	form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
    		public void onSubmitComplete(SubmitCompleteEvent event) {
    			Window.alert(event.getResults());
    		}
    	});

    	form.add(holder);

    	return form;
    }
}
