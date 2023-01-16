package project.coffee.dao;

import org.springframework.data.repository.CrudRepository;

import project.coffee.model.StorageCoffee;


public interface StorageCoffeeDAO extends CrudRepository<StorageCoffee, Integer>{
	
	
}
