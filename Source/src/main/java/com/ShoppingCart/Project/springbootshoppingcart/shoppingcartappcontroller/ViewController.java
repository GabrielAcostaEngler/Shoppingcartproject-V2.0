package com.ShoppingCart.Project.springbootshoppingcart.shoppingcartappcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.ShoppingCart.Project.springbootshoppingcart.NetellerTxInput;

@Controller
public class ViewController {

	@GetMapping("/submitinput")
	public String informationInputMapping(Model model) {

		model.addAttribute("netellerTxInput", new NetellerTxInput());

		return "submitinput";
	}

	@PostMapping("/submitinput")
	public String informationInput(@ModelAttribute NetellerTxInput netellerTxInput) {
		

		netellerTxInput.setUserId("1");
		netellerTxInput.setSessionId("2");
		netellerTxInput.setMerchantId("1992");
		
		return "result";
	}

}
