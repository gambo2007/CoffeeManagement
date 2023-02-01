package project.coffee.dto;

public class UserDto {
	private int Login_id;
	private String username;
	private String password;
	private String role;
	private String email;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}




	


	public UserDto(int login_id, String username, String password, String role, String email) {
		super();
		Login_id = login_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getLogin_id() {
		return Login_id;
	}

	public void setLogin_id(int login_id) {
		Login_id = login_id;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
