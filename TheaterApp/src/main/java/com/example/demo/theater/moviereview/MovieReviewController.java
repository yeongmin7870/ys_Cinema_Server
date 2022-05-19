package com.example.demo.theater.moviereview;

import com.example.demo.logControll.LogController;
import com.example.demo.theater.customer.CustomerNotFoundException;
import com.example.demo.theater.movie.MovieNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
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
//    @GetMapping("/movie/rating/{id}")
//    @ApiOperation(value = "영화 평점 계산해서 보내주는 기능")
//    public float ratingScore(String id, Integer movieId){
//        return service.ratingScore(id, movieId);
//    }


    @GetMapping("/MovieReview")
    @ApiOperation(value = "영화 전체 리뷰 보여주기")
    public List<MovieReview> retrieveAllMovieReview() {
        return service.findAll();
    }

    @GetMapping("/MovieReview/{mrId}")
    @ApiOperation(value = "해당 영화 리뷰만 보여주기")
    public MovieReview retrieveMovieReview (@PathVariable Integer mrId){
        MovieReview movieReview = service.findById(mrId);

        if (movieReview==null) {
            throw new MovieNotFoundException(String.format("ID [%s] Not Found",mrId));
        }

        return movieReview;
    }

    @PostMapping("/MovieReview")
    @ApiOperation(value = "영화 리뷰 작성 삽입")
    public ResponseEntity<MovieReview> newReview(@RequestBody MovieReview newMovieReview){
        MovieReview insertMovieReview = service.findById(newMovieReview.getMovieReviewId());

        if (insertMovieReview == null) {

            insertMovieReview.setMr_Uptime(LocalDateTime.now());
            service.save(newMovieReview);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newMovieReview.getMovieReviewId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }else {
            throw new MovieNotFoundException(String.format("ID [%s] already exist",insertMovieReview.getMovieReviewId()));
        }
    }

    @PutMapping("/MovieReview/{id}")
    @ApiOperation(value = "영화 리뷰 수정")
    public MovieReview replaceMovieReview ( @RequestBody MovieReview newMovieReview,
                                            @PathVariable Integer id, String content, Integer reviewStarScore) {
        MovieReview updateMovieReview = service.updateMovieReview(newMovieReview, id, content, reviewStarScore);

        if(updateMovieReview == null) {
            throw new CustomerNotFoundException(String.format("ID [%s] Not Found", id));
        }

        return updateMovieReview;
    }

    @DeleteMapping("/MovieReview/{id}")
    @ApiOperation(value = "리뷰 삭제하기")
    public void deleteMovieReview(@PathVariable Integer id) {service.deleteMovieReview(id);}
}
