package com.example.fawryapi.providers.controller;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.providers.service.ProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/provider")
public class ProviderAPIController {
    private final ProviderService providerService;

    @Autowired
    public ProviderAPIController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // 1. get specific service providers
    @PostMapping (path = "recharge/{id}")
    APIResponse<Object> recharge(
            @PathVariable("id") Long id,
            @RequestParam String providerName,
            @RequestParam String number,
            @RequestParam double amount
    ) {
        return providerService.recharge(id, providerName, number, amount);
    }

    // 2. get all
    @PostMapping (path = "internetPayment/{id}")
    APIResponse<Object> internetPayment(
            @PathVariable("id") Long id,
            @RequestParam String providerName,
            @RequestParam String number,
            @RequestParam double amount
    ) throws JsonProcessingException {
        return providerService.internetPayment(id,providerName,number,amount);
    }


    @PostMapping (path = "donation/{id}")
    APIResponse<Object> donation(
            @PathVariable("id") Long id,
            @RequestParam String providerName,
            @RequestParam String dest,
            @RequestParam double amount
    ) throws JsonProcessingException {
        return providerService.donation(id,providerName,dest,amount);
    }

    @PostMapping (path = "landline/{id}")
    APIResponse<Object> landlineRecharge(
            @PathVariable("id") Long id,
            @RequestParam String plan,
            @RequestParam String number,
            @RequestParam double amount
    ) throws JsonProcessingException {
        return providerService.landLineRecharge(id,plan,number,amount);
    }
}
