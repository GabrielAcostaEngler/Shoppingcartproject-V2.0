package com.ShoppingCart.Project.springbootshoppingcart;

public class UserRegistrationValidator {
	
	
	
	
	public boolean validateUserEmailReg(User reguser, MockDBHandler udh) {
		
		for(User i : udh.mockDB.getRegisteredUsers()) {
			if(i.getEmail().equals(reguser.getEmail())) {
				
				return false;
			}
		}
		return true;
	}
	
}
