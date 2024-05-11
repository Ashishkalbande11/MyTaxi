package com.example.RideIt.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class TripBookingRequest {
    String source;

    String destination;

    double tripDistanceInKm;

    String customerEmailId;



}
