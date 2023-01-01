package com.example.fawryapi.customer.repository;

import com.example.fawryapi.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByUserNameIgnoreCase(String userName);
    Optional<Customer> findByEmailIgnoreCase(String email);

    @Query(nativeQuery = true, value = "Select * from customer_tbl where customer_email = ?1 and customer_password = ?2")
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
