package com.ShoppingCart.Project.springbootshoppingcart.httpClientService;






/*import org.json.JSONException;
import org.json.JSONObject;

import com.ShoppingCart.Project.springbootshoppingcart.User;
import com.ShoppingCart.Project.springbootshoppingcart.VerifyUserInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
*/


public class ResponseParserService {
/*	
	ObjectMapper mapper = new ObjectMapper();
	ObjectParserService ops;
	String jsonResponse;
	
	
	public String verifyUserSuccess(User user) {
		
		user.setSuccess(true);
		
		jsonResponse = ops.userToJson(user);
		
		return jsonResponse;
	}
	
	public String verifyUserFailed(VerifyUserInput usrUtil) throws JSONException, JsonProcessingException {
		JSONObject jsonobj = new JSONObject();
		
		jsonobj.put("sessionId", usrUtil.getSessionId());
		jsonobj.put("userId", usrUtil.getUserId());
		jsonobj.put("Success", false);
		jsonobj.put("errMsg", "Unknown ID");
		
		mapper.writeValueAsString(jsonobj);
		
		String response = mapper.writeValueAsString(jsonobj);
		
		return response;
		
	}
	*/
}
