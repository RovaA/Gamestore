package mg.rova.gamestore.server.guice;

import java.io.IOException;

import javax.persistence.EntityManager;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import mg.rova.gamestore.server.persistence.ThreadLocalEntityManager;

public class EntityManagerModule extends AbstractModule {

	@Override
	protected void configure() {
	}
	
	//@Singleton
	@Provides
	public EntityManager entityManager() throws IOException {
		return ThreadLocalEntityManager.get();
	}

}
