package com.example.tripease.transformer;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;

public class CabTransformers {
    public static Cab cabRequestToCab(CabRequest cabRequest){
        Cab cab = new Cab();
        cab.setCabNumber(cabRequest.getCabNumber());
        cab.setCabModel(cabRequest.getCabModel());
        cab.setPerKmRate(cabRequest.getPerKmRate());
        cab.setAvailable(true);

        return cab;
    }

    public static CabResponse cabToCabResponse(Cab cab, Driver driver){
        CabResponse cabResponse = new CabResponse();
        cabResponse.setCabNumber(cab.getCabNumber());
        cabResponse.setCabModel(cab.getCabModel());
        cabResponse.setPerKmRate(cab.getPerKmRate());
        cabResponse.setAvailable(cab.isAvailable());
        cabResponse.setDriver(DriverTransformers.driverToDriverResponse(driver));
        return cabResponse;

    }
}
