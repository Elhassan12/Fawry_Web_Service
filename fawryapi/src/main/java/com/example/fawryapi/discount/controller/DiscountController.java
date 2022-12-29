package com.example.fawryapi.discount.controller;

import com.example.fawryapi.discount.model.Discount;
import com.example.fawryapi.discount.model.DiscountObserver;
import com.example.fawryapi.discount.repository.DiscountData;

public class DiscountController {
	DiscountObserver discountObserver = DiscountObserver.getInstance();
	DiscountData discountData = DiscountData.getInstance();
	
	public void setOverallDiscount(Discount discount) {
		discountData.setOveralldiscount(discount);
	}
	
	public void setSpecificDiscount(Discount discount) {
		discountData.setSpecificdiscount(discount);
	}
	
	public Discount getOverallDiscount() {
		return discountData.getOveralldiscount(); 
	}
	
	public Discount getSpoecificDiscount() {
		return discountData.getSpecificdiscount(); 
	}
	
	public void notifyDiscount(String serviceName, String discountType, Discount discount) {
		discountObserver.notifyDiscount(serviceName, discountType, discount);
	}
}
