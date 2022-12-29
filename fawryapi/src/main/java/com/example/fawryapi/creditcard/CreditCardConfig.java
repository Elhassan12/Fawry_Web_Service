package com.example.fawryapi.creditcard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CreditCardConfig {
    @Bean
    CommandLineRunner commandLineRunner3(CreditCardRepository creditCardRepository){
        return args -> {
          CreditCard creditCard1 = new CreditCard(1L,"1234",5000);
          CreditCard creditCard2 = new CreditCard(2L,"1221",500);
            creditCardRepository.saveAll(List.of(creditCard1,creditCard2));
        };
    }
}
