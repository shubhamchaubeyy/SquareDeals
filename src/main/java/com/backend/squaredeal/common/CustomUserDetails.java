package com.backend.squaredeal.common;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.backend.squaredeal.auth.entity.Role;

public class CustomUserDetails implements UserDetails {

	private final Long userId;

	private final String username;

	private final String password;

	private final Long tenantId;

	private final Role role;

	private final boolean active;

	public CustomUserDetails(Long userId, String username, String password, Long tenantId, Role role, boolean active) {

		this.userId = userId;
		this.username = username;
		this.password = password;
		this.tenantId = tenantId;
		this.role = role;
		this.active = active;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
    public boolean isEnabled() {

        return active;
    }
}