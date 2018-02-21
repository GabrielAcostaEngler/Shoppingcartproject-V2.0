package com.ShoppingCart.Project.springbootshoppingcart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "site_users")
public class SiteUser {

	@Id
	@Column(name = "userId")
	@GeneratedValue
	private Long userId;
	
	
	@Column(name="firstName")
	@NotBlank(message="{register.firstname.invalid}")
	private String firstName;
	
	@Column(name="lastName")
	@NotBlank(message="{register.lastname.invalid}")
	private String lastName;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="country")
	@NotBlank(message="{register.country.invalid}")
	private String country;
	
	@Column(name = "email", unique=true)
	@Email(message="{register.email.invalid}")
	@NotBlank(message="{register.email.invalid}")
	private String email;
	
	@Transient
	@Size(min=5, max=15, message="{register.password.size}")
	private String plainPassword;
	
	@Column(name="password", length=60)
	private String password;
	
	@Column(name="dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotBlank(message="{register.dob.invalid}")
	private String dob;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="balance")
	private Double balance;
	
	@Column(name="balanceCy")
	@NotBlank
	private String balanceCy;
	
	protected SiteUser() {
	}

	public SiteUser(String firstName, String lastName, String street, String city, String zip, String country,
			String email, String plainPassword, String dob, String mobile) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.password = new BCryptPasswordEncoder().encode(plainPassword);
		this.plainPassword = plainPassword;
		this.dob = dob;
		this.mobile = mobile;
		this.balanceCy = "";
		this.balance = 0.00;

		switch (country) {

		case "Sweden":
			this.balanceCy = "SEK";
			this.balance = 500.00;
			break;

		case "Spain":
			this.balanceCy = "EUR";
			this.balance = 50.87;
			break;

		case "United States":
			this.balanceCy = "USD";
			this.balance = 63.39;
			break;
			
		default:
			this.balanceCy = "EUR";
			this.balance = 50.87;
			break;

		}
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
	
	public String getPlainPassword() {
		return plainPassword;
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

	public void setPlainPassword(String plainPassword) {
		this.password = new BCryptPasswordEncoder().encode(plainPassword);
		this.plainPassword = plainPassword;
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
