package com.ShoppingCart.Project.springbootshoppingcart.shoppingcartappcontroller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.PiqTx;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.service.PiqTxService;
import com.ShoppingCart.Project.springbootshoppingcart.siteuser.SiteUser;
import com.ShoppingCart.Project.springbootshoppingcart.siteuser.service.UserService;

@Controller
public class ViewController {
	
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	PiqTxService piqTxService;
	
	
	
	
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
	

	

	@RequestMapping(value="/managefunds", method = RequestMethod.GET)
	public String informationInputMapping(Model model, HttpServletRequest request,HttpServletResponse response) {
		
		SiteUser siteUser = userService.getCurrentSiteUser();
		
		String merchantMid = "1992";
		String sessionId = request.getSession().getId();
		
		
		String piqCashierDepositUrl = "https://test-cashier.paymentiq.io:443/#/merchant/"+
								merchantMid+
								"/user/"+ 
								siteUser.getUserId().toString()+
								"/method/"+
								"deposit?selectlastusedtxmethod=false&showconfirmation=false&showmenu=true&locale=en&container=iframe&iframeWidth=400&iframeHeight=700&sessionid="+
								sessionId;
		
		String piqCashierWithdrawUrl = "https://test-cashier.paymentiq.io:443/#/merchant/"+
								merchantMid+
								"/user/"+ 
								siteUser.getUserId().toString()+
								"/method/"+
								"withdrawal?selectlastusedtxmethod=false&showconfirmation=false&showmenu=true&locale=en&container=iframe&iframeWidth=400&iframeHeight=700&sessionid="+
								sessionId;
		
		model.addAttribute("piqwithdrawurl", piqCashierWithdrawUrl);
		model.addAttribute("piqdepositurl", piqCashierDepositUrl);
		
		return "paymentpage";
	}
	
	
	
	@RequestMapping(value="/txhistory", method = RequestMethod.GET)
	public String showTxHistory(Model model, HttpServletRequest request,HttpServletResponse response) {
		
		SiteUser siteUser = userService.getCurrentSiteUser();
		ArrayList<PiqTx> txHistory = new ArrayList<PiqTx>();
		
		txHistory = piqTxService.getTxHistory(siteUser.getUserId().toString());
		
		model.addAttribute("txHistory", txHistory);
		
		return "txhistory";
	}

}
