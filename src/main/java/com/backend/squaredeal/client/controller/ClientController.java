package com.backend.squaredeal.client.controller;

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

import com.backend.squaredeal.client.dto.ClientRequest;
import com.backend.squaredeal.client.dto.ClientRequirementRequest;
import com.backend.squaredeal.client.dto.ClientRequirementResponse;
import com.backend.squaredeal.client.dto.ClientResponse;
import com.backend.squaredeal.client.entity.ClientStatus;
import com.backend.squaredeal.client.services.ClientService;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@PostMapping("/clients")
	public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest client) {
		ClientResponse createdClient = clientService.createClient(client);
		return ResponseEntity.ok(createdClient);
	}
	
	@GetMapping("/clients")
	public ResponseEntity<List<ClientResponse>> getAllClients() {
		List<ClientResponse> res = clientService.getAllClients();
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<ClientResponse> getClientById (@PathVariable Long id) {
		ClientResponse res = clientService.getClientById(id);
		return ResponseEntity.ok(res);
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<ClientResponse> updateClient(@PathVariable Long id, @RequestBody ClientRequest client) {
		ClientResponse updatedClient = clientService.updateClient(id, client);
		return ResponseEntity.ok(updatedClient);
	}
	
	@PostMapping("/clients/{id}/status")
	public ResponseEntity<ClientResponse> updateClientStatus(@PathVariable Long id, @RequestBody ClientStatus status) {
		ClientResponse updatedClient = clientService.updateClientStatus(id, status);
		return ResponseEntity.ok(updatedClient);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<ClientResponse> deleteClient(@PathVariable Long id) {
		ClientResponse res= clientService.deleteClient(id);
		return ResponseEntity.ok(res);
	}
	
	@PostMapping("/clients/{id}/requirements")
	public ResponseEntity<ClientRequirementResponse> addClientRequirement(@PathVariable Long id, @RequestBody ClientRequirementRequest requirement) {
		ClientRequirementResponse createdRequirement = clientService.createClientRequirement(id, requirement);
		return ResponseEntity.ok(createdRequirement);
	}
	
	@GetMapping("/clients/{id}/requirements")
	public ResponseEntity<List<ClientRequirementResponse>> getClientRequirements(@PathVariable Long id) {
		List<ClientRequirementResponse> res = clientService.getClientRequirements(id);
		return ResponseEntity.ok(res);
	}
	
	@PutMapping("/clients/{id}/requirements/{requirementId}")
	public ResponseEntity<ClientRequirementResponse> updateClientRequirement(@PathVariable Long id, @PathVariable Long requirementId, @RequestBody ClientRequirementRequest requirement) {
		ClientRequirementResponse updatedRequirement = clientService.updateClientRequirement(id, requirementId, requirement);
		return ResponseEntity.ok(updatedRequirement);
	}
	
	@DeleteMapping("/clients/{id}/requirements/{requirementId}")
	public ResponseEntity<ClientRequirementResponse> deleteClientRequirement(@PathVariable Long id, @PathVariable Long requirementId) {
		ClientRequirementResponse res = clientService.deleteClientRequirement(id, requirementId);
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/clients/{id}/timeline")
	public ResponseEntity<List<String>> getClientTimeline(@PathVariable Long id) {
		// Implementation for retrieving a client's timeline
		return null;
	}
}


