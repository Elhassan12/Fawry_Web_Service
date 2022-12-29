package com.example.fawryapi.discount.model;
import com.example.fawryapi.discount.model.Discount;
import com.example.fawryapi.discount.model.Observer;
import com.example.fawryapi.services.Service;
import com.example.fawryapi.services.repo.ServiceRepo;

import java.util.ArrayList;


public class DiscountObserver implements Observer {
	ArrayList<Service> servicesList;
	ServiceRepo serviceData = ServiceRepo.getInstance();
	static final DiscountObserver discountObserver = new DiscountObserver();
	public static DiscountObserver getInstance(){
		return discountObserver;
	}
	private DiscountObserver() {

		this.servicesList = serviceData.getServiceList();
	}
	
	@Override
	public void subscribe(Service service) {
		servicesList.add(service); 
	}; 
	
	@Override
	public void unsubscribe(Service service) {
		servicesList.remove(service); 
	}

	@Override
	public void notifyDiscount(String serviceName, String discountType, Discount discount) {
		if (discountType.equals("overall")) {
			for(int i =0 ; i<servicesList.size() ; i++) {
				servicesList.get(i).updateDiscount(discount);
			}
		}
		else if (serviceName.equals("mobile recharge")) {
			servicesList.get(0).updateDiscount(discount);
			}
		else if (serviceName.equals("internet payment")) {
			servicesList.get(1).updateDiscount(discount);
			}
		else if (serviceName.equals("landline")) {
			servicesList.get(2).updateDiscount(discount);
			}
		else if (serviceName.equals("donation")) {
			servicesList.get(3).updateDiscount(discount);
			}
	}
	
	
	
	// Discount options
	// create discount first 
	// Observe 
	// Make controller for serviceData


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
