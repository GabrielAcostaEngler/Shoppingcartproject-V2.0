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
			userService.register(new SiteUser("TestSEK",
									"testsson",
									"testvgn123",
									"testcity",
									"75757",
									"Sweden",
									"TEST_USER_SEK@gmail.com",
									"password",
									"1990-01-01",
									"0760000000"));
			
			
			
			
			userService.register(new SiteUser("TestEUR",
									"testsson2",
									"testvgn123",
									"testcity2",
									"75756",
									"Spain",
									"TEST_USER_EUR@gmail.com",
									"password",
									"1990-01-02",
									"0760000002"));
			
			userService.register(new SiteUser("TestUSD",
									"testsson2",
									"testvgn123",
									"testcity2",
									"75756",
									"United States",
									"TEST_USER_USD@gmail.com",
									"password",
									"1990-01-02",
									"0760000002"));
		};
	}
	
	
	@Bean
	PasswordEncoder getEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
