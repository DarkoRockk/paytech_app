package com.example.paytechapp.controller;

import com.example.paytechapp.dto.request.PaymentRequestDTO;
import com.example.paytechapp.dto.response.PaymentResponseDTO;
import com.example.paytechapp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO request) throws IOException {
        return paymentService.createPayment(request);
    }
}
