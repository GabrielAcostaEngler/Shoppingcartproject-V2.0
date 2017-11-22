package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ShoppingCart.Project.springbootshoppingcart.SiteUser;
import com.ShoppingCart.Project.springbootshoppingcart.TUser;
import com.ShoppingCart.Project.springbootshoppingcart.UserDao;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.AuthorizeTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.CancelTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.TransferTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.VerifyUserInput;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Component
public class PiqResponseHandler {

	@Autowired
	UserDao usrdao;
	
	PiqCallbackValidator rv = new PiqCallbackValidator();
	
	
	public static TUser testuser = new TUser("Gabriel", "Acosta", "Stnbrohultsvgn", "uppsala", "75758", "swe",
			"ga@hotmail.com","password", "1992-10-06", "0767105222");

	public PiqResponseHandler() {

	}

	public String verifyUserHandler(VerifyUserInput indata) {

		SiteUser user= usrdao.findByUserId(Long.parseLong(indata.getUserId()));
	
		testuser.setSessionId("2");
		String response;

		if (rv.validateVerifyUserRequest(user, indata)) {

			JsonObject jsonobj = new JsonObject();
			
			jsonobj.addProperty("userId",user.getUserId());
			jsonobj.addProperty("success",true);
			jsonobj.addProperty("firstName",user.getFirstName());
			jsonobj.addProperty("lastName",user.getLastName());
			jsonobj.addProperty("street",user.getStreet());
			jsonobj.addProperty("city",user.getCity());
			jsonobj.addProperty("zip",user.getZip());
			jsonobj.addProperty("country",user.getCountry());
			jsonobj.addProperty("email",user.getEmail());
			jsonobj.addProperty("dob",user.getDob());
			jsonobj.addProperty("mobile",user.getMobile());
			jsonobj.addProperty("balance",user.getBalance());
			jsonobj.addProperty("balanceCy",user.getBalanceCy());
			
			response = new Gson().toJson(jsonobj);

			return response;

		} else {

			JsonObject jsonobj = new JsonObject();

			jsonobj.addProperty("sessionId", indata.getSessionId());
			jsonobj.addProperty("userId", indata.getUserId());
			jsonobj.addProperty("success", false);
			jsonobj.addProperty("errMsg", "Unknown ID");

			response = new Gson().toJson(jsonobj);

			return response;
		}
	}

	public String authorizeTxHandler(AuthorizeTxInput indata) {
		
		SiteUser user= usrdao.findByUserId(Long.parseLong(indata.getUserId()));
		UUID authCode = UUID.randomUUID();

		String response;

		if (rv.validateAutorizeTxRequest(user, indata)) {

			JsonObject jsonobj = new JsonObject();

			jsonobj.addProperty("userId", user.getUserId());
			jsonobj.addProperty("success", true);
			jsonobj.addProperty("authCode", authCode.toString());

			response = new Gson().toJson(jsonobj);

			return response;

		} else {

			JsonObject jsonobj = new JsonObject();

			jsonobj.addProperty("userId", testuser.getUserId());
			jsonobj.addProperty("success", false);
			jsonobj.addProperty("authCode", authCode.toString());
			jsonobj.addProperty("errMsg", "User not Authorized");

			response = new Gson().toJson(jsonobj);

			return response;
		}
	}

	public String transferTxHandler(TransferTxInput indata) {

		SiteUser user= usrdao.findByUserId(Long.parseLong(indata.getUserId()));
		String response;
		Double balanceAfterTransaction;

		if (rv.validateTransferTxRequest(user, indata)) {

			balanceAfterTransaction = user.getBalance() + indata.getTxAmount();
			user.setBalance(balanceAfterTransaction);
			usrdao.save(user);

			UUID merchantTxId = UUID.randomUUID();
			JsonObject jsonobj = new JsonObject();

			jsonobj.addProperty("userId", user.getUserId());
			jsonobj.addProperty("success", true);
			jsonobj.addProperty("txId", indata.getTxId());
			jsonobj.addProperty("merchantTxId", merchantTxId.toString());

			response = new Gson().toJson(jsonobj);

			return response;

		} else {

			JsonObject jsonobj = new JsonObject();

			jsonobj.addProperty("userId", user.getUserId());
			jsonobj.addProperty("success", false);
			jsonobj.addProperty("txId", indata.getTxId());
			jsonobj.addProperty("errMsg", "Transfer was not Successful");

			response = new Gson().toJson(jsonobj);

			return response;

		}

	}

	public String cancelTxHandler(CancelTxInput indata) {

		SiteUser user= usrdao.findByUserId(Long.parseLong(indata.getUserId()));
		String response;

		if (rv.validateCancelTxRequest(user, indata)) {

			JsonObject jsonobj = new JsonObject();

			jsonobj.addProperty("userId", user.getUserId());
			jsonobj.addProperty("success", true);

			response = new Gson().toJson(jsonobj);

			return response;

		} else {

			JsonObject jsonobj = new JsonObject();

			jsonobj.addProperty("userId", user.getUserId());
			jsonobj.addProperty("success", false);
			jsonobj.addProperty("errMsg", "Error");

			response = new Gson().toJson(jsonobj);

			return response;
		}

	}

}
