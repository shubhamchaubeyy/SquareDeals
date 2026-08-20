package com.backend.squaredeal.agent.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.squaredeal.agent.dto.AgentProfileRequest;
import com.backend.squaredeal.agent.dto.AgentRequest;
import com.backend.squaredeal.agent.dto.AgentResponse;
import com.backend.squaredeal.agent.entity.AgentProfile;
import com.backend.squaredeal.agent.repository.AgentProfileRepository;
import com.backend.squaredeal.auth.entity.Role;
import com.backend.squaredeal.auth.entity.User;
import com.backend.squaredeal.auth.repository.UserRepository;
import com.backend.squaredeal.common.CustomUserDetails;
import com.backend.squaredeal.tenant.entity.Tenant;
import com.backend.squaredeal.tenant.repository.TenantRepository;


@Service
public class AgentService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TenantRepository tenantRepository;
	
	@Autowired
	private AgentProfileRepository agentProfileRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	public AgentResponse createAgent(AgentRequest agentRequest) {
		
		User user = new User();
		user.setName(agentRequest.getName());
		user.setEmail(agentRequest.getEmail());
		user.setPhone(agentRequest.getPhone());
		user.setUsername(agentRequest.getUsername());
		user.setPassword(passwordEncoder.encode(agentRequest.getPassword()));
		user.setRole(Role.AGENT);
		user.setActive(true);
		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
//		Optional<User> adminUser = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername());
//		
//		if(adminUser.isEmpty() || adminUser.get().getRole() != Role.ADMIN) {
//			throw new RuntimeException("Only admin can create agent");
//		}
				
		Tenant tenant = tenantRepository.findById(userDetails.getTenantId())
				.orElseThrow(() -> new RuntimeException("Tenant not found"));
		
		user.setTenant(tenant);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setDeletedAt(null);
		
		userRepository.save(user);
		return new AgentResponse(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getUsername(), user.getRole(), user.isActive(), user.getTenant().getId());
	}

	public List<AgentResponse> getAllAgents() {
		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
//		Optional<User> adminUser = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername());
//		
//		if(adminUser.isEmpty() || adminUser.get().getRole() != Role.ADMIN) {
//			throw new RuntimeException("Only admin can view agents");
//		}
		
		List<User> agents = userRepository.findByTenantIdAndIsActiveTrue(userDetails.getTenantId());
		
		return agents.stream()
				.map(agent -> new AgentResponse(agent.getId(), agent.getName(), agent.getEmail(), agent.getPhone(), agent.getUsername(), agent.getRole(), agent.isActive(), agent.getTenant().getId()))
				.toList();
	}
	
	public AgentResponse getAgentById(Long agentId) {
		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
//		Optional<User> adminUser = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername());
//		
//		if(adminUser.isEmpty()) {
//			throw new RuntimeException("Only admin can view agents");
//		}
//		
		User agent = userRepository.findByIdAndTenantIdAndIsActiveTrue(agentId, userDetails.getTenantId())
				.orElseThrow(() -> new RuntimeException("Agent not found"));
		
		return new AgentResponse(agent.getId(), agent.getName(), agent.getEmail(), agent.getPhone(), agent.getUsername(), agent.getRole(), agent.isActive(), agent.getTenant().getId());
	}
	
	public AgentResponse updateAgent(Long agentId, AgentRequest agentRequest) {
		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
//		Optional<User> adminUser = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername());
//		
//		if(adminUser.isEmpty()) {
//			throw new RuntimeException("Only admin can update agents");
//		}
		
		User agent = userRepository.findByIdAndTenantIdAndIsActiveTrue(agentId, userDetails.getTenantId())
				.orElseThrow(() -> new RuntimeException("Agent not found"));
		
		agent.setName(agentRequest.getName());
		agent.setEmail(agentRequest.getEmail());
		agent.setPhone(agentRequest.getPhone());
		agent.setUsername(agentRequest.getUsername());
		agent.setPassword(passwordEncoder.encode(agentRequest.getPassword()));
//		if(agentRequest.getPassword() != null && !agentRequest.getPassword().isEmpty()) {
//			agent.setPassword(passwordEncoder.encode(agentRequest.getPassword()));
//		}
		agent.setUpdatedAt(LocalDateTime.now());
		
		userRepository.save(agent);
		
		return new AgentResponse(agent.getId(), agent.getName(), agent.getEmail(), agent.getPhone(), agent.getUsername(), agent.getRole(), agent.isActive(), agent.getTenant().getId());
	}
	
	public AgentProfile addAgentProfile(Long id,AgentProfileRequest agentProfileRequest) {
		
		User agent = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Agent not found"));
		
		AgentProfile agentProfile = new AgentProfile();
		agentProfile.setAvailabilityStatus(agentProfileRequest.getAvailabilityStatus());
		agentProfile.setCommissionRate(agentProfileRequest.getCommissionRate());
		agentProfile.setJoiningDate(agentProfileRequest.getJoiningDate());
		agentProfile.setTerritory(agentProfileRequest.getTerritory());
		agentProfile.setEmployeeCode(agentProfileRequest.getEmployeeCode());
		agentProfile.setUser(agent);
		agentProfile.setCreatedAt(LocalDateTime.now());
		agentProfile.setUpdatedAt(LocalDateTime.now());
		agentProfileRepository.save(agentProfile);
		
		return agentProfile;
	}
	
	public AgentProfile getAgentProfile(Long id) {
		
		AgentProfile agentProfile = agentProfileRepository.findByUserId(id)
				.orElseThrow(() -> new RuntimeException("Agent profile not found"));
		
		return agentProfile;
	}
	
	public AgentProfile updateAgentProfile(Long id, AgentProfileRequest agentProfileRequest) {
		
		AgentProfile agentProfile = agentProfileRepository.findByUserId(id)
				.orElseThrow(() -> new RuntimeException("Agent profile not found"));
		
		agentProfile.setAvailabilityStatus(agentProfileRequest.getAvailabilityStatus());
		agentProfile.setCommissionRate(agentProfileRequest.getCommissionRate());
		agentProfile.setJoiningDate(agentProfileRequest.getJoiningDate());
		agentProfile.setTerritory(agentProfileRequest.getTerritory());
		agentProfile.setEmployeeCode(agentProfileRequest.getEmployeeCode());
		agentProfile.setUpdatedAt(LocalDateTime.now());
		
		agentProfileRepository.save(agentProfile);
		
		return agentProfile;
	}
}
