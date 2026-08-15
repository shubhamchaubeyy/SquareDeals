package com.backend.squaredeal.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.squaredeal.auth.entity.User;
import com.backend.squaredeal.auth.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private  UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String username)
	        throws UsernameNotFoundException {

	    System.out.println("LOGIN USERNAME = " + username);

	    User user = userRepository
	            .findByUsername(username)
	            .orElseThrow(() ->
	                    new UsernameNotFoundException(
	                            "User not found: " + username
	                    )
	            );

	    System.out.println("USER FOUND = " + user.getUsername());
	    System.out.println("ROLE = " + user.getRole());
	    System.out.println("ACTIVE = " + user.isActive());
	    System.out.println(
	            "TENANT = " +
	            (user.getTenant() == null
	                    ? null
	                    : user.getTenant().getId())
	    );

	    Long tenantId =
	            user.getTenant() == null
	                    ? null
	                    : user.getTenant().getId();

	    return new CustomUserDetails(
	            user.getId(),
	            user.getUsername(),
	            user.getPassword(),
	            tenantId,
	            user.getRole(),
	            user.isActive()
	    );
	}
}
