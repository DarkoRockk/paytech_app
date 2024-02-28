package com.example.paytechapp.client;

import com.example.paytechapp.dto.PaymentFormDto;
import com.example.paytechapp.dto.response.PaymentProviderResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "paytechclient",
        url = "https://engine-sandbox.pay.tech/"
)
public interface PaymentClient {

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/v1/payments"
    )
    PaymentProviderResponseDTO createPayment(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody PaymentFormDto request);
}