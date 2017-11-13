package com.ShoppingCart.Project.springbootshoppingcart;

import java.util.ArrayList;

public class FakeDataBase {

	
	private ArrayList<User> registeredUsers;
	
	
	//Constructor
	public FakeDataBase(ArrayList<User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	
	//add user to DB
	public void addRegisteredUser(User user) {
		this.registeredUsers.add(user);
	}
	
	
	
	
	
	
	
	
	//Getters
	public ArrayList<User> getRegisteredUsers() {
		return registeredUsers;
	}

	
	//Setters
	public void setRegisteredUsers(ArrayList<User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}
	
	
	
	
}
