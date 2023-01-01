package com.example.fawryapi.transaction.controller;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //1. getAllTransaction // actually it won't harm if we keep it! so you want to filter it out?
    @GetMapping
    APIResponse<Object> getTransactions(){// ok?
        return transactionService.getTransactions();
    }
    //2. getCustomerTransaction
    @GetMapping(path = "{customerId}")
    APIResponse<Object> getCustomerTransaction(@PathVariable("customerId")Long customerId){
        return transactionService.getCustomerTransactions(customerId);
    }
    //3. getTransactionByIdForCustomer
    @GetMapping(path = "/specific/{transactionId}")
    APIResponse<Object> getTransactionById(@PathVariable("transactionId")Long transactionId){
        return transactionService.getTransactionById(transactionId);
    }

}
