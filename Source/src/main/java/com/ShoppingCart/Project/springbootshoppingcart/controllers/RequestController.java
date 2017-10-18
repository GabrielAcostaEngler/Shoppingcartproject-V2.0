package com.ShoppingCart.Project.springbootshoppingcart.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ShoppingCart.Project.springbootshoppingcart.AuthorizeTransactionInput;
import com.ShoppingCart.Project.springbootshoppingcart.VerifyUserInput;
import com.ShoppingCart.Project.springbootshoppingcart.httpClientService.RequestHandler;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;


@Controller
public class RequestController {

	@Autowired
	private RequestHandler rh;
	
	

	@RequestMapping(value= "/verifyuser", method = RequestMethod.POST)
	@ResponseBody
	public void verifyUser(@RequestBody String indata, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			VerifyUserInput verifyUserInput = new VerifyUserInput(indata);
			String verifyUserResponse = rh.verifyUserHandler(verifyUserInput);
				
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
	public void authorizeUser(@RequestBody String indata, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			AuthorizeTransactionInput authorizeTransactionInput = new AuthorizeTransactionInput(indata);
			String authorizeTransactionResponse = rh.authorizeTransactionHandler(authorizeTransactionInput);
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(authorizeTransactionResponse);
			
			
			return;
			
			
		} catch(Exception e){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
	}
	
	
}
