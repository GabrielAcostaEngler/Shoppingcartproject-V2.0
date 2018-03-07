package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.callbackinput.*;

@Entity
public class PiqTx {
	
	
	@Id
	@GeneratedValue
	private int txId;
	private String userId;
	private String sessionId;
	private Double txAmount;
	private String txAmountCy;
	private int txTypeId;
	private String txName;
	private String provider;
	private String authCode;
	private String txPspAmount;
	private String txPspAmountCy;
	private String fee;
	private String feeCy;
	private String txRefId;
	

	//getters
	public int getTxId() {
		return txId;
	}
	public String getUserId() {
		return userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public Double getTxAmount() {
		return txAmount;
	}
	public String getTxAmountCy() {
		return txAmountCy;
	}
	public int getTxTypeId() {
		return txTypeId;
	}
	public String getTxName() {
		return txName;
	}
	public String getProvider() {
		return provider;
	}
	public String getAuthCode() {
		return authCode;
	}
	public String getTxPspAmount() {
		return txPspAmount;
	}
	public String getTxPspAmountCy() {
		return txPspAmountCy;
	}
	public String getFee() {
		return fee;
	}
	public String getFeeCy() {
		return feeCy;
	}
	public String getTxRefId() {
		return txRefId;
	}

	
	//setters
	
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public void setTxAmount(Double txAmount) {
		this.txAmount = txAmount;
	}
	public void setTxAmountCy(String txAmountCy) {
		this.txAmountCy = txAmountCy;
	}
	public void setTxTypeId(int txTypeId) {
		this.txTypeId = txTypeId;
	}
	public void setTxName(String txName) {
		this.txName = txName;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public void setTxPspAmount(String txPspAmount) {
		this.txPspAmount = txPspAmount;
	}
	public void setTxPspAmountCy(String txPspAmountCy) {
		this.txPspAmountCy = txPspAmountCy;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public void setFeeCy(String feeCy) {
		this.feeCy = feeCy;
	}
	public void setTxRefId(String txRefId) {
		this.txRefId = txRefId;
	}



	

}
