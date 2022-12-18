package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.Role;
import com.plantavida.back.domain.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleRepositoryImpl implements RoleRepository {
    @Autowired
    RoleJpaRepository db;

    @Override
    public Role findByType(String type) {
        return db.findByType(type);
    }
}
