package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Integer> {
    Role findByType(String type);
}
