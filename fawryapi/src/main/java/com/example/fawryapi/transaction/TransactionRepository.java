package com.example.fawryapi.transaction;

import com.example.fawryapi.APIResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {


    @Query(nativeQuery = true,value = "Select * from transaction where customer_id =?1 and complete = true")
    List<Transaction> getCustomerTransactions(Long customerId);
}
