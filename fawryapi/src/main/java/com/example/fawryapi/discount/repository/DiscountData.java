package com.example.fawryapi.discount.repository;

import com.example.fawryapi.discount.model.Discount;


public class DiscountData {
	Discount overalldiscount;
	Discount specificdiscount; 
	
	public Discount getOveralldiscount() {
		return overalldiscount;
	}

	public void setOveralldiscount(Discount overalldiscount) {
		this.overalldiscount = overalldiscount;
	}

	public Discount getSpecificdiscount() {
		return specificdiscount;
	}

	public void setSpecificdiscount(Discount specificdiscount) {
		this.specificdiscount = specificdiscount;
	}

	private DiscountData () {}
	private static DiscountData discountData = new DiscountData(); 
	
	public static DiscountData getInstance() {
		return DiscountData.discountData;
	}
	
}
