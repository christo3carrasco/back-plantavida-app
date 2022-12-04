package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    public Optional<User> getUser(String email) {
        return userService.readUserEmail(email);
    }
}
