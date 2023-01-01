package com.example.fawryapi.discount.repository;

import com.example.fawryapi.discount.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {

    @Query(nativeQuery = true, value = "Select * from discounts where active = true")
    List<Discount> findAllByActive();
}
