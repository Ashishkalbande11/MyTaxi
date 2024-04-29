package com.example.RideIt.Model;

import com.example.RideIt.Enum.TripStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBooking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;

        String source;

        String destination;

        String bookingId;//UUID

        double tripDistanceInKm;

        double totalFare;

        TripStatus tripStatus;

        @CreationTimestamp
        Date bookedAt;

        @ManyToOne
        @JoinColumn
        @JsonIgnore
        Driver driver;

        @ManyToOne
        @JoinColumn
        @JsonIgnore
        Customer customer;
}
