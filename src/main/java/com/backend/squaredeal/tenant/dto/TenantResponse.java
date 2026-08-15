package com.backend.squaredeal.tenant.dto;

import com.backend.squaredeal.tenant.entity.SubscriptionStatus;

public class TenantResponse {
	 	private Long id;

	    private String businessName;

	    private String businessCode;

	    private String ownerName;

	    private String email;

	    private String phone;

	    private String address;

	    private boolean active;

	    private SubscriptionStatus subscriptionStatus;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		public String getOwnerName() {
			return ownerName;
		}

		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
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

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public SubscriptionStatus getSubscriptionStatus() {
			return subscriptionStatus;
		}

		public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
			this.subscriptionStatus = subscriptionStatus;
		}

		public TenantResponse(Long id, String businessName, String businessCode, String ownerName, String email,
				String phone, String address, boolean active, SubscriptionStatus subscriptionStatus) {
			super();
			this.id = id;
			this.businessName = businessName;
			this.businessCode = businessCode;
			this.ownerName = ownerName;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.active = active;
			this.subscriptionStatus = subscriptionStatus;
		}

		public TenantResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
