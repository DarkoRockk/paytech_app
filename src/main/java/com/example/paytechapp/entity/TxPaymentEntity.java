package com.example.paytechapp.entity;

import com.example.paytechapp.entity.base.BaseEntity;
import com.example.paytechapp.enums.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tx_payments")
public class TxPaymentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity user = null;

    public BigDecimal amount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    public PaymentStatusEnum status = PaymentStatusEnum.IN_PROCESS;
}

