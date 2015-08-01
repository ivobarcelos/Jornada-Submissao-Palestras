package br.com.isoftlab.submissaoPalestras.mb;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.isoftlab.submissaoPalestras.modelo.User;

@Named
@SessionScoped
public class UserLogBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private User user;

	public void logar(User user) {
		this.user = user;
	}
	
	public boolean isLogado(){
		return user != null;
	}

	public void deslogar() {
		this.user = null;
	}

	public User getUsuario() {
		return user;
	}
}
