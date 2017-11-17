package com.ShoppingCart.Project.springbootshoppingcart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//@formatter:off
		
		http
			.authorizeRequests()
				.antMatchers(
						"/","/register")
				.permitAll()
				.antMatchers(
					"/css/*",
					"/img/*").permitAll()
			.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/welcome")
				.permitAll()
				.and()
			.logout()
			.permitAll()
			.logoutSuccessUrl("/login");
		
		//@formatter:on

	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		//@formatter:off
		auth.inMemoryAuthentication()
		.withUser("username")
		.password("password")
		.roles("USER");
		
		//@formatter:on
	}

}
