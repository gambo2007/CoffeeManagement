package project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.model.Customer_Order;
import project.coffee.service.Customer_OrderService;

@RestController
@RequestMapping("/customer_order")
public class Customer_OrderController {
	@Autowired
	private Customer_OrderService service;
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@GetMapping(value = "/")
	public List<Customer_Order> getAll()
	{
		return service.getAll();
	}
	
	
	@GetMapping(value = "/get/{Ord_id}")
	public Customer_Order getCustomer_Order(@PathVariable("Ord_id")int Ord_Id)
	{
		return service.findCustomer_Order(Ord_Id);
	}
	
	@PostMapping(value = "/add")
	public Customer_Order add(@RequestBody Customer_Order co) {
		return service.add(co);
	}
	
	@PutMapping(value = "/update/{Ord_id}")
	public Customer_Order update(@PathVariable("Ord_id")int Ord_Id, @RequestBody Customer_Order co)
	{
		co.getOrder_details().setOrd_Id(Ord_Id);
		return service.update(co);
	}
	
	@DeleteMapping(value = "delete/{Ord_id}")
	public void delete(@PathVariable("Ord_id") int Ord_Id)
	{
		service.delete(Ord_Id);
	}
}
