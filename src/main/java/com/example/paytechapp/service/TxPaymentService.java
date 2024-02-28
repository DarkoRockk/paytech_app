package com.example.paytechapp.service;

import com.example.paytechapp.dto.PaymentFormDto;
import com.example.paytechapp.entity.TxPaymentEntity;
import com.example.paytechapp.entity.UserEntity;
import com.example.paytechapp.enums.PaymentStatusEnum;
import com.example.paytechapp.repository.TxPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TxPaymentService {

    private final TxPaymentRepository txPaymentRepository;

    public TxPaymentEntity create(PaymentFormDto request, UserEntity user) {
        return txPaymentRepository.save(TxPaymentEntity.builder()
                .user(user)
                .status(PaymentStatusEnum.IN_PROCESS)
                .amount(request.getAmount())
                .build());
    }

    @Transactional
    public TxPaymentEntity save(TxPaymentEntity tx) {
        return txPaymentRepository.save(tx);
    }
}
