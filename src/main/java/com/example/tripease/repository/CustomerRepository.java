package com.example.tripease.repository;

import com.example.tripease.Enum.Gender;
import com.example.tripease.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    List<Customer> findByGender(Gender gender);

    List<Customer> findByGenderAndAge(Gender gender, int age);

//    @Query("select c from Customer c where c.gender = :gender and c.age > :age ") // HQL query
//    List<Customer> findByGenderAndAgeGreaterThan(@Param("gender") Gender gender,
//                                                   @Param("age") int age);

    @Query(value = "select * from customer c where gender = :gender and age > :age ", nativeQuery = true) // SQL query
    List<Customer> findByGenderAndAgeGreaterThan(@Param("gender") String gender,
                                                 @Param("age") int age);
}
