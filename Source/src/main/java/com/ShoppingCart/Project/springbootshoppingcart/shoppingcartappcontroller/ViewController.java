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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ShoppingCart.Project.springbootshoppingcart.NetellerTxInput;
import com.google.gson.Gson;

@Controller
public class ViewController {
	
	
	@GetMapping("/register")
	public String registerUserPage() {
		return "register";
	}
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	

	@GetMapping("/submitinput")
	public String informationInputMapping(Model model) {

		model.addAttribute("netellerTxInput", new NetellerTxInput());

		return "submitinput";
	}

	@PostMapping("/submitinput")
	public String informationInput(@ModelAttribute NetellerTxInput netellerTxInput) {

		String piqUrl = "https://test-api.paymentiq.io/paymentiq/api/neteller/deposit/process";

		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(piqUrl);
			postRequest.setHeader("accept", "application/json");
			postRequest.setHeader("content-type", "application/json");
			
			netellerTxInput.setUserId("1");
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
