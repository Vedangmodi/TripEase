package com.example.tripease.dto.response;

public class CabResponse {
    private String cabNumber;
    private String cabModel;
    private double perKmRate;
    private boolean available;

    private DriverResponse driver;

    public CabResponse(String cabNumber, String cabModel, double perKmRate, boolean available, DriverResponse driver) {
        this.cabNumber = cabNumber;
        this.cabModel = cabModel;
        this.perKmRate = perKmRate;
        this.available = available;
        this.driver = driver;
    }

    public CabResponse() {
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    public String getCabModel() {
        return cabModel;
    }

    public void setCabModel(String cabModel) {
        this.cabModel = cabModel;
    }

    public double getPerKmRate() {
        return perKmRate;
    }

    public void setPerKmRate(double perKmRate) {
        this.perKmRate = perKmRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public DriverResponse getDriver() {
        return driver;
    }

    public void setDriver(DriverResponse driver) {
        this.driver = driver;
    }
}
