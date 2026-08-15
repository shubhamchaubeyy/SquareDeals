package com.backend.squaredeal.tenant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.squaredeal.tenant.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
	
	Optional<Tenant> findByBusinessCode(
            String businessCode
    );

    boolean existsByBusinessCode(
            String businessCode
    );

}
