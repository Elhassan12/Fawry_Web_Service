package com.example.fawryapi.transaction;

import com.example.fawryapi.transaction.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionRepositoryTest {
    private final TransactionRepository transactionRepository;

    @Autowired
    TransactionRepositoryTest(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Test
    void getAcceptedTransactions(){
        System.out.println(transactionRepository.getAcceptedTransactions());
    }
    @Test
    void getTransactions(){
        System.out.println(transactionRepository.getCustomerTransactions(1L));
    }
    @Test
    void getTransactionById(){
        System.out.println(transactionRepository.findById(3L));
    }
    @Test
    void getRejectedRefunds(){
        System.out.println(transactionRepository.getRejectedTransactions());
    }
    @Test
    void getCustomerRefundRequests(){
        System.out.println(transactionRepository.getCustomerRefunds(1L));
    }
}