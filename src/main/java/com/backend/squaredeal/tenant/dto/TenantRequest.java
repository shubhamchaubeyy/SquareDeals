package com.backend.squaredeal.tenant.dto;

public class TenantRequest {
	    
		private String businessName;
		private String businessCode;
	    private String ownerName;

	    private String email;

	    private String phone;
	    private String pincode;
	    private String address;
	    
	    private String city;
	    
	    private String state;
	    
	    private String country;

		public String getBusinessName() {
			return businessName;
		}

		public void setBusinessName(String businessName) {
			this.businessName = businessName;
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

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
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
		
		public String getBusinessCode() {
			return businessCode;
		}
		
		public void setBusinessCode(String businessCode) {
			this.businessCode = businessCode;
		}
		public TenantRequest(String businessName, String ownerName, String email, String phone, String pincode,
				String address, String city, String state, String country,String businessCode) {
			super();
			this.businessName = businessName;
			this.ownerName = ownerName;
			this.email = email;
			this.phone = phone;
			this.pincode = pincode;
			this.address = address;
			this.city = city;
			this.state = state;
			this.country = country;
			this.businessCode = businessCode;
		}

		public TenantRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
