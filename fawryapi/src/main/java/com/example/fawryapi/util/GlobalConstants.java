package com.example.fawryapi.util;

import com.example.fawryapi.providers.donation_providers.CancerHospital;
import com.example.fawryapi.providers.donation_providers.NGOs;
import com.example.fawryapi.providers.donation_providers.Schools;
import com.example.fawryapi.providers.internet_pay_providers.EtisalatInternetPayment;
import com.example.fawryapi.providers.internet_pay_providers.OrangeInternetPayment;
import com.example.fawryapi.providers.internet_pay_providers.VodafoneInternetPayment;
import com.example.fawryapi.providers.internet_pay_providers.WeInternetPayment;
import com.example.fawryapi.providers.landline_providers.MonthleyReceipt;
import com.example.fawryapi.providers.landline_providers.QuarterReceipt;
import com.example.fawryapi.providers.moblile_recahrge_providers.EtisalatRecharge;
import com.example.fawryapi.providers.moblile_recahrge_providers.OrangeRecharge;
import com.example.fawryapi.providers.moblile_recahrge_providers.VodafoneRecharge;
import com.example.fawryapi.providers.moblile_recahrge_providers.WeRecharge;
import com.example.fawryapi.services.donations.Donation;
import com.example.fawryapi.services.internet_payment.InternetPayment;
import com.example.fawryapi.services.landline.Landline;
import com.example.fawryapi.services.mobile_recharge.MobileRecharge;

public class GlobalConstants {
    // balance recharge providers
    public static VodafoneRecharge vodafoneRecharge = new VodafoneRecharge();
    public static EtisalatRecharge etisalatRecharge = new EtisalatRecharge();
    public static OrangeRecharge orangeRecharge = new OrangeRecharge();
    public static WeRecharge weRecharge = new WeRecharge();
    // internet payment providers
    public static VodafoneInternetPayment vodafoneInternetPayment = new VodafoneInternetPayment();
    public static EtisalatInternetPayment etisalatInternetPayment = new EtisalatInternetPayment();
    public static OrangeInternetPayment orangeInternetPayment = new OrangeInternetPayment();
    public static WeInternetPayment weInternetPayment = new WeInternetPayment();

    // donation
    public static CancerHospital cancerHospital = new CancerHospital();
    public static Schools schools = new Schools();
    public static NGOs ngOs = new NGOs();

    // landline
    public static MonthleyReceipt monthleyReceipt = new MonthleyReceipt();
    public static QuarterReceipt quarterReceipt = new QuarterReceipt();


    // all services
    public static MobileRecharge mobileRecharge = new MobileRecharge("mobile recharge", 10);
    public static InternetPayment internetPayment = new InternetPayment("internet payment", 10);
    public static Landline landline = new Landline("landline", 10);
    public static Donation donation = new Donation("donation", 0);
}
