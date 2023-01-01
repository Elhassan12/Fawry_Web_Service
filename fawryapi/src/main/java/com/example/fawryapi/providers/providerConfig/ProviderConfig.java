package com.example.fawryapi.providers.providerConfig;

import com.example.fawryapi.providers.model.internet_pay_providers.EtisalatInternetPayment;
import com.example.fawryapi.providers.model.internet_pay_providers.OrangeInternetPayment;
import com.example.fawryapi.providers.model.internet_pay_providers.WeInternetPayment;
import com.example.fawryapi.providers.model.moblile_recahrge_providers.EtisalatRecharge;
import com.example.fawryapi.providers.model.moblile_recahrge_providers.OrangeRecharge;
import com.example.fawryapi.providers.model.moblile_recahrge_providers.WeRecharge;
import com.example.fawryapi.providers.controller.ProviderController;
import com.example.fawryapi.providers.model.donation_providers.CancerHospital;
import com.example.fawryapi.providers.model.donation_providers.NGOs;
import com.example.fawryapi.providers.model.donation_providers.Schools;
import com.example.fawryapi.providers.model.internet_pay_providers.VodafoneInternetPayment;
import com.example.fawryapi.providers.model.landline_providers.MonthleyReceipt;
import com.example.fawryapi.providers.model.landline_providers.QuarterReceipt;
import com.example.fawryapi.providers.model.moblile_recahrge_providers.VodafoneRecharge;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProviderConfig {
    @Bean
    CommandLineRunner commandLineRunner5(){
        return args -> {
            ProviderController providerController = new ProviderController();
            VodafoneRecharge vodafoneRecharge = new VodafoneRecharge();
            EtisalatRecharge etisalatRecharge = new EtisalatRecharge();
            OrangeRecharge orangeRecharge = new OrangeRecharge();
            WeRecharge weRecharge = new WeRecharge();
            VodafoneInternetPayment vodafoneInternetPayment = new VodafoneInternetPayment();
            EtisalatInternetPayment etisalatInternetPayment = new EtisalatInternetPayment();
            OrangeInternetPayment orangeInternetPayment = new OrangeInternetPayment();
            WeInternetPayment weInternetPayment = new WeInternetPayment();
            CancerHospital cancerHospital = new CancerHospital();
            Schools schools = new Schools();
            NGOs ngOs = new NGOs();
            MonthleyReceipt monthleyReceipt = new MonthleyReceipt();
            QuarterReceipt quarterReceipt = new QuarterReceipt();

            providerController.addProvider(vodafoneRecharge);
            providerController.addProvider(etisalatRecharge);
            providerController.addProvider(orangeRecharge);
            providerController.addProvider(weRecharge);
            providerController.addProvider(vodafoneInternetPayment);
            providerController.addProvider(etisalatInternetPayment);
            providerController.addProvider(orangeInternetPayment);
            providerController.addProvider(weInternetPayment);
            providerController.addProvider(cancerHospital);
            providerController.addProvider(schools);
            providerController.addProvider(ngOs);
            providerController.addProvider(monthleyReceipt);
            providerController.addProvider(quarterReceipt);
        };
    }
}
