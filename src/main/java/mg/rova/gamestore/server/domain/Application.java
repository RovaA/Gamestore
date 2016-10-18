package mg.rova.gamestore.server.domain;

import java.util.Date;

public class Application {

	private Long id;

	private Integer version;

	private String title;

	private String keyword;

	private String Author;

	private Date date;

	private String path;

	private String description;

	public Application() {

	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersion() {
		return version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Application findApplication(Long id) {
		return null;
	}
}
