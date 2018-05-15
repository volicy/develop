package com.security.test.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserDetailsService{
	private Log log = LogFactory.getLog(getClass());
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("name:   "+username);
		String password = "111";
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired= true;
		boolean accountNonLocked = true;
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
		
		List<SimpleGrantedAuthority> list = Arrays.asList(simpleGrantedAuthority);
		
		return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, list);
	}

}
