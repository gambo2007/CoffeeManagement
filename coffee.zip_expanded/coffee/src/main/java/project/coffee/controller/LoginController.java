package project.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.model.Login;
import project.coffee.service.LoginService;
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping("/{username}/{password}")
	public ResponseEntity<Login> findByUsernameAndPassword(@PathVariable("username")String username,@PathVariable("password")String password) {
		Login log =service.findByUsernameAndPassword(username,password);
		return new ResponseEntity<Login>(log,HttpStatus.OK);
	}
	
	// register account
	@PostMapping(value = "/register")
	public ResponseEntity<Login> add (@RequestBody Login register) {
		Login log = service.add(register);
		return new ResponseEntity<Login>(log,HttpStatus.CREATED);
	}
}
