package project.coffee.dto;

import java.util.Date;

public class CustomerRegistrationDto {

	private int CusId;
	private String cusName;
	private Date bod;
	private String address;
	private String phoneNumber;
	private String email;
	
	private int Login_id;
	private String username;
	private String password;
	public CustomerRegistrationDto() {
		super();
	}
	public CustomerRegistrationDto(int CusId, String cusName, Date bod, String address, String phoneNumber,
			String email, int login_id, String username, String password) {
		super();
		this.CusId = CusId;
		this.cusName = cusName;
		this.bod = bod;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.Login_id = login_id;
		this.username = username;
		this.password = password;
	}
	
	public int getCusId() {
		return CusId;
	}
	public void setCusId(int cusId) {
		CusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public Date getBod() {
		return bod;
	}
	public void setBod(Date bod) {
		this.bod = bod;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	
}
