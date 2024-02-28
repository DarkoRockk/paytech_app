package com.example.paytechapp.service;

import com.example.paytechapp.dto.UserDto;
import com.example.paytechapp.dto.request.PaymentRequestDTO;
import com.example.paytechapp.entity.UserEntity;
import com.example.paytechapp.enums.Role;
import com.example.paytechapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getOrCreateUser(PaymentRequestDTO request) {
        var user = getUserByEmail(request.getEmail());
        if (user == null) {
            user = userRepository.save(
                    UserEntity.builder()
                            .username(request.getUsername())
                            .firstName(request.getFirstName())
                            .lastName(request.getLastName())
                            .password("dddd")
                            .role(Role.ROLE_USER)
                            .email(request.getEmail())
                            .build()
            );
        }
        System.out.println(user);
        return user;
    }

    public UserEntity getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public UserEntity save(UserDto user) {
        return userRepository.save(
                UserEntity.builder()
                        .username(user.getFirstName())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .password(user.getPassword())
                        .role(Role.ROLE_USER)
                        .email(user.getEmail())
                        .build()
        );
    }
}

