package com.backend.squaredeal.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.backend.squaredeal.auth.dto.LoginRequest;
import com.backend.squaredeal.auth.dto.LoginResponse;
import com.backend.squaredeal.auth.entity.Role;
import com.backend.squaredeal.auth.entity.User;
import com.backend.squaredeal.auth.repository.UserRepository;
import com.backend.squaredeal.common.CustomUserDetails;
import com.backend.squaredeal.common.JwtService;
import com.backend.squaredeal.tenant.entity.Tenant;
import com.backend.squaredeal.tenant.repository.TenantRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TenantRepository tenantRepository;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

		String token = jwtService.generateToken(userDetails);

		return new LoginResponse(token, userDetails.getUsername(), userDetails.getRole().name(),
				userDetails.getTenantId());
	}


	@PostMapping("/create-superadmin")
	public String createsuperadmin() {
//		 Tenant tenant = tenantRepository.findById((long) 1).orElseThrow(() -> new
//		 RuntimeException("Tenant not found"));
		User newUser = new User();
		newUser.setUsername("superadmin");
		newUser.setPassword(passwordEncoder.encode("123456"));
		newUser.setRole(Role.SUPERADMIN);
		newUser.setActive(true);
		newUser.setTenant(null); 
		userRepository.save(newUser);
		return "Successfully added";
	}
	@PostMapping("/create-admin")
	public String createadmin() {
		 Tenant tenant = tenantRepository.findById((long) 3).orElseThrow(() -> new
		 RuntimeException("Tenant not found"));
		User newUser = new User();
		newUser.setUsername("admin3");
		newUser.setPassword(passwordEncoder.encode("123456"));
		newUser.setRole(Role.ADMIN);
		newUser.setActive(true);
		newUser.setTenant(tenant); 
		userRepository.save(newUser);
		return "Successfully added";
	}
}