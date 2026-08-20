package com.backend.squaredeal.tenant.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tenants")
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String businessName;
	private String businessCode;
	private String ownerName;
	@Column(unique = true)
	String email;
	
	@Column(unique = true,length = 10)
	private String phone;
	private String address;
	private String city;
	private String state;
	private String country;
	
	@Column(length = 6)
	private String pincode;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;
	private Boolean isActive = true;
	
	@Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;
	
	private LocalDate subscriptionStartDate;

    private LocalDate subscriptionEndDate;
    
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
	
	public Boolean getActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public SubscriptionStatus getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public LocalDate getSubscriptionStartDate() {
		return subscriptionStartDate;
	}
	public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}
	public LocalDate getSubscriptionEndDate() {
		return subscriptionEndDate;
	}
	public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}
	
	
	public Tenant(long id, String businessName, String businessCode, String ownerName, String email, String phone,
			String address, String city, String state, String country, String pincode, Status status, Boolean isActive,
			SubscriptionStatus subscriptionStatus, LocalDate subscriptionStartDate, LocalDate subscriptionEndDate,
			LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.businessCode = businessCode;
		this.ownerName = ownerName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.status = status;
		this.isActive = isActive;
		this.subscriptionStatus = subscriptionStatus;
		this.subscriptionStartDate = subscriptionStartDate;
		this.subscriptionEndDate = subscriptionEndDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public Tenant() {
		super();
	}
	
	//logoUrl
	//timezone
	//currency
	
	
}


