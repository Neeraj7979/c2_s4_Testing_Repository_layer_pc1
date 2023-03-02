package com.niit.bej.c2s4TestingRepositorylayer.repository;

import com.niit.bej.c2s4TestingRepositorylayer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {
    @Query("{'customerProduct.productName':?0}")
    List<Customer>findByProductName(String productName);
}
