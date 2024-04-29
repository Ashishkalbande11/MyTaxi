package com.example.RideIt.Transformer;

import com.example.RideIt.DTO.Request.CabRequest;
import com.example.RideIt.DTO.Response.CabResponse;
import com.example.RideIt.Model.Cab;

public class CabTransformer {
    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()

                .numberOfSeats(cabRequest.getNumberOfSeats())
                .carModel(cabRequest.getCarModel())
                .farePerKM(cabRequest.getFarePerKm())
                .cabNo(cabRequest.getCabNo())
                .carType(cabRequest.getCarType())
                .available(true)
                .build();
    }
    public static CabResponse cabToCabResponse(Cab cab){
        return CabResponse.builder()
                .cabNo(cab.getCabNo())
                .carModel(cab.getCarModel())
                .farePerKm(cab.getFarePerKM())
                .build();
    }
}
