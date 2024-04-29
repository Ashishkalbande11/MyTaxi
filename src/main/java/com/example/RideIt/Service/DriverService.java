package com.example.RideIt.Service;

import com.example.RideIt.DTO.Request.DriverRequest;
import com.example.RideIt.Model.Cab;
import com.example.RideIt.Model.Driver;
import com.example.RideIt.Repository.DriverRepository;
import com.example.RideIt.Transformer.CabTransformer;
import com.example.RideIt.Transformer.DriverTransformer;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public String addDriver(DriverRequest driverRequest) {
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);

        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCab());

        driver.setCab(cab);
        cab.setDriver(driver);

        driverRepository.save(driver);
        return "Driver ans cab saved successfully";
    }
    public Driver getDriver(String mobNo){
        return driverRepository.findByMobNo(mobNo);
    }
}
