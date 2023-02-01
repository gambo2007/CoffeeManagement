package project.coffee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.coffee.model.Owner;

@Repository
public interface OwnerDAO extends JpaRepository<Owner, Integer>{
	boolean existsByOwnerName(String ownerName);
	boolean existsByPhoneNumber(String phoneNumber);
	
}
