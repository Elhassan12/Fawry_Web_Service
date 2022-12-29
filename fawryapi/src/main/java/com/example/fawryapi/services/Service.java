package com.example.fawryapi.services;

import com.example.fawryapi.discount.model.Discount;
import com.example.fawryapi.providers.model.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Service {
    protected ArrayList<Provider> serviceList;
    private String serviceName;
    private double fees;

    public Service(String serviceName, double fees) {
        this.serviceName = serviceName;
        this.fees = fees;
        this.serviceList = new ArrayList<>();
    }



    public void updateDiscount(Discount discount) {
        for (int i = 0; i < serviceList.size(); i++) {
            serviceList.get(i).setDiscount(discount.getDiscountPrecentage());
        }
    }
}
