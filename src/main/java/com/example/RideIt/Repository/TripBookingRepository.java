package com.example.RideIt.Repository;

import com.example.RideIt.Model.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripBookingRepository extends JpaRepository<TripBooking,Integer> {
}
