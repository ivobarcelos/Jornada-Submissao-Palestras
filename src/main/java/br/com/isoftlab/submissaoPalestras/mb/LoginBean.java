package br.com.isoftlab.submissaoPalestras.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.isoftlab.submissaoPalestras.dao.UserDao;
import br.com.isoftlab.submissaoPalestras.modelo.User;
import br.com.isoftlab.submissaoPalestras.tx.Transactional;

@Named
@RequestScoped
@Transactional
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -2453714083792366754L;

	@Inject
	Event<User> eventoLogin;

	
	private User user = new User();
	
	@Inject
	private UserDao dao;

	@Inject
	private UserLogBean userLogged;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String efetuaLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		boolean loginValido = dao.exist(this.user);
		if (loginValido) {
			userLogged.logar(user);
			//eventoLogin.fire(usuario);
			
			
			FacesMessage mensagem = new FacesMessage("Usuário/senha Válidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage(null, mensagem);
			
			return "/pages/main?faces-redirect=true";
		} else {
			FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
			userLogged.deslogar();
			this.user = new User();
			return "index";
		}
	}

	public String logout() {
		this.userLogged.deslogar();
		return "index?faces-redirect=true";
	}
}
