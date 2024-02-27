package com.example.paytechapp.service;

import com.example.paytechapp.client.PaymentClient;
import com.example.paytechapp.dto.request.PaymentRequestDTO;
import com.example.paytechapp.dto.response.PaymentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProviderPaymentService {

    private final PaymentClient client;
    private final UserService userService;
    private final TxPaymentService txPaymentService;
    private final String AUTH_TOKEN = "Bearer cAmmvalAikARkB81fgxgMtnMbEdNbuWa";

    @Transactional
    public PaymentResponseDTO createPayment(PaymentRequestDTO request) {
        var user = userService.getOrCreateUser(request);
        txPaymentService.create(request, user);
        return client.createPayment(AUTH_TOKEN, request);
    }
}
