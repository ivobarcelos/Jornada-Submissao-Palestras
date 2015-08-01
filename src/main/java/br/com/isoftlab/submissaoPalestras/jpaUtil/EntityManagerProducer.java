package br.com.isoftlab.submissaoPalestras.jpaUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

	//@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Produces @RequestScoped   
	public EntityManager getEntityManager() {
		try {
			emf = Persistence.createEntityManagerFactory("submissao-palestras");
			return emf.createEntityManager();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public void close(@Disposes EntityManager manager){
		manager.close();
	}
}