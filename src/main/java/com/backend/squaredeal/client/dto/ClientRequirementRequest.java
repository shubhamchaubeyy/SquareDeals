package com.backend.squaredeal.client.dto;

public class ClientRequirementRequest {
	
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
	public ClientRequirementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClientRequirementRequest(String requirementType, String propertyType, String listingType, Integer minBudget,
			Integer maxBudget, Integer minArea, Integer maxArea, Integer bedrooms, Integer bathrooms,
			String preferredCity, String preferredLocalities, String preferredFloor, String furnishingType,
			String possessionRequirement, String amenities) {
		super();
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
	}
	
	
}
