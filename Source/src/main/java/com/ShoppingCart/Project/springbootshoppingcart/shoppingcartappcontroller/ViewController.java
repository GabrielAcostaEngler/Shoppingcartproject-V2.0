package com.ShoppingCart.Project.springbootshoppingcart.shoppingcartappcontroller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ShoppingCart.Project.springbootshoppingcart.MockDBHandler;
import com.ShoppingCart.Project.springbootshoppingcart.SiteUser;
import com.ShoppingCart.Project.springbootshoppingcart.UserDao;

@Controller
public class ViewController {
	
	MockDBHandler usd = new MockDBHandler();
	
	
	@Autowired
	UserDao userDao;
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(value="/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
	
	
	//-----------------------------------------
	
	@RequestMapping(value="/registeredusers", method = RequestMethod.GET)
	public String listedUsersPage(Model model) {
		
		model.addAttribute("list",usd.mockDB.getRegisteredUsers().toString());
		
		return"registeredusers";
	}
	

	

	@RequestMapping(value="/netellerdeposit", method = RequestMethod.GET)
	public String informationInputMapping(Model model, HttpServletRequest request,HttpServletResponse response) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		SiteUser siteUser = userDao.findByEmail(name);
		
		String merchantMid = "1992";
		String sessionId = request.getSession().getId();
		
		
		String piqCashierUrl = "https://test-cashier.paymentiq.io:443/#/merchant/"+
								merchantMid+
								"/user/"+ 
								siteUser.getUserId().toString()+
								"/method/"+
								"deposit?selectlastusedtxmethod=false&showconfirmation=false&showmenu=true&locale=en&container=iframe&iframeWidth=400&iframeHeight=700&sessionid="+
								sessionId;
		
		model.addAttribute("piqurl", piqCashierUrl);
		
		return "netellerdepositform";
	}

}
