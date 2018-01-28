package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

public class PiqValidateObject {
	
	
	boolean success;
	String resultMessage = "";
	
	final String ERROR_USERID_DOES_NOT_MATCH = "ERROR_USERID_DOES_NOT_MATCH";


	public PiqValidateObject() {
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getResultMessage() {
		return resultMessage;
	}


	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	

}
