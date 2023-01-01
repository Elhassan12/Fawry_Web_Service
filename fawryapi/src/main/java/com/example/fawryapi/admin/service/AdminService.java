package com.example.fawryapi.admin.service;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.admin.model.Admin;
import com.example.fawryapi.admin.repository.AdminRepository;
import com.example.fawryapi.wallet.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final WalletRepository walletRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, WalletRepository walletRepository) {
        this.adminRepository = adminRepository;
        this.walletRepository = walletRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).get();
    }

    public Admin getAdminByUserName(String userName) {
        return adminRepository.findByUserNameIgnoreCase(userName).get();
    }

    public APIResponse<Admin> addNewAdmin(Admin admin) {
        Optional<Admin> adminOptional = adminRepository.findByUserNameIgnoreCase(admin.getUserName());
        if(adminOptional.isPresent()){
            throw new IllegalStateException("admin name already taken");
        }
        adminRepository.save(admin);
        return new APIResponse<>(true, "admin updated successfully", admin);
    }
    public APIResponse<Long> deleteAdmin(Long id) {
        boolean exists = adminRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Admin with id "+id+" does not exist");
        }
        adminRepository.deleteById(id);
        return new APIResponse<>(true,"admin deleted successfully",id);
    }

    @Transactional
    public APIResponse<Object> updateAdmin(Long id,String userName, String password) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "customer with id "+ id + " does not exist"
                ));

        if(password.length() >= 4 && password.length() <=8){
            admin.setPassword(password);
        }

        if(userName != null && userName.length() > 0 &&
                !Objects.equals(admin.getUserName(),userName))
        {
            Optional<Admin> customerOptional = adminRepository.findByUserNameIgnoreCase(userName);
            if(customerOptional.isPresent()){
                throw new IllegalStateException("user name already taken");
            }
            admin.setUserName(userName);
        }
        return new APIResponse<>(true,"Admin info updated successfully",admin);
    }

    public APIResponse<Object> getWalletTransactions() {
        return new APIResponse<>(true,"Wallet Transactions",walletRepository.findAll());
    }

    public APIResponse<Object> signIn(String name, String password) {
        Optional<Admin> adminOptional = adminRepository.findByEmailAndPassword(name,password);
        if(adminOptional.isPresent()){// yes I made an id for him !
            return new APIResponse<>(true,"SignedIn successfully",adminOptional.get());
        }
        return new APIResponse<>(false,"not valid credential",List.of(name,password));
    }
}
