package com.example.fawryapi.refund.admin;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.customer.model.Customer;
import com.example.fawryapi.customer.repository.CustomerRepository;
import com.example.fawryapi.transaction.model.Transaction;
import com.example.fawryapi.transaction.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRefundService {
    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AdminRefundService(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    public APIResponse<Object> getAllRefunds() {
        return new APIResponse<>(true, "all refund requests", transactionRepository.getWaitingTransactions());
    }

    public APIResponse<Object> getRefundById(Long refundId) {
        return new APIResponse<>(true, "refund "+refundId, transactionRepository.findById(refundId));
    }

    public APIResponse<Object> getAcceptedRefunds() {
        return new APIResponse<>(true, "all accepted refunds", transactionRepository.getAcceptedTransactions());
    }

    public APIResponse<Object> getRejectedRefunds() {
        return new APIResponse<>(true, "all rejected refunds", transactionRepository.getRejectedTransactions());
    }

    @Transactional
    public APIResponse<Object> updateRefundStatus(Long refundId, String status) {
        boolean exists = transactionRepository.existsById(refundId);
        if(!exists)return  new APIResponse<>(false,"no such refund",refundId);

        Transaction transaction = transactionRepository.findById(refundId).get();
        Customer customer = customerRepository.findById(transaction.getCustomerId()).get();

        if(status.equals("Approved")){
            customer.setWalletAmount(customer.getWalletAmount()+transaction.getAmount());
            transaction.setStatus("Approved");
            return  new APIResponse<>(true,"refund accepted "+ refundId,transaction);
        }else{
            transaction.setStatus("Rejected");
            return  new APIResponse<>(false,"refund rejected "+ refundId,transaction);
        }
    }
}
