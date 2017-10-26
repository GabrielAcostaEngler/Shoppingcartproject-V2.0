package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ShoppingCart.Project.springbootshoppingcart.User;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.AuthorizeTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.CancelTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.TransferTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.VerifyUserInput;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Component
public class PiqResponseHandler {
	
	PiqCallbackValidator rv = new PiqCallbackValidator();
	public static User testuser = new User(
			"1",false,"Gabriel","Acosta","Stnbrohultsvgn","uppsala","75758","swe","ga@hotmail.com","1992-10-06","0767105222",1000.0,"SEK","SV_SE");
	
	  
	public PiqResponseHandler(){
		
	}
	
	

	public String verifyUserHandler(VerifyUserInput indata) {
		
		testuser.setSessionId("2");
		String response;
		
		if(rv.validateVerifyUserRequest(testuser, indata)) {
			
			testuser.setSuccess(true);
			response = new Gson().toJson(testuser);
			
			return response;
			
		}else{
			
			
			JsonObject jsonobj = new JsonObject();
			
			jsonobj.addProperty("sessionId", indata.getSessionId());
			jsonobj.addProperty("userId", indata.getUserId());
			jsonobj.addProperty("Success", false);
			jsonobj.addProperty("errMsg", "Unknown ID");
			
			response = new Gson().toJson(jsonobj);
			
			return response;
		}
	}
	
	public String authorizeTxHandler(AuthorizeTxInput indata) {
		
		String response;
		
		if(rv.validateAutorizeTxRequest(testuser, indata)) {
			
	
			
			
			UUID authCode = UUID.randomUUID();		
			JsonObject jsonobj = new JsonObject();
						
			jsonobj.addProperty("userId", testuser.getUserId());
			jsonobj.addProperty("Success", true);
			jsonobj.addProperty("authCode", authCode.toString());
			
			response = new Gson().toJson(jsonobj);
			
			return response;
			
			
		}else {
			
			UUID authCode = UUID.randomUUID();
			JsonObject jsonobj = new JsonObject();
			
			jsonobj.addProperty("userId", testuser.getUserId());
			jsonobj.addProperty("Success", false);
			jsonobj.addProperty("authCode", authCode.toString());
			jsonobj.addProperty("errMsg", "User not Authorized");
			
			response = new Gson().toJson(jsonobj);
			
			return response;
		}			
	}
	
	public String transferTxHandler(TransferTxInput indata) {
		
		String response;
		Double balanceAfterTransaction;
		
		if(rv.validateTransferTxRequest(testuser, indata)) {
			
			balanceAfterTransaction = testuser.getBalance() + indata.getTxAmount();
			testuser.setBalance(balanceAfterTransaction);
			
			UUID merchantTxId = UUID.randomUUID();
			JsonObject jsonobj = new JsonObject();
			
			jsonobj.addProperty("userId", testuser.getUserId());
			jsonobj.addProperty("Success", true);
			jsonobj.addProperty("txId", indata.getTxId());
			jsonobj.addProperty("merchantTxId", merchantTxId.toString() );
			jsonobj.addProperty("userBalance", testuser.getBalance());
			
			response = new Gson().toJson(jsonobj);
			
			return response;
			
			
		}else {
			
			JsonObject jsonobj = new JsonObject();
			
			jsonobj.addProperty("userId", testuser.getUserId());
			jsonobj.addProperty("Success", false);
			jsonobj.addProperty("txId", indata.getTxId());
			jsonobj.addProperty("errMsg", "Transfer was not Successful");
			
			response = new Gson().toJson(jsonobj);
			
			return response;
			
			
		}
		
	}
	
	public String cancelTxHandler(CancelTxInput indata) {
		
		String response;
		
		if(rv.validateCancelTxRequest(testuser, indata)) {
			
			JsonObject jsonobj = new JsonObject();
			
			jsonobj.addProperty("userId", testuser.getUserId());
			jsonobj.addProperty("Success", true);
			
			response = new Gson().toJson(jsonobj);
			
			return response;
			
		}else {
			
			
			JsonObject jsonobj = new JsonObject();
			
			jsonobj.addProperty("userId", testuser.getUserId());
			jsonobj.addProperty("Success", false);
			jsonobj.addProperty("errMsg", "Error");
			
			response = new Gson().toJson(jsonobj);
			
			return response;
		}
		
	}
	
}
