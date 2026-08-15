package com.backend.squaredeal.common;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${jwt.secret-key}")
	private String secretKey;

	@Value("${jwt.expiration-time}")
	private long expirationTime;

	private SecretKey getSigningKey() {

		return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
	}

	public String generateToken(CustomUserDetails userDetails) {

		return Jwts.builder()

				.subject(userDetails.getUsername())

				// User ID
				.claim("userId", userDetails.getUserId())

				// Tenant ID
				// NULL for SUPER_ADMIN
				.claim("tenantId", userDetails.getTenantId())

				// Role
				.claim("role", userDetails.getRole().name())

				// Authorities
				.claim("roles", userDetails.getAuthorities().stream().map(auth -> auth.getAuthority()).toList())

				.issuedAt(new Date())

				.expiration(new Date(System.currentTimeMillis() + expirationTime))

				.signWith(getSigningKey())

				.compact();
	}

	public String extractUsername(String token) {

		return Jwts.parser()

				.verifyWith(getSigningKey())

				.build()

				.parseSignedClaims(token)

				.getPayload()

				.getSubject();
	}

	public Long extractUserId(String token) {

		return Jwts.parser()

				.verifyWith(getSigningKey())

				.build()

				.parseSignedClaims(token)

				.getPayload()

				.get("userId", Long.class);
	}

	public Long extractTenantId(String token) {

		return Jwts.parser()

				.verifyWith(getSigningKey())

				.build()

				.parseSignedClaims(token)

				.getPayload()

				.get("tenantId", Long.class);
	}

	public String extractRole(String token) {

		return Jwts.parser()

				.verifyWith(getSigningKey())

				.build()

				.parseSignedClaims(token)

				.getPayload()

				.get("role", String.class);
	}

	private boolean isTokenExpired(String token) {

		Date expirationDate = Jwts.parser()

				.verifyWith(getSigningKey())

				.build()

				.parseSignedClaims(token)

				.getPayload()

				.getExpiration();

		return expirationDate.before(new Date());
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {

		try {

			String username = extractUsername(token);

			return username.equals(userDetails.getUsername()) && !isTokenExpired(token);

		} catch (JwtException | IllegalArgumentException e) {

			return false;
		}
	}
}