package com.plantavida.back.domain.repositories;

import com.plantavida.back.domain.entities.Role;

public interface RoleRepository {
    Role findByType(String type);
}
