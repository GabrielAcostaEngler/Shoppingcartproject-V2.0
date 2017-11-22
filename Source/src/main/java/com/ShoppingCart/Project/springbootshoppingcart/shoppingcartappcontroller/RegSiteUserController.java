package com.ShoppingCart.Project.springbootshoppingcart.shoppingcartappcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ShoppingCart.Project.springbootshoppingcart.SiteUser;
import com.ShoppingCart.Project.springbootshoppingcart.TUser;
import com.ShoppingCart.Project.springbootshoppingcart.UserService;

@Controller
public class RegSiteUserController {
	
	
	@Autowired
	private UserService userService;

	
	
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerUserPage(Model model) {
		
		model.addAttribute("user", new TUser(null, null, null, null, null, null, null, null, null, null));
		
		return "registerpage";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUserRequest(@ModelAttribute SiteUser user ) {
		
		userService.register(user);
		
		System.out.println(user.toString());
		
		return "registeredusers";
		
	}
}
