package com.annamakos.socialcare.api.repository;

import com.annamakos.socialcare.api.model.Role;
import com.annamakos.socialcare.api.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
