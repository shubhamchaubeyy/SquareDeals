package com.backend.squaredeal.tenant.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.squaredeal.auth.dto.UserRequest;
import com.backend.squaredeal.auth.dto.UserResponse;
import com.backend.squaredeal.auth.entity.Role;
import com.backend.squaredeal.auth.entity.User;
import com.backend.squaredeal.auth.repository.UserRepository;
import com.backend.squaredeal.tenant.dto.TenantRequest;
import com.backend.squaredeal.tenant.dto.TenantResponse;
import com.backend.squaredeal.tenant.entity.Status;
import com.backend.squaredeal.tenant.entity.SubscriptionStatus;
import com.backend.squaredeal.tenant.entity.Tenant;
import com.backend.squaredeal.tenant.repository.TenantRepository;

@Service
public class TenantService {
	
	@Autowired
	private TenantRepository tenantRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public TenantResponse createNewTenant(TenantRequest  request) {
		
		Tenant tenant = new Tenant();
		
		tenant.setBusinessName(request.getBusinessName());
		tenant.setBusinessCode(request.getBusinessCode());
		tenant.setOwnerName(request.getOwnerName());
		tenant.setEmail(request.getEmail());
		tenant.setPhone(request.getPhone());
		tenant.setPincode(request.getPincode());
		tenant.setAddress(request.getAddress());
		tenant.setCity(request.getCity());
		tenant.setState(request.getState());
		tenant.setCountry(request.getCountry());
		tenant.setActive(true); 
		tenant.setStatus(Status.TRIAL);
		tenant.setSubscriptionStatus(SubscriptionStatus.TRIAL);
		tenant.setSubscriptionStartDate(LocalDate.now());
		tenant.setSubscriptionEndDate(LocalDate.now().plusDays(30));
		tenant.setCreatedAt(LocalDateTime.now());
		tenant.setUpdatedAt(LocalDateTime.now());
		tenant.setDeletedAt(null); 
				
		tenantRepository.save(tenant);			
		return new TenantResponse(tenant.getId(), tenant.getBusinessName(), tenant.getBusinessCode(), tenant.getOwnerName(),
				tenant.getEmail(), tenant.getPhone(),tenant.getAddress(), tenant.getActive(), tenant.getSubscriptionStatus());
	}
	
	
	public Tenant getTenantById(Long id) {
		
		Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new RuntimeException("Tenant not found"));
		
		return tenant;
	}
	
	public List<Tenant> getAllTenantDetails() {
		List<Tenant> tenants = tenantRepository.findAll();
		return tenants; 
	}
	
	public Tenant updateTenant(Long id, Tenant updatedTenant) {
	    Tenant existingTenant = tenantRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Tenant not found"));

	    existingTenant.setBusinessName(updatedTenant.getBusinessName());
	    existingTenant.setBusinessCode(updatedTenant.getBusinessCode());
	    existingTenant.setOwnerName(updatedTenant.getOwnerName());
	    existingTenant.setEmail(updatedTenant.getEmail());
	    existingTenant.setPhone(updatedTenant.getPhone());
	    existingTenant.setPincode(updatedTenant.getPincode());
	    existingTenant.setAddress(updatedTenant.getAddress());
	    existingTenant.setCity(updatedTenant.getCity());
	    existingTenant.setState(updatedTenant.getState());
	    existingTenant.setCountry(updatedTenant.getCountry());
	    existingTenant.setActive(updatedTenant.getActive());
	    existingTenant.setStatus(updatedTenant.getStatus());
	    existingTenant.setSubscriptionStatus(updatedTenant.getSubscriptionStatus());
	    existingTenant.setSubscriptionStartDate(updatedTenant.getSubscriptionStartDate());
	    existingTenant.setSubscriptionEndDate(updatedTenant.getSubscriptionEndDate());
	    existingTenant.setUpdatedAt(LocalDateTime.now());

	    return tenantRepository.save(existingTenant);
	}
	
	public TenantResponse getTenantStatus(Long id) {
	    Tenant tenant = tenantRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Tenant not found"));

	    return new TenantResponse(tenant.getId(), tenant.getBusinessName(), tenant.getBusinessCode(),
	            tenant.getOwnerName(), tenant.getEmail(), tenant.getPhone(), tenant.getAddress(),
	            tenant.getActive(), tenant.getSubscriptionStatus());
	}
	
	public TenantResponse deleteTenant(Long id)
	{
		Tenant tenant = tenantRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Tenant not found"));
		
		tenant.setActive(false);
		tenant.setStatus(Status.INACTIVE);
		tenant.setDeletedAt(LocalDateTime.now());
		tenantRepository.save(tenant);
		return new TenantResponse(tenant.getId(), tenant.getBusinessName(), tenant.getBusinessCode(),
	            tenant.getOwnerName(), tenant.getEmail(), tenant.getPhone(), tenant.getAddress(),
	            tenant.getActive(), tenant.getSubscriptionStatus());
	}
	
	//admin management	
    
	public UserResponse userRequest(UserRequest request) {
		User user = new User();
		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhone());
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		user.setActive(true);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setDeletedAt(null);
		
		Tenant tenant = getTenantById(request.getTenantId());
		
		user.setTenant(tenant);
		userRepository.save(user);
		
		return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getPhone(),
				user.getUsername(), user.getRole(), user.isActive(),user.getTenant().getId());
	}
	
	public UserResponse getAdminDetails(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getPhone(),
				user.getUsername(), user.getRole(), user.isActive(),user.getTenant().getId());
	}
	
	
	
	public UserResponse updateAdminDetails(Long id, User updatedUser) {
	    User existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    existingUser.setName(updatedUser.getName());
	    existingUser.setEmail(updatedUser.getEmail());
	    existingUser.setPhone(updatedUser.getPhone());
	    existingUser.setUsername(updatedUser.getUsername());
	    existingUser.setRole(updatedUser.getRole());
	    existingUser.setActive(updatedUser.isActive());
	    existingUser.setUpdatedAt(LocalDateTime.now());

	    return new UserResponse(existingUser.getId(), existingUser.getName(), existingUser.getEmail(),
	            existingUser.getPhone(), existingUser.getUsername(), existingUser.getRole(),
	            existingUser.isActive(), existingUser.getTenant().getId());
	}
	
	public UserResponse deleteAdminDetails(Long id) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    user.setActive(false);
	    user.setDeletedAt(LocalDateTime.now());
	    userRepository.save(user);

	    return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getPhone(),
	            user.getUsername(), user.getRole(), user.isActive(), user.getTenant().getId());
	}

}
