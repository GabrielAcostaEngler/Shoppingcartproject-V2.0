package com.ShoppingCart.Project.springbootshoppingcart;

public class NetellerTxInput {

	// attributes
	private String Sessionid;
	private String userid;
	private String merchantid;
	private String amount;
	private String bonuscode;
	private String account;
	private String accountid;
	private String secureid;
	// Constructor


	// Getters
	public String getSessionid() {
		return Sessionid;
	}

	public String getUserid() {
		return userid;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public String getAmount() {
		return amount;
	}

	public String getBonuscode() {
		return bonuscode;
	}

	public String getAccount() {
		return account;
	}

	public String getAccountid() {
		return accountid;
	}

	public String getSecureid() {
		return secureid;
	}

	// Setters
	public void setSessionid(String sessionid) {
		Sessionid = sessionid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setBonuscode(String bonuscode) {
		this.bonuscode = bonuscode;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public void setSecureid(String secureid) {
		this.secureid = secureid;
	}

	@Override
	public String toString() {
		return "Neteller [Sessionid=" + Sessionid + ", userid=" + userid + ", merchantid=" + merchantid + ", amount="
				+ amount + ", bonuscode=" + bonuscode + ", account=" + account + ", accountid=" + accountid
				+ ", secureid=" + secureid + "]";
	}

}