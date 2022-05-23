package com.example.demo.theater.moviereview;

import com.example.demo.theater.writedReview.WritedReview;
import com.example.demo.theater.writedReview.WritedReviewDaoService;
import com.example.demo.theater.writedReview.WritedReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Service
public class MovieReviewDaoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieReviewRepository movieReviewRepository;

    @Autowired
    private WritedReviewDaoService reviewDaoService;

    @Autowired
    private WritedReviewRepository writedReviewRepository;

    //내가 적은 리뷰 조인해서 찾기

    public List<Object> retrieveMyReview(String cId){
        return movieReviewRepository.retrieveMyReview(cId);
    }


    // 누가 어떤 영화에 리뷰를 작성했는지 판단여부
    public boolean searchMovieReivew(String cId,MovieReview movieReview) {

        try {
            Integer mrNo = movieReview.getMovieId();
            WritedReview result = movieReviewRepository.oneReview(cId,mrNo);
            if (result != null) {
                return true;
            } else {
                return false;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //영화아이디로 리뷰 찾기
    public List<Object> retrieveMovieReview(Integer movieId) {
        List<Object> movieReviews = movieReviewRepository.retrieveFindOne(movieId);
        return movieReviews;
    }


    // 영화 평점 출트
    public Integer ratingScore(Integer movieId) throws IOException {

        List<MovieReview> movieReview = movieReviewRepository.findByMovieId(movieId);

        Integer count = movieReview.size();
        Integer sum = movieReviewRepository.sumRating(movieId);

        return sum / count;
    }


    public List<Object> findAll() {
        return movieReviewRepository.retrieveFindAll();
    }

    public MovieReview findById(Integer movieReviewId) {
        MovieReview movieReview = movieReviewRepository.findByMovieReviewId(movieReviewId);
        return movieReview;
    }

    public MovieReview save(MovieReview movieReview) {
        return movieReviewRepository.save(movieReview);
    }

    public MovieReview updateMovieReview(MovieReview newMovieReview, Integer movieReviewId) {


        MovieReview movieReview = movieReviewRepository.retrieveReview(movieReviewId);


        Date today = new Date();
        if (movieReview == null) {
            return null;
        }
        movieReview.setMrContent(newMovieReview.getMrContent());
        movieReview.setMrUptime(today);
        movieReview.setMrReviewStarScore(newMovieReview.getMrReviewStarScore());
        movieReview.setMrThumbs(newMovieReview.getMrThumbs());
        movieReview.setMrNotgood(newMovieReview.getMrNotgood());


        MovieReview updateMovieReview = movieReviewRepository.save(movieReview);

        return updateMovieReview;
    }

    public void deleteMovieReview(Integer mrNo) {

        writedReviewRepository.removeMrNo(mrNo);
        movieReviewRepository.deleteById(mrNo);

    }
}
