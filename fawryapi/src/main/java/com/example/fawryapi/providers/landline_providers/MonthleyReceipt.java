package com.example.fawryapi.providers.landline_providers;

import com.example.fawryapi.providers.model.Provider;

public class MonthleyReceipt extends Provider {
	private double amount;  

	public MonthleyReceipt() {
		super("landline");
		super.setProviderName("Monthley Receipt");

		this.amount = 80; 
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
		if  (to.length() == 7) {
			return true; 
		}
		return false;
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
