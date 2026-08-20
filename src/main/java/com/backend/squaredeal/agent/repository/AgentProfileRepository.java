package com.backend.squaredeal.agent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.squaredeal.agent.entity.AgentProfile;

@Repository
public interface AgentProfileRepository extends JpaRepository<AgentProfile, Long> {
	// Add custom query methods if needed
	Optional<AgentProfile> findByUserId(Long agentId);
}
