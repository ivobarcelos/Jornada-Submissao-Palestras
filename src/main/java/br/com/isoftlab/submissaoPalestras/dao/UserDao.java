package br.com.isoftlab.submissaoPalestras.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.isoftlab.submissaoPalestras.modelo.User;

@Stateless
public class UserDao {
	
	@Inject
	EntityManager manager;
	
	public boolean exist(User user){
		
		boolean ret = false;
		
		String sQuery = "from ";
		sQuery += "user u ";
		sQuery += "where ";
		sQuery += "u.login = :pLogin and ";
		sQuery += "u.password = :pPassword ";
		
		try {			
			Query query = manager.createQuery(sQuery);
			query.setParameter("pLogin", user.getLogin());
			query.setParameter("pPassword",user.getPassword());
			
			ret = !query.getResultList().isEmpty();
		} catch (Exception e) {
		}
		
		return ret; 
	}
	
	

}
