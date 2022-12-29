package com.example.fawryapi.customer;

import com.example.fawryapi.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{id}")
    public APIResponse<Object> getCustomerById(@PathVariable("id") Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping(path = "name/{userName}")
    public Customer getCustomerByUserName(@PathVariable("userName") String userName){
        return customerService.getCustomerByUserName(userName);
    }

    @PostMapping
    public APIResponse<Customer> addNewCustomer(@RequestBody Customer customer){
        return customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public APIResponse<Integer> deleteCustomer(@PathVariable("customerId") Long customerId){
        return customerService.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public APIResponse<Customer> updateCustomer(
            @PathVariable("customerId")Long customerId,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) double walletAmount
    ){
        return customerService.updateCustomer(customerId,userName,email,password,walletAmount);
    }

    @PutMapping(path = "wallet/{customerId}")
    public APIResponse<String> recharge(
            @PathVariable("customerId")Long customerId,
            @RequestParam double walletAmount
    ){
        return customerService.recharge(customerId,walletAmount);
    }
}
