package project.coffee.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Customer_Order")
public class Customer_Order {
	@Id
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Ord_Id", referencedColumnName = "Ord_Id")
	private Order_Details order_details;
	
	@ManyToOne
	@JoinColumn(name="Cus_Id", nullable=false)
	private Customer customer;
	
	@Column(name="status")
	private String status;
	
	@Column(name="Ord_Date")
	private Date Ord_Date;
	
	@OneToOne(mappedBy = "customer_order")
    private Invoice invoice;

	public Customer_Order(Order_Details order_details, Customer customer, String status, Date ord_Date,
			Invoice invoice) {
		super();
		this.order_details = order_details;
		this.customer = customer;
		this.status = status;
		Ord_Date = ord_Date;
		this.invoice = invoice;
	}

	public Order_Details getOrder_details() {
		return order_details;
	}

	public void setOrder_details(Order_Details order_details) {
		this.order_details = order_details;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrd_Date() {
		return Ord_Date;
	}

	public void setOrd_Date(Date ord_Date) {
		Ord_Date = ord_Date;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
