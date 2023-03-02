package com.niit.bej.c2s4TestingRepositorylayer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE,reason = "Customer Data already present")
public class CustomerAlreadyExistException extends Exception {
}
