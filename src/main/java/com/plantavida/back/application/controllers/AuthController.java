package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.dto.JwtAuthResponseDTO;
import com.plantavida.back.domain.dto.LoginDTO;
import com.plantavida.back.domain.dto.SignupDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {
    @PostMapping(value = "/login", produces = {"application/json"})
    ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO);

    @PostMapping(value = "/signup", produces = {"application/json"})
    ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO);
}
