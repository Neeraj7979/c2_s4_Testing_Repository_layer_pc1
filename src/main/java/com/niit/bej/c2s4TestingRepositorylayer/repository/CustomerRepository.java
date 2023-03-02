package com.niit.bej.c2s4TestingRepositorylayer.repository;

import com.niit.bej.c2s4TestingRepositorylayer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {
}
