package com.backend.squaredeal.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.squaredeal.auth.entity.Role;
import com.backend.squaredeal.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

	Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    List<User> findByTenantId(Long tenantId);

    List<User> findByTenantIdAndRole(
            Long tenantId,
            Role role
    );

    Optional<User> findByIdAndTenantId(
            Long id,
            Long tenantId
    );

}
