package com.example.demo.theater.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    private static final

    @Autowired
    private MovieRepository movieRepository;

    //영화 전체 출력
    public List<Movie> findAll () {return movieRepository.findAll();}

    //ID값으로 해당 영화 검색
    public Movie findById (Integer m_No){
        Movie movie = movieRepository.findByMovieId(m_No);
        return movie;
    }

    public Movie save(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

}
