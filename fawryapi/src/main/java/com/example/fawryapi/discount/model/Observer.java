package com.example.fawryapi.discount.model;


import com.example.fawryapi.services.model.Service;

public interface Observer {
	void subscribe(Service service);
	void unsubscribe(Service service);
	void notifyDiscount(String serviceName, String discountType, Discount discount);
}
