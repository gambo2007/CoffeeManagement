package project.coffee.dao;

import org.springframework.data.repository.CrudRepository;

import project.coffee.model.Coffee;

public interface CoffeeDAO extends CrudRepository<Coffee, Integer>{

}
