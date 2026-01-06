package com.example.tripease.dto.request;

import com.example.tripease.Enum.TripStatus;

public class BookingRequest {
    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    TripStatus tripStatus;

    private double billAmount;

    public BookingRequest() {
    }

    public BookingRequest(String pickup, String destination, double tripDistanceInKm) {
        this.pickup = pickup;
        this.destination = destination;
        this.tripDistanceInKm = tripDistanceInKm;
//        TripStatus tripStatus;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTripDistanceInKm() {
        return tripDistanceInKm;
    }

    public void setTripDistanceInKm(double tripDistanceInKm) {
        this.tripDistanceInKm = tripDistanceInKm;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
}
