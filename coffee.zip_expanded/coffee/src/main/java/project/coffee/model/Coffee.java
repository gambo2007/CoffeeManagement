package project.coffee.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@Column(name="Quanity")
	private Integer quanity;
	
	@Id
	@Column(name="Coffee_Id")
	private Integer coffee_id;
	
	//OrderCustomer
	@OneToMany(mappedBy = "Customer")
	private Set<OrderCoffee> orderlist;
	
	
	
	public Coffee(String coffe_name, String desc, String price, Integer quanity, Integer coffee_id,
			Set<OrderCoffee> orderlist) {
		super();
		this.coffe_name = coffe_name;
		this.desc = desc;
		this.price = price;
		this.quanity = quanity;
		this.coffee_id = coffee_id;
		this.orderlist = orderlist;
	}
	
	
	public Integer getQuanity() {
		return quanity;
	}


	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
	}


	public Integer getCoffee_id() {
		return coffee_id;
	}

	public void setCoffee_id(Integer coffee_id) {
		this.coffee_id = coffee_id;
	}

	public Set<OrderCoffee> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(Set<OrderCoffee> orderlist) {
		this.orderlist = orderlist;
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
