package project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.model.Customer;
import project.coffee.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@PostMapping(value ="/editcustomer")
	public ResponseEntity<Customer> add(@RequestBody Customer cus) {
		Customer cust =service.add(cus);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/editcustomer/{cus_id}")
	public ResponseEntity<Customer> update(@PathVariable("cus_id")int cus_id,@RequestBody Customer cus) {
		cus.setCus_id(cus_id);
		Customer cust = service.update(cus);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	//admin role
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/getcus")
	public ResponseEntity<List<Customer>> getAll()
	{
		List<Customer> cust = service.getAll();
		return new ResponseEntity<List<Customer>>(cust,HttpStatus.OK);
	}
	
	//client role
	@GetMapping(value = "/getcus/{id}")
	public ResponseEntity<Customer> getById(@PathVariable("id")int Cus_id)
	{
		Customer cus =service.getById(Cus_id);
		return new ResponseEntity<Customer>(cus,HttpStatus.OK);
	}
}
