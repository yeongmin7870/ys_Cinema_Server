package com.example.demo.theater.moviereview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieReviewDaoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieReviewRepository movieReviewRepository;

    public List<MovieReview> findAll() {
        return movieReviewRepository.findAll();
    }

    public MovieReview findById(Integer movieReviewId) {
        MovieReview movieReview = movieReviewRepository.findByMovieReviewId(movieReviewId);
        return movieReview;
    }

    public MovieReview save(MovieReview movieReview){
        movieReviewRepository.save(movieReview);
        return movieReview;
    }


}
