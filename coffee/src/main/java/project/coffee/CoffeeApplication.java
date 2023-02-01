package project.coffee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.password.PasswordEncoder;

import project.coffee.dao.LoginDAO;
import project.coffee.dao.MenuDAO;
import project.coffee.model.Login;
import project.coffee.model.Menu;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EntityScan(basePackages = "project.coffee")
public class CoffeeApplication implements CommandLineRunner {
	@Autowired
	private LoginDAO dao;
	@Autowired
	private MenuDAO mdao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(CoffeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Login> admin = dao.findByUsername("admin");
		if(!admin.isPresent()) {
			Login login  = new Login(0,"admin",encoder.encode("admin"),"admin@gmail.com","ROLE_ADMIN");
			dao.save(login);
		}
		Menu m = new Menu(0, "All", "All item for you", "https://grf.vn/wp-content/uploads/2021/04/bo-tui-nhung-mon-junk-food-khong-an-la-tiec-o-toronto-unhealthiest-foods-planet.jpg");
		mdao.save(m);
	}

}
