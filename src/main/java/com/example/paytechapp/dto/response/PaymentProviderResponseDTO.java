package com.example.paytechapp.dto.response;

import lombok.Data;

@Data
public class PaymentProviderResponseDTO {
    private Integer  status;
    private ResultResponseDTO result = new ResultResponseDTO();
}
