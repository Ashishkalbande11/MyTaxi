package com.example.RideIt.Transformer;

import com.example.RideIt.DTO.Request.DriverRequest;
import com.example.RideIt.DTO.Response.DriverResponse;
import com.example.RideIt.Model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .mobNo(driverRequest.getMobNo())
                .panNo(driverRequest.getPanNo())
                .age(driverRequest.getAge())
                .rating(0)
                .build();
    }
    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .mobNo(driver.getMobNo())
                .rating(driver.getRating())
                .cabResponse(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
