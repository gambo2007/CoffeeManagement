package project.coffee.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="Menu")
public class Menu {
	@Id
	@Column(name="Menu_Id")
	private Integer Menu_Id;
	
	@Column(name="Menu_name")
	private String Menu_name;
	
	@Column(name="Description")
	private String Description;

	@OneToMany(mappedBy="menu")
    private List<Coffee> coffees;

	public Menu(Integer menu_Id, String menu_name, String description, List<Coffee> coffees) {
		super();
		Menu_Id = menu_Id;
		Menu_name = menu_name;
		Description = description;
		this.coffees = coffees;
	}

	public Integer getMenu_Id() {
		return Menu_Id;
	}

	public void setMenu_Id(Integer menu_Id) {
		Menu_Id = menu_Id;
	}

	public String getMenu_name() {
		return Menu_name;
	}

	public void setMenu_name(String menu_name) {
		Menu_name = menu_name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Coffee> getCoffees() {
		return coffees;
	}

	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}
	
}
