package com.example.paytechapp.service;

import com.example.paytechapp.dto.request.PaymentRequestDTO;
import com.example.paytechapp.entity.UserEntity;
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
            user = userRepository.save(new UserEntity(
                    request.getName(),
                    request.getSurname(),
                    request.getEmail()
            ));
        }
        System.out.println(user);
        return user;
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
