package project.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.coffee.dao.LoginDAO;
import project.coffee.exception.NullObjectException;
import project.coffee.model.Login;
@Service
public class LoginService {
	@Autowired
	private LoginDAO dao;

	public Login findByUsernameAndPassword(String username,String passowrd) {
		return dao.findByUsernameAndPassword(username, passowrd);
	}

	public Login add(Login register) {
		if(register == null) {
			throw new NullObjectException("Login");
		}
		return dao.save(register);
	}
}