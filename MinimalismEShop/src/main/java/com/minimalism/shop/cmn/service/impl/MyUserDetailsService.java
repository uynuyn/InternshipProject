package com.minimalism.shop.cmn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserServiceImpl userService;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = userService.findUserbyUsername(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getPermissions());
		return buildUserForAuthentication(user, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<Permission> permissions) {

		List<GrantedAuthority> setAuths = new ArrayList<>();

		// Build user's authorities
		for (Permission permission : permissions) {
			setAuths.add(new SimpleGrantedAuthority(permission.getRole().getRole()));
		}

		return setAuths;
	}

	private org.springframework.security.core.userdetails.User 
				buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User
				(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}

}
