package com.example.tripease.repository;

import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query(value = "select * from driver_info where cab_id = :cabId ", nativeQuery = true )
    Driver getDriverById(@Param("cabId") int cabId);

    Driver findByCab(Cab cab);
}
