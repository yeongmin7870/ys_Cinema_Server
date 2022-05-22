package com.example.demo.theater.moviereview;

import com.example.demo.logControll.LogController;
import com.example.demo.theater.customer.CustomerNotFoundException;
import com.example.demo.theater.movie.MovieNotFoundException;
import com.example.demo.theater.writedReview.WritedReview;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/theater")
@CrossOrigin
public class MovieReviewController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String methodName;

    private LogController logController;

    @Autowired
    private MovieReviewDaoService service;




    // 사용자가 영화 평점 입력 후 계산해서 현재 해당 영화 평점 출력
    @GetMapping("/movie/rating/{id}")
    @ApiOperation(value = "영화 평점 출력")
    public Integer ratingScore(Integer movieId) throws IOException {
        return service.ratingScore(movieId);
    }


    @GetMapping("/MovieReview")
    @ApiOperation(value = "영화 전체 리뷰 보여주기")
    public List<MovieReview> retrieveAllMovieReview() {
        return service.findAll();
    }

    @GetMapping("/MovieReview/{movieId}")
    @ApiOperation(value = "해당 영화 리뷰만 보여주기")
    public List<MovieReview> retrieveMovieReview(@PathVariable Integer movieId) {
        List<MovieReview> movieReview = service.retrieveMovieReview(movieId);

        if (movieReview == null) {
            throw new MovieNotFoundException(String.format("ID [%s] Not Found", movieId));
        }

        return movieReview;
    }

    @PostMapping("/MovieReview")
    @ApiOperation(value = "영화 리뷰 작성 삽입")
    public String newReview(@RequestBody MovieReview newMovieReview, @RequestParam String id) {

        // 해당 영화 리뷰 작성을 했니? : true  작성을 안했다면 : false
        boolean result = service.searchMovieReivew(id);

        if (result == true) {
            return "리뷰를 이미 작성했습니다";
        } else {

            WritedReview writedReview = service.insertWR(newMovieReview,id);

            Date today = new Date();

            newMovieReview.setMrUptime(today);
            service.save(newMovieReview);
        }
        return "finish";
    }

    @PutMapping("/MovieReview")
    @ApiOperation(value = "영화 리뷰 수정")
    public MovieReview replaceMovieReview(@RequestBody MovieReview newMovieReview, String id) {
        MovieReview updateMovieReview = service.updateMovieReview(newMovieReview, id);


        if (updateMovieReview == null) {
            throw new CustomerNotFoundException(String.format("ID [%s] Not Found", newMovieReview.getMovieReviewId()));
        }

        return updateMovieReview;
    }

    @DeleteMapping("/MovieReview/{id}")
    @ApiOperation(value = "리뷰 삭제하기")
    public void deleteMovieReview(@PathVariable Integer id) {
        service.deleteMovieReview(id);
    }
}
