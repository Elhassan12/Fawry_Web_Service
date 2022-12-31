package com.example.fawryapi.transaction;

import com.example.fawryapi.APIResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {


    @Query(nativeQuery = true,value = "Select * from transaction " +
            "where customer_id =?1 and complete = true and status != 'Approved'")
    List<Transaction> getCustomerTransactions(Long customerId);

    @Query(nativeQuery = true,value = "Select * from transaction " +
            "where complete = true and status = 'Approved'")
    List<Transaction> getAcceptedTransactions();
    @Query(nativeQuery = true,value = "Select * from transaction " +
            "where complete = true and status = 'Waiting'")
    List<Transaction> getWaitingTransactions();

    @Query(nativeQuery = true,value = "Select * from transaction " +
            "where complete = true and status = 'Rejected'")
    List<Transaction> getRejectedTransactions();


    @Query(nativeQuery = true,value = "Select * from transaction " +
            "where complete = true and customer_id =?1 and status = 'Approved' or status = 'Rejected' or status = 'Waiting'")
    List<Transaction> getCustomerRefunds(Long customerId);


}
