package project.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.coffee.dao.StorageCoffeeDAO;
import project.coffee.model.StorageCoffee;


@Service
public class StorageCoffeeService {
	@Autowired
	private StorageCoffeeDAO dao;
	
	
	public List<StorageCoffee> getAll(){
		List<StorageCoffee> scoffee = new ArrayList<StorageCoffee>();
		dao.findAll().forEach((StorageCoffee s)->{
			scoffee.add(s);
		});
		return scoffee;
	}
	
	public StorageCoffee add(StorageCoffee s) {
		return dao.save(s);
	}
	
	public StorageCoffee update(StorageCoffee s) {
		return dao.save(s);
	}
	public void delete(int coffee_id) {
		dao.deleteById(coffee_id);
	}
}
