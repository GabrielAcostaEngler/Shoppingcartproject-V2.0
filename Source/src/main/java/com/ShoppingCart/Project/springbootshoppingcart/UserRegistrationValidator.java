package com.ShoppingCart.Project.springbootshoppingcart;

public class UserRegistrationValidator {
	
	
	
	
	public boolean validateUserEmailReg(TUser reguser, MockDBHandler udh) {
		
		for(TUser i : udh.mockDB.getRegisteredUsers()) {
			if(i.getEmail().equals(reguser.getEmail())) {
				
				return false;
			}
		}
		return true;
	}
	
}
