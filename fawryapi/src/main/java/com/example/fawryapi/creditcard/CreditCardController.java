package com.example.fawryapi.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/creditcard")
public class CreditCardController {
    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping(path = "{id}")
    public CreditCard getCreditCardById(@PathVariable("id") Long id){
        return creditCardService.findCreditCardById(id);
    }

    @PostMapping
    public void addCreditCard(@RequestBody CreditCard creditCard){
        creditCardService.addCreditCard(creditCard);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCreditCard(@PathVariable("id")Long id){
        creditCardService.deleteCreditCard(id);
    }

    @PutMapping(path = "{id}")
    public void updateCreditCard(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String creditCardNumber,
            @RequestParam(required = false) double creditCardBalance
    ){
        creditCardService.updateCreditCard(id,creditCardNumber,creditCardBalance);
    }
}
