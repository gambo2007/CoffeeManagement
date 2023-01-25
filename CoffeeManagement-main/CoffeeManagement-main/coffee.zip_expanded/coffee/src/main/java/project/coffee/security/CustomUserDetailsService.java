package project.coffee.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import project.coffee.dao.LoginDAO;
import project.coffee.model.Account_Type;
import project.coffee.model.Login;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private LoginDAO dao;

	public LoginDAO getDao() {
		return dao;
	}

	public void setDao(LoginDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Login user = dao.findByUsernameAndPassword(username, username);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		user.getAc().forEach((role)->{
			System.out.println(role.getType_name());
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),mapRolesToAuthorities(user.getAc()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Account_Type> ac)
	{
		return ac.stream().map(role-> new SimpleGrantedAuthority(role.getType_name())).collect(Collectors.toList());
	}
	
	
}
