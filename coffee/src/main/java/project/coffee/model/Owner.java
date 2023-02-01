package project.coffee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Owner")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@Column(name = "Owner_Id")
	private int OwnerId;
	
	@Column(name="Ownername",unique =true)
	private String ownerName;
	
	@Column(name ="Birthdate")
	private Date bod;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="PhoneNumber" , unique =true)
	private String phoneNumber;
	
	@Column(name="Email", unique = true)
	private String email;

	public Owner(int ownerId, String ownerName, Date bod, String address, String phoneNumber, String email) {
		super();
		this.OwnerId = ownerId;
		this.ownerName = ownerName;
		this.bod = bod;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Owner() {
		super();
	}

	public int getOwnerId() {
		return OwnerId;
	}

	public void setOwnerId(int ownerId) {
		OwnerId = ownerId;
	}

	

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
