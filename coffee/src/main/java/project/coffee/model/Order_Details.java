package project.coffee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Order_Details")
public class Order_Details {
	
	@Id
	@Column(name="Ord_Id")
	private Integer Ord_Id;
	
	@Column(name="Unit_Price")
	private Integer Unit_Price;
	
	@Column(name="Quantity")
	private Integer Quantity;
	
	@ManyToOne
	@JoinColumn(name="Coffee_Id", nullable=false)
	private Coffee coffee;
	
	@OneToOne(mappedBy = "order_details")
	private Customer_Order customer_order;
	
	
	public Order_Details(Integer ord_Id, Integer unit_Price, Integer quantity, Coffee coffee,
			Customer_Order customer_order) {
		super();
		Ord_Id = ord_Id;
		Unit_Price = unit_Price;
		Quantity = quantity;
		this.coffee = coffee;
		this.customer_order = customer_order;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public Customer_Order getCustomer_order() {
		return customer_order;
	}

	public void setCustomer_order(Customer_Order customer_order) {
		this.customer_order = customer_order;
	}

	public Integer getOrd_Id() {
		return Ord_Id;
	}
	public void setOrd_Id(Integer ord_Id) {
		Ord_Id = ord_Id;
	}
	public Integer getUnit_Price() {
		return Unit_Price;
	}
	public void setUnit_Price(Integer unit_Price) {
		Unit_Price = unit_Price;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
}
