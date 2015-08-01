package br.com.isoftlab.submissaoPalestras.jpaUtil;

import javax.enterprise.inject.Produces;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFactoryProducer {

	@Produces
	public EntityManagerFactory cria() {
		return  Persistence.createEntityManagerFactory("submissao-palestras");
	}
}
