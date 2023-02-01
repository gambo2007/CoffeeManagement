package project.coffee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.coffee.dao.LoginDAO;
import project.coffee.exception.InvalidCredentialsException;
import project.coffee.exception.NullObjectException;
import project.coffee.model.Login;
@Service
public class LoginService {
	@Autowired
	private LoginDAO dao;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	public Login createAccount(Login login) {
		if(login == null) {
			throw new NullObjectException("Login");
		}
		return dao.save(login);
	}
	public Login getLoginById(int Login_id) {
		return dao.findById(Login_id).get();
	}
	
	public List<Login> getAll(){
		List<Login> logins = new ArrayList<Login>();
		dao.findAll().forEach((Login c)->{
			logins.add(c);
		});
		return logins;
	}
	
	public boolean existsByUsername(String username) {
		return dao.existsByUsername(username);
	}
	
	public boolean existByEmail(String email) {
		return dao.existsByEmail(email);
	}
	
	
	public Login login(Login login) {
		Optional<Login> opt = dao.findByUsername(login.getUsername());
		Login logi = null;
		if(opt.isPresent()) {
			logi = opt.get();
			String pwdInDB = logi.getPassword();
			System.out.println(pwdInDB);
			if(passwordEncoder.matches(login.getPassword(), logi.getPassword())) {
				return logi;
			}else {
				throw new InvalidCredentialsException("password");
			}
		}
		else {
			throw new InvalidCredentialsException("username");
		}
	}

	
}