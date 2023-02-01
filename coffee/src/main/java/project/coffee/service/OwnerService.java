package project.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.coffee.dao.OwnerDAO;
import project.coffee.exception.NullObjectException;
import project.coffee.model.Owner;

@Service
public class OwnerService {
	@Autowired
	private OwnerDAO dao;
	
	public Owner registerCustomer(Owner owner) {
		if (owner == null) {
			throw new NullObjectException("Customer");
		}
		return dao.save(owner);
	}
	
	public boolean existsByOwnerName(String ownerName) {
		System.out.println(ownerName);
		System.out.println(dao);
		return dao.existsByOwnerName(ownerName);
	}
	
	public boolean existsByPhoneNumber(String phoneNumber) {
		return dao.existsByPhoneNumber(phoneNumber);
	}
}
