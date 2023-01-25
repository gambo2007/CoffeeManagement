package project.coffee.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="Coffee")
public class Coffee {
	@Column(name="Name")
	private String coffe_name;
	
	@Column(name="Description")
	private String desc;
	
	@Column(name="Price")
	private String price;
	
	
	@Id
	@Column(name="Coffee_Id")
	private Integer coffee_id;
	
	
	//Menu
	@ManyToOne
	@JoinColumn(name="Menu_Id", nullable=false)
	private Menu menu;
	
	
	//Order
	@OneToMany(mappedBy="coffee")
	private Set<Order_Details> order_details;


	public Coffee(String coffe_name, String desc, String price, Integer coffee_id, Menu menu,
			Set<Order_Details> order_details) {
		super();
		this.coffe_name = coffe_name;
		this.desc = desc;
		this.price = price;
		this.coffee_id = coffee_id;
		this.menu = menu;
		this.order_details = order_details;
	}


	public Set<Order_Details> getOrder_details() {
		return order_details;
	}


	public void setOrder_details(Set<Order_Details> order_details) {
		this.order_details = order_details;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public Integer getCoffee_id() {
		return coffee_id;
	}

	public void setCoffee_id(Integer coffee_id) {
		this.coffee_id = coffee_id;
	}


	public String getCoffe_name() {
		return coffe_name;
	}
	public void setCoffe_name(String coffe_name) {
		this.coffe_name = coffe_name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
