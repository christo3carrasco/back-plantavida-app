package com.plantavida.back.infrastructure.repositories;

import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    UserJpaRepository db;

    @Override
    public Optional<User> findByEmail(String email) {
        return db.findByEmail(email);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return db.existsByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return db.save(user);
    }
}
