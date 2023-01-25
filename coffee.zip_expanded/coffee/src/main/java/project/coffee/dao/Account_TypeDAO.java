package project.coffee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.coffee.model.Account_Type;

public interface Account_TypeDAO extends JpaRepository<Account_Type, Integer>{
	Optional<Account_Type> findByName(String name);
}
