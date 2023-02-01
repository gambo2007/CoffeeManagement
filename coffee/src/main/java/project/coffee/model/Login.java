package project.coffee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Login_id_seq")
	@Column(name= "Login_Id")
	private int Login_id;
	
	@Column(name="username", unique =true)
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name ="Email", unique =true)
	private String email;
	
	@Column(name ="role",nullable = false)
	private String role;
	
	public Login() {
		super();
	}

	
	public Login(int login_id, String username, String password, String email) {
		super();
		this.Login_id = login_id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Login(int login_id, String username, String password, String email, String role) {
		super();
		this.Login_id = login_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public int getLogin_id() {
		return Login_id;
	}

	public void setLogin_id(int login_id) {
		Login_id = login_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	


	
}

