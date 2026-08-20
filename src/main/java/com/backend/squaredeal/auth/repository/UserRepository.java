package com.backend.squaredeal.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.squaredeal.auth.entity.Role;
import com.backend.squaredeal.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

	Optional<User> findByUsernameAndIsActiveTrue(String username);

    boolean existsByUsernameAndIsActiveTrue(String username);

    List<User> findByTenantIdAndIsActiveTrue(Long tenantId);

    List<User> findByTenantIdAndRoleAndIsActiveTrue(
            Long tenantId,
            Role role
    );

    Optional<User> findByIdAndTenantIdAndIsActiveTrue(
            Long id,
            Long tenantId
    );

}
