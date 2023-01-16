package project.coffee.dao;

import org.springframework.data.repository.CrudRepository;

import project.coffee.model.OrderCoffee;

public interface OrderCoffeeDAO extends CrudRepository<OrderCoffee, Integer>{

}
