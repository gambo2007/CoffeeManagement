package project.coffee.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name ="Coffee")
public class Coffee {
	@Column(name="Name")
	private String coffee_name;
	
	@Column(name="Description")
	private String desc;
	
	@Column(name="Price")
	private Integer price;
	
	@Column(name="Img", columnDefinition="CLOB")
	@Lob
	private String Img;
	
	@Id
	@Column(name="Coffee_Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer coffee_id;
	
	
	//Menu
	@ManyToOne
	@JoinColumn(name="Menu_Id", nullable=false)
	@JsonIgnoreProperties(value = "coffees")
	private Menu menu;
	
	
	//Order
	@OneToMany(mappedBy="coffee")
	@JsonIgnore
	private Set<Order_Details> order_details;


	public Coffee() {
		super();
	}

	public Coffee(String coffee_name, String desc, Integer price, String img, Integer coffee_id) {
		super();
		this.coffee_name = coffee_name;
		this.desc = desc;
		this.price = price;
		Img = img;
		this.coffee_id = coffee_id;
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


	public String getCoffee_name() {
		return coffee_name;
	}
	public void setCoffee_name(String coffee_name) {
		this.coffee_name = coffee_name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}
	
}