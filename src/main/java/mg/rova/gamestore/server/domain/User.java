package mg.rova.gamestore.server.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Long id;

	private Long version;

	private String name;

	private String firstname;

	private String username;

	private String password;

	private List<Application> applications = new ArrayList<Application>();

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public void addApplication(Application application) {
		if (application == null)
			return;
		applications.add(application);
	}

	public void removeApplication(Application application) {
		if (application == null)
			return;
		applications.remove(application);
	}
	
	public static User findUser(Long id) {
		return null;
	}

}
