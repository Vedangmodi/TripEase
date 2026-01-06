package com.example.tripease.transformer;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Driver;

public class DriverTransformers {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        Driver driver = new Driver();
        driver.setName(driverRequest.getName());
        driver.setAge(driverRequest.getAge());
        driver.setEmailId(driverRequest.getEmailId());

        return driver;
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        DriverResponse driverResponse = new DriverResponse();

        driverResponse.setDriverId(driver.getDriverId());
        driverResponse.setName(driver.getName());
        driverResponse.setAge(driver.getAge());
        driverResponse.setEmailId((driver.getEmailId()));

        return driverResponse;

    }
}
