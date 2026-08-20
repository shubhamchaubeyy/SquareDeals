package com.backend.squaredeal.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.squaredeal.agent.dto.AgentProfileRequest;
import com.backend.squaredeal.agent.dto.AgentRequest;
import com.backend.squaredeal.agent.dto.AgentResponse;
import com.backend.squaredeal.agent.entity.AgentProfile;
import com.backend.squaredeal.agent.services.AgentService;

@RestController
@RequestMapping("/api/v1/admin")
public class AgentController {

	@Autowired
	private AgentService agentService;
	
	@PostMapping("/agents")
	public ResponseEntity<AgentResponse> createAgent(@RequestBody AgentRequest agentRequest) {
		
		AgentResponse res = agentService.createAgent(agentRequest);
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/agents")  //also returning the admin 
	public ResponseEntity<List<AgentResponse>> getAllAgents() {
		List<AgentResponse> agents = agentService.getAllAgents();
		return ResponseEntity.ok(agents);
	}
	
	@GetMapping("/agents/{id}") //working perfectly
	public ResponseEntity<AgentResponse> getAgentById(@PathVariable Long id) {
		AgentResponse agent = agentService.getAgentById(id);
		return ResponseEntity.ok(agent);
	}
	
	@PutMapping("/agents/{id}") //working perfectly
	public ResponseEntity<AgentResponse> updateAgent(@PathVariable Long id, @RequestBody AgentRequest agentRequest) {
		AgentResponse updatedAgent = agentService.updateAgent(id, agentRequest);
		return ResponseEntity.ok(updatedAgent);
	}
	
	@PostMapping("/agents/{id}/status")
	public ResponseEntity<AgentResponse> updateAgentStatus(@PathVariable Long id, @RequestBody String status) {
		// Implementation for updating an agent's status
		return null;
	}
	
	@GetMapping("/agents/{id}/performance")
	public ResponseEntity<AgentResponse> getAgentPerformance(@PathVariable Long id) {
		// Implementation for retrieving an agent's performance
		return null;
	}
	
	@PostMapping("/agents/{id}/agentprofile")
	public ResponseEntity<AgentProfile> addAgentProfile(@PathVariable Long id, @RequestBody AgentProfileRequest agentProfileRequest) {
		
		AgentProfile agentProfile = agentService.addAgentProfile(id, agentProfileRequest);
		return ResponseEntity.ok(agentProfile);
	}
	
	@GetMapping("/agents/{id}/agentprofile")
	public ResponseEntity<AgentProfile> getAgentProfile(@PathVariable Long id) {
		AgentProfile agentProfile = agentService.getAgentProfile(id);
		return ResponseEntity.ok(agentProfile);
	}
	
	@PutMapping("/agents/{id}/agentprofile")
	public ResponseEntity<AgentProfile> updateAgentProfile(@PathVariable Long id, @RequestBody AgentProfileRequest agentProfileRequest) {
		AgentProfile updatedAgentProfile = agentService.updateAgentProfile(id, agentProfileRequest);
		return ResponseEntity.ok(updatedAgentProfile);
	}

}
