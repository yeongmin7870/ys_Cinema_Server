package com.example.demo.theater.movieSchedule;


import com.example.demo.logControll.LogController;
import com.example.demo.theater.movie.Movie;
import com.example.demo.theater.movie.MovieNotFoundException;
import com.example.demo.theater.writedReview.WritedReviewDaoService;
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
            /*SimpleDateFormat formatter = new SimpleDateFormat("mm-ss");
            List<Movie> mHour = movieScheduleDaoService.movieHour(newMovieSchedule);

            newMovieSchedule.setMS_EndTime();*/
            movieScheduleDaoService.save(newMovieSchedule);
            String m_Hour = movieScheduleDaoService.movieHour(newMovieSchedule);

            movieScheduleDaoService.updateEndTime(Integer.parseInt(m_Hour), newMovieSchedule);
        }

        return "finish";
    }

}
