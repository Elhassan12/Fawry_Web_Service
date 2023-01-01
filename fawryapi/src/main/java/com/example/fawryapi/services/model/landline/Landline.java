package com.example.fawryapi.services.model.landline;

import java.util.ArrayList;
import com.example.fawryapi.providers.controller.ProviderController;
import com.example.fawryapi.providers.model.Provider;
import com.example.fawryapi.services.model.Service;

public class Landline extends Service {
	ArrayList<Provider> landlineList;
	ProviderController providerController = new ProviderController();

	public Landline(String serviceName, double fees) {
		super(serviceName, fees);
		super.serviceList = providerController.getProviderList("landline");
	}

	public ArrayList<Provider> getLandlineList() {
		return super.serviceList;
	}
	

	

}
