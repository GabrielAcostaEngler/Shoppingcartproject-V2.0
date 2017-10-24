package com.ShoppingCart.Project.springbootshoppingcart;

public class User {
	
	private String userId;
	private String sessionId;
	private boolean success;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String zip;
	private String country;
	private String email;
	private String dob;
	private String mobile;
	private Double balance;
	private String balanceCy;
	private String locale;
	
	//constructor
	public User(String userId, boolean success, String firstName, String lastName, String street, String city,
			String zip, String country, String email, String dob, String mobile, double balance, String balanceCy,
			String locale) {
		super();
		this.userId = userId;
		this.success = success;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.dob = dob;
		this.mobile = mobile;
		this.balance = balance;
		this.balanceCy = balanceCy;
		this.locale = locale;
	}
	
	
	//Getters

	public String getUserId() {
		return userId;
	}


	public String getSessionId() {
		return sessionId;
	}


	public boolean isSuccess() {
		return success;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getStreet() {
		return street;
	}


	public String getCity() {
		return city;
	}


	public String getZip() {
		return zip;
	}


	public String getCountry() {
		return country;
	}


	public String getEmail() {
		return email;
	}


	public String getDob() {
		return dob;
	}


	public String getMobile() {
		return mobile;
	}


	public double getBalance() {
		return balance;
	}


	public String getBalanceCy() {
		return balanceCy;
	}


	public String getLocale() {
		return locale;
	}
	
	

	//Setters
	
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public void setBalanceCy(String balanceCy) {
		this.balanceCy = balanceCy;
	}


	public void setLocale(String locale) {
		this.locale = locale;
	}

	
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", sessionId=" + sessionId + ", success=" + success + ", firstName="
				+ firstName + ", lastName=" + lastName + ", street=" + street + ", city=" + city + ", zip=" + zip
				+ ", country=" + country + ", email=" + email + ", dob=" + dob + ", mobile=" + mobile + ", balance="
				+ balance + ", balanceCy=" + balanceCy + ", locale=" + locale + "]";
	}


	
	
	
	
	
}
