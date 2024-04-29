package com.example.RideIt.Service;

import com.example.RideIt.Model.Coupon;
import com.example.RideIt.Repository.CouponRepository;
import com.example.RideIt.Transformer.CouponTransformer;
import org.hibernate.sql.model.ast.builder.CollectionRowDeleteByUpdateSetNullBuilder;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public String addCoupon(String couponCode, int discount) {
        Coupon coupon = CouponTransformer.prepareCoupon(couponCode, discount);
        couponRepository.save(coupon);
        return "coupon saved successfully";
    }
}
