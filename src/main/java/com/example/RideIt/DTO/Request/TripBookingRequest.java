package com.example.RideIt.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
