package com.example.fawryapi.services.mobile_recharge;

import java.util.ArrayList;

import com.example.fawryapi.providers.controller.ProviderController;
import com.example.fawryapi.providers.model.Provider;
import com.example.fawryapi.services.Service;

public class MobileRecharge extends Service {
	
	ArrayList<Provider> rechargeList;
	ProviderController providerController = new ProviderController();

	public MobileRecharge(String serviceName, double fees) {
		super(serviceName, fees);
		super.serviceList = providerController.getProviderList("mobile recharge"); 
	}
	
	public ArrayList<Provider> getRechargeList() {
		return super.serviceList;
	}

	
	


}
