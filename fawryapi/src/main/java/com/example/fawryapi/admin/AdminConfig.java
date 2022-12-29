package com.example.fawryapi.admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunner2(AdminRepository adminRepository){
        return args -> {
            Admin admin1 = new Admin(1L,"admin1","1111");
            Admin admin2 = new Admin(2L,"admin2","1111");
            adminRepository.saveAll(List.of(admin1,admin2));
        };
    }
}
