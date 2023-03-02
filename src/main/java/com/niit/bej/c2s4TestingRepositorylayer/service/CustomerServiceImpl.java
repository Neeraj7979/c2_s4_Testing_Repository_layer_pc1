package com.niit.bej.c2s4TestingRepositorylayer.service;

import com.niit.bej.c2s4TestingRepositorylayer.domain.Customer;
import com.niit.bej.c2s4TestingRepositorylayer.exception.CustomerAlreadyExistException;
import com.niit.bej.c2s4TestingRepositorylayer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException {
        if (customerRepository.findById(customer.getCustomerId()).isPresent())
            throw new CustomerAlreadyExistException();
        else
            return customerRepository.save(customer);


    }

    @Override
    public List<Customer> getCustomer() {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public List<Customer> findByProductName(String productName) {
        return null;
    }
}
