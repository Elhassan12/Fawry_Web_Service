package com.example.fawryapi.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepositoryTest {

    private final CustomerRepository customerRepository;

    @Autowired
    CustomerRepositoryTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


}