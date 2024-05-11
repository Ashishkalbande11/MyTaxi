package com.example.RideIt.Repository;

import com.example.RideIt.Enum.Gender;
import com.example.RideIt.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   // @Query(value = "select * from customer where gender = :gender and age >=: age", nativeQuery = true) //..SQL Query

    @Query(value = "select c from Customer c where c.gender = :gender and c.age >= :age")
    List<Customer> getByGenderAndAgeGreaterThan(Gender gender, int age);

   // @Query(value = "select c from Customer c where c.email =: emailId")
    Customer findByEmailId(String emailId);



   // List<Customer> findByCustomerId(int customerId);
}
