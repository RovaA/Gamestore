package mg.rova.gamestore.server.domain.dao;

import mg.rova.gamestore.server.domain.User;

public interface UserDao {
	
	public User create(User user);

	public User authenticate(String username, String password);
	
}
