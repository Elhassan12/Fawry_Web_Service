package com.example.fawryapi.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByUserNameIgnoreCase(String userName);
    Optional<Customer> findByEmailIgnoreCase(String email);
}
