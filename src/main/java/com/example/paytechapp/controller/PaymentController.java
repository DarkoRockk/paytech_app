package com.example.paytechapp.controller;

import com.example.paytechapp.dto.PaymentFormDto;
import com.example.paytechapp.service.PaymentProviderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentProviderService paymentProviderService;

    @GetMapping("/payment")
    public String showPaymentFrom(Model model) {
        PaymentFormDto paymentForm = new PaymentFormDto();
        model.addAttribute("paymentForm", paymentForm);
        return "payment";
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error";
    }

    @PostMapping("/payment/process")
    public ModelAndView processPayment(@Valid @ModelAttribute("paymentForm") PaymentFormDto paymentForm, Principal principal) {
        var result = paymentProviderService.processPayment(paymentForm, principal);
        if (result.getStatus() == 200) {
            return new ModelAndView("redirect:" + result.getResult().getRedirectUrl());
        }
        return new ModelAndView("redirect:/error");
    }
}
