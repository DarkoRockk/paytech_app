package com.example.paytechapp.service;

import com.example.paytechapp.client.PaymentClient;
import com.example.paytechapp.dto.request.PaymentRequestDTO;
import com.example.paytechapp.dto.response.PaymentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentClient client;
    private final String AUTH_TOKEN = "Bearer cAmmvalAikARkB81fgxgMtnMbEdNbuWa";

    public PaymentResponseDTO createPayment(PaymentRequestDTO request) {
        return client.createPayment(AUTH_TOKEN, request);
    }
}
