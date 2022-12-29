package com.example.fawryapi.discount.model;

import lombok.ToString;

@ToString
public class Discount {
	private String discountType;
	private double discountPrecentage;
	
	public Discount(String discountType, double discountPrecentage) {
		this.discountType = discountType;
		this.discountPrecentage = discountPrecentage;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public double getDiscountPrecentage() {
		return discountPrecentage;
	}
	public void setDiscountPrecentage(double discountPrecentage) {
		this.discountPrecentage = discountPrecentage;
	} 
	
}
