package com.backend.squaredeal.agent.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.backend.squaredeal.auth.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class AgentProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agent_id", referencedColumnName = "id")
	private User user;

	private String employeeCode;
	private String territory;
	private Integer commissionRate;
	private LocalDate joiningDate;
	private String availabilityStatus;
	//private String profileImageUrl;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public AgentProfile(Long id, User user, String employeeCode, String territory, Integer commissionRate,
			LocalDate joiningDate, String availabilityStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.employeeCode = employeeCode;
		this.territory = territory;
		this.commissionRate = commissionRate;
		this.joiningDate = joiningDate;
		this.availabilityStatus = availabilityStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public AgentProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
