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

import project.coffee.model.Menu;
import project.coffee.service.MenuService;


@RestController
@RequestMapping("/Menu")
public class MenuController {
	@Autowired
	private MenuService service;
	
	
	@GetMapping(value = "/viewall")
	public List<Menu> getAll()
	{
		return service.getAll();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@PostMapping(value = "/add")
	public Menu add(@RequestBody Menu m) {
		return service.add(m);
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@PutMapping(value = "/update/{Menu_Id}")
	public Menu update(@PathVariable("Menu_Id")int Menu_Id,@RequestBody Menu m)
	{
		m.setMenu_Id(Menu_Id);
		return service.update(m);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@DeleteMapping(value = "delete/{Menu_Id}")
	public void delete(@PathVariable("Menu_Id") int Menu_Id)
	{
		service.delete(Menu_Id);
	}
}
