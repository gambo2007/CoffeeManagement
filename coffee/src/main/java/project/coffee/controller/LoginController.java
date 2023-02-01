package project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.dto.UserDto;
import project.coffee.model.Login;
import project.coffee.service.LoginService;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<Login>login(@RequestBody UserDto dto){
		Login login = new Login();
		login.setUsername(dto.getUsername());
		login.setPassword(dto.getPassword());
		Login log = service.login(login);
		return new ResponseEntity<Login>(log, HttpStatus.OK);
	}
	
	@GetMapping(value = "/viewall/{Login_id}")
	public Login getLoginById(@PathVariable("Login_id") int Login_id)
	{
		return service.getLoginById(Login_id);
	}
	
	
	@GetMapping(value = "/getall")
	public List<Login> getAll()
	{
		return service.getAll();
	}
	
	
	
}
