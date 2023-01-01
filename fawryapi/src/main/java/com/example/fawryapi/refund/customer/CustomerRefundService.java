package com.example.fawryapi.refund.customer;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.transaction.model.Transaction;
import com.example.fawryapi.transaction.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRefundService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public CustomerRefundService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public APIResponse<Object> getCustomerRefunds(Long customerId) {
        return new APIResponse<>(true,"customer refund requests",transactionRepository.getCustomerRefunds(customerId));
    }


    @Transactional
    public APIResponse<Object> applyRefund(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).get();
        transaction.setStatus("Waiting");
        return new APIResponse<>(true,"refund Request sent",transaction);
    }
}
