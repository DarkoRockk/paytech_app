package com.example.paytechapp.controller;

import com.example.paytechapp.dto.request.PaymentRequestDTO;
import com.example.paytechapp.dto.response.PaymentResponseDTO;
import com.example.paytechapp.service.ProviderPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final ProviderPaymentService providerPaymentService;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO request) {
        return providerPaymentService.createPayment(request);
    }
}
