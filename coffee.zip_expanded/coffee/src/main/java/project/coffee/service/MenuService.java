package project.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.coffee.dao.MenuDAO;
import project.coffee.model.Menu;

public class MenuService {
	@Autowired
	private MenuDAO dao;
	
	
	public List<Menu> getAll(){
		List<Menu> menus = new ArrayList<Menu>();
		dao.findAll().forEach((Menu m)->{
			menus.add(m);
		});
		return menus;
	}
	
	public Menu add(Menu m) {
		return dao.save(m);
	}
	
	public Menu update(Menu m) {
		return dao.save(m);
	}
	public void delete(int Menu_id) {
		dao.deleteById(Menu_id);
	}
}
