package com.plantavida.back.domain.repositories;

import com.plantavida.back.domain.entities.Role;

import java.util.Optional;

public interface RoleRepository {
    Role findByType(String type);
}
