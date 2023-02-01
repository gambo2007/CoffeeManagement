package project.coffee.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Invoice")
public class Invoice {
	
	@Id
	@Column(name="Inv_Id")
	private Integer Inv_Id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Ord_Id", referencedColumnName = "Ord_Id")
    private Customer_Order customer_order;
	
	@Column(name="Amount")
	private String Amount;
	
	@Column(name="Dates")
	private Date Dates;

	public Invoice(Integer inv_Id, Customer_Order customer_order, String amount, Date dates) {
		super();
		Inv_Id = inv_Id;
		this.customer_order = customer_order;
		Amount = amount;
		Dates = dates;
	}

	public Integer getInv_Id() {
		return Inv_Id;
	}

	public void setInv_Id(Integer inv_Id) {
		Inv_Id = inv_Id;
	}

	public Customer_Order getCustomer_order() {
		return customer_order;
	}

	public void setCustomer_order(Customer_Order customer_order) {
		this.customer_order = customer_order;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public Date getDates() {
		return Dates;
	}

	public void setDates(Date dates) {
		Dates = dates;
	}
}
