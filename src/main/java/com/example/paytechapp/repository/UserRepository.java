package com.example.paytechapp.repository;

import com.example.paytechapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

    UserEntity findByEmail(String email);

    UserEntity findByUsernameOrEmail (String username, String email);
}
