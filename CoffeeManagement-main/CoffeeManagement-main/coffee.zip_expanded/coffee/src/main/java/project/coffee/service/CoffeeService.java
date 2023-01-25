package project.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.coffee.dao.CoffeeDAO;
import project.coffee.model.Coffee;

public class CoffeeService {
	@Autowired
	private CoffeeDAO dao;
	
	
	public List<Coffee> getAll(){
		List<Coffee> coffees = new ArrayList<Coffee>();
		dao.findAll().forEach((Coffee c)->{
			coffees.add(c);
		});
		return coffees;
	}
	
	public Coffee add(Coffee c) {
		return dao.save(c);
	}
	
	public Coffee update(Coffee c) {
		return dao.save(c);
	}
	public void delete(int coffee_id) {
		dao.deleteById(coffee_id);
	}
}
