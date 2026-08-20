package com.backend.squaredeal.client.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.squaredeal.client.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findByUserIdAndIsActiveTrue(Long userId);
	List<Client> findByTenantIdAndIsActiveTrue(Long tenantId);
    
	//List<Client> findByUserAndIsActiveTrue(String username);
	
	Optional<Client> findByIdAndIsActiveTrue(Long id);
	Optional<Client> findByIdAndUserIdAndIsActiveTrue(Long id, Long userId);
	Optional<Client> findByIdAndTenantIdAndIsActiveTrue(Long id, Long tenantId);
	
	
}
