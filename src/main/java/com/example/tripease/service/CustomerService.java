package com.example.tripease.service;

import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.transformer.CustomerTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

//        RequestDTO -> Entity
        Customer customer = CustomerTransformers.customerRequestToCustomer(customerRequest);
        
//        save the entity to db
        Customer savedCustomer =  customerRepository.save(customer);

//        saved entity -> ResponseDTO
        return CustomerTransformers.customerToCustomerResponse(customer);

    }

    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if(optionalCustomer.isEmpty()){
           throw new CustomerNotFoundException("Invalid ID");
       }

        Customer savedCustomer =  optionalCustomer.get();

        return CustomerTransformers.customerToCustomerResponse(savedCustomer);

    }

    public List<CustomerResponse> getAllByGender(Gender gender) {
        List<Customer> customers = customerRepository.findByGender(gender);

        List<CustomerResponse> customerResponses = new ArrayList<>();

        for(Customer customer : customers){
            customerResponses.add(CustomerTransformers.customerToCustomerResponse(customer));
        }

        return customerResponses;

    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers = customerRepository.findByGenderAndAge(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();

        for(Customer customer : customers){
            customerResponses.add(CustomerTransformers.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }

//    public List<CustomerResponse> findByGenderAndAgeGreaterThan(Gender gender, int age) {
//
//        List<Customer> customers = customerRepository.findByGenderAndAgeGreaterThan(gender, age);
//
//        List<CustomerResponse> customerResponses = new ArrayList<>();
//
//        for(Customer customer : customers){
//            customerResponses.add(CustomerTransformers.customerToCustomerResponse(customer));
//        }
//
//        return customerResponses;
//    }

    public List<CustomerResponse> findByGenderAndAgeGreaterThan(String gender, int age) {

        List<Customer> customers = customerRepository.findByGenderAndAgeGreaterThan(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();

        for(Customer customer : customers){
            customerResponses.add(CustomerTransformers.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }
}
