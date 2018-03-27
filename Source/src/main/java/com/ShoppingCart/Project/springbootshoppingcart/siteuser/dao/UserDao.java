package com.ShoppingCart.Project.springbootshoppingcart.siteuser.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingCart.Project.springbootshoppingcart.siteuser.SiteUser;

@Repository
public interface UserDao extends CrudRepository<SiteUser, Long> {

	SiteUser findByEmail(String email);
	
	SiteUser findByUserId(Long userId);
}
