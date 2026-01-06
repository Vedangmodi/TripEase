package com.example.tripease.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name="driver_info")  // it is used to use the perticular name ,if  the table already exists then jps creates a new table.
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;

    @Column(name="driver_name")
    private String name;
    private int age;

    @Column(unique = true, nullable = false)
    private String emailId;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="driver_id")
    List<Booking> bookings = new ArrayList<>();

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cab_id")
    Cab cab;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }
}
