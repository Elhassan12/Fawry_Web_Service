package com.example.fawryapi.providers.controller;

import com.example.fawryapi.providers.model.Provider;
import com.example.fawryapi.providers.repo.ProviderData;

import java.util.ArrayList;

public class ProviderController {

    ProviderData providerData = ProviderData.getInstance();

    public void addProvider(Provider provider) {
        providerData.addProvider(provider);
    }

    public ArrayList<Provider> getProviderList(String category) {
        return providerData.getProviderList(category);
    }

    public ArrayList<Provider> getAllProviderList() {
        ArrayList<Provider> rechargeList = this.getProviderList("mobile recharge");
        ArrayList<Provider> internetPaymentList = this.getProviderList("internet payment");
        ArrayList<Provider> landlineList = this.getProviderList("landline");
        ArrayList<Provider> donationList = this.getProviderList("donation");
        ArrayList<Provider> allProviders = new ArrayList<>();
        allProviders.addAll(rechargeList);
        allProviders.addAll(internetPaymentList);
        allProviders.addAll(landlineList);
        allProviders.addAll(donationList);

        return allProviders;
    }


}
