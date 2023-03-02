package com.niit.bej.c2s4TestingRepositorylayer.controller;

import com.niit.bej.c2s4TestingRepositorylayer.domain.Customer;
import com.niit.bej.c2s4TestingRepositorylayer.exception.CustomerAlreadyExistException;
import com.niit.bej.c2s4TestingRepositorylayer.exception.CustomerNotFoundException;
import com.niit.bej.c2s4TestingRepositorylayer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/addcustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistException {
        try {
            Customer addCustomer=customerService.addCustomer(customer);
            return new ResponseEntity<>(addCustomer, HttpStatus.CREATED);
        }
        catch (CustomerAlreadyExistException exception){
            throw new CustomerAlreadyExistException();
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @GetMapping("/getcustomer")
    public ResponseEntity<?> getCustomer() throws CustomerNotFoundException {
        try {
            List<Customer> customerList=customerService.getCustomer();
            return new ResponseEntity<>(customerList,HttpStatus.ACCEPTED);
        }
        catch (CustomerNotFoundException exception){
            throw new CustomerNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/deletecustomer")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Integer id) throws CustomerNotFoundException {
        try {
            boolean status=customerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (CustomerNotFoundException exception){
            throw new CustomerNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/customerbyproductname/{productname}")
    public ResponseEntity<?> findByProductName(@PathVariable String productName) throws CustomerNotFoundException {
        try {
            List<Customer> customerList=customerService.getByProductName(productName);
            return new ResponseEntity<>(customerList,HttpStatus.ACCEPTED);
        }
        catch (CustomerNotFoundException exception){
            throw new CustomerNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
