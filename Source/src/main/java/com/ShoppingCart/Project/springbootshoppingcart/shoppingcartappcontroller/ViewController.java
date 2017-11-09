package com.ShoppingCart.Project.springbootshoppingcart.shoppingcartappcontroller;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ShoppingCart.Project.springbootshoppingcart.NetellerTxInput;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.PiqResponseHandler;
import com.google.gson.Gson;

@Controller
public class ViewController {
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String userloggedInPage() {
		return "userloggedin";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage() {
		return "loginpage";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerUserPage() {
		return "registerpage";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUserRequest() {
		
		
		
		
		return "";
		
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}
	

	@RequestMapping(value="/netellerdeposit", method = RequestMethod.GET)
	public String informationInputMapping(Model model) {

		model.addAttribute("netellerTxInput", new NetellerTxInput());

		return "netellerdepositform";
	}

	@RequestMapping(value="/netellerdeposit", method = RequestMethod.POST)
	public String netellerDepositRequest(@ModelAttribute NetellerTxInput netellerTxInput) {

		String piqUrl = "https://test-api.paymentiq.io/paymentiq/api/neteller/deposit/process";

		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(piqUrl);
			postRequest.setHeader("accept", "application/json");
			postRequest.setHeader("content-type", "application/json");
			
			netellerTxInput.setUserId(PiqResponseHandler.testuser.getUserId());
			netellerTxInput.setSessionId("2");
			netellerTxInput.setMerchantId("1992");
			
			String payLoad = new Gson().toJson(netellerTxInput);
			StringEntity reqEntity = new StringEntity(payLoad,"UTF-8");

			reqEntity.setChunked(false);
	        
			postRequest.setEntity(reqEntity);
			postRequest.setHeader("accept", "application/json");
			postRequest.setHeader("content-type", "application/json");

			HttpResponse response = client.execute(postRequest);
			HttpEntity respEntity = response.getEntity();
			
			String content = EntityUtils.toString(respEntity);
			System.out.println(content);
			
			

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
				
			}
			

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "result";

	}

}
