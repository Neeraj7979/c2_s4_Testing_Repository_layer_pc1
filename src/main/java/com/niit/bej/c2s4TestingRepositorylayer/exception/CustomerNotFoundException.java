package com.niit.bej.c2s4TestingRepositorylayer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Customer Details Not found")
public class CustomerNotFoundException extends Exception {
}
