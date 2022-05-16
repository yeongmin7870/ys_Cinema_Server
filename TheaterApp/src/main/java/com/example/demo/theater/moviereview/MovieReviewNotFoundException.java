package com.example.demo.theater.moviereview;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieReviewNotFoundException extends RuntimeException{
   public MovieReviewNotFoundException(String message) {super(message);}
}
