package com.example.fawryapi.services.service;

import com.example.fawryapi.APIResponse;
import com.example.fawryapi.providers.controller.ProviderController;
import com.example.fawryapi.providers.model.Provider;
import com.example.fawryapi.util.GlobalConstants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceService {
    ProviderController providerController = new ProviderController();
    public APIResponse<Object> getAllServices() {
        Map<String, List<String>> services = new HashMap<>();
        List<String> landlineProviders = new ArrayList<>();
        for (Provider provider : GlobalConstants.landline.getServiceList()) {
            landlineProviders.add(provider.getProviderName());
        }
        services.put("landLine",landlineProviders);


        List<String> donationProviders = new ArrayList<>();
        for (Provider provider : GlobalConstants.donation.getServiceList()) {
            donationProviders.add(provider.getProviderName());
        }
        services.put("donation",donationProviders);



        List<String> internetPayment = new ArrayList<>();
        for (Provider provider : GlobalConstants.internetPayment.getServiceList()) {
            internetPayment.add(provider.getProviderName());
        }
        services.put("internetPayment",internetPayment);


        List<String> mobileRecharge = new ArrayList<>();
        for (Provider provider : GlobalConstants.mobileRecharge.getServiceList()) {
            mobileRecharge.add(provider.getProviderName());
        }
        services.put("mobileRecharge",mobileRecharge);

        return new APIResponse<>(true,"list of services and providers", services.toString());
    }

    public APIResponse<Object> searchByCategory(String category) {
        String[] serviceListNames = {"mobile recharge", "internet payment", "landline", "donation"};
        ArrayList<Provider> serviceList = new ArrayList<>();
        if (category.equals(serviceListNames[0])) {
            serviceList = providerController.getProviderList("mobile recharge");
        }
        else if (category.equals(serviceListNames[1])) {
            serviceList = providerController.getProviderList("internet payment");
        }
        else if (category.equals(serviceListNames[2])) {
            serviceList = providerController.getProviderList("landline");
        }
        else if (category.equals(serviceListNames[3])) {
            serviceList = providerController.getProviderList("donation");
        }
        return new APIResponse<>(true,category+" providers",serviceList.toString());
    }
}
