package project.coffee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Menu")
public class Menu {
	@Id
	@Column(name="Coffee_id")
	private int coffee_id;
	
	@Column(name="Name")
	private String coffe_name;
	
	@Column(name="Description")
	private String desc;
	
	@Column(name="Price")
	private String price;
	
	public Menu(int coffee_id, String coffe_name, String desc, String price) {
		super();
		this.coffee_id = coffee_id;
		this.coffe_name = coffe_name;
		this.desc = desc;
		this.price = price;
	}
	public Menu() {
		super();
	}
	public int getCoffee_id() {
		return coffee_id;
	}
	public void setCoffee_id(int coffee_id) {
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

