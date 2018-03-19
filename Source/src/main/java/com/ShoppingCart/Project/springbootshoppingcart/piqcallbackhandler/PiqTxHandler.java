package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ShoppingCart.Project.springbootshoppingcart.SiteUser;
import com.ShoppingCart.Project.springbootshoppingcart.UserDao;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.*;


@Component
public class PiqTxHandler {

	@Autowired
	UserDao userDao;
	
	
	private PiqCallbackValidator callbackValid = new PiqCallbackValidator();
	private PiqValidateObject pvo = new PiqValidateObject();
	private TxCmdHandler cmdHandler = new TxCmdHandler();
	private PiqJsonResponseHandler piqJsonResponse = new PiqJsonResponseHandler();
	


	public PiqTxHandler() {

	}
	
	
	
	public String verifyUserHandler(VerifyUserInput indata) {
		
		cmdHandler.addVerifyUserCmd(indata);
		
		SiteUser user= userDao.findByUserId(Long.parseLong(indata.getUserId()));
	
		if (callbackValid.validateVerifyUserRequest(user, indata, pvo).isSuccess()) {
			
			return piqJsonResponse.verifyUserSuccess(user);
			
		} else {

			return piqJsonResponse.verifyUserFailed(user, indata, pvo);
			
		}
	}

	public String authorizeTxHandler(AuthorizeTxInput indata) {
		
		VerifyUserInput userInput = cmdHandler.getLatestCmd();
		
		System.out.println(userInput.toString());
		
		SiteUser user= userDao.findByUserId(Long.parseLong(indata.getUserId()));


		if (callbackValid.validateAutorizeTxRequest(user, indata, pvo).isSuccess()) {

			return piqJsonResponse.authorizeTxSuccess(user);

		} else {

			return piqJsonResponse.authorizeTxFailed(user, pvo);
		}
	}

	public String transferTxHandler(TransferTxInput indata) {

		SiteUser user= userDao.findByUserId(Long.parseLong(indata.getUserId()));
		Double balanceAfterTransaction;

		if (callbackValid.validateTransferTxRequest(user, indata, pvo).isSuccess()) {

			balanceAfterTransaction = user.getBalance() + indata.getTxAmount();
			user.setBalance(balanceAfterTransaction);
			userDao.save(user);

			return piqJsonResponse.transferTxSucess(user, indata);

		} else {

			return piqJsonResponse.transferTxFailed(user, indata, pvo);

		}

	}

	public String cancelTxHandler(CancelTxInput indata) {

		SiteUser user= userDao.findByUserId(Long.parseLong(indata.getUserId()));

		if (callbackValid.validateCancelTxRequest(user, indata, pvo).isSuccess()) {

			return piqJsonResponse.cancelTxSuccess(user);

		} else {
			
			return piqJsonResponse.cancelTxFailed(user, pvo);
		}

	}

}
