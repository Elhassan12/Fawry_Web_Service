package com.example.fawryapi.services.donations;

import java.util.ArrayList;

import com.example.fawryapi.providers.controller.ProviderController;
import com.example.fawryapi.providers.model.Provider;
import com.example.fawryapi.services.Service;

public class Donation extends Service {
	ProviderController providerController = new ProviderController();
	ArrayList<Provider> donationList;
	
	public Donation(String serviceName, double fees) {
		super(serviceName,0);
		super.serviceList = providerController.getProviderList("donation");
		
	}

	public ArrayList<Provider> getInternetPaymentList() {
		return super.serviceList;
	}

}
