package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import java.util.ArrayList;

import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.VerifyUserInput;

public class TxCmdHandler {
	
	private ArrayList<VerifyUserInput> txCmd = new ArrayList<VerifyUserInput>();
	
	
	
	public TxCmdHandler() {
	}


	public void addVerifyUserCmd(VerifyUserInput verifyUserInput) {
		this.txCmd.add(verifyUserInput);
	}
	
	
	public VerifyUserInput getLatestCmd(VerifyUserInput userInput) {
		
		for(int i = txCmd.size() - 1; i >= 0;) {
			return (VerifyUserInput) txCmd.get(i);
		}
		return null;
	}

}
