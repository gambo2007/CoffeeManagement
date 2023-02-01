package project.coffee.dao;

import org.springframework.data.repository.CrudRepository;

import project.coffee.model.Customer_Order;

public interface Customer_OrderDAO extends CrudRepository<Customer_Order, Integer>{

}
