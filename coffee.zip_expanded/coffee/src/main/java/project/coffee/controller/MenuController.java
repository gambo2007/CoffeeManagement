package project.coffee.controller;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.model.Menu;
import project.coffee.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService service;
	
	
	@GetMapping(value = "/menucoffee")
	public List<Menu> getAll()
	{
		return service.getAll();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@PostMapping(value = "/menucoffee")
	public Menu add(@RequestBody Menu m) {
		return service.add(m);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@PutMapping(value = "/menucoffee/{coffee_id}")
	public Menu update(@PathVariable("Coffee_id")int coffee_id,@RequestBody Menu m)
	{
		m.getStorageCoffee().setCoffee_id(coffee_id);
		return service.update(m);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@DeleteMapping(value = "/menucoffee/{coffee_id}")
	public void delete(@PathVariable("Coffee_id") int coffee_id)
	{
		service.delete(coffee_id);
	}
}
