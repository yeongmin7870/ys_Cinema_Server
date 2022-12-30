package com.example.demo.theater.controller;


import com.example.demo.theater.dao.MovieScheduleDaoService;
import com.example.demo.theater.dao.WritedReviewDaoService;
import com.example.demo.theater.exception.MovieNotFoundException;
import com.example.demo.theater.exception.MovieScheduleNotFoundException;
import com.example.demo.theater.vo.Movie;
import com.example.demo.theater.vo.MovieSchedule;

import io.swagger.annotations.ApiOperation;
import oracle.sql.DATE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/theater")
@CrossOrigin
public class MovieScheduleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String methodName;

    private LogController logController;

    @Autowired
    private MovieScheduleDaoService movieScheduleDaoService;

    @Autowired
    private WritedReviewDaoService writedReviewDaoService;

    @GetMapping("/MovieSchedule")
    @ApiOperation(value = "상영시간표 전체 보기")
    public List<MovieSchedule> retrieveAll() {
        return movieScheduleDaoService.findAll();
    }

    @GetMapping("/MovieSchedule/{id}")
    @ApiOperation(value = "상영시간표 지정된 id로 개별 보기")
    public MovieSchedule retrieveOne(@PathVariable Integer movieScheduleId) {
        MovieSchedule movieSchedule = movieScheduleDaoService.findById(movieScheduleId);

        if (movieSchedule == null) {
            throw new MovieScheduleNotFoundException(String.format("ID [%s] Not Found", movieScheduleId));
        }

        return movieSchedule;
    }

    @PostMapping("/MovieSchedule")
    @ApiOperation(value = "상영 시간 등록")
    public String newSchedule(@RequestBody MovieSchedule newMovieSchedule){

        boolean result = movieScheduleDaoService.scheduleProcess(newMovieSchedule);

        if(result == false) {
            return "영화, 상영관, 상영기간 중 하나가 없거나 지난기간입니다.";
        }else {
            Integer m_Hour = movieScheduleDaoService.movieHour(newMovieSchedule);
            movieScheduleDaoService.insertSchedule(m_Hour, newMovieSchedule);
        }
        return "finish";
    }

    @DeleteMapping("/MovieSchedule/{id}")
    @ApiOperation(value = "영화 상영시간 삭제")
    public void deleteSchedule(@PathVariable Integer movieScheduleId) {
        movieScheduleDaoService.deleteSchedule(movieScheduleId);
    }

    @PutMapping("/MovieSchedule")
    @ApiOperation(value = "영화 상영시간 수정")
    public String replaceSchedule(@RequestBody MovieSchedule newMovieSchedule,
                                         @RequestParam Integer movieScheduleId) {

        boolean result = movieScheduleDaoService.scheduleProcess(newMovieSchedule);

        if(result == false) {
            return "업데이트 불가.";
        }else {
            Integer m_Hour = movieScheduleDaoService.movieHour(newMovieSchedule);
            Integer ms_no = newMovieSchedule.getMovieScheduleId();
            movieScheduleDaoService.updateMovieSchedule(m_Hour, newMovieSchedule, ms_no);
        }
        return "finish";
    }

}
