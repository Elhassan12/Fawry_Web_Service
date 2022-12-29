package com.example.fawryapi.services.internet_payment;

import java.util.ArrayList;


import com.example.fawryapi.providers.controller.ProviderController;
import com.example.fawryapi.providers.model.Provider;
import com.example.fawryapi.services.Service;

public class InternetPayment extends Service {
	ArrayList<Provider> internetPaymentList;
	ProviderController providerController = new ProviderController();
	
	public InternetPayment(String serviceName, double fees) {
		super(serviceName, fees);
		super.serviceList = providerController.getProviderList("internet payment"); 
	}

	public ArrayList<Provider> getInternetPaymentList() {
		return super.serviceList;
	}


}
