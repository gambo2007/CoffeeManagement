package project.coffee.dao;

import org.springframework.data.repository.CrudRepository;

import project.coffee.model.Login;

public interface LoginDAO extends CrudRepository<Login, Integer> {
	public Login findByUsernameAndPassword(String username,String password);
	boolean existsByUsername(String username);
}
