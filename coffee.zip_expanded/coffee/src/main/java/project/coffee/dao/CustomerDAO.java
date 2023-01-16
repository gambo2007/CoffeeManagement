package project.coffee.dao;

import org.springframework.data.repository.CrudRepository;

import project.coffee.model.Customer;


public interface CustomerDAO extends CrudRepository<Customer, Integer>{
	
	
}
