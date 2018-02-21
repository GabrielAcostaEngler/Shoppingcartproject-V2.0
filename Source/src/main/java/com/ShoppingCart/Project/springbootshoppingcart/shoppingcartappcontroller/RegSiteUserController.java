package com.ShoppingCart.Project.springbootshoppingcart.shoppingcartappcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ShoppingCart.Project.springbootshoppingcart.SiteUser;
import com.ShoppingCart.Project.springbootshoppingcart.UserService;

@Controller
public class RegSiteUserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUserPage(Model model) {

		SiteUser user = new SiteUser("","","","","","","","","","");

		model.addAttribute("user", user);

		return "registerpage";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUserRequest(Model model,@ModelAttribute(value="user") @Valid SiteUser user, BindingResult result) {

		if (!result.hasErrors()) {
			userService.register(user);
			System.out.println("\n" + user.toString() + "\n");

			return "registrationsuccess";
		}

		return "registerpage";

	}
}
