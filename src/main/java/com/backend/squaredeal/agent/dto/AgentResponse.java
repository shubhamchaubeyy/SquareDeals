package com.backend.squaredeal.agent.dto;

import com.backend.squaredeal.auth.entity.Role;

public class AgentResponse {
	private Long   userId;
	private String name;
	private String email;
	private String phone;
	private String username;
	private Role role;
	private boolean isActive ; 
    private Long tenant_id;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Long getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(Long tenant_id) {
		this.tenant_id = tenant_id;
	}
	
	
	public AgentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgentResponse(Long userId, String name, String email, String phone, String username, Role role,
			boolean isActive, Long tenant_id) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.role = role;
		this.isActive = isActive;
		this.tenant_id = tenant_id;
	}
	
}
