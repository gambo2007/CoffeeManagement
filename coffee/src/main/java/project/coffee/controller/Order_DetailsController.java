package project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.model.Order_Details;
import project.coffee.service.Order_DetailsService;

@RestController
@RequestMapping("/order_details")
public class Order_DetailsController {
	@Autowired
	private Order_DetailsService service;
	
	//@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@GetMapping(value = "/")
	public List<Order_Details> getAll()
	{
		return service.getAll();
	}
	
	
	@GetMapping(value = "/get/{Ord_id}")
	public Order_Details getOrder_Details(@PathVariable("Ord_id")int Ord_Id)
	{
		return service.findOrder_Details(Ord_Id);
	}
	
	@PostMapping(value = "/add")
	public Order_Details add(@RequestBody Order_Details od) {
		return service.add(od);
	}
	
	@PutMapping(value = "/update/{Ord_id}")
	public Order_Details update(@PathVariable("Ord_id")int Ord_Id, @RequestBody Order_Details od)
	{
		od.setOrd_Id(Ord_Id);
		return service.update(od);
	}
	
	@DeleteMapping(value = "delete/{Ord_id}")
	public void delete(@PathVariable("Ord_id") int Ord_Id)
	{
		service.delete(Ord_Id);
	}
}
