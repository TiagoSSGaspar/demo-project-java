package br.com.tiago.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory = null;
	
	static {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("projeto01");
		}		
	}
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
