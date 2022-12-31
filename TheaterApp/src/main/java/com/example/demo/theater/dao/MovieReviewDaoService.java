package com.example.demo.theater.dao;

import com.example.demo.theater.vo.Customer;
import com.example.demo.theater.repository.MovieReviewRepository;
import com.example.demo.theater.repository.WritedReviewRepository;
import com.example.demo.theater.vo.MovieReview;
import com.example.demo.theater.vo.WritedReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

    // 내가 적은 리뷰 조인해서 찾기

    public List<Object> retrieveMyReview(String cId) {
        return movieReviewRepository.retrieveMyReview(cId);
    }

    // 누가 어떤 영화에 리뷰를 작성했는지 판단여부
    public Integer searchMovieReivew(String cId, MovieReview newMovieReviw) {

        Integer result = movieReviewRepository.oneReview(cId, newMovieReviw.getMovieId());
        logger.info(result.toString());
        return result;
    }

    // 영화아이디로 리뷰 찾기
    public List<MovieReview> retrieveMovieReview(Integer movieId) {
        List<MovieReview> movieReview = movieReviewRepository.retrieveFindOne(movieId);
        List<WritedReview> movieWrited = movieReviewRepository.retrieveFindOne2(movieId);
        List<Customer> moviCust = movieReviewRepository.retrieveFindOne3(movieId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd.a.HH:mm:ss1");

        for (int i = 0; i < movieReview.size(); i++) {
            movieReview.get(i).setCId(movieWrited.get(i).getCId());
            movieReview.get(i).setRcNo(movieWrited.get(i).getRcNo());
            movieReview.get(i).setC_Nikname(moviCust.get(i).getC_Nikname());
            movieReview.get(i).setImageUri(
                    "http://caramels.kro.kr:9632/theater/customer/image/display?id=" + movieWrited.get(i).getCId());
        }
        // customer 프로필 가져오기

        return movieReview;
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

    public void deleteMovieReview(Integer mrno) {

        writedReviewRepository.removeMrNo(mrno);
        movieReviewRepository.deleteById(mrno);

    }
}
