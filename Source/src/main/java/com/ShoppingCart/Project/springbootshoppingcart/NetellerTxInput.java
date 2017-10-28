package com.ShoppingCart.Project.springbootshoppingcart;

public class NetellerTxInput {

	// attributes
	private String sessionId;
	private String userId;
	private String merchantId;
	private String amount;
	private String bonusCode;
	private String account;
	private String accountId;
	private String secureId;
	// Constructor


	// Getters
	public String getSessionId() {
		return sessionId;
	}

	public String getUserId() {
		return userId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public String getAmount() {
		return amount;
	}

	public String getBonusCode() {
		return bonusCode;
	}

	public String getAccount() {
		return account;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getSecureId() {
		return secureId;
	}

	// Setters
	public void setSessionId(String sessionid) {
		sessionId = sessionid;
	}

	public void setUserId(String userid) {
		this.userId = userid;
	}

	public void setMerchantId(String merchantid) {
		this.merchantId = merchantid;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setBonusCode(String bonuscode) {
		this.bonusCode = bonuscode;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setAccountId(String accountid) {
		this.accountId = accountid;
	}

	public void setSecureId(String secureid) {
		this.secureId = secureid;
	}

	@Override
	public String toString() {
		return "Neteller [Sessionid=" + sessionId + ", userid=" + userId + ", merchantid=" + merchantId + ", amount="
				+ amount + ", bonuscode=" + bonusCode + ", account=" + account + ", accountid=" + accountId
				+ ", secureid=" + secureId + "]";
	}

}