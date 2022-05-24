package com.example.demo.theater.moviereview;

import com.example.demo.logControll.LogController;
import com.example.demo.theater.customer.CustomerNotFoundException;
import com.example.demo.theater.movie.MovieNotFoundException;
import com.example.demo.theater.writedReview.WritedReview;
import com.example.demo.theater.writedReview.WritedReviewDaoService;
import com.example.demo.theater.writedReview.WritedReviewRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
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

    @Autowired
    private WritedReviewDaoService writedReviewDaoService;


    @GetMapping("/movieRetrieve/myReview")
    @ApiOperation(value = "내가 적은 리뷰보기",notes = "사용자 아이디를 Parameter로 받고 List object 타입인 jSON형태로 보내줍니다 따라서 VO를 이용해 값을 받아야합니다")
    public List<Object> retrieveMyReivew(@RequestParam  String cId){
        return service.retrieveMyReview(cId);
    }



    // 사용자가 영화 평점 입력 후 계산해서 현재 해당 영화 평점 출력
    @GetMapping("/movie/rating/{id}")
    @ApiOperation(value = "영화 평점 출력")
    public Integer ratingScore(@RequestParam Integer movieId) throws IOException {
        return service.ratingScore(movieId);
    }


    @GetMapping("/MovieReview")
    @ApiOperation(value = "영화 전체 리뷰 보여주기")
    public List<Object> retrieveAllMovieReview() {
        return service.findAll();
    }

    @GetMapping("/MovieReview/oneMovie")
    @ApiOperation(value = "해당 영화 리뷰만 보여주기")
    public List<MovieReview> retrieveMovieReview(@RequestParam Integer movieId) {
        List<MovieReview> movieReview = service.retrieveMovieReview(movieId);

        if (movieReview == null) {
            throw new MovieNotFoundException(String.format("ID [%s] Not Found", movieId));
        }

        return movieReview;
    }

    @PostMapping("/MovieReview")
    @ApiOperation(value = "영화 리뷰 작성 삽입")
    public String newReview(@RequestBody MovieReview newMovieReview, @RequestParam String id) {

        Integer result = service.searchMovieReivew(id,newMovieReview);


        if (result > 0) {
            return "fail";
        } else {
            Date today = new Date();
            newMovieReview.setMrUptime(today);  // 서버 시간
            MovieReview movieReview = service.save(newMovieReview);
            WritedReview a = writedReviewDaoService.save(id, movieReview);
            System.out.println("확인" + a);
        }
        return "finish";
    }

    @PutMapping("/MovieReview")
    @ApiOperation(value = "영화 리뷰 수정")
    public MovieReview replaceMovieReview(@RequestBody MovieReview newMovieReview, Integer movieReviewId) {
        MovieReview updateMovieReview = service.updateMovieReview(newMovieReview, movieReviewId);


        if (updateMovieReview == null) {
            throw new CustomerNotFoundException(String.format("ID [%s] Not Found", movieReviewId));
        }

        return updateMovieReview;
    }

    @DeleteMapping("/MovieReview}")
    @ApiOperation(value = "리뷰 삭제하기")
    public void deleteMovieReview(@RequestParam Integer mrNo) {
        service.deleteMovieReview(mrNo);
    }
}
