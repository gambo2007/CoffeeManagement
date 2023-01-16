package project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.model.OrderCoffee;
import project.coffee.service.OrderCoffeeService;

@RestController
@RequestMapping("/order")
public class OrderCoffeeController {

	@Autowired
	private OrderCoffeeService service;
	
	@PostFilter("filterObject == authentication.principal.username")
	@GetMapping(value = "/order")
	public List<OrderCoffee> getAll()
	{
		return service.getAll();
	}
	
	@PostMapping(value = "/menu")
	public OrderCoffee add(@RequestBody OrderCoffee o) {
		return service.add(o);
	}
	
	@PutMapping(value = "/order/{coffee_id}")
	public OrderCoffee update(@PathVariable("Coffee_id")int coffee_id,@RequestBody OrderCoffee o)
	{
		o.getMenu().getStorageCoffee().setCoffee_id(coffee_id);
		return service.update(o);
	}
	
	@DeleteMapping(value = "/coffee/{coffee_id}")
	public void delete(@PathVariable("Coffee_id") int coffee_id)
	{
		service.delete(coffee_id);
	}
}
