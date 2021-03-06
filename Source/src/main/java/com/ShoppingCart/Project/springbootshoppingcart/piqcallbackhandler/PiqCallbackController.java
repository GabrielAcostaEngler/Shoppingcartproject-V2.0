package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.PiqTxHandler;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.AuthorizeTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.CancelTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.TransferTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.VerifyUserInput;
import com.ShoppingCart.Project.springbootshoppingcart.siteuser.service.UserService;


@RequestMapping("/paymentiq")
@Controller
public class PiqCallbackController {

	@Autowired
	private PiqTxHandler piqTxHandler;
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value= "/verifyuser", method = RequestMethod.POST)
	@ResponseBody
	public void verifyUser(@RequestBody String indata, HttpServletRequest request, HttpServletResponse response) {
			

		
		try {
			VerifyUserInput verifyUserInput = new VerifyUserInput(indata);
			String verifyUserResponse = piqTxHandler.verifyUserHandler(verifyUserInput);
			
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(verifyUserResponse);
			
			return;
		
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			return;
		}
		
	}
	
	
	@RequestMapping(value="/authorize", method = RequestMethod.POST)
	@ResponseBody
	public void authorizeTx(@RequestBody String indata, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			AuthorizeTxInput authorizeTxInput = new AuthorizeTxInput(indata);
			String authorizeTxResponse = piqTxHandler.authorizeTxHandler(authorizeTxInput);
			
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(authorizeTxResponse);
			
			return;
			
		} catch(Exception e){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			return;
		}
		
	}
	
	
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	@ResponseBody
	public void transferTx(@RequestBody String indata, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			TransferTxInput transferTxinput = new TransferTxInput(indata);
			String transferTxResponse = piqTxHandler.transferTxHandler(transferTxinput);
			
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(transferTxResponse);
			
			
			return;
			
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			return;
		}
		
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ResponseBody
	public void cancelTx(@RequestBody String indata, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			response.setContentType("application/json");
			CancelTxInput cancelTxInput = new CancelTxInput(indata);
			String cancelTxResponse = piqTxHandler.cancelTxHandler(cancelTxInput);
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(cancelTxResponse);
			
			return;
			
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			return;
		}
		
	}
	
}
