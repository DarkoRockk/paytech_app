package com.example.paytechapp.entity;

import com.example.paytechapp.entity.base.BaseEntity;
import com.example.paytechapp.enums.PaymentStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tx_payments")
@Getter
@Setter
public class TxPaymentEntity extends BaseEntity {

    public BigDecimal amount = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING)
    public PaymentStatusEnum status = PaymentStatusEnum.IN_PROCESS;

}
