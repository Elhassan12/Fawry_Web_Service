package com.example.fawryapi.wallet.repository;

import com.example.fawryapi.wallet.model.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletTransaction,Long> {
}
