package com.ShoppingCart.Project.springbootshoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


	@Autowired
	private UserDao usrDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	public void register(SiteUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		usrDao.save(user);
	}
	public SiteUser getCurrentSiteUser() {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		SiteUser siteUser = usrDao.findByEmail(name);
		
		return siteUser;
	}
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		SiteUser user = usrDao.findByEmail(email);
		
		if (user == null) {
			
			
			return null;
			
		}
		
		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String password = user.getPassword();
		
		return new User(email,password,auth);
		
	}
}
