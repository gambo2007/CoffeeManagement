package project.coffee.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Account_Type")
public class Account_Type {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "Type_seq")
	@Column(name ="Type_id")
	private int Type_id;
	
	@Column(name="Type_name")
	private String Type_name;
	
	@ManyToMany(mappedBy = "ac")
	private Set<Login> login;

	public Set<Login> getLogin() {
		return login;
	}

	public void setLogin(Set<Login> login) {
		this.login = login;
	}

	public Account_Type(int type_id, String type_name) {
		super();
		Type_id = type_id;
		Type_name = type_name;
	}

	public Account_Type() {
		super();
	}

	public int getType_id() {
		return Type_id;
	}

	public void setType_id(int type_id) {
		Type_id = type_id;
	}

	public String getType_name() {
		return Type_name;
	}

	public void setType_name(String type_name) {
		Type_name = type_name;
	}
	
	
}
