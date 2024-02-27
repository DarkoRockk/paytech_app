package com.example.paytechapp.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequestDTO {

    private String name;
    private String surname;
    private String email;
    private String paymentType;
    private BigDecimal amount;
    private String currency;
}
