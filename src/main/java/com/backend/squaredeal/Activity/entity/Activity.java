package com.backend.squaredeal.Activity.entity;

import java.time.LocalDateTime;

import com.backend.squaredeal.auth.entity.User;
import com.backend.squaredeal.client.entity.Client;
import com.backend.squaredeal.lead.entity.Lead;
import com.backend.squaredeal.tenant.entity.Tenant;

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
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id")
	private Tenant tenant;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lead_id")
	private Lead lead;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Enumerated(EnumType.STRING)
	private Direction direction;
	
	private String subject;
	private String content;
	private String notes;
	private String status;
	private LocalDateTime occurredAt;
	private String source;
	private String externalReference;
	private LocalDateTime createdAt;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Lead getLead() {
		return lead;
	}
	public void setLead(Lead lead) {
		this.lead = lead;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getOccurredAt() {
		return occurredAt;
	}
	public void setOccurredAt(LocalDateTime occurredAt) {
		this.occurredAt = occurredAt;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getExternalReference() {
		return externalReference;
	}
	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Activity(Long id, Tenant tenant, Client client, Lead lead, User user, Type type, Direction direction,
			String subject, String content, String notes, String status, LocalDateTime occurredAt, String source,
			String externalReference, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.tenant = tenant;
		this.client = client;
		this.lead = lead;
		this.user = user;
		this.type = type;
		this.direction = direction;
		this.subject = subject;
		this.content = content;
		this.notes = notes;
		this.status = status;
		this.occurredAt = occurredAt;
		this.source = source;
		this.externalReference = externalReference;
		this.createdAt = createdAt;
	}
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}


}
