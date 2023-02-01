package project.coffee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.coffee.model.Login;

public interface LoginDAO extends JpaRepository<Login, Integer> {
	Optional<Login> findByEmail(String email);
	Optional<Login> findByUsernameOrEmail(String username , String email);
	Optional<Login> findByUsername(String username);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	
}
