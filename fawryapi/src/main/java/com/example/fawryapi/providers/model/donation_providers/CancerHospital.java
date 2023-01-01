package com.example.fawryapi.providers.model.donation_providers;

import com.example.fawryapi.providers.model.Provider;

public class CancerHospital extends Provider {
	
	private double amount;  

	public CancerHospital() {
		super("donation");
		super.setProviderName("Cancer Hospital");

	}

	public double getAmount() {
		if (discount == 0) {
			return amount; 
		}
		return amount*discount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



	@Override
	public boolean handleRequest(String to) {
		return true;
	}
	
	@Override
	public boolean handleRequestAmount(double amount) {
		if (amount <= 10000) {
			return true; 
		}
		return false;
	}

	@Override
	public void submitRequest(String to, double amount) {
		this.amount = amount; 
		this.to = to;
	}

}
