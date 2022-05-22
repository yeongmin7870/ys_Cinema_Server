package com.example.demo.theater.moviereview;

import com.example.demo.theater.customer.Customer;
import com.example.demo.theater.movie.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;


@Service
public class MovieReviewDaoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieReviewRepository movieReviewRepository;

    // 누가 어떤 영화에 리뷰를 작성했는지 판단여부
    public boolean searchMovieReivew(String cId, Integer movieId){
        MovieReview result = movieReviewRepository.oneReview(cId,movieId);
        if(result != null){
            return true;
        }
        else{
            return false;
        }
    }

    //영화아이디로 리뷰 찾기
    public List<MovieReview> retrieveMovieReview(Integer movieId) {
        List<MovieReview> movieReviews = movieReviewRepository.findByMovieId(movieId);

        return movieReviews;
    }


    // 영화 평점 출트
    public Integer ratingScore(Integer movieId) throws IOException {

        List<MovieReview> movieReview = movieReviewRepository.findByMovieId(movieId);

        Integer count = movieReview.size();
        Integer sum = movieReviewRepository.sumRating(movieId);

        return sum/count;
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
        MovieReview movieReview = movieReviewRepository.oneReview(newMovieReview.getCId(), newMovieReview.getMovieId());

        Date today = new Date();
        if (movieReview == null) {
            return null;
        }
        movieReview.setMr_Content(newMovieReview.getMr_Content());
        movieReview.setMr_Uptime(today);
        movieReview.setMr_ReviewStarScore(newMovieReview.getMr_ReviewStarScore());
        movieReview.setMr_Thumbs(newMovieReview.getMr_Thumbs());
        movieReview.setMr_Notgood(newMovieReview.getMr_Thumbs());


        MovieReview updateMovieReview = movieReviewRepository.save(movieReview);

        return updateMovieReview;
    }

    public void deleteMovieReview (Integer id) {
        movieReviewRepository.deleteById(id);
    }
}
