package project.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.coffee.dao.OrderCoffeeDAO;
import project.coffee.model.OrderCoffee;

@Service
public class OrderCoffeeService {

	@Autowired
	private OrderCoffeeDAO dao;
	
	public List<OrderCoffee> getAll(){
		List<OrderCoffee> ocoffee = new ArrayList<OrderCoffee>();
		dao.findAll().forEach((OrderCoffee o)->{
			ocoffee.add(o);
		});
		return ocoffee;
	}
	
	public OrderCoffee add(OrderCoffee o) {
		return dao.save(o);
	}
	
	public OrderCoffee update(OrderCoffee o) {
		return dao.save(o);
	}
	public void delete(int coffee_id) {
		dao.deleteById(coffee_id);
	}
}
