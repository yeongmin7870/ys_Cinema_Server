package com.example.demo.theater.movieSchedule;

import com.example.demo.theater.moviereview.MovieReviewNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieScheduleNotFoundException extends RuntimeException{
    public MovieScheduleNotFoundException(String message) {super(message);}
}
