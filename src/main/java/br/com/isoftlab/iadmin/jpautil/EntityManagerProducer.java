package br.com.isoftlab.iadmin.jpautil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	//@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Produces @RequestScoped   
	public EntityManager getEntityManager() {
		//EntityManagerFactory emf=null;
		try {
			emf = Persistence.createEntityManagerFactory("iadmin");
			return emf.createEntityManager();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	//public void close(@Disposes EntityManager manager){
	//	manager.close();
	//}
}