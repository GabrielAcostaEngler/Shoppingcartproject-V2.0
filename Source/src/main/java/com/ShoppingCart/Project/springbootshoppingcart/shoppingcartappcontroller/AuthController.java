package com.ShoppingCart.Project.springbootshoppingcart.shoppingcartappcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	String userLogin() {
		
		return "loginpage";
	}

}
