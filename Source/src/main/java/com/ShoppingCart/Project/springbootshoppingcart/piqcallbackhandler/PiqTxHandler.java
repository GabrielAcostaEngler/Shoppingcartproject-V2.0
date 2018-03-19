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
	
	@Autowired
	PiqTxDao piqTxDao;
	
	
	private PiqCallbackValidator callbackValid = new PiqCallbackValidator();
	private PiqValidateObject pvo = new PiqValidateObject();
	private TxCmdHandler cmdHandler = new TxCmdHandler();
	private PiqJsonResponseHandler piqJsonResponse = new PiqJsonResponseHandler();
	


	public PiqTxHandler() {

	}
	
	
	
	public String verifyUserHandler(VerifyUserInput indata) {
		
		cmdHandler.addVerifyUserCmd(indata);
		String response;
		SiteUser user= userDao.findByUserId(Long.parseLong(indata.getUserId()));
	
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
		piqTxDao.save(piqTx);
		
		String response;
		SiteUser user= userDao.findByUserId(Long.parseLong(indata.getUserId()));


		if (callbackValid.validateAutorizeTxRequest(user, indata, pvo).isSuccess()) {
			
			response = piqJsonResponse.authorizeTxSuccess(user,piqTx);
		
			piqTx.setAuthorizeTxResponse(response);
			piqTxDao.save(piqTx);

			return response;

		} else {
			
			response = piqJsonResponse.authorizeTxFailed(user, pvo);
			
			piqTx.setAuthorizeTxResponse(response);
			piqTxDao.save(piqTx);
			
			return response;
		}
	}

	public String transferTxHandler(TransferTxInput indata) {
		PiqTx piqTx = piqTxDao.findByPiqTxId(indata.getTxId());
		
		piqTx.setAuthCode(indata.getAuthCode());
		piqTx.setTxPspAmount(indata.getTxPspAmount());
		piqTx.setTxPspAmountCy(indata.getTxPspAmountCy());
		piqTx.setFee(indata.getFee());
		piqTx.setFeeCy(indata.getFeeCy());
		piqTx.setTxRefId(indata.getTxRefId());
		
		piqTxDao.save(piqTx);

		String response;
		SiteUser user= userDao.findByUserId(Long.parseLong(indata.getUserId()));
		Double balanceAfterTransaction;

		if (callbackValid.validateTransferTxRequest(user, indata, pvo).isSuccess()) {

			balanceAfterTransaction = user.getBalance() + indata.getTxAmount();
			user.setBalance(balanceAfterTransaction);
			userDao.save(user);
			
			response = piqJsonResponse.transferTxSucess(user, indata, piqTx);
			
			piqTx.setTransferTxResponse(response);
			piqTxDao.save(piqTx);
			

			return response;

		} else {

			response = piqJsonResponse.transferTxFailed(user, indata, pvo);
			
			piqTx.setTransferTxResponse(response);
			piqTxDao.save(piqTx);
			
			return response;

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
