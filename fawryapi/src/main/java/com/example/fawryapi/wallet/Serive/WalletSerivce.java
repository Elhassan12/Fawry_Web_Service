package com.example.fawryapi.wallet.Serive;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletSerivce {
    private final WalletRepository walletRepository;

    @Autowired
    public WalletSerivce(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public APIResponse<Object> getWalletTransactions() {
        return new APIResponse<>(true,"all wallet Transactions",walletRepository.findAll());
    }
}
