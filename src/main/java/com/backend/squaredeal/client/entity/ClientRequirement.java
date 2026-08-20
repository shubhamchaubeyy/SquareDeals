package com.backend.squaredeal.client.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ClientRequirement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;
	
	private String requirementType;
	private String propertyType;
	private String listingType;
	private Integer minBudget;
	private Integer maxBudget;
	private Integer minArea;
	private Integer maxArea;
	private Integer bedrooms;
	private Integer bathrooms;
	private String preferredCity;
	private String preferredLocalities;
	private String preferredFloor;
	private String furnishingType;
	private String possessionRequirement;
	private String amenities;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getRequirementType() {
		return requirementType;
	}
	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getListingType() {
		return listingType;
	}
	public void setListingType(String listingType) {
		this.listingType = listingType;
	}
	public Integer getMinBudget() {
		return minBudget;
	}
	public void setMinBudget(Integer minBudget) {
		this.minBudget = minBudget;
	}
	public Integer getMaxBudget() {
		return maxBudget;
	}
	public void setMaxBudget(Integer maxBudget) {
		this.maxBudget = maxBudget;
	}
	public Integer getMinArea() {
		return minArea;
	}
	public void setMinArea(Integer minArea) {
		this.minArea = minArea;
	}
	public Integer getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(Integer maxArea) {
		this.maxArea = maxArea;
	}
	public Integer getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}
	public Integer getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}
	public String getPreferredCity() {
		return preferredCity;
	}
	public void setPreferredCity(String preferredCity) {
		this.preferredCity = preferredCity;
	}
	public String getPreferredLocalities() {
		return preferredLocalities;
	}
	public void setPreferredLocalities(String preferredLocalities) {
		this.preferredLocalities = preferredLocalities;
	}
	public String getPreferredFloor() {
		return preferredFloor;
	}
	public void setPreferredFloor(String preferredFloor) {
		this.preferredFloor = preferredFloor;
	}
	public String getFurnishingType() {
		return furnishingType;
	}
	public void setFurnishingType(String furnishingType) {
		this.furnishingType = furnishingType;
	}
	public String getPossessionRequirement() {
		return possessionRequirement;
	}
	public void setPossessionRequirement(String possessionRequirement) {
		this.possessionRequirement = possessionRequirement;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
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
	public ClientRequirement(Long id, Client client, String requirementType, String propertyType, String listingType,
			Integer minBudget, Integer maxBudget, Integer minArea, Integer maxArea, Integer bedrooms, Integer bathrooms,
			String preferredCity, String preferredLocalities, String preferredFloor, String furnishingType,
			String possessionRequirement, String amenities, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.client = client;
		this.requirementType = requirementType;
		this.propertyType = propertyType;
		this.listingType = listingType;
		this.minBudget = minBudget;
		this.maxBudget = maxBudget;
		this.minArea = minArea;
		this.maxArea = maxArea;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.preferredCity = preferredCity;
		this.preferredLocalities = preferredLocalities;
		this.preferredFloor = preferredFloor;
		this.furnishingType = furnishingType;
		this.possessionRequirement = possessionRequirement;
		this.amenities = amenities;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public ClientRequirement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
