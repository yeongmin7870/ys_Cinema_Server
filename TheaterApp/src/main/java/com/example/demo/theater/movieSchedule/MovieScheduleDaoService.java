package com.example.demo.theater.movieSchedule;

import com.example.demo.theater.movie.Movie;
import com.example.demo.theater.movie.MovieRepository;
import com.example.demo.theater.storeaddress.StoreAddress;
import oracle.sql.DATE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.theater.storeaddress.StoreAddressRepository;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class MovieScheduleDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    movieScheduleRepository movieScheduleRepository;

    @Autowired
    StoreAddressRepository storeAddressRepository;

    @Autowired
    MovieRepository movieRepository;


    //모든 상영시간표
    public List<MovieSchedule> findAll() {
        return movieScheduleRepository.findAll();
    }

    //아이디 찾기
    public MovieSchedule findById(Integer id) {
        return movieScheduleRepository.findByMovieScheduleId(id);
    }


    //모든 데이터를 입력받아옴
    public MovieSchedule save(MovieSchedule newMovieSchedule) {
        return movieScheduleRepository.save(newMovieSchedule);
    }

    //현재 store와 movie에 해당 값이 있는지 없으면 false여야함
    public boolean scheduleProcess(MovieSchedule movieSchedule) {
        try {
            Date serverTime = new Date();
            Integer mNo = movieSchedule.getM_No();
            Integer storeId = movieSchedule.getStore_No();
            List<Object> result = movieScheduleRepository.DataCheck(storeId, mNo,serverTime);

            return  result != null ? true : false;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer movieHour(MovieSchedule movieSchedule) {
        Integer mNo = movieSchedule.getM_No();
        Integer mHour = Integer.parseInt(movieScheduleRepository.movieHour(mNo));


        if (mHour.equals(null)) {
            return null;
        }
        return mHour;
    }

    /*public void updateEndTime(Integer m_Hour, MovieSchedule movieSchedule) {
        Integer movieScheduleId = movieSchedule.getMovieScheduleId();
        movieScheduleRepository.endTime(m_Hour, movieScheduleId);
        Date m_StarTime, Integer m_no, Integer store_No, String m_Hour
    }*/

    public void insertSchedule(Integer m_Hour, MovieSchedule movieSchedule) {
        Date m_StarTime = movieSchedule.getMS_StarTime();
        Integer m_no = movieSchedule.getM_No();
        Integer store_No = movieSchedule.getStore_No();
        movieScheduleRepository.insertSchedule(m_StarTime, m_no, store_No, m_Hour);
    }
}
