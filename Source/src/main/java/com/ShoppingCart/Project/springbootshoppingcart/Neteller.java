package com.ShoppingCart.Project.springbootshoppingcart;

public class Neteller {
	
	//attributes
	private String Sessionid;
	private String userid;
	private String merchantid;
	private String amount;
	private String bonuscode;
	private String account;
	private String accountid;
	private String secureid;
	private Object attributes;

	//Constructor
	public Neteller(String sessionid, String userid, String merchantid, String amount, String bonuscode, String account,
			String accountid, String secureid, Object attributes) {
		super();
		Sessionid = sessionid;
		this.userid = userid;
		this.merchantid = merchantid;
		this.amount = amount;
		this.bonuscode = bonuscode;
		this.account = account;
		this.accountid = accountid;
		this.secureid = secureid;
		this.attributes = attributes;
	}
	
	
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
	public Object getAttributes() {
		return attributes;
	}
	
	
	
	@Override
	public String toString() {
		return "Neteller [Sessionid=" + Sessionid + ", userid=" + userid + ", merchantid=" + merchantid + ", amount="
				+ amount + ", bonuscode=" + bonuscode + ", account=" + account + ", accountid=" + accountid
				+ ", secureid=" + secureid + ", attributes=" + attributes + "]";
	}
	
	
	
}