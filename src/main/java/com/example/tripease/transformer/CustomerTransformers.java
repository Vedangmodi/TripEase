package com.example.tripease.transformer;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;

public class CustomerTransformers {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setEmailId(customerRequest.getEmailId());
        customer.setGender(customerRequest.getGender());

//        return Customer.builder()
//                .name(customerRequest.getName())
//                .age(customerRequest.getAge())
//                .emailId(customerRequest.getEmailId())
//                .gender(customerRequest.getGender())
//                .build();

//        issue - Lombok’s @Builder only works if the class is recognized and compiled properly with Lombok.

        return customer;

    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setName(customer.getName());
        customerResponse.setAge(customer.getAge());
        customerResponse.setEmailId(customer.getEmailId());

        return customerResponse;


    }
}
