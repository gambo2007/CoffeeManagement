package project.coffee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.dto.CustomerRegistrationDto;
import project.coffee.exception.DataAlreadyInUseException;
import project.coffee.model.Customer;
import project.coffee.model.Login;
import project.coffee.service.CustomerService;
import project.coffee.service.LoginService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CustomerController {
	@Autowired
	private CustomerService cusService;
	
	@Autowired
	private LoginService logService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerRegistrationDto> registerCustomer(@RequestBody CustomerRegistrationDto customerRegistrationDto){
		if(cusService.existsByCusName(customerRegistrationDto.getCusName())) {
			throw new DataAlreadyInUseException("Customer Name",customerRegistrationDto.getCusName());
		}
		
		if(cusService.existsByPhoneNumber(customerRegistrationDto.getPhoneNumber())) {
			throw new DataAlreadyInUseException("Customer PhoneNumber",customerRegistrationDto.getPhoneNumber());
		}
		
		if(logService.existsByUsername(customerRegistrationDto.getUsername())) {
			throw new DataAlreadyInUseException("username",customerRegistrationDto.getUsername());
		}
		
		if(logService.existByEmail(customerRegistrationDto.getEmail())) {
			throw new DataAlreadyInUseException("email",customerRegistrationDto.getEmail());
		}
		
		Customer cus = new Customer();
		cus.setCusId(customerRegistrationDto.getCusId());
		cus.setCusName(customerRegistrationDto.getCusName());
		cus.setEmail(customerRegistrationDto.getEmail());
		cus.setBod(customerRegistrationDto.getBod());
		cus.setAddress(customerRegistrationDto.getAddress());
		cus.setPhoneNumber(customerRegistrationDto.getPhoneNumber());
		
		
		Login login = new Login();
		login.setLogin_id(customerRegistrationDto.getLogin_id());
		login.setUsername(customerRegistrationDto.getUsername());
		login.setPassword(passwordEncoder.encode(customerRegistrationDto.getPassword()));
		login.setEmail(customerRegistrationDto.getEmail());
		login.setRole("ROLE_CUSTOMER");
		
		//It require static 
		Customer savedCus = cusService.registerCustomer(cus);
		Login savelog = logService.createAccount(login);
		
		CustomerRegistrationDto dto = new CustomerRegistrationDto();
		dto.setCusId(savedCus.getCusId());
		dto.setCusName(savedCus.getCusName());
		dto.setEmail(savedCus.getEmail());
		dto.setPhoneNumber(savedCus.getPhoneNumber());
		dto.setAddress(savedCus.getAddress());
		dto.setBod(savedCus.getBod());
		
		dto.setLogin_id(savelog.getLogin_id());
		dto.setUsername(savelog.getUsername());
		
		
		return new  ResponseEntity<CustomerRegistrationDto>(dto,HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/getall")
	public List<Customer> getAll()
	{
		return cusService.getAll();
	}
	
	
	
	
	
	
}
