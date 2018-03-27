package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.*;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.PiqTx;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.service.PiqTxService;
import com.ShoppingCart.Project.springbootshoppingcart.siteuser.SiteUser;
import com.ShoppingCart.Project.springbootshoppingcart.siteuser.service.UserService;


@Component
public class PiqTxHandler {

	@Autowired
	UserService userService;
	
	@Autowired
	PiqTxService piqTxService;
	
	
	private PiqCallbackValidator callbackValid = new PiqCallbackValidator();
	private PiqValidateObject pvo = new PiqValidateObject();
	private TxCmdHandler cmdHandler = new TxCmdHandler();
	private PiqJsonResponseHandler piqJsonResponse = new PiqJsonResponseHandler();


	public PiqTxHandler() {
		
	}
	
	
	public String verifyUserHandler(VerifyUserInput indata) {
		
		cmdHandler.addVerifyUserCmd(indata);
		String response;
		SiteUser user= userService.findByUserId(Long.parseLong(indata.getUserId()));
	
		if (callbackValid.validateVerifyUserRequest(user, indata, pvo).isSuccess()) {
			
			response = piqJsonResponse.verifyUserSuccess(user);
			cmdHandler.addVerifyUserRespCmd(response);
			
			return response;
			
		} else {
			
			response = piqJsonResponse.verifyUserFailed(user, indata, pvo);

			return response;
			
		}
	}

	public String authorizeTxHandler(AuthorizeTxInput indata) {
		
		VerifyUserInput verifyUserData = cmdHandler.getLatestVerifyUserCmd();
		String verifyUserRespData = cmdHandler.getLatestVerifyUserRespCmd();
		
		PiqTx piqTx = new PiqTx();
		piqTx.setUserId(verifyUserData.getUserId());
		piqTx.setSessionId(verifyUserData.getSessionId());
		piqTx.setTxAmount(indata.getTxAmount());
		piqTx.setTxAmountCy(indata.getTxAmountCy());
		piqTx.setPiqTxId(indata.getTxId());
		piqTx.setTxTypeId(indata.getTxTypeId());
		piqTx.setTxName(indata.getTxName());
		piqTx.setProvider(indata.getProvider());
		piqTx.setVerifyUserResponse(verifyUserRespData);
		piqTxService.saveTx(piqTx);
		
		String response;
		SiteUser user= userService.findByUserId(Long.parseLong(indata.getUserId()));


		if (callbackValid.validateAutorizeTxRequest(user, indata, pvo).isSuccess()) {
			
			response = piqJsonResponse.authorizeTxSuccess(user,piqTx);
		
			piqTx.setAuthorizeTxResponse(response);
			piqTx.setTxSuccess("SUCCESS");
			piqTxService.saveTx(piqTx);

			return response;

		} else {
			
			response = piqJsonResponse.authorizeTxFailed(user, pvo);
			
			piqTx.setAuthorizeTxResponse(response);
			piqTx.setTxSuccess("FAILED");
			piqTx.setTxMsg(pvo.getResultMessage());
			piqTxService.saveTx(piqTx);
			
			return response;
		}
	}

	public String transferTxHandler(TransferTxInput indata) {
		
		PiqTx piqTx = piqTxService.findByPiqTxId(indata.getTxId());
		
		piqTx.setAuthCode(indata.getAuthCode());
		piqTx.setTxPspAmount(indata.getTxPspAmount());
		piqTx.setTxPspAmountCy(indata.getTxPspAmountCy());
		piqTx.setFee(indata.getFee());
		piqTx.setFeeCy(indata.getFeeCy());
		piqTx.setTxRefId(indata.getTxRefId());
		
		piqTxService.saveTx(piqTx);

		String response;
		SiteUser user= userService.findByUserId(Long.parseLong(indata.getUserId()));
		Double balanceAfterTransaction;

		if (callbackValid.validateTransferTxRequest(user, indata, pvo).isSuccess()) {

			balanceAfterTransaction = user.getBalance() + indata.getTxAmount();
			user.setBalance(balanceAfterTransaction);
			userService.saveUser(user);
			
			response = piqJsonResponse.transferTxSucess(user, indata, piqTx);
			
			piqTx.setTransferTxResponse(response);
			piqTx.setTxSuccess("SUCCESS");
			piqTxService.saveTx(piqTx);
			

			return response;

		} else {

			response = piqJsonResponse.transferTxFailed(user, indata, pvo);
			
			piqTx.setTransferTxResponse(response);
			piqTx.setTxSuccess("FAILED");
			piqTx.setTxMsg(pvo.getResultMessage());
			piqTxService.saveTx(piqTx);
			
			return response;

		}

	}

	public String cancelTxHandler(CancelTxInput indata) {

		PiqTx piqTx = piqTxService.findByPiqTxId(indata.getTxId());
		
		String response;
		SiteUser user= userService.findByUserId(Long.parseLong(indata.getUserId()));

		if (callbackValid.validateCancelTxRequest(user, indata, pvo).isSuccess()) {

			response = piqJsonResponse.cancelTxSuccess(user);
			piqTx.setCancelTxResponse(response);
			
			return response;

		} else {
			
			response = piqJsonResponse.cancelTxFailed(user, pvo);
			piqTx.setTxSuccess("FAILED");
			piqTx.setTxMsg(pvo.getResultMessage());
			piqTx.setCancelTxResponse(response);
			
			return response;
		}

	}

}
