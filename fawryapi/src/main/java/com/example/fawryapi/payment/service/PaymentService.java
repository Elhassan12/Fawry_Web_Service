package com.example.fawryapi.payment.service;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.customer.model.Customer;
import com.example.fawryapi.customer.repository.CustomerRepository;
import com.example.fawryapi.transaction.model.Transaction;
import com.example.fawryapi.transaction.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service

public class PaymentService {
    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public PaymentService(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional // yes you are right
    public APIResponse<Object> payWithCreditCard(Long transactionId, String creditCardNumber, double amount) {
        // credit card validation goes here
        // checking if the credit card hava appropriate amount

        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        if(transaction.isPresent()&&!transaction.get().isComplete()){
            transaction.get().setPaymentway("creditCard");
            transaction.get().setTransactionDate(Date.valueOf(LocalDate.now()));
            transaction.get().setComplete(true);
            return new APIResponse<>(true,"Transaction is completed",transaction.get().toString());
        }
        return new APIResponse<>(false,"Transaction not valid :(",transactionId);
    }

    @Transactional
    public APIResponse<Object> payWithCash(Long transactionId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        if(transaction.isPresent()&&!transaction.get().isComplete()){
            transaction.get().setPaymentway("cash");
            transaction.get().setTransactionDate(Date.valueOf(LocalDate.now()));
            transaction.get().setComplete(true);
            return new APIResponse<>(true,"Transaction is completed",transaction.get().toString());
        }
        return new APIResponse<>(false,"Transaction not valid :(",transactionId);
    }

    @Transactional
    public APIResponse<Object> payWithWallet(Long transactionId, Long customerId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(transaction.isPresent() && !transaction.get().isComplete() && customer.get().getWalletAmount() >= transaction.get().getAmount()){
            customer.get().setWalletAmount(customer.get().getWalletAmount()-transaction.get().getAmount());
            transaction.get().setPaymentway("wallet");
            transaction.get().setTransactionDate(Date.valueOf(LocalDate.now()));
            transaction.get().setComplete(true);
            return new APIResponse<>(true,"Transaction is completed",transaction.get().toString());
        }
        return new APIResponse<>(false,"Transaction not valid :(",transactionId);
    }
}
