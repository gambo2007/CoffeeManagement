package project.coffee.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Customer_seq")
	@Column(name = "Cus_id")
	private int Cus_id;
	
	@Column(name="Cus_Name")
	private String cus_name;
	
	@Column(name="BirthDate")
	private Date bod;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="PhoneNumber")
	private String phoneNumber;
	
	@Column(name="Email")
	private String email;
	
	@OneToOne
	@JoinColumn(name="username")
	private Login username;
	
	@OneToMany(mappedBy = "Menu")
	Set<OrderCoffee> orderlist;
	
	public Login getUsername() {
		return username;
	}
	public void setUsername(Login username) {
		this.username = username;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
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
	
	public int getCus_id() {
		return Cus_id;
	}
	public void setCus_id(int cus_id) {
		Cus_id = cus_id;
	}
	

	public Customer(int cus_id, String cus_name, Date bod, String address, String phoneNumber, String email) {
		super();
		Cus_id = cus_id;
		this.cus_name = cus_name;
		this.bod = bod;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public Customer() {
		super();
	}
	
}

