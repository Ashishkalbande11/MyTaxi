package com.example.RideIt.Controller;

import com.example.RideIt.Model.Coupon;
import com.example.RideIt.Service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/coupon")
    public ResponseEntity<String> addCoupon(@RequestParam("coupon-code")String couponCode,
                                            @RequestParam("percentage-discount") int discount){
        String response = couponService.addCoupon(couponCode,discount);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
