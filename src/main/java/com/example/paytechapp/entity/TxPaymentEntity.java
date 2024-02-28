package com.example.paytechapp.entity;

import com.example.paytechapp.entity.base.BaseEntity;
import com.example.paytechapp.enums.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TxPaymentEntity that)) return false;
        if (!super.equals(o)) return false;
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
                "} " + super.toString();
    }
}

