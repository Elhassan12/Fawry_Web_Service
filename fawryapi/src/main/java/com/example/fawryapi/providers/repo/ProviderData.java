package com.example.fawryapi.providers.repo;

import com.example.fawryapi.providers.model.Provider;

import java.util.ArrayList;
import java.util.Objects;


public class ProviderData {

    ArrayList<Provider> rechargeList = new ArrayList<Provider>();
    ArrayList<Provider> internetPaymentList = new ArrayList<Provider>();
    ArrayList<Provider> donationList = new ArrayList<Provider>();
    ArrayList<Provider> landlineList = new ArrayList<Provider>();
    ArrayList<Provider> emptyList = new ArrayList<Provider>();

    static ProviderData providerData = new ProviderData();
    private ProviderData() {}

    public static ProviderData getInstance() {
        return providerData.providerData;
    }

    public void addProvider(Provider provider) {
        if (Objects.equals(provider.getCategory(), "mobile recharge")) {
            rechargeList.add(provider);
        }
        else if (Objects.equals(provider.getCategory(), "internet payment")) {
            internetPaymentList.add(provider);
        }
        else if (Objects.equals(provider.getCategory(), "landline")) {
            landlineList.add(provider);
        }
        else if (Objects.equals(provider.getCategory(), "donation")) {
            donationList.add(provider);
        }

    }

    public ArrayList<Provider> getProviderList(String category) {
        if (category == "mobile recharge") {
            return rechargeList;
        }
        else if (category == "internet payment") {
            return internetPaymentList;
        }
        else if (category == "landline") {
            return landlineList;
        }
        else if (category == "donation") {
            return donationList;
        }
        return emptyList;
    }
}
