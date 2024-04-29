package com.example.RideIt.Repository;

import com.example.RideIt.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Driver findByMobNo(String mobNo);
}
