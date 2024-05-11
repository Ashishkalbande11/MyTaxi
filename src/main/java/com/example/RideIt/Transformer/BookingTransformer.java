package com.example.RideIt.Transformer;

import com.example.RideIt.DTO.Request.TripBookingRequest;
import com.example.RideIt.DTO.Response.TripBookingResponse;
import com.example.RideIt.Enum.TripStatus;
import com.example.RideIt.Model.TripBooking;

import javax.print.attribute.standard.DateTimeAtProcessing;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

public class BookingTransformer {
    public static TripBooking bookingRequestToBooking(TripBookingRequest tripBookingRequest){
        return TripBooking.builder()
                .source(tripBookingRequest.getSource())
                .destination(tripBookingRequest.getDestination())
                .tripStatus(TripStatus.IN_TRANSIT)
                .bookedAt(LocalDateTime.now())
                .tripDistanceInKm(tripBookingRequest.getTripDistanceInKm())
                .bookingId(String.valueOf(UUID.randomUUID()))

                .build();
    }
    public static TripBookingResponse tripBookingToTripBookingResponse(TripBooking tripBooking){
        return  TripBookingResponse.builder()
                .bookingId(tripBooking.getBookingId())
                .source(tripBooking.getSource())
                .destination(tripBooking.getDestination())
                .tripDistanceInKm(String.valueOf(tripBooking.getTripDistanceInKm()))
                .totalFare(tripBooking.getTotalFare())
                .tripStatus(tripBooking.getTripStatus())
                .bookedAt(tripBooking.getBookedAt())
                .customerResponse(CustomerTransformer.customerToCustomerResponse(tripBooking.getCustomer()))
                .driverResponse(DriverTransformer.driverToDriverResponse(tripBooking.getDriver()))


                .build();
    }
}
