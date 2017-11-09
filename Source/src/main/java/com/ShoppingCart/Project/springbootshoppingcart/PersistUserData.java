package com.ShoppingCart.Project.springbootshoppingcart;

import java.util.ArrayList;

public class PersistUserData {

	private ArrayList<User> registeredUserlist = new ArrayList<>();

	public ArrayList<User> persistedUserList() {
		return this.registeredUserlist;
	}

	public void registerUser(User user) {
		this.registeredUserlist.add(user);
	}

}
