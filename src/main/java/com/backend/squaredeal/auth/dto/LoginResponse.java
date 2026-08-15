package com.backend.squaredeal.auth.dto;

public class LoginResponse {
	private String token;

    private String username;

    private String role;
    
    private Long tenantId;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Long getTenantId() {
		return tenantId;
	}
	
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public LoginResponse(String token, String username, String role,Long tenantId) {
		super();
		this.token = token;
		this.username = username;
		this.role = role;
		this.tenantId = tenantId;
	}

	public LoginResponse() {
		super();
	}
    
}
