package com.example.fawryapi.discount.service;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.discount.model.Discount;
import com.example.fawryapi.discount.model.DiscountObserver;
import com.example.fawryapi.discount.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public APIResponse<Object> applyOverAllDiscount(double discount) {
        DiscountObserver discountObserver = DiscountObserver.getInstance();
        Discount notifyDiscount = new Discount("overall","overall",discount,true);
        discountRepository.save(notifyDiscount);
        discountObserver.notifyDiscount("","overall",notifyDiscount);
        return new APIResponse<>(true,"discount has been applied",notifyDiscount.toString());
    }

    public APIResponse<Object> applySpecificDiscount(double discount, String serviceName) {
        DiscountObserver discountObserver =  DiscountObserver.getInstance();
        Discount notifyDiscount = new Discount("specific",serviceName,discount,true);
        discountRepository.save(notifyDiscount);
        discountObserver.notifyDiscount(serviceName,"specific",notifyDiscount);
        return new APIResponse<>(true,"discount has been applied",notifyDiscount.toString());
    }

    public APIResponse<Object> getAllDiscounts() {
        return new APIResponse<>(true,"Discounts",discountRepository.findAll());
    }
}
