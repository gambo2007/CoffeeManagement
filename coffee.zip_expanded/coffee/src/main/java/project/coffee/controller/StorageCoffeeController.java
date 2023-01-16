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

import project.coffee.model.StorageCoffee;
import project.coffee.service.StorageCoffeeService;

@RestController
@RequestMapping("/storage")
public class StorageCoffeeController {
	@Autowired
	private StorageCoffeeService service;
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@GetMapping(value = "/coffee")
	public List<StorageCoffee> getAll()
	{
		return service.getAll();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@PostMapping(value = "/coffee")
	public StorageCoffee add(@RequestBody StorageCoffee s) {
		return service.add(s);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@PutMapping(value = "/coffee/{coffee_id}")
	public StorageCoffee update(@PathVariable("Coffee_id")int coffee_id,@RequestBody StorageCoffee s)
	{
		s.setCoffee_id(coffee_id);
		return service.update(s);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@DeleteMapping(value = "/coffee/{coffee_id}")
	public void delete(@PathVariable("Coffee_id") int coffee_id)
	{
		service.delete(coffee_id);
	}
}
