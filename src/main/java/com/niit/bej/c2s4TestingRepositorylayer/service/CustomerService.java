package com.niit.bej.c2s4TestingRepositorylayer.service;

import com.niit.bej.c2s4TestingRepositorylayer.domain.Customer;
import com.niit.bej.c2s4TestingRepositorylayer.exception.CustomerAlreadyExistException;
import com.niit.bej.c2s4TestingRepositorylayer.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer) throws CustomerAlreadyExistException;

    List<Customer> getCustomer() throws CustomerNotFoundException, ClassNotFoundException;

    boolean deleteById(Integer id) throws CustomerNotFoundException;

    List<Customer> getByProductName(String productName) throws CustomerNotFoundException;
}
