package com.example.fawryapi.transaction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Configuration
public class TransactionConfig {
    @Bean
    CommandLineRunner commandLineRunner8(TransactionRepository transactionRepository){
        // Waiting,Approved,Reject
        return args -> {
            Transaction transaction1 = new Transaction(1L,"Waiting","Cash", Date.valueOf(LocalDate.now())
                    ,1L,"VodafoneRecharge","MobileRecharge","01018529761",200,true);

            Transaction transaction2 = new Transaction(2L,"Approved","Cash", Date.valueOf(LocalDate.now())
                    ,1L,"VodafoneRecharge","MobileRecharge","01018529761",200,true);

            Transaction transaction3 = new Transaction(3L,"Rejected","Cash", Date.valueOf(LocalDate.now())
                    ,4L,"VodafoneRecharge","MobileRecharge","01018529761",200,true);
            transactionRepository.saveAll(List.of(transaction1,transaction2,transaction3));
        };
    }
}
