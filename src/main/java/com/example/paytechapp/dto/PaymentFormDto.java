package com.example.paytechapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Data
public class PaymentFormDto {

    private String paymentType = "DEPOSIT";

    @NotEmpty
    private BigDecimal amount;

    @NotEmpty
    private String currency;
}
