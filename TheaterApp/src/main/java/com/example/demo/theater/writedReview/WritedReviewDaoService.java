package com.example.demo.theater.writedReview;

import com.example.demo.theater.moviereview.MovieReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class WritedReviewDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WritedReviewRepository repository;



    public WritedReview save(String cId, MovieReview newMoviReview){
        WritedReview writedReview = new WritedReview();
        writedReview.setCId(cId);
        writedReview.setMrNo(newMoviReview.getMovieReviewId());
        return repository.save(writedReview);
    }


    public List<WritedReview> findAll(){
        return repository.findAll();
    }
}
