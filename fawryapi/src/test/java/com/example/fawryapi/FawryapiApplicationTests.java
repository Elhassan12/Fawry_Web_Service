package com.example.fawryapi;

import com.example.fawryapi.customer.model.Customer;
import com.example.fawryapi.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class FawryapiApplicationTests {

	@Autowired
	private final CustomerRepository customerRepository;

	FawryapiApplicationTests(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Test
	void checkUserNameOrEmail(){
		Customer customer = Customer.builder()
				.userName("frank")
				.email("john")
				.password("1234")
				.walletAmount(0)
				.build();

		Optional<Customer> tmp = customerRepository.findByUserNameIgnoreCase("samyMohsen");

	}

}
