package com.ShoppingCart.Project.springbootshoppingcart.httpClientService;

import com.ShoppingCart.Project.springbootshoppingcart.AuthorizeTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.CancelTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.TransferTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.User;
import com.ShoppingCart.Project.springbootshoppingcart.VerifyUserInput;

public class RequestValidator {
	
	
	public boolean validateVerifyUserRequest(User user, VerifyUserInput indata) {
		
		if(indata.getSessionId().equals(user.getSessionId()) && indata.getUserId().equals(user.getUserId())) {
			
			return true;
			
		} else {	
			
			return false;
			
		}
		
	}
	
	public boolean validateAutorizeTxRequest(User user, AuthorizeTxInput indata) {
		
		if(indata.getUserId().equals(user.getUserId()) && indata.getTxAmount() <= user.getBalance()) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean validateTransferTxRequest(User user, TransferTxInput indata) {
		
		if(indata.getUserId().equals(user.getUserId()) && indata.getTxAmountCy().equals(user.getBalanceCy())) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean validateCancelTxRequest(User user, CancelTxInput indata) {
		
		if(indata.getUserId().equals(user.getUserId())) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
}
