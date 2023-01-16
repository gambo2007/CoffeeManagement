package project.coffee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name ="Customer_Order")
public class OrderCoffee {
	@Id
	int Ord_id;
	
	/*
	@Column(name="Cus_id")
	int Cus_id;*/
	
	/*
	@Column(name="Coffee_id")
	int Coffee_id;*/
	
	@Column(name="status")
	int status;
	
	@Column(name="Ord_Date")
	Date Ord_Date;
	
	@Id
	@ManyToOne
    @MapsId("coffee_id")
    @JoinColumn(name = "Coffee_id")
	Menu menu;

	@ManyToOne
    @MapsId("Cus_id")
    @JoinColumn(name = "Cus_id")
	Customer customer;
	

	
    public OrderCoffee(int ord_id, int status, Date ord_Date, Menu menu, Customer customer) {
		super();
		Ord_id = ord_id;
		this.status = status;
		Ord_Date = ord_Date;
		this.menu = menu;
		this.customer = customer;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getOrd_id() {
		return Ord_id;
	}

	public void setOrd_id(int ord_id) {
		Ord_id = ord_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrd_Date() {
		return Ord_Date;
	}

	public void setOrd_Date(Date ord_Date) {
		Ord_Date = ord_Date;
	}
	
	
}
