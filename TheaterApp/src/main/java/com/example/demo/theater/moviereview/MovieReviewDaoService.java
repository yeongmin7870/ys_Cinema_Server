package com.example.demo.theater.moviereview;

import com.example.demo.theater.customer.Customer;
import com.example.demo.theater.movie.Movie;
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


    // 영화 평점 계산
    public Integer ratingScore(Integer mno) {
        MovieReview movieReview = movieReviewRepository.findByMno(mno);

        return movieReviewRepository.sumRating(mno);
    }


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

    public MovieReview updateMovieReview (MovieReview newMovieReview) {
        MovieReview movieReview = movieReviewRepository.findByMovieReviewId(newMovieReview.getMovieReviewId());


        if (movieReview == null) {
            return null;
        }

        movieReview.setC_Id(newMovieReview.getC_Id());
        movieReview.setMr_Content(newMovieReview.getMr_Content());
        movieReview.setMr_ReviewStarScore(newMovieReview.getMr_ReviewStarScore());

        MovieReview updateMovieReview = movieReviewRepository.save(movieReview);

        return updateMovieReview;
    }

    public void deleteMovieReview (Integer id) {
        movieReviewRepository.deleteById(id);
    }
}
