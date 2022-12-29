package com.example.fawryapi.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner1(CustomerRepository customerRepository){
        return args -> {
            Customer samyMohsen = new Customer(1L,"SamyMohsen","samymohsen33@gmail.com",0,"1111");
            Customer ahmedHassan = new Customer(2L,"AhmedHassan","ahmedhassan33@gmail.com",500,"1111");
            Customer ahmedMostafa = new Customer(3L,"AhmedMostafa","ahmedmostafa33@gmail.com",1000000,"1111");
            Customer alHassanAli= new Customer(4L,"AlHassanAli","alhassanali33@gmail.com",2000000,"1111");
            Customer abdAllahBakry= new Customer(5L,"AbdAllahBakry","abdallahbakry33@gmail.com",10000000,"1111");
            customerRepository.saveAll(List.of(samyMohsen,ahmedHassan,ahmedMostafa,alHassanAli,abdAllahBakry));
        };
    }
}
