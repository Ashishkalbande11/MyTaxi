package com.example.RideIt.Controller;


import com.example.RideIt.DTO.Request.TripBookingRequest;
import com.example.RideIt.DTO.Response.TripBookingResponse;
import com.example.RideIt.Service.TripBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trip")
public class TripBookingController {
    private final TripBookingService tripBookingService;

    public TripBookingController(TripBookingService tripBookingService) {
        this.tripBookingService = tripBookingService;
    }
    @PostMapping("/book")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestParam( value = "apply-coupon", required = false, defaultValue = "false") boolean applyCoupon,
                                                   @RequestBody TripBookingRequest tripBookingRequest){
        TripBookingResponse response = tripBookingService.bookCab(applyCoupon, tripBookingRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @PutMapping("/cab")
    public String updateCab(){
        tripBookingService.updateAllCabsToAvailable();
        return "All Cabs Are Available now";
    }

//    @GetMapping("/allbookings")
//    public ResponseEntity<List<TripBookingResponse>> gettAllBookingForCustomer(@PathVariable int customerId){
//        List<TripBookingResponse> bookings = tripBookingService.getAllBookingsForCustomer(customerId);
//        return new ResponseEntity<>(bookings,HttpStatus.CREATED);
//    }

}
