package com.example.paytechapp.service;

import com.example.paytechapp.dto.UserRegistrationDto;
import com.example.paytechapp.entity.UserEntity;
import com.example.paytechapp.enums.Role;
import com.example.paytechapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserEntity getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Transactional
    public UserEntity save(UserRegistrationDto user) {
        return userRepository.save(
                UserEntity.builder()
                        .username(user.getFirstName())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .role(Role.ROLE_USER)
                        .email(user.getEmail())
                        .build()
        );
    }
}

