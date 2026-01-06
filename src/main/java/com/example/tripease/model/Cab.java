package com.example.tripease.model;

import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.*;

@Entity
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;
    private String cabNumber;
    private String cabModel;
    private double perKmRate;
//    private TripStatus tripStatus;
    private boolean available;


    public Cab() {
    }

    public Cab(int cabId, String cabNumber, String cabModel, double perKmRate,  boolean available) {
        this.cabId = cabId;
        this.cabNumber = cabNumber;
        this.cabModel = cabModel;
        this.perKmRate = perKmRate;
//        this.tripStatus = tripStatus;
        this.available = available;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
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

//    public TripStatus getTripStatus() {
//        return tripStatus;
//    }
//
//    public void setTripStatus(TripStatus tripStatus) {
//        this.tripStatus = tripStatus;
//    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}
