package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface UserController {
    @GetMapping(value = "/user/{email}", produces = {"application/json"})
    Optional<User> getUser(@PathVariable(value = "email") String email);
}
