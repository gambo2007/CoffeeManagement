package project.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.dto.OwnerRegistraionDto;
import project.coffee.exception.DataAlreadyInUseException;
import project.coffee.model.Login;
import project.coffee.model.Owner;
import project.coffee.service.LoginService;
import project.coffee.service.OwnerService;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OwnerController {
	@Autowired
	private OwnerService owService;
	
	@Autowired
	private LoginService logService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<OwnerRegistraionDto> registerCustomer(@RequestBody OwnerRegistraionDto ownerRegistrationDto){
		if(owService.existsByOwnerName(ownerRegistrationDto.getOwnerName())) {
			throw new DataAlreadyInUseException("Owner Name",ownerRegistrationDto.getOwnerName());
		}
		
		if(owService.existsByPhoneNumber(ownerRegistrationDto.getPhoneNumber())) {
			throw new DataAlreadyInUseException("Customer PhoneNumber",ownerRegistrationDto.getPhoneNumber());
		}
		
		if(logService.existsByUsername(ownerRegistrationDto.getUsername())) {
			throw new DataAlreadyInUseException("username",ownerRegistrationDto.getUsername());
		}
		
		if(logService.existByEmail(ownerRegistrationDto.getEmail())) {
			throw new DataAlreadyInUseException("email",ownerRegistrationDto.getEmail());
		}
		
		Owner ow = new Owner();
		ow.setOwnerId(ownerRegistrationDto.getOwnerId());
		ow.setOwnerName(ownerRegistrationDto.getOwnerName());
		ow.setEmail(ownerRegistrationDto.getEmail());
		ow.setBod(ownerRegistrationDto.getBod());
		ow.setAddress(ownerRegistrationDto.getAddress());
		ow.setPhoneNumber(ownerRegistrationDto.getPhoneNumber());
		
		
		Login login = new Login();
		login.setLogin_id(ownerRegistrationDto.getLogin_id());
		login.setUsername(ownerRegistrationDto.getUsername());
		login.setPassword(passwordEncoder.encode(ownerRegistrationDto.getPassword()));
		login.setEmail(ownerRegistrationDto.getEmail());
		login.setRole("ROLE_Owner");
		
		//It require static 
		Owner savedOwner = owService.registerCustomer(ow);
		Login savelog = logService.createAccount(login);
		
		OwnerRegistraionDto dto = new OwnerRegistraionDto();
		dto.setOwnerId(savedOwner.getOwnerId());
		dto.setOwnerName(savedOwner.getOwnerName());
		dto.setEmail(savedOwner.getEmail());
		dto.setPhoneNumber(savedOwner.getPhoneNumber());
		dto.setAddress(savedOwner.getAddress());
		dto.setBod(savedOwner.getBod());
		
		dto.setLogin_id(savelog.getLogin_id());
		dto.setUsername(savelog.getUsername());
		
		
		return new  ResponseEntity<OwnerRegistraionDto>(dto,HttpStatus.CREATED);
		
	}
}
