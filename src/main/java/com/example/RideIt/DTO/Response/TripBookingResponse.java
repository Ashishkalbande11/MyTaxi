package com.example.RideIt.DTO.Response;

import com.example.RideIt.Enum.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBookingResponse {
    String bookingId;

    String source;

    String destination;

    String tripDistanceInKm;

    double totalFare;

    TripStatus tripStatus;

    LocalDateTime bookedAt;

    CustomerResponse customerResponse;

    DriverResponse driverResponse;

    String message;

}
