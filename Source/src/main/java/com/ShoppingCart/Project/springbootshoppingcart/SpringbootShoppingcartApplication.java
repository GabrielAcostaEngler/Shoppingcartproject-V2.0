package com.ShoppingCart.Project.springbootshoppingcart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringbootShoppingcartApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShoppingcartApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(UserDao user) {
		
		return args -> {
			user.save(new SiteUser("Gabriel",
									"Acosta",
									"stnbrohultsvgn",
									"Uppsala",
									"75758",
									"Sweden",
									"ga_engler@hotmail.com",
									"hejhej",
									"1992-10-06",
									"0767105222"));
		};
	}

}
