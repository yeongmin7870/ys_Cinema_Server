package com.example.demo.theater.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Integer message){
        super("Could not find customer");
    }
}
