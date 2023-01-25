package project.coffee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.coffee.dao.CustomerDAO;
import project.coffee.exception.NullObjectException;
import project.coffee.exception.ResourceNotFoundException;
import project.coffee.model.Customer;
@Service
public class CustomerService {
	@Autowired
	private CustomerDAO dao;

	
	public Customer add(Customer cus) {
		if(cus == null) {
			throw new NullObjectException("Customer");
		}
		return dao.save(cus);
	}
	
	public List<Customer> getAll(){
		List<Customer> regis = new ArrayList<Customer>();
		dao.findAll().forEach((Customer r)->{
			regis.add(r);
		});
		return regis;
	}

	public Customer getById(int cus_id) {
		// TODO Auto-generated method stub
		Optional<Customer> ocus = dao.findById(cus_id);
		Customer cus = null;
		if(ocus.isPresent()) {
			cus = ocus.get();
		}
		return cus;
	}

	public Customer update(Customer cus) {
		Optional<Customer>cust = dao.findById(cus.getCus_id());
		if(!cust.isPresent()) {
			throw new ResourceNotFoundException("Customer","Customer Id", String.valueOf(cus.getCus_id()));
		}
		return dao.save(cus);
	}
	
	
}

