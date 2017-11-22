package com.ShoppingCart.Project.springbootshoppingcart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<SiteUser, Long> {

	SiteUser findByEmail(String email);

	SiteUser findByUserId(Long userId);
}
