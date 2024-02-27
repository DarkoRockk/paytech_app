package com.example.paytechapp.repository;

import com.example.paytechapp.entity.TxPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TxPaymentRepository extends JpaRepository<TxPaymentEntity, BigInteger> {
}
