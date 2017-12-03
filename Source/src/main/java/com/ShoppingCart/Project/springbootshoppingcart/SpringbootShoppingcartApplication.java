package com.ShoppingCart.Project.springbootshoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
public class SpringbootShoppingcartApplication extends SpringBootServletInitializer {
	
	@Autowired 
	UserService userService;

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShoppingcartApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			userService.register(new SiteUser("Test",
									"testsson",
									"testvgn123",
									"testcity",
									"75757",
									"Sweden",
									"TEST_USER@hotmail.com",
									"password",
									"1990-01-01",
									"0760000000"));
		};
	}
	
	
	@Bean
	PasswordEncoder getEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
