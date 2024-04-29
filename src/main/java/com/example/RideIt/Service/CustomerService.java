package com.example.RideIt.Service;

import com.example.RideIt.DTO.Request.CustomerRequest;
import com.example.RideIt.DTO.Response.CustomerResponse;
import com.example.RideIt.Enum.Gender;
import com.example.RideIt.Model.Customer;
import com.example.RideIt.Repository.CustomerRepository;
import com.example.RideIt.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerService {
//    @Autowired
//    CustomerRepository customerRepository;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
       // return "customer saved successfully";
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getCustomerByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customerList = customerRepository.getByGenderAndAgeGreaterThan(gender,age);
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        for(Customer customer : customerList){
            customerResponseList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponseList;
    }
}
