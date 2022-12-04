package com.plantavida.back.domain.services;

import com.plantavida.back.domain.entities.User;
import com.plantavida.back.infrastructure.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public Optional<User> readUserEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
