package project.coffee.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@Column(name = "Cus_Id")
	private int CusId;
	
	@Column(name="Cus_Name", unique = true)
	private String cusName;
	
	@Column(name="Birthdate")
	private Date bod;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="PhoneNumber" , unique =true)
	private String phoneNumber;
	
	@Column(name="Email", unique = true)
	private String email;
	
	
	@OneToMany(mappedBy="customer")
    private Set<Customer_Order> customer_order;
	
	
	
	
	
	
	public Customer(int cusId, String cusName, Date bod, String address, String phoneNumber, String email,
			Set<Customer_Order> customer_order) {
		super();
		CusId = cusId;
		this.cusName = cusName;
		this.bod = bod;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.customer_order = customer_order;
	}



	public Customer() {
		super();
	}



	public Set<Customer_Order> getCustomer_order() {
		return customer_order;
	}
	public void setCustomer_order(Set<Customer_Order> customer_order) {
		this.customer_order = customer_order;
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
	


	
	
}

