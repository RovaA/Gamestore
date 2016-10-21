package mg.rova.gamestore.client.editor;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.Composite;

import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.html.Option;
import mg.rova.gamestore.shared.Category;

public class CategoryDropdownEditor extends Composite implements LeafValueEditor<Category> {

	private final MaterialListBox listBox = new MaterialListBox();

	public CategoryDropdownEditor() {

		initWidget(listBox);

		for (Category category : Category.values()) {
			listBox.add(new Option(category.toString()));
		}
	}

	@Override
	public void setValue(Category value) {
		if (value == null) {
			listBox.setValue(Category.values()[0].toString());
			return;
		}
		listBox.setValue(value.toString());
	}

	@Override
	public Category getValue() {
		Category value = null;
		for (Category category : Category.values()) {
			if (listBox.getValue().equals(category.toString())) {
				value = category;
				break;
			}
		}
		return value;
	}

}
