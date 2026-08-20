package com.backend.squaredeal.client.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.backend.squaredeal.auth.entity.Role;
import com.backend.squaredeal.auth.entity.User;
import com.backend.squaredeal.auth.repository.UserRepository;
import com.backend.squaredeal.client.dto.ClientRequest;
import com.backend.squaredeal.client.dto.ClientRequirementRequest;
import com.backend.squaredeal.client.dto.ClientRequirementResponse;
import com.backend.squaredeal.client.dto.ClientResponse;
import com.backend.squaredeal.client.entity.Client;
import com.backend.squaredeal.client.entity.ClientRequirement;
import com.backend.squaredeal.client.entity.ClientStatus;
import com.backend.squaredeal.client.repository.ClientRepository;
import com.backend.squaredeal.client.repository.ClientRequirementRepository;
import com.backend.squaredeal.common.CustomUserDetails;
import com.backend.squaredeal.tenant.entity.Tenant;
import com.backend.squaredeal.tenant.repository.TenantRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TenantRepository tenantRepository;
	
	@Autowired
	private ClientRequirementRepository clientRequirementRepository;

	public ClientResponse createClient(ClientRequest request) {

		Client client = new Client();
		client.setClientName(request.getClientName());
		client.setPhone(request.getPhone());
		client.setAlternatePhone(request.getAlternatePhone());
		client.setEmail(request.getEmail());
		client.setClientType(request.getClientType());
		client.setSource(request.getSource());
		client.setStatus(request.getStatus());
		client.setPriority(request.getPriority());
		client.setAddress(request.getAddress());
		client.setCity(request.getCity());
		client.setState(request.getState());
		client.setPincode(request.getPincode());
		client.setCountry(request.getCountry());
		client.setOccupation(request.getOccupation());
		client.setCompanyName(request.getCompanyName());
		client.setNotes(request.getNotes());

		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		User agent = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));

		Tenant tenant = tenantRepository.findById(userDetails.getTenantId())
				.orElseThrow(() -> new RuntimeException("Tenant not found"));

		client.setUser(agent);
		client.setTenant(tenant);
		client.setCreatedAt(LocalDateTime.now());
		client.setUpdatedAt(LocalDateTime.now());
		client.setDeletedAt(null);

Client savedClient = clientRepository.save(client);
		
		return new ClientResponse(savedClient.getId(),savedClient.getClientName(), savedClient.getPhone(), savedClient.getAlternatePhone(), savedClient.getEmail(),
				savedClient.getClientType(), savedClient.getSource(), savedClient.getStatus(), savedClient.getPriority(),
				savedClient.getAddress(), savedClient.getCity(), savedClient.getState(), savedClient.getPincode(),
				savedClient.getCountry(), savedClient.getOccupation(), savedClient.getCompanyName(), savedClient.getNotes());
	}

	public List<ClientResponse> getAllClients() {
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		User user = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		List<Client> clients = null;
		if(user.getRole() == Role.ADMIN) {
			clients = clientRepository.findByTenantIdAndIsActiveTrue(user.getTenant().getId());
			
		}
		else if(user.getRole() == Role.AGENT) {
		 clients =clientRepository.findByUserIdAndIsActiveTrue(user.getId());
		} 

		return clients.stream()
				.map(client -> new ClientResponse(client.getId(), client.getClientName(), client.getPhone(), client.getAlternatePhone(),
						client.getEmail(), client.getClientType(), client.getSource(), client.getStatus(),
						client.getPriority(), client.getAddress(), client.getCity(), client.getState(),
						client.getPincode(), client.getCountry(), client.getOccupation(), client.getCompanyName(),
						client.getNotes()))
				.collect(Collectors.toList());
	}

	public ClientResponse getClientById(Long id) {
		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		User user = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		Client client = new Client(); ;
		if(user.getRole() == Role.ADMIN) {
			// Admin can access any client in the tenant, so we don't need to check userId
			client = clientRepository.findByIdAndTenantIdAndIsActiveTrue(id, user.getTenant().getId())
					.orElseThrow(() -> new RuntimeException("Client not found"));
			
		}
		else if(user.getRole() == Role.AGENT) {
		client = clientRepository.findByIdAndUserIdAndIsActiveTrue(id,user.getId())
				.orElseThrow(() -> new RuntimeException("Client not found"));
		}
		return new ClientResponse(client.getId(),client.getClientName(), client.getPhone(), client.getAlternatePhone(),
				client.getEmail(), client.getClientType(), client.getSource(), client.getStatus(), client.getPriority(),
				client.getAddress(), client.getCity(), client.getState(), client.getPincode(), client.getCountry(),
				client.getOccupation(), client.getCompanyName(), client.getNotes());
	}

	public ClientResponse updateClient(Long id, ClientRequest request) {
		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		User user = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		Client client = new Client(); ;
		if(user.getRole() == Role.ADMIN) {
			// Admin can access any client in the tenant, so we don't need to check userId
			client = clientRepository.findByIdAndTenantIdAndIsActiveTrue(id, user.getTenant().getId())
					.orElseThrow(() -> new RuntimeException("Client not found"));
			
		}
		else if(user.getRole() == Role.AGENT) {
		client = clientRepository.findByIdAndUserIdAndIsActiveTrue(id,user.getId())
				.orElseThrow(() -> new RuntimeException("Client not found"));
		}


		client.setClientName(request.getClientName());
		client.setPhone(request.getPhone());
		client.setAlternatePhone(request.getAlternatePhone());
		client.setEmail(request.getEmail());
		client.setClientType(request.getClientType());
		client.setSource(request.getSource());
		client.setStatus(request.getStatus());
		client.setPriority(request.getPriority());
		client.setAddress(request.getAddress());
		client.setCity(request.getCity());
		client.setState(request.getState());
		client.setPincode(request.getPincode());
		client.setCountry(request.getCountry());
		client.setOccupation(request.getOccupation());
		client.setCompanyName(request.getCompanyName());
		client.setNotes(request.getNotes());

		Client savedClient = clientRepository.save(client);

		return new ClientResponse(savedClient.getId(), savedClient.getClientName(), savedClient.getPhone(),
				savedClient.getAlternatePhone(), savedClient.getEmail(), savedClient.getClientType(),
				savedClient.getSource(), savedClient.getStatus(), savedClient.getPriority(), savedClient.getAddress(),
				savedClient.getCity(), savedClient.getState(), savedClient.getPincode(), savedClient.getCountry(),
				savedClient.getOccupation(), savedClient.getCompanyName(), savedClient.getNotes());
	}

	public ClientResponse updateClientStatus(Long id, ClientStatus status) {
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		User user = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		Client client = new Client(); ;
		if(user.getRole() == Role.ADMIN) {
			// Admin can access any client in the tenant, so we don't need to check userId
			client = clientRepository.findByIdAndTenantIdAndIsActiveTrue(id, user.getTenant().getId())
					.orElseThrow(() -> new RuntimeException("Client not found"));
			
		}
		else if(user.getRole() == Role.AGENT) {
		client = clientRepository.findByIdAndUserIdAndIsActiveTrue(id,user.getId())
				.orElseThrow(() -> new RuntimeException("Client not found"));
		}


		client.setStatus(status);
		Client savedClient = clientRepository.save(client);

		return new ClientResponse(savedClient.getId(), savedClient.getClientName(), savedClient.getPhone(),
				savedClient.getAlternatePhone(), savedClient.getEmail(), savedClient.getClientType(),
				savedClient.getSource(), savedClient.getStatus(), savedClient.getPriority(), savedClient.getAddress(),
				savedClient.getCity(), savedClient.getState(), savedClient.getPincode(), savedClient.getCountry(),
				savedClient.getOccupation(), savedClient.getCompanyName(), savedClient.getNotes());
	}

	public ClientResponse deleteClient(Long id) {
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		User user = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		Client client = new Client(); ;
		if(user.getRole() == Role.ADMIN) {
			// Admin can access any client in the tenant, so we don't need to check userId
			client = clientRepository.findByIdAndTenantIdAndIsActiveTrue(id, user.getTenant().getId())
					.orElseThrow(() -> new RuntimeException("Client not found"));
			
		}
		else if(user.getRole() == Role.AGENT) {
		client = clientRepository.findByIdAndUserIdAndIsActiveTrue(id,user.getId())
				.orElseThrow(() -> new RuntimeException("Client not found"));
		}

		client.setIsActive(false);
		Client savedClient = clientRepository.save(client);

		return new ClientResponse(savedClient.getId(), savedClient.getClientName(), savedClient.getPhone(),
				savedClient.getAlternatePhone(), savedClient.getEmail(), savedClient.getClientType(),
				savedClient.getSource(), savedClient.getStatus(), savedClient.getPriority(), savedClient.getAddress(),
				savedClient.getCity(), savedClient.getState(), savedClient.getPincode(), savedClient.getCountry(),
				savedClient.getOccupation(), savedClient.getCompanyName(), savedClient.getNotes());
	}
	
	public ClientRequirementResponse createClientRequirement(Long clientId,ClientRequirementRequest request) {
		
		ClientRequirement clientRequirement = new ClientRequirement();
		
		Client client = clientRepository.findByIdAndIsActiveTrue(clientId)
				.orElseThrow(() -> new RuntimeException("Client not found"));
		
	    clientRequirement.setClient(client);
	    clientRequirement.setRequirementType(request.getRequirementType());
	    clientRequirement.setPropertyType(request.getPropertyType());
	    clientRequirement.setListingType(request.getListingType());
	    clientRequirement.setMinBudget(request.getMinBudget());
	    clientRequirement.setMaxBudget(request.getMaxBudget());
	    clientRequirement.setMinArea(request.getMinArea());
	    clientRequirement.setMaxArea(request.getMaxArea());
	    clientRequirement.setBedrooms(request.getBedrooms());
	    clientRequirement.setBathrooms(request.getBathrooms());
	    clientRequirement.setPreferredFloor(request.getPreferredFloor());
	    clientRequirement.setPreferredLocalities(request.getPreferredLocalities());
	    clientRequirement.setPreferredCity(request.getPreferredCity());
	    clientRequirement.setFurnishingType(request.getFurnishingType());
	    clientRequirement.setPossessionRequirement(request.getPossessionRequirement());
	    clientRequirement.setAmenities(request.getAmenities());
	    clientRequirement.setCreatedAt(LocalDateTime.now());
	    clientRequirement.setUpdatedAt(LocalDateTime.now());

	    ClientRequirement savedClientRequirement = clientRequirementRepository.save(clientRequirement);
	    
	    return new ClientRequirementResponse(savedClientRequirement.getId(), savedClientRequirement.getRequirementType(),
	    		savedClientRequirement.getPropertyType(), savedClientRequirement.getListingType(),
	    		savedClientRequirement.getMinBudget(), savedClientRequirement.getMaxBudget(),
	    		savedClientRequirement.getMinArea(), savedClientRequirement.getMaxArea(),
	    		savedClientRequirement.getBedrooms(), savedClientRequirement.getBathrooms(),
	    		savedClientRequirement.getPreferredCity(), savedClientRequirement.getPreferredLocalities(),
	    		savedClientRequirement.getPreferredFloor(), savedClientRequirement.getFurnishingType(),
	    		savedClientRequirement.getPossessionRequirement(), savedClientRequirement.getAmenities());
	}
	
	public List<ClientRequirementResponse> getClientRequirements(Long clientId) {
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		User user = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		Client client = null;
		if(user.getRole() == Role.ADMIN) {
			// Admin can access any client in the tenant, so we don't need to check userId
			client = clientRepository.findByIdAndTenantIdAndIsActiveTrue(clientId, user.getTenant().getId())
					.orElseThrow(() -> new RuntimeException("Client not found"));
			
		}
		else if(user.getRole() == Role.AGENT) {
		client = clientRepository.findByIdAndUserIdAndIsActiveTrue(clientId,user.getId())
				.orElseThrow(() -> new RuntimeException("Client not found"));
		}

		
		List<ClientRequirement> clientRequirements = clientRequirementRepository.findByClientId(clientId);
		
		return clientRequirements.stream()
				.map(requirement -> new ClientRequirementResponse(requirement.getId(), requirement.getRequirementType(),
						requirement.getPropertyType(), requirement.getListingType(), requirement.getMinBudget(),
						requirement.getMaxBudget(), requirement.getMinArea(), requirement.getMaxArea(),
						requirement.getBedrooms(), requirement.getBathrooms(), requirement.getPreferredCity(),
						requirement.getPreferredLocalities(), requirement.getPreferredFloor(),
						requirement.getFurnishingType(), requirement.getPossessionRequirement(),
						requirement.getAmenities()))
				.collect(Collectors.toList());
	}
	
	public ClientRequirementResponse updateClientRequirement(Long clientId, Long requirementId, ClientRequirementRequest request) {
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		User user = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		Client client = null;
		if(user.getRole() == Role.ADMIN) {
			// Admin can access any client in the tenant, so we don't need to check userId
			client = clientRepository.findByIdAndTenantIdAndIsActiveTrue(clientId, user.getTenant().getId())
					.orElseThrow(() -> new RuntimeException("Client not found"));
			
		}
		else if(user.getRole() == Role.AGENT) {
		client = clientRepository.findByIdAndUserIdAndIsActiveTrue(clientId,user.getId())
				.orElseThrow(() -> new RuntimeException("Client not found"));
		}
		
		ClientRequirement clientRequirement = clientRequirementRepository.findByIdAndClientId(requirementId, clientId)
				.orElseThrow(() -> new RuntimeException("Client Requirement not found"));

		clientRequirement.setRequirementType(request.getRequirementType());
		clientRequirement.setPropertyType(request.getPropertyType());
		clientRequirement.setListingType(request.getListingType());
		clientRequirement.setMinBudget(request.getMinBudget());
		clientRequirement.setMaxBudget(request.getMaxBudget());
		clientRequirement.setMinArea(request.getMinArea());
		clientRequirement.setMaxArea(request.getMaxArea());
		clientRequirement.setBedrooms(request.getBedrooms());
		clientRequirement.setBathrooms(request.getBathrooms());
		clientRequirement.setPreferredCity(request.getPreferredCity());
		clientRequirement.setPreferredLocalities(request.getPreferredLocalities());
		clientRequirement.setPreferredFloor(request.getPreferredFloor());
		clientRequirement.setFurnishingType(request.getFurnishingType());
		clientRequirement.setPossessionRequirement(request.getPossessionRequirement());
		clientRequirement.setAmenities(request.getAmenities());
		clientRequirement.setUpdatedAt(LocalDateTime.now());

		ClientRequirement savedClientRequirement = clientRequirementRepository.save(clientRequirement);

		return new ClientRequirementResponse(savedClientRequirement.getId(), savedClientRequirement.getRequirementType(),
				savedClientRequirement.getPropertyType(), savedClientRequirement.getListingType(),
				savedClientRequirement.getMinBudget(), savedClientRequirement.getMaxBudget(),
				savedClientRequirement.getMinArea(), savedClientRequirement.getMaxArea(),
				savedClientRequirement.getBedrooms(), savedClientRequirement.getBathrooms(),
				savedClientRequirement.getPreferredCity(), savedClientRequirement.getPreferredLocalities(),
				savedClientRequirement.getPreferredFloor(), savedClientRequirement.getFurnishingType(),
				savedClientRequirement.getPossessionRequirement(), savedClientRequirement.getAmenities());
	}
	
	public ClientRequirementResponse deleteClientRequirement(Long clientId, Long requirementId) {
		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		User user = userRepository.findByUsernameAndIsActiveTrue(userDetails.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		Client client = null;
		if(user.getRole() == Role.ADMIN) {
			// Admin can access any client in the tenant, so we don't need to check userId
			client = clientRepository.findByIdAndTenantIdAndIsActiveTrue(clientId, user.getTenant().getId())
					.orElseThrow(() -> new RuntimeException("Client not found"));
			
		}
		else if(user.getRole() == Role.AGENT) {
		client = clientRepository.findByIdAndUserIdAndIsActiveTrue(clientId,user.getId())
				.orElseThrow(() -> new RuntimeException("Client not found"));
		}
		ClientRequirement clientRequirement = clientRequirementRepository.findByIdAndClientId(requirementId, clientId)
				.orElseThrow(() -> new RuntimeException("Client Requirement not found"));

		clientRequirementRepository.delete(clientRequirement);

		return new ClientRequirementResponse(clientRequirement.getId(), clientRequirement.getRequirementType(),
				clientRequirement.getPropertyType(), clientRequirement.getListingType(),
				clientRequirement.getMinBudget(), clientRequirement.getMaxBudget(),
				clientRequirement.getMinArea(), clientRequirement.getMaxArea(),
				clientRequirement.getBedrooms(), clientRequirement.getBathrooms(),
				clientRequirement.getPreferredCity(), clientRequirement.getPreferredLocalities(),
				clientRequirement.getPreferredFloor(), clientRequirement.getFurnishingType(),
				clientRequirement.getPossessionRequirement(), clientRequirement.getAmenities());
	}
}
