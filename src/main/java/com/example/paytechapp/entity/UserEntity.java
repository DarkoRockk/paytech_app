package com.example.paytechapp.entity;

import com.example.paytechapp.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {
    String username = null;
}
