package com.example.paytechapp.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequestDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String paymentType;
    private BigDecimal amount;
    private String currency;
}
