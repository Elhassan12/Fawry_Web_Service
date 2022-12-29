package com.example.fawryapi.providers.moblile_recahrge_providers;

import com.example.fawryapi.providers.model.Provider;

public class WeRecharge extends Provider {
	private double amount;  
;
	

	public WeRecharge() {
		super("mobile recharge");
		super.setProviderName("We Recharge");

	}

	public double getAmount() {
		if (getDiscount() == 0) {
			return amount; 
		}
		return amount*discount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public boolean handleRequest(String to) {
		if (to.charAt(2) == '5' && to.length() == 11) {
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
		this.to = to;
	}
}
