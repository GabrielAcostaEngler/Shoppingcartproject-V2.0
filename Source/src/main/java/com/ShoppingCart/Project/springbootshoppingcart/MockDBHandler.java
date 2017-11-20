package com.ShoppingCart.Project.springbootshoppingcart;

import java.util.ArrayList;

public class MockDBHandler {

	private UserRegistrationValidator usv;
	public FakeDataBase mockDB = new FakeDataBase(new ArrayList<TUser>());

	public void userRegistrationHandler(TUser regUser) {

		/*if (usv.validateUserEmailReg(regUser) == false) {

			
		}*/
		
		mockDB.addRegisteredUser(regUser);
	}

}
