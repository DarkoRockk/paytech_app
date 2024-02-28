package com.example.paytechapp.service;

import com.example.paytechapp.dto.request.PaymentRequestDTO;
import com.example.paytechapp.entity.TxPaymentEntity;
import com.example.paytechapp.entity.UserEntity;
import com.example.paytechapp.enums.PaymentStatusEnum;
import com.example.paytechapp.repository.TxPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TxPaymentService {

    private final TxPaymentRepository txPaymentRepository;

    public TxPaymentEntity create(PaymentRequestDTO request, UserEntity user) {
        return txPaymentRepository.save(TxPaymentEntity.builder()
                .user(user)
                .status(PaymentStatusEnum.IN_PROCESS)
                .amount(request.getAmount())
                .build());
    }

    public TxPaymentEntity save(TxPaymentEntity tx) {
        return txPaymentRepository.save(tx);
    }
}
