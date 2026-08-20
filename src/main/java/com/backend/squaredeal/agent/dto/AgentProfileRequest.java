package com.backend.squaredeal.agent.dto;

import java.time.LocalDate;


public class AgentProfileRequest {

	private String employeeCode;
	private String territory;
	private Integer commissionRate;
	private LocalDate joiningDate;
	private String availabilityStatus;
	//private String profileImageUrl;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	public Integer getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(Integer commissionRate) {
		this.commissionRate = commissionRate;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public AgentProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgentProfileRequest(String employeeCode, String territory, Integer commissionRate, LocalDate joiningDate,
			String availabilityStatus) {
		super();
		this.employeeCode = employeeCode;
		this.territory = territory;
		this.commissionRate = commissionRate;
		this.joiningDate = joiningDate;
		this.availabilityStatus = availabilityStatus;
	}

}
