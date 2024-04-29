package com.example.RideIt.Transformer;

import com.example.RideIt.Model.Coupon;

public class CouponTransformer {
    public static Coupon prepareCoupon(String couponCode, int discount){
        return Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(discount)
                .build();
    }
}
