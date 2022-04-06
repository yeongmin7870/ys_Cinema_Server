package com.example.demo.theater.customer;

// HTTp Status code
// 2xx -> OK
// 4xx -> client
// 5xx -> Server

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message){
        super(message);
    }

}
