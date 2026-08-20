package com.backend.squaredeal.client.entity;

import java.time.LocalDateTime;

import com.backend.squaredeal.auth.entity.User;
import com.backend.squaredeal.tenant.entity.Tenant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id")
	private Tenant tenant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agent_id")
	private User user;
	
	private String clientName;
	
	@Column(unique = true,length = 10)
	private String phone;
	
	@Column(nullable = true,length = 10)
	private String alternatePhone;
	
	@Column(nullable = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ClientType clientType;
	
	private String source;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ClientStatus status;
	
	private String priority;
	private String address;
	private String city;
	private String state;
	
	@Column(length = 6)
	private String pincode;
	private String country;
	private String occupation;
	private String companyName;
	private String notes;
	private Boolean isActive = true;
	private LocalDateTime  createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime  deletedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAlternatePhone() {
		return alternatePhone;
	}
	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ClientType getClientType() {
		return clientType;
	}
	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public ClientStatus getStatus() {
		return status;
	}
	public void setStatus(ClientStatus status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Client(Long id, Tenant tenant, User user, String clientName, String phone, String alternatePhone,
			String email, ClientType clientType, String source, ClientStatus status, String priority, String address,
			String city, String state, String pincode, String country, String occupation, String companyName,
			String notes, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt,Boolean isActive) {
		super();
		this.id = id;
		this.tenant = tenant;
		this.user = user;
		this.clientName = clientName;
		this.phone = phone;
		this.alternatePhone = alternatePhone;
		this.email = email;
		this.clientType = clientType;
		this.source = source;
		this.status = status;
		this.priority = priority;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.occupation = occupation;
		this.companyName = companyName;
		this.notes = notes;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.isActive = isActive;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


}
