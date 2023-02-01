package project.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.coffee.dao.Order_DetailsDAO;
import project.coffee.model.Order_Details;

@Service
public class Order_DetailsService {
	@Autowired
	private Order_DetailsDAO dao;
	
	public List<Order_Details> getAll(){
		List<Order_Details> order_details = new ArrayList<Order_Details>();
		dao.findAll().forEach((Order_Details od)->{
			order_details.add(od);
		});
		return order_details;
	}
	
	public Order_Details findOrder_Details(Integer Ord_id) {
		return dao.findById(Ord_id).get();
	}
	
	public Order_Details add(Order_Details od) {
		return dao.save(od);
	}
	
	public Order_Details update(Order_Details od) {
		return dao.save(od);
	}
	
	public void delete(int Ord_Id) {
		dao.deleteById(Ord_Id);
	}
}
