package com.example.paytechapp.dto.response;

import lombok.Data;

@Data
public class PaymentResponseDTO {
    private Integer  status;
    private ResultResponseDTO result;
}
