package com.example.fawryapi.services.controller;

import com.example.fawryapi.APIResponse;
import com.example.fawryapi.services.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/service")
public class ServiceAPIController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceAPIController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    //1. get all services
    @GetMapping
    APIResponse<Object> getAllServices(){
        return serviceService.getAllServices();
    }
    //2. get service by category
    @GetMapping(path = "{category}")
    APIResponse<Object> searchByCategory(@PathVariable("category") String category){
        return serviceService.searchByCategory(category);
    }
    //api/v1/service/landline
}
