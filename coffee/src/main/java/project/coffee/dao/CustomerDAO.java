package project.coffee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.coffee.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	boolean existsByCusName(String cusName);
	boolean existsByPhoneNumber(String phoneNumber);
	
}
