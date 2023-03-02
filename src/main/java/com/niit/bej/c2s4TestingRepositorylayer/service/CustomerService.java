package com.niit.bej.c2s4TestingRepositorylayer.service;

import com.niit.bej.c2s4TestingRepositorylayer.domain.Customer;

import java.util.List;

public interface CustomerService {
   Customer addCustomer(Customer customer);
   List<Customer> getCustomer();
   boolean deleteById(Integer id);
   List<Customer> findByProductName(String productName);
}
