package mg.rova.gamestore.client.editor;

import java.io.IOException;
import java.util.List;

import org.gwtbootstrap3.client.ui.ValueListBox;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.Composite;

import mg.rova.gamestore.client.proxy.ApplicationProxy;

public class ApplicationListEditor extends Composite implements LeafValueEditor<List<ApplicationProxy>> {

	protected ValueListBox<ApplicationProxy> applicationsListBox;

	public ApplicationListEditor() {
		applicationsListBox = new ValueListBox<ApplicationProxy>(new Renderer<ApplicationProxy>() {

			@Override
			public String render(ApplicationProxy object) {
				return object.getTitle();
			}

			@Override
			public void render(ApplicationProxy object, Appendable appendable) throws IOException {
				if (object == null)
					return;
				appendable.append(object.getTitle());
			}
		});
		initWidget(applicationsListBox);
	}

	@Override
	public void setValue(List<ApplicationProxy> value) {

	}

	@Override
	public List<ApplicationProxy> getValue() {
		return null;
	}

}
