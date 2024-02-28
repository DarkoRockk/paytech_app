package com.example.paytechapp.entity;

import com.example.paytechapp.entity.base.BaseEntity;
import com.example.paytechapp.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "public")
public class UserEntity extends BaseEntity {

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "first_name", unique = true, nullable = false)
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
}
