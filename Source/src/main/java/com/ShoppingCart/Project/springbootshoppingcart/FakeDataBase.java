package com.ShoppingCart.Project.springbootshoppingcart;

import java.util.ArrayList;

public class FakeDataBase {

	
	private ArrayList<TUser> registeredUsers;
	
	
	//Constructor
	public FakeDataBase(ArrayList<TUser> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	
	//add user to DB
	public void addRegisteredUser(TUser user) {
		this.registeredUsers.add(user);
	}
	
	
	
	
	
	
	
	
	//Getters
	public ArrayList<TUser> getRegisteredUsers() {
		return registeredUsers;
	}

	
	//Setters
	public void setRegisteredUsers(ArrayList<TUser> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}
	
	
	
	
}
