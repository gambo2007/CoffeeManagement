package project.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.coffee.dao.Customer_OrderDAO;
import project.coffee.model.Customer_Order;
@Service
public class Customer_OrderService {
	@Autowired
	private Customer_OrderDAO dao;
	
	public List<Customer_Order> getAll(){
		List<Customer_Order> customer_order = new ArrayList<Customer_Order>();
		dao.findAll().forEach((Customer_Order co)->{
			customer_order.add(co);
		});
		return customer_order;
	}
	
	public Customer_Order findCustomer_Order(Integer Ord_id) {
		return dao.findById(Ord_id).get();
	}
	
	public Customer_Order add(Customer_Order co) {
		return dao.save(co);
	}
	
	public Customer_Order update(Customer_Order co) {
		return dao.save(co);
	}
	
	public void delete(int Ord_Id) {
		dao.deleteById(Ord_Id);
	}
}
