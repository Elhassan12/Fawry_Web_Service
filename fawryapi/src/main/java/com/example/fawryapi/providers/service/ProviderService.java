package com.example.fawryapi.providers.service;

import com.example.fawryapi.APIResponse;
import com.example.fawryapi.transaction.Transaction;
import com.example.fawryapi.transaction.TransactionRepository;
import com.example.fawryapi.util.GlobalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProviderService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public ProviderService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public APIResponse<Object> recharge(Long id, String providerName, String number, double amount) {
        providerName= providerName.toLowerCase();

        //create transaction and save data
        Transaction transaction = new Transaction(id);
        //separate them

        boolean validAmount = GlobalConstants.vodafoneRecharge.handleRequestAmount(amount);
        if(!validAmount){
            return new APIResponse<>(false,"not valid amount",amount);
        }

        if(providerName.equals("vodafonerecharge")){
            boolean validNumber = GlobalConstants.vodafoneRecharge.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }else if(providerName.equals("etisalatrecharge")){
            boolean validNumber = GlobalConstants.etisalatRecharge.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }else if(providerName.equals("orangerecharge")){
            boolean validNumber = GlobalConstants.orangeRecharge.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }else if(providerName.equals("werecharge")){
            boolean validNumber = GlobalConstants.weRecharge.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }
        Map<String,Object> map = new HashMap<>();
        GlobalConstants.etisalatRecharge.setAmount(amount);
        double cost = GlobalConstants.etisalatRecharge.getAmount();
        // add transaction id to the map
        map.put("number",number);
        map.put("rechargeAmount",amount);
        map.put("cost",cost);
        transaction.setAmount(cost);
        transaction.setComplete(false);
        transaction.setSentTo(number);
        transaction.setServiceName("mobileRecharge");
        transaction.setProviderName(providerName);
        transaction.setStatus("");
        transactionRepository.save(transaction);
        return new APIResponse<>(true,"you are recharging XD",map.toString());
        // ---= pending
        // ---= complete
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public APIResponse<Object> internetPayment(Long id, String providerName, String number, double amount) {
        providerName= providerName.toLowerCase();

        //create transaction and save data
        Transaction transaction = new Transaction(id);
        //separate them

        boolean validAmount = GlobalConstants.orangeInternetPayment.handleRequestAmount(amount);
        if(!validAmount){
            return new APIResponse<>(false,"not valid amount",amount);
        }

        if(providerName.equals("vodafoneinternetpayment")){
            boolean validNumber = GlobalConstants.vodafoneInternetPayment.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }else if(providerName.equals("etisalatinternetpayment")){
            boolean validNumber = GlobalConstants.etisalatInternetPayment.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }else if(providerName.equals("orangeinternetpayment")){
            boolean validNumber = GlobalConstants.orangeInternetPayment.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }else if(providerName.equals("weinternetpayment")){
            boolean validNumber = GlobalConstants.weInternetPayment.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }

        Map<String,Object> map = new HashMap<>();
        GlobalConstants.etisalatInternetPayment.setAmount(amount);
        double cost = GlobalConstants.etisalatInternetPayment.getAmount();
        // add transaction id to the map
        map.put("number",number);
        map.put("rechargeAmount",amount);
        map.put("cost",cost);
        transaction.setAmount(cost);
        transaction.setComplete(false);
        transaction.setSentTo(number);
        transaction.setServiceName("internetPayment");
        transaction.setProviderName(providerName);
        transaction.setStatus("");
        transactionRepository.save(transaction);
        return new APIResponse<>(true,"you are recharging your internet XD",map.toString());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public APIResponse<Object> donation(Long id, String providerName, String dest, double amount) {
        Transaction transaction = new Transaction(id);
        providerName= providerName.toLowerCase();
        boolean validAmount = GlobalConstants.orangeInternetPayment.handleRequestAmount(amount);
        if(!validAmount){
            return new APIResponse<>(false,"not valid amount",amount);
        }

        if(providerName.equals("schools")){
            boolean validDest = GlobalConstants.schools.handleRequest(dest);
            if(!validDest){
                return new APIResponse<>(false,"not a valid destination",dest);
            }
        }else if(providerName.equals("cancerhospital")){
            boolean validDest = GlobalConstants.cancerHospital.handleRequest(dest);
            if(!validDest){
                return new APIResponse<>(false,"not a valid destination",dest);
            }
        }else if(providerName.equals("ngos")){
            boolean validDest = GlobalConstants.ngOs.handleRequest(dest);
            if(!validDest){
                return new APIResponse<>(false,"not a valid destination",dest);
            }
        }
        Map<String,Object> map = new HashMap<>();
        GlobalConstants.schools.setAmount(amount);
        double cost = GlobalConstants.schools.getAmount();
        // add transaction id to the map
        map.put("destination",dest);
        map.put("rechargeAmount",amount);
        map.put("cost",cost);
        transaction.setAmount(cost);
        transaction.setComplete(false);
        transaction.setSentTo(dest);
        transaction.setServiceName("donation");
        transaction.setProviderName(providerName);
        transaction.setStatus("");
        transactionRepository.save(transaction);
        return new APIResponse<>(true,"you are donating to "+dest+" <3 :) # ~-O",map.toString());
    ////////////////////////////////////////////////////////////////////////////////////////////////

    }


    public APIResponse<Object> landLineRecharge(Long id, String providerName, String number, double amount) {
        Transaction transaction = new Transaction(id);
        providerName= providerName.toLowerCase();
        boolean validAmount = GlobalConstants.orangeInternetPayment.handleRequestAmount(amount);
        if(!validAmount){
            return new APIResponse<>(false,"not valid amount",amount);
        }
        if(providerName.equals("monthlyreceipt")){
            boolean validNumber = GlobalConstants.monthleyReceipt.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }else if(providerName.equals("quarterreceipt")){
            boolean validNumber = GlobalConstants.quarterReceipt.handleRequest(number);
            if(!validNumber){
                return new APIResponse<>(false,"not a valid number",number);
            }
        }
        Map<String,Object> map = new HashMap<>();
        GlobalConstants.monthleyReceipt.setAmount(amount);
        double cost = GlobalConstants.monthleyReceipt.getAmount();
        // add transaction id to the map
        map.put("number",number);
        map.put("rechargeAmount",amount);
        map.put("cost",cost);
        transaction.setAmount(cost);
        transaction.setComplete(false);
        transaction.setSentTo(number);
        transaction.setServiceName("landline");
        transaction.setProviderName(providerName);
        transaction.setStatus("");
        transactionRepository.save(transaction);
        return new APIResponse<>(true,"recharging landline",map.toString());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
}
// payment
// discount
// refund :) we finish here
