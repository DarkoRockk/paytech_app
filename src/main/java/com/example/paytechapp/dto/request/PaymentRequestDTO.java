package com.example.paytechapp.dto.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PaymentRequestDTO {
    private String paymentType;
    private BigInteger amount;
    private String currency;
}
