package com.plantavida.back.domain.repositories;

import com.plantavida.back.domain.entities.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    User createUser(User user);
}
