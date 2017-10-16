package com.ShoppingCart.Project.springbootshoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class SpringbootShoppingcartApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
	    return builder.sources(this.getClass());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootShoppingcartApplication.class, args);
	}
	
}
