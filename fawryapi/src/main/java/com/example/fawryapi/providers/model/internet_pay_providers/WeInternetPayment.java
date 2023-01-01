package com.example.fawryapi.providers.model.internet_pay_providers;

import com.example.fawryapi.providers.model.Provider;

public class WeInternetPayment extends Provider {
	private double amount;  

	public WeInternetPayment() {
		super("internet payment");
		super.setProviderName("We Internet Payment");
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
		if (to.charAt(2) == '5' && to.length() == 11) {
			return true; 
		}
		return false;
	}
	
	@Override
	public boolean handleRequestAmount(double amount) {
		if (amount <= 5000) {
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
