package com.ShoppingCart.Project.springbootshoppingcart.shoppingcartappcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ShoppingCart.Project.springbootshoppingcart.NetellerTxInput;

@Controller
public class ViewController {

	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView informationInputMapping (ModelAndView modelAndView,NetellerTxInput inputData) {
		
		
		
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/submitinput", method = RequestMethod.POST)
	public String informationInput(Model model) {
		
		
		
		model.addAttribute("NetellerTxInput", new NetellerTxInput());

		return "InformationInput";
	}

	
	
	
	
}
