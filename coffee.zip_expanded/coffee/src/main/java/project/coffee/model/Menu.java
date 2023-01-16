package project.coffee.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Menu")
public class Menu {
	
	@Column(name="Name")
	private String coffe_name;
	
	@Column(name="Description")
	private String desc;
	
	@Column(name="Price")
	private String price;
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Coffee_id", referencedColumnName = "Coffee_id")
	private StorageCoffee storageCoffee;
	
	//OrderCustomer
	@OneToMany(mappedBy = "Customer")
	private Set<OrderCoffee> orderlist;
	
	
	public Menu(String coffe_name, String desc, String price, StorageCoffee storageCoffee, Set<OrderCoffee> orderlist) {
		super();
		this.coffe_name = coffe_name;
		this.desc = desc;
		this.price = price;
		this.storageCoffee = storageCoffee;
		this.orderlist = orderlist;
	}
	
	public StorageCoffee getStorageCoffee() {
		return storageCoffee;
	}
	public void setStorageCoffee(StorageCoffee storageCoffee) {
		this.storageCoffee = storageCoffee;
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

