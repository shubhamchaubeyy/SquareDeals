package com.backend.squaredeal.auth.dto;


import com.backend.squaredeal.auth.entity.Role;


public class UserRequest {
	
	private String name;
	private String email;
	private String phone;
	private String username;
	private String password;
	private Role role;
    private Long tenantId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRequest(String name, String email, String phone, String username, String password, Role role,
			Long tenantId) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.role = role;
		this.tenantId = tenantId;
	}
    
    
}
