package com.backend.squaredeal.client.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.squaredeal.client.entity.ClientRequirement;

public interface ClientRequirementRepository extends JpaRepository<ClientRequirement, Long> {

	List<ClientRequirement> findByClientId(Long clientId);
	
	Optional<ClientRequirement> findByIdAndClientId(Long id, Long clientId);
}
