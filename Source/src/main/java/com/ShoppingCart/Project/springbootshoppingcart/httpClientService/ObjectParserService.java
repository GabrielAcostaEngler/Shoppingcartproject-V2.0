package com.ShoppingCart.Project.springbootshoppingcart.httpClientService;

import java.io.IOException;

import com.ShoppingCart.Project.springbootshoppingcart.User;
import com.ShoppingCart.Project.springbootshoppingcart.VerifyUserInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectParserService {

	private String jsonresult;
	private ObjectMapper mapper = new ObjectMapper();
	private VerifyUserInput userutil;
	
	public ObjectParserService(){
		
	}
	
	public String userToJson(User user) {
		
		try {
			
			jsonresult = mapper.writeValueAsString(user);
				
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonresult;
	}
	
	

	public VerifyUserInput utilityToObject(String jsonString) {
		
		
		try {
			userutil = mapper.readValue(jsonString,VerifyUserInput.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userutil;
		
		
	}
	
}
