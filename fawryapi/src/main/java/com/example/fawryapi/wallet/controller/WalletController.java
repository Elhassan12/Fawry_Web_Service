package com.example.fawryapi.wallet.controller;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.wallet.Serive.WalletSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/walletTransactions")
public class WalletController {
    private final WalletSerivce walletSerivce;

    @Autowired
    public WalletController(WalletSerivce walletSerivce) {
        this.walletSerivce = walletSerivce;
    }

    @GetMapping()
    APIResponse<Object> getWalletTransactions(){
        return walletSerivce.getWalletTransactions();
    }
}
