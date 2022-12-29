package com.example.fawryapi.services.repo;

import com.example.fawryapi.services.Service;

import java.util.ArrayList;


public class ServiceRepo {
    ArrayList<Service> serviceList = new ArrayList<>();
    private ServiceRepo() {}
    private static ServiceRepo serviceData = new ServiceRepo();

    public static ServiceRepo getInstance() {
        return ServiceRepo.serviceData;
    }

    public void addService(Service service) {
        serviceList.add(service);
    }

    public ArrayList<Service> getServiceList() {
        return serviceList;
    }

}
