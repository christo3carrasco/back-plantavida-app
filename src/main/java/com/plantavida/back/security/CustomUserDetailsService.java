package com.plantavida.back.security;

import com.plantavida.back.domain.entities.Role;
import com.plantavida.back.domain.entities.User;
import com.plantavida.back.infrastructure.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email no registrado: " + email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRoles(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRoles(Role roles) {
        return List.of(new SimpleGrantedAuthority(roles.getType()));
    }
}
