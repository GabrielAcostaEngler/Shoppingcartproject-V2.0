package com.ShoppingCart.Project.springbootshoppingcart.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ShoppingCart.Project.springbootshoppingcart.User;
import com.ShoppingCart.Project.springbootshoppingcart.httpClientService.ObjectParserService;


@Controller
public class UserController {
	
	private ObjectParserService ops = new ObjectParserService();
	
	
	User testuser = new User("1",true,"Gabriel","Acosta","Stnbrohultsvgn","uppsala","75758","swe","ga@hotmail.com","1992-10-06","0767105222",100,"SEK","SV_SE");

	
	@RequestMapping(value="/api/testuser", method = RequestMethod.GET)
	public ResponseEntity<User> get(){
		
		
		return new ResponseEntity<User>(testuser,HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/index")
	public String showUserInfo() {
		
		String result = ops.userToJson(testuser);
		
		return result;
		
	}
	
	

	public String printoutUser(User user) {
		
		
		return user.getUserId() + user.getFirstName() + user.getLastName() + user.getBalance();
	}

}
