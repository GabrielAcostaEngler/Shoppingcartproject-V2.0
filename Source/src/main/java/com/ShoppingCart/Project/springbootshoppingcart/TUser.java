package com.ShoppingCart.Project.springbootshoppingcart;

import java.util.UUID;

public class TUser {
	
	private String userId;
	private String sessionId;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String zip;
	private String country;
	private String email;
	private String password;
	private String dob;
	private String mobile;
	private Double balance;
	private String balanceCy;
	
	//constructor
	public TUser(String firstName, String lastName, String street, String city,
			String zip, String country, String email,String password, String dob, String mobile) {
		
		UUID userIdConstructor = UUID.randomUUID();
		double startingBalance = 500.00;
		String standardBalanceCy = "SEK";
		
		this.userId = userIdConstructor.toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.mobile = mobile;
		this.balance = startingBalance;
		this.balanceCy = standardBalanceCy;
	}
	
	
	//Getters

	public String getUserId() {
		return userId;
	}


	public String getSessionId() {
		return sessionId;
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
	
	public String getPassword() {
		return password;
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
	

	//Setters
	
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
	
	public void setPassword (String password) {
		this.password = password;
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
	
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", sessionId=" + sessionId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", street=" + street + ", city=" + city + ", zip=" + zip
				+ ", country=" + country + ", email=" + email + ", dob=" + dob + ", mobile=" + mobile + ", balance="
				+ balance + ", balanceCy=" + balanceCy+ "]";
	}


	
	
	
	
	
}
