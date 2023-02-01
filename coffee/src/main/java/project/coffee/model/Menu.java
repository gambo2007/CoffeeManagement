package project.coffee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name ="Menu")
public class Menu {
	@Id
	@Column(name="Menu_Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer Menu_Id;
	
	@Column(name="Menu_name")
	private String Menu_name;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="Img",columnDefinition="CLOB")
	@Lob 
	private String Img;

	@OneToMany(mappedBy="menu", cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "menu")
    private List<Coffee> coffees;

	
	public Menu() {
		super();
	}


	public Menu(Integer menu_Id, String menu_name, String description, String img) {
		super();
		Menu_Id = menu_Id;
		Menu_name = menu_name;
		Description = description;
		Img = img;
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


	public String getImg() {
		return Img;
	}


	public void setImg(String img) {
		Img = img;
	}
	
	
}