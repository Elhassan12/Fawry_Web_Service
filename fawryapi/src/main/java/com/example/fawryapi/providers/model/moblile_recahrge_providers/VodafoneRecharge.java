package com.example.fawryapi.providers.model.moblile_recahrge_providers;

import com.example.fawryapi.providers.model.Provider;

public class VodafoneRecharge extends Provider {
	private double amount;  

	

	public VodafoneRecharge() {
		super("mobile recharge");
		super.setProviderName("vodafone Recharge");

	}

	public double getAmount() {
		if (getDiscount() == 0) {
			return amount; 
		}
		return amount* getDiscount();
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



	@Override
	public boolean handleRequest(String to) {
		if (to.charAt(2) == '0' && to.length() == 11) {
			return true; 
		}
		return false;
	}
	
	@Override
	public boolean handleRequestAmount(double amount) {
		if (amount <= 500) {
			return true; 
		}
		return false;
	}

	@Override
	public void submitRequest(String to, double amount) {
		this.amount = amount; 
		this.setTo(to);
	}
	
}
