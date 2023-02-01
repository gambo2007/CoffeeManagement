package project.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.coffee.dao.CustomerDAO;
import project.coffee.exception.NullObjectException;
import project.coffee.model.Customer;
import project.coffee.model.Login;
@Service
public class CustomerService {
	@Autowired
	private  CustomerDAO dao;
	

	public Customer registerCustomer(Customer customer) {
		if (customer == null) {
			throw new NullObjectException("Customer");
		}
		return dao.save(customer);
	}
	
	public boolean existsByCusName(String cusName) {
		System.out.println(cusName);
		System.out.println(dao);
		return dao.existsByCusName(cusName);
	}
	
	public boolean existsByPhoneNumber(String phoneNumber) {
		return dao.existsByPhoneNumber(phoneNumber);
	}
	
	
	public List<Customer> getAll(){
		List<Customer> customer = new ArrayList<Customer>();
		dao.findAll().forEach((Customer c)->{
			customer.add(c);
		});
		return customer;
	}
}

