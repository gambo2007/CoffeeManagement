package project.coffee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Storage")
public class StorageCoffee {
	@Id
	@Column(name="Coffee_id")
	private int Coffee_id;

	@Column(name="Coffee_Name")
	private String Coffee_name;
	
	@Column(name="Import_Date")
	private Date importDate;
	
	@Column(name="Expiration_Date")
	private Date expirateDate;
	
	@OneToOne(mappedBy = "Storage")
	private Menu menu;
	
	public StorageCoffee(int coffee_id, String coffee_name, Date importDate, Date expirateDate) {
		super();
		Coffee_id = coffee_id;
		Coffee_name = coffee_name;
		this.importDate = importDate;
		this.expirateDate = expirateDate;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public int getCoffee_id() {
		return Coffee_id;
	}

	public void setCoffee_id(int coffee_id) {
		Coffee_id = coffee_id;
	}

	public String getCoffee_name() {
		return Coffee_name;
	}

	public void setCoffee_name(String coffee_name) {
		Coffee_name = coffee_name;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Date getExpirateDate() {
		return expirateDate;
	}

	public void setExpirateDate(Date expirateDate) {
		this.expirateDate = expirateDate;
	}
	
	
}
