package com.example.RideIt.Repository;

import com.example.RideIt.Model.Coupon;
import com.example.RideIt.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
   // @Query()
   // Driver findByMobNo(String mobNo);
}
