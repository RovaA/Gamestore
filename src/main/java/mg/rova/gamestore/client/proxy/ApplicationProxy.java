package mg.rova.gamestore.client.proxy;

import java.util.Date;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

import mg.rova.gamestore.server.domain.Application;
import mg.rova.gamestore.shared.Category;

@ProxyFor(Application.class)
public interface ApplicationProxy extends EntityProxy {

	Long getId();
	
	String getTitle();

	void setTitle(String title);
	
	String getKeyword();

	void setKeyword(String keyword);
	
	String getAuthor();

	void setAuthor(String author);

	Date getDate();

	void setDate(Date date);
	
	String getPath();

	void setPath(String path);

	String getDescription();

	void setDescription(String description);
	
	Category getCategory();

	void setCategory(Category category);
	
	UserProxy getUser();

	void setUser(UserProxy user);
	
}
