package com.backend.squaredeal.client.dto;

import com.backend.squaredeal.client.entity.ClientStatus;
import com.backend.squaredeal.client.entity.ClientType;

public class ClientResponse {
	private Long id;
	private String clientName;
	private String phone;
	
	private String alternatePhone;
	
	private String email;
	
	private ClientType clientType;
	
	private String source;
	
	private ClientStatus status;
	
	private String priority;
	private String address;
	private String city;
	private String state;
	
	private String pincode;
	private String country;
	private String occupation;
	private String companyName;
	private String notes;
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ClientResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClientResponse(Long id,String clientName, String phone, String alternatePhone, String email, ClientType clientType,
			String source, ClientStatus status, String priority, String address, String city, String state,
			String pincode, String country, String occupation, String companyName, String notes) {
		super();
		this.id=id;
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
	}
	
	
}
