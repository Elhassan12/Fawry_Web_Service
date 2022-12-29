package com.example.fawryapi.creditcard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
    Optional<CreditCard> findByCreditCardNumberIgnoreCase(String creditCardNumber);
}
