package com.example.paytechapp.controller;

import com.example.paytechapp.dto.PaymentFormDto;
import com.example.paytechapp.dto.request.PaymentRequestDTO;
import com.example.paytechapp.dto.response.PaymentResponseDTO;
import com.example.paytechapp.service.ProviderPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final ProviderPaymentService providerPaymentService;

    @PostMapping( "/payment")
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO request) {
        return providerPaymentService.createPayment(request);
    }

    @GetMapping( "/payment")
    public String showPaymentFrom(Model model) {
        PaymentFormDto paymentForm = new PaymentFormDto();
        model.addAttribute("paymentForm", paymentForm);
        return "payment";
    }
}
