package com.ShoppingCart.Project.springbootshoppingcart.httpClientService;



import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ShoppingCart.Project.springbootshoppingcart.AuthorizeTransactionInput;
import com.ShoppingCart.Project.springbootshoppingcart.User;
import com.ShoppingCart.Project.springbootshoppingcart.VerifyUserInput;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Component
public class RequestHandler {
	
	User testuser = new User(
			"1",false,"Gabriel","Acosta","Stnbrohultsvgn","uppsala","75758","swe","ga@hotmail.com","1992-10-06","0767105222",100.0,"SEK","SV_SE");
	
	public RequestHandler(){
		
	}
	
	

	public String verifyUserHandler(VerifyUserInput indata) {
		
		testuser.setSessionId("2");
		String response;
		
		if(indata.getSessionId().equals(testuser.getSessionId()) && indata.getUserId().equals(testuser.getUserId())) {
			
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
	
	public String authorizeTransactionHandler(AuthorizeTransactionInput indata) {
		
		String response;
		
		if(indata.getUserId().equals(testuser.getUserId()) && indata.getTxAmount() <= testuser.getBalance()) {
			
			
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
}
