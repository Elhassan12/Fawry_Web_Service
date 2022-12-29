package com.example.fawryapi.payment;

import com.example.fawryapi.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // pay with credit card
    @PostMapping(path = "creditcard/{transactionId}")
    APIResponse<Object> payWithCreditCard(
            @PathVariable("transactionId") Long transactionId,
            @RequestParam String creditCardNumber,
            @RequestParam double amount
    ){
        return paymentService.payWithCreditCard(transactionId,creditCardNumber,amount);
    }

    // pay with cash
    @PostMapping(path = "cash/{transactionId}")
    APIResponse<Object> payCash(
            @PathVariable("transactionId") Long transactionId
    ){
        return paymentService.payWithCash(transactionId);
    }
    // pay with wallet
    @PostMapping(path = "wallet/{transactionId}")
    APIResponse<Object> payWithWallet(
            @PathVariable("transactionId") Long transactionId,
            @RequestParam("customerId") Long customerId
    ){
        return paymentService.payWithWallet(transactionId,customerId);
    }
}
