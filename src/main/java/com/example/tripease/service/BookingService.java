package com.example.tripease.service;

import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.exception.BookingNotFoundException;
import com.example.tripease.exception.CabNotFoundException;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.BookingRepository;
import com.example.tripease.repository.CabRepository;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transformer.BookingTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer Not Found!!!");
        }

        Customer customer = optionalCustomer.get();

        Cab availableCab = cabRepository.getAvailableCabRandomly();
        if(availableCab == null){
            throw new CabNotFoundException("Sorry Cab Not Found!");
        }

        Booking booking = BookingTransformers.bookingRequestToBooking(bookingRequest, availableCab.getPerKmRate());
        Booking savedBooking = bookingRepository.save(booking);

        availableCab.setAvailable(false);
//      customer.getBookings().add(booking);
        customer.getBookings().add(savedBooking);

        Driver driver = driverRepository.getDriverById(availableCab.getCabId());
//      driver.getBookings().add(booking);
        driver.getBookings().add(savedBooking);

        Customer savedCustomer = customerRepository.save(customer);
        Driver savedDriver = driverRepository.save(driver);

        sendEmail(savedCustomer, savedDriver);


        return BookingTransformers.BookingToBookingResponse(savedBooking,savedCustomer,availableCab, savedDriver);

    }

    public BookingResponse deleteBooking(int BookingId) {
//        Optional<Customer> optionalCustomer =  customerRepository.findById(customerId);
//        if(optionalCustomer.isEmpty()){
//            throw new CustomerNotFoundException("Customer does not exist with this specific id!");
//        }

//        Customer customer  = optionalCustomer.get();

        Optional<Booking> optionalBooking = bookingRepository.findById(BookingId);

        if(optionalBooking.isEmpty()){
            throw new BookingNotFoundException("No booking found!");
        }

        Booking booking = optionalBooking.get();

        Customer customer = booking.getCustomer();
        Cab cab = booking.getCab();
        Driver driver = driverRepository.findByCab(cab);

        cab.setAvailable(true);
        cabRepository.save(cab);

        bookingRepository.delete(booking);

        return BookingTransformers.BookingToBookingResponse(booking, customer, cab, driver);

    }





    private void sendEmail(Customer customer, Driver driver){

        String text = "Congrats!" + customer.getName() + " Your Cab has been booked successfully!" + " Your driver name is - "
                + driver.getName() + ", email -" + driver.getEmailId();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("vedangmodios@gmail.com");
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setSubject("congratulations! your cab has been booked!");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);

    }


}
