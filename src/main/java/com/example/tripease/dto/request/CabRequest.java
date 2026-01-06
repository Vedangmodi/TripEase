package com.example.tripease.dto.request;

public class CabRequest {
    private String cabNumber;
    private String cabModel;
    private double perKmRate;

    public CabRequest(String cabNumber, String cabModel, double perKmRate) {
        this.cabNumber = cabNumber;
        this.cabModel = cabModel;
        this.perKmRate = perKmRate;
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

    public CabRequest() {
    }
}
