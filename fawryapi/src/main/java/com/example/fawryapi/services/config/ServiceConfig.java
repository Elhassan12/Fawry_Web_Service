package com.example.fawryapi.services.config;

import com.example.fawryapi.discount.controller.DiscountController;
import com.example.fawryapi.discount.model.Discount;
import com.example.fawryapi.discount.model.DiscountObserver;
import com.example.fawryapi.services.donations.Donation;
import com.example.fawryapi.services.internet_payment.InternetPayment;
import com.example.fawryapi.services.landline.Landline;
import com.example.fawryapi.services.mobile_recharge.MobileRecharge;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceConfig {
    @Bean
    CommandLineRunner commandLineRunner6(){
        return args -> {
            MobileRecharge mobileRecharge = new MobileRecharge("mobile recharge", 10);
//            for (Provider provider : mobileRecharge.getServiceList()) {
//                System.out.println(provider.getProviderName()+" "+provider.getCategory());
//            }

            InternetPayment internetPayment = new InternetPayment("internet payment", 10);
            Landline landline = new Landline("landline", 10);
            Donation donation = new Donation("donation", 1);

//            DiscountController discountController = new DiscountController();
            DiscountObserver discountObserver = DiscountObserver.getInstance();
            discountObserver.subscribe(mobileRecharge);
            discountObserver.subscribe(internetPayment);
            discountObserver.subscribe(landline);
            discountObserver.subscribe(donation);
            //.........................
            Discount discount = new Discount("specific",0.8);
            discountObserver.notifyDiscount(mobileRecharge.getServiceName(),"specific",discount);
            System.out.println(mobileRecharge.getServiceList().get(0).getDiscount());

        };
    }
}
