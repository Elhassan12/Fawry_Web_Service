package com.example.fawryapi.transaction;

import com.example.fawryapi.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public APIResponse<Object> getAllTransactions() {
        return  new APIResponse<>(true,"list of transactions",transactionRepository.findAll());
    }

    public APIResponse<Object> getCustomerTransactions(Long customerId) {
        Optional<List<Transaction>> optionalTransactionList = Optional.ofNullable(transactionRepository.getCustomerTransactions(customerId));
        if(optionalTransactionList.isPresent()){
        return new APIResponse<>(true,"customer with id: "+customerId+" Transactions "
                ,transactionRepository.getCustomerTransactions(customerId));
        }
        return new APIResponse<>(true,"customer with id: "+customerId+" didnt do any Transactions "
                ,customerId);
    }

    public APIResponse<Object> getTransactionById(Long transactionId) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);
        if(transactionOptional.isPresent()){
        return new APIResponse<>(true,"transaction with id: "+transactionId,
                transactionRepository.findById(transactionId));
        }
        return new APIResponse<>(true,"no transaction with id: "+transactionId,
                transactionId);
    }
}
