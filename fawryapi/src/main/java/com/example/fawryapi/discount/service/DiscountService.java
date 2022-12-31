package com.example.fawryapi.discount.service;

import com.example.fawryapi.APIResponse;
import com.example.fawryapi.discount.model.Discount;
import com.example.fawryapi.discount.model.DiscountObserver;
import com.example.fawryapi.util.GlobalConstants;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    public APIResponse<Object> applyOverAllDiscount(double discount) {
        DiscountObserver discountObserver = DiscountObserver.getInstance();
        Discount notifyDiscount = new Discount("overall",discount);
        discountObserver.notifyDiscount("","overall",notifyDiscount);

        return new APIResponse<>(true,"discount has been applied",notifyDiscount.toString());
    }

    public APIResponse<Object> applySpecificDiscount(double discount, String serviceName) {
        DiscountObserver discountObserver =  DiscountObserver.getInstance();
        Discount notifyDiscount = new Discount("specific",discount);
        discountObserver.notifyDiscount(serviceName,"specific",notifyDiscount);
        return new APIResponse<>(true,"discount has been applied",notifyDiscount.toString());
    }
}
