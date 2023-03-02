package com.niit.bej.c2s4TestingRepositorylayer.service;

import com.niit.bej.c2s4TestingRepositorylayer.domain.Customer;
import com.niit.bej.c2s4TestingRepositorylayer.exception.CustomerAlreadyExistException;
import com.niit.bej.c2s4TestingRepositorylayer.exception.CustomerNotFoundException;
import com.niit.bej.c2s4TestingRepositorylayer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException {
        if (customerRepository.findById(customer.getCustomerId()).isPresent())
            throw new CustomerAlreadyExistException();
        else return customerRepository.save(customer);


    }

    @Override
    public List<Customer> getCustomer() throws ClassNotFoundException {
        List<Customer> getCustomer = customerRepository.findAll();
        if (getCustomer.isEmpty()) throw new ClassNotFoundException();
        else return getCustomer;
    }

    @Override
    public boolean deleteById(Integer id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Customer> getByProductName(String productName) throws CustomerNotFoundException {
        List<Customer> customerList = customerRepository.findByProductName(productName);
        if (customerList.isEmpty()) throw new CustomerNotFoundException();
        else return customerList;
    }
}
