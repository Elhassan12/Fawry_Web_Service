package com.example.fawryapi.admin.repository;

import com.example.fawryapi.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByUserNameIgnoreCase(String userName);

    @Query(nativeQuery = true,value = "Select * from admin where admin_name = ?1 and admin_password = ?2")
    Optional<Admin> findByEmailAndPassword(String email, String password);
}
