package com.example.fawryapi.refund.customer;

import com.example.fawryapi.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "customerrefund")
public class CustomerRefundController {
    private final CustomerRefundService customerRefundService;

    @Autowired
    public CustomerRefundController(CustomerRefundService customerRefundService) {
        this.customerRefundService = customerRefundService;
    }

    // apply refund --> transaction id
    @PutMapping(path = "{transactionId}")
    APIResponse<Object> applyRefund(@PathVariable("transactionId")Long transactionId){
        return customerRefundService.applyRefund(transactionId);
    }
    // get refund requests --> customer id
    @GetMapping(path = "{customerId}")
    APIResponse<Object> getCustomerRefunds(@PathVariable("customerId")Long customerId){
        return customerRefundService.getCustomerRefunds(customerId);
    }

}
