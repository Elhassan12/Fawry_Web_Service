package com.example.fawryapi.creditcard;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard findCreditCardById(Long id) {
        return creditCardRepository.findById(id).get();
    }

    public void addCreditCard(CreditCard creditCard) {
        Optional<CreditCard> creditCardOptional =  creditCardRepository.
                findByCreditCardNumberIgnoreCase(creditCard.getCreditCardNumber());

        if(creditCardOptional.isPresent()){
            throw new IllegalStateException("Something went wrong, try again!");
        }
        creditCardRepository.save(creditCard);
    }

    public void deleteCreditCard(Long id) {
        boolean exists = creditCardRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("CreditCard with id "+id+" does not exist");
        }
        creditCardRepository.deleteById(id);
    }

    @Transactional
    public void updateCreditCard(Long id, String creditCardNumber, double creditCardBalance) {
        CreditCard creditCard = creditCardRepository.findById(id)
                .orElseThrow( ()-> new IllegalStateException(
                        "Credit Card with id "+ id + "does not exist"
                ));

        if(creditCardNumber != null && creditCardNumber.length() > 0 &&
                !Objects.equals(creditCard.getCreditCardNumber(),creditCardNumber))
        {
            Optional<CreditCard> creditCardOptional = creditCardRepository.findByCreditCardNumberIgnoreCase(creditCardNumber);
            if(creditCardOptional.isPresent()){
                throw new IllegalStateException("user name already taken");
            }
            creditCard.setCreditCardNumber(creditCardNumber);
        }


        if(creditCardBalance >= 0){
            creditCard.setCreditCardBalance(creditCardBalance);
        }
    }
}
