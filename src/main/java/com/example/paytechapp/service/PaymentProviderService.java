package com.example.paytechapp.service;

import com.example.paytechapp.client.PaymentClient;
import com.example.paytechapp.dto.PaymentFormDto;
import com.example.paytechapp.dto.response.PaymentProviderResponseDTO;
import com.example.paytechapp.enums.PaymentStatusEnum;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentProviderService {

    private final PaymentClient client;
    private final UserService userService;
    private final TxPaymentService txPaymentService;
    private final String AUTH_TOKEN = "Bearer cAmmvalAikARkB81fgxgMtnMbEdNbuWa";

    @Transactional
    public PaymentProviderResponseDTO processPayment(PaymentFormDto request, Principal principal) {
        var user = userService.getUserByEmail(principal.getName());
        var tx = txPaymentService.create(request, user);
        var response = new PaymentProviderResponseDTO();
        try {
            response = client.createPayment(AUTH_TOKEN, request);
            tx.setStatus(PaymentStatusEnum.COMPLETED);
            txPaymentService.save(tx);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            if (e instanceof FeignException.BadRequest) {
                response.setStatus(400);
            } else response.setStatus(500);
            tx.setStatus(PaymentStatusEnum.FAILED);
            txPaymentService.save(tx);
            response.getResult().setRedirectUrl("redirect");
        }
        return response;
    }
}
