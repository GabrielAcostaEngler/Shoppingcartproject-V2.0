package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import com.ShoppingCart.Project.springbootshoppingcart.TUser;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.AuthorizeTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.CancelTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.TransferTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.VerifyUserInput;

public class PiqCallbackValidator {
	
	
	public boolean validateVerifyUserRequest(TUser user, VerifyUserInput indata) {
		
		if(indata.getSessionId().equals(user.getSessionId()) && indata.getUserId().equals(user.getUserId())) {
			
			return true;
			
		} else {	
			
			return false;
			
		}
		
	}
	
	public boolean validateAutorizeTxRequest(TUser user, AuthorizeTxInput indata) {
		
		if(indata.getUserId().equals(user.getUserId()) && indata.getTxAmount() <= user.getBalance()) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean validateTransferTxRequest(TUser user, TransferTxInput indata) {
		
		if(indata.getUserId().equals(user.getUserId()) && indata.getTxAmountCy().equals(user.getBalanceCy())) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean validateCancelTxRequest(TUser user, CancelTxInput indata) {
		
		if(indata.getUserId().equals(user.getUserId())) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
}
