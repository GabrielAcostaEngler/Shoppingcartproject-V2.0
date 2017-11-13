package com.ShoppingCart.Project.springbootshoppingcart;

import java.util.ArrayList;

public class MockDBHandler {

	private UserRegistrationValidator usv;
	public FakeDataBase mockDB = new FakeDataBase(new ArrayList<User>());

	public void userRegistrationHandler(User regUser) {

		/*if (usv.validateUserEmailReg(regUser) == false) {

			
		}*/
		
		mockDB.addRegisteredUser(regUser);
	}

}
