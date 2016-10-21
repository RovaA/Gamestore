package mg.rova.gamestore.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SearchEvent extends GwtEvent<SearchEventHandler> {

	public static Type<SearchEventHandler> TYPE = new Type<SearchEventHandler>();

	private String search;

	public SearchEvent(String search) {
		this.search = search;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SearchEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SearchEventHandler handler) {
		handler.onSearch(search);
	}

}
