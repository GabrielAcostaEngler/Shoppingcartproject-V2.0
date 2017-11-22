package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import com.ShoppingCart.Project.springbootshoppingcart.SiteUser;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.AuthorizeTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.CancelTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.TransferTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.VerifyUserInput;

public class PiqCallbackValidator {
	
	
	
	public boolean validateVerifyUserRequest(SiteUser user, VerifyUserInput indata) {
		
		
		if(/*indata.getSessionId().equals(user.getSessionId()) &&*/ indata.getUserId().equals(user.getUserId().toString())) {
			
			return true;
			
		} else {	
			
			return false;
			
		}
		
	}
	
	public boolean validateAutorizeTxRequest(SiteUser user, AuthorizeTxInput indata) {
		
		
		if(indata.getUserId().equals(user.getUserId().toString()) && indata.getTxAmount() <= user.getBalance()) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean validateTransferTxRequest(SiteUser user, TransferTxInput indata) {
		
		if(indata.getUserId().equals(user.getUserId().toString()) && indata.getTxAmountCy().equals(user.getBalanceCy())) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean validateCancelTxRequest(SiteUser user, CancelTxInput indata) {
		
		if(indata.getUserId().equals(user.getUserId().toString())) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
}
