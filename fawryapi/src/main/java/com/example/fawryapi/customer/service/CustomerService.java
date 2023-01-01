package com.example.fawryapi.customer.service;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.customer.model.Customer;
import com.example.fawryapi.customer.repository.CustomerRepository;
import com.example.fawryapi.discount.repository.DiscountRepository;
import com.example.fawryapi.wallet.repository.WalletRepository;
import com.example.fawryapi.wallet.model.WalletTransaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final WalletRepository walletRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, DiscountRepository discountRepository, WalletRepository walletRepository) {
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.walletRepository = walletRepository;
    }

    public List<Customer> getCustomers() {
       return customerRepository.findAll();
    }

    public APIResponse<Object> getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.<APIResponse<Object>>map(customer -> new APIResponse<>(true, "customer exists", customer))
                .orElseGet(() -> new APIResponse<>(false, "customer doesn't exist", id));
    }

    public Customer getCustomerByUserName(String userName) {
        return customerRepository.findByUserNameIgnoreCase(userName).get();
    }


    public APIResponse<Customer> addNewCustomer(Customer customer) {
        Optional<Customer> customerOptionalName = customerRepository
                .findByUserNameIgnoreCase(customer.getUserName());

        Optional<Customer> customerOptionalEmail = customerRepository
                .findByEmailIgnoreCase(customer.getEmail());

        if(customerOptionalName.isPresent() && customerOptionalEmail.isPresent()){
            throw new IllegalStateException("User name or Email already taken");
        }else if(customerOptionalName.isPresent()){
            throw new IllegalStateException("User name already taken");
        }else if(customerOptionalEmail.isPresent()){
            throw new IllegalStateException("Email already taken");
        }
        customerRepository.save(customer);
        APIResponse<Customer> apiResponse = new APIResponse<>();
        apiResponse.setMessage("Customer added successfully");
        apiResponse.setStatus(true);
        apiResponse.setData(customer);
        return  apiResponse;
    }

    public APIResponse<Integer> deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("customer with id "+customerId+" does not exist");
        }
        customerRepository.deleteById(customerId);
        APIResponse<Integer> apiResponse = new APIResponse<>();
        apiResponse.setData(Math.toIntExact(customerId));
        apiResponse.setMessage("Customer deleted successfully");
        apiResponse.setStatus(true);
        return apiResponse;
    }

    @Transactional
    public APIResponse<Customer> updateCustomer(Long customerId, String userName, String email, String password,double walletAmount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new IllegalStateException(
                        "customer with id "+customerId+ " does not exist"
                ));

        if(userName != null && userName.length() > 0 &&
        !Objects.equals(customer.getUserName(),userName))
        {
            Optional<Customer> customerOptional = customerRepository.findByUserNameIgnoreCase(userName);
            if(customerOptional.isPresent()){
                throw new IllegalStateException("user name already taken");
            }
            customer.setUserName(userName);
        }

        if(email != null && email.length() > 0 &&
                !Objects.equals(customer.getEmail(),email))
        {
            Optional<Customer> customerOptional = customerRepository.findByEmailIgnoreCase(email);
            if(customerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            customer.setEmail(email);
        }

        if(password != null && password.length() > 0 &&
        !Objects.equals(customer.getPassword(),password)){
            customer.setPassword(password);
        }

        if(walletAmount >= 0 && walletAmount!=customer.getWalletAmount()){
            customer.setWalletAmount(walletAmount+customer.getWalletAmount());
        }
        Customer tmp_customer = Customer.builder()
                .userName(customer.getUserName())
                .customerID(customerId)
                .email(customer.getEmail())
                .password("***********")
                .walletAmount(walletAmount)
                .build();

        APIResponse<Customer> apiResponse = new APIResponse<>();
        apiResponse.setMessage("updated successfully");
        apiResponse.setStatus(true);
        apiResponse.setData(tmp_customer);
        return apiResponse;
    }

    @Transactional
    public APIResponse<String> recharge(Long customerId,double walletAmount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new IllegalStateException(
                        "customer with id "+customerId+ " does not exist"
                ));

        if(walletAmount >= 0 && walletAmount!=customer.getWalletAmount()){
            customer.setWalletAmount(walletAmount+customer.getWalletAmount());
        }
        APIResponse<String> apiResponse = new APIResponse<>();
        apiResponse.setMessage("updated successfully");
        apiResponse.setStatus(true);

        WalletTransaction walletTransaction = new WalletTransaction();

        walletTransaction.setCustomerId(customerId);
        walletTransaction.setBefore(customer.getWalletAmount()-walletAmount);
        walletTransaction.setAfter(customer.getWalletAmount());
        walletTransaction.setDate(Date.valueOf(LocalDate.now()));

        walletRepository.save(walletTransaction);

        Map<String,Object> map = new HashMap<>();
        map.put("userName",customer.getUserName());
        map.put("customerId",customer.getCustomerID());
        map.put("walletBalance",customer.getWalletAmount());
        map.put("rechargeAmount",walletAmount);
        apiResponse.setData(map.toString());
        return apiResponse;
    }

    public APIResponse<Object> getDiscounts() {
        return new APIResponse<>(true,"Active discounts",discountRepository.findAllByActive());
    }

    public APIResponse<Object> signIn(String email, String password) {
        Optional<Customer> customerOptional = customerRepository.findByEmailAndPassword(email,password);
        if(customerOptional.isPresent()){// yes I made an id for him !
            return new APIResponse<>(true,"SignedIn successfully",customerOptional.get());
        }
        return new APIResponse<>(false,"not valid credential",List.of(email,password));
    }
}