package com.ShoppingCart.Project.springbootshoppingcart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "site_users")
public class SiteUser {

	protected SiteUser(){}

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long userId;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String zip;
	private String country;
	@Column(name = "email")
	private String email;
	private String password;
	private String dob;
	private String mobile;
	private Double balance;
	private String balanceCy;

	public SiteUser(String firstName, String lastName, String street, String city, String zip, String country,
			String email, String password, String dob, String mobile) {
		
		Double startingBalance = 500.00;
		String standardBalanceCy = "SEK";

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

	// getters
	public Long getUserId() {
		return userId;
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

	public Double getBalance() {
		return balance;
	}

	public String getBalanceCy() {
		return balanceCy;
	}

	// setters

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public void setPassword(String password) {
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

	// toString
	@Override
	public String toString() {
		return "SiteUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", street="
				+ street + ", city=" + city + ", zip=" + zip + ", country=" + country + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", mobile=" + mobile + ", balance=" + balance
				+ ", balanceCy=" + balanceCy + "]";
	}

}
