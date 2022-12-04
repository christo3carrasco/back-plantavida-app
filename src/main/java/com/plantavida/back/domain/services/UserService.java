package com.plantavida.back.domain.services;

import com.plantavida.back.domain.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> readUserEmail(String email);
}
