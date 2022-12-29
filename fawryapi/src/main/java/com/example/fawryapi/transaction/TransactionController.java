package com.example.fawryapi.transaction;

import com.example.fawryapi.APIResponse;
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

    //1. getAllTransaction
    @GetMapping
    APIResponse<Object> getAllTransactions(){
        return transactionService.getAllTransactions();
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
