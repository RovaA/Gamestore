package mg.rova.gamestore.server.domain.dao;

import java.util.List;

import mg.rova.gamestore.server.domain.Application;

public interface ApplicationDao {
	
	public Application create(Application application);
	
	public Application findById(Long id);
	
	public List<Application> findByUserId(Long userId);
	
	public List <Application> findAll();
	
	public boolean remove(Long id);
	
}
