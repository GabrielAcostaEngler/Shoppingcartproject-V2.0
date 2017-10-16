package com.ShoppingCart.Project.springbootshoppingcart.httpClientService;



import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.ShoppingCart.Project.springbootshoppingcart.User;
import com.ShoppingCart.Project.springbootshoppingcart.VerifyUserInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class RequestHandler {

	private ObjectMapper mapper = new ObjectMapper();
	User testuser = new User(
			"1",false,"Gabriel","Acosta","Stnbrohultsvgn","uppsala","75758","swe","ga@hotmail.com","1992-10-06","0767105222",100,"SEK","SV_SE");
	
	public RequestHandler(){
		
	}
	
	

	public String verifyUserHandler(VerifyUserInput indata) throws JsonProcessingException, JSONException {
		
		String response;
		
		if(indata.getSessionId().equals(testuser.getSessionId()) || indata.getUserId().equals(testuser.getUserId())) {
			
			testuser.setSuccess(true);
			
			response = mapper.writeValueAsString(testuser);
			
			return response;
			
		}else{
			
			JSONObject jsonobj = new JSONObject();
			
			jsonobj.put("sessionId", indata.getSessionId());
			jsonobj.put("userId", indata.getUserId());
			jsonobj.put("Success", false);
			jsonobj.put("errMsg", "Unknown ID");
			
			response = mapper.writeValueAsString(jsonobj);
			
			return response;
		}
	}
}
