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

import project.coffee.model.Coffee;
import project.coffee.service.CoffeeService;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
	@Autowired
	private CoffeeService service;
	
	
	@GetMapping(value = "/")
	public List<Coffee> getAll()
	{
		return service.getAll();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@PostMapping(value = "/add")
	public Coffee add(@RequestBody Coffee c) {
		return service.add(c);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@PutMapping(value = "/update/{coffee_id}")
	public Coffee update(@PathVariable("Coffee_id")int coffee_id,@RequestBody Coffee c)
	{
		c.setCoffee_id(coffee_id);
		return service.update(c);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@DeleteMapping(value = "delete/{coffee_id}")
	public void delete(@PathVariable("Coffee_id") int coffee_id)
	{
		service.delete(coffee_id);
	}
}
