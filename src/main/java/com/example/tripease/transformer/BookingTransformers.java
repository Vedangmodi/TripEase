package com.example.tripease.transformer;

import com.example.tripease.Enum.TripStatus;
import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;

public class BookingTransformers {
    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, double perKmRate){
        Booking booking = new Booking();
        booking.setPickup(bookingRequest.getPickup());
        booking.setDestination(bookingRequest.getDestination());
        booking.setTripDistanceInKm(bookingRequest.getTripDistanceInKm());
        booking.setTripStatus(TripStatus.IN_PROGRESS);
        booking.setBillAmount(bookingRequest.getTripDistanceInKm() * perKmRate);

        return booking;
    }

    public static BookingResponse BookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        BookingResponse bookingResponse = new BookingResponse();

        bookingResponse.setPickup(booking.getPickup());
        bookingResponse.setDestination(booking.getDestination());
        bookingResponse.setTripDistanceInKm(booking.getTripDistanceInKm());
        bookingResponse.setTripStatus(booking.getTripStatus());
        bookingResponse.setBillAmount(booking.getBillAmount());
        bookingResponse.setBookedAt(booking.getBookedAt());
        bookingResponse.setLastUpdateAt(booking.getLastUpdateAt());

        bookingResponse.setCustomer(CustomerTransformers.customerToCustomerResponse(customer));
        bookingResponse.setCab(CabTransformers.cabToCabResponse(cab, driver));

        return bookingResponse;
    }

}
