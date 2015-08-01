package br.com.isoftlab.submissaoPalestras.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;

@Entity(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 6801892773581942231L;
	
	public User(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique=true, nullable=false)
	private int id;
	
	@Column(name="login", nullable=false)
	@Email
	private String login;
	
	@Column(name="password", nullable=false)
	private String password;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
