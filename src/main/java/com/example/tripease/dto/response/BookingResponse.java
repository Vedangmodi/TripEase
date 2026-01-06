package com.example.tripease.dto.response;

import com.example.tripease.Enum.TripStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

public class BookingResponse {
    private int bookingId;

    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    TripStatus tripStatus;


    private double billAmount;

    Date bookedAt;
    Date lastUpdateAt;

    CustomerResponse customer;
    CabResponse cab;

    public BookingResponse(int bookingId, String pickup, String destination, double tripDistanceInKm, double billAmount, Date bookedAt, Date lastUpdateAt, CustomerResponse customer, CabResponse cab) {
        this.bookingId = bookingId;
        this.pickup = pickup;
        this.destination = destination;
        this.tripDistanceInKm = tripDistanceInKm;
        this.billAmount = billAmount;
        this.bookedAt = bookedAt;
        this.lastUpdateAt = lastUpdateAt;
        this.customer = customer;
        this.cab = cab;
    }

    public BookingResponse() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public Date getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(Date lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }

    public CabResponse getCab() {
        return cab;
    }

    public void setCab(CabResponse cab) {
        this.cab = cab;
    }
}
