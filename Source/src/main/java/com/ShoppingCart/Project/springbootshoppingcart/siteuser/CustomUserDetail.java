package com.ShoppingCart.Project.springbootshoppingcart.siteuser;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private SiteUser siteUser;
	
	Set<GrantedAuthority> authorities=null;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return siteUser.getPassword();
	}

	@Override
	public String getUsername() {
		return siteUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return siteUser.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return siteUser.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return siteUser.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return siteUser.isEnabled();
	}

}
