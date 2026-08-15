package com.backend.squaredeal.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.squaredeal.tenant.dto.TenantRequest;
import com.backend.squaredeal.tenant.dto.TenantResponse;
import com.backend.squaredeal.tenant.entity.Tenant;
import com.backend.squaredeal.tenant.services.TenantService;

@RestController
@RequestMapping("/api/v1/superadmin/")
public class TenantController {

	@Autowired
	private TenantService tenantService;
	
	@PostMapping("/tenants")
	public ResponseEntity<TenantResponse> createBusiness(@RequestBody TenantRequest business) {
		TenantResponse response = tenantService.createNewTenant(business);
		
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/tenants")
	public ResponseEntity<List<Tenant>> getAllBusinesses() {
		
		List<Tenant> tenants = tenantService.getAllTenantDetails();
		
		return ResponseEntity.ok(tenants);
	}
	
	@GetMapping("/tenants/{id}")
	public ResponseEntity<Tenant> getBusinessById(@PathVariable Long id) {
		Tenant response = tenantService.getTenantById(id);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/tenants/{id}")
	public ResponseEntity<Tenant> updateBusiness(@PathVariable Long id, @RequestBody Tenant business) {
		
		Tenant updatedTenant = tenantService.updateTenant(id, business);
		
		return ResponseEntity.ok(updatedTenant);
	}

	@GetMapping("/tenants/{id}/status")
	public ResponseEntity<TenantResponse> getBusinessStatus(@PathVariable Long id) {
		TenantResponse response = tenantService.getTenantStatus(id);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/tenants/{id}")
	public ResponseEntity<TenantResponse> deleteBusiness(@PathVariable Long id) {
		TenantResponse response = tenantService.deleteTenant(id);
		return ResponseEntity.ok(response);
	}
	//•	GET    /businesses/me  will be added to the admin controller
	//•	PUT    /businesses/me
}

