package com.example.paytechapp.entity;

import com.example.paytechapp.entity.base.BaseEntity;
import com.example.paytechapp.enums.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "tx_payments")
@RequiredArgsConstructor
public class TxPaymentEntity extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity user = null;

    public BigDecimal amount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    public PaymentStatusEnum status = PaymentStatusEnum.IN_PROCESS;

    public TxPaymentEntity(UserEntity user, BigDecimal amount) {
        this.user = user;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TxPaymentEntity that = (TxPaymentEntity) o;
        return Objects.equals(user, that.user) && Objects.equals(amount, that.amount) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, amount, status);
    }

    @Override
    public String toString() {
        return "TxPaymentEntity{" +
                "user=" + user +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}

