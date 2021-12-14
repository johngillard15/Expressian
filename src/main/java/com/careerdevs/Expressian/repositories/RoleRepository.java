package com.careerdevs.Expressian.repositories;

import com.careerdevs.Expressian.models.auth.ERoll;
import com.careerdevs.Expressian.models.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERoll name);
}
