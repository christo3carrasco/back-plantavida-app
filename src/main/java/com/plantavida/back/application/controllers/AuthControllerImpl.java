package com.plantavida.back.application.controllers;

import com.plantavida.back.domain.dto.JwtAuthResponseDTO;
import com.plantavida.back.domain.dto.LoginDTO;
import com.plantavida.back.domain.dto.SignupDTO;
import com.plantavida.back.domain.entities.Role;
import com.plantavida.back.domain.entities.User;
import com.plantavida.back.infrastructure.repositories.RoleRepositoryImpl;
import com.plantavida.back.infrastructure.repositories.UserRepositoryImpl;
import com.plantavida.back.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/auth")
public class AuthControllerImpl implements AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private RoleRepositoryImpl roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.genToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponseDTO(token));
    }

    @Override
    public ResponseEntity<?> signupUser(SignupDTO signupDTO) {
        if (userRepository.existsByEmail(signupDTO.getEmail())) {
            return new ResponseEntity<>("Ese correo ya existe", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setDni(signupDTO.getDni());
        user.setFirstname(signupDTO.getFirstname());
        user.setLastname(signupDTO.getLastname());
        user.setPhone(signupDTO.getPhone());
        user.setBirth(signupDTO.getBirth());
        user.setGender(signupDTO.getGender());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        user.setStatus(1);

        Role role = roleRepository.findByType("ROLE_USER_ROLE");
        user.setRole(role);

        userRepository.createUser(user);
        return new ResponseEntity<>("Usuario registrado", HttpStatus.OK);
    }
}
