package com.example.demo.theater.dao;

import com.example.demo.theater.repository.WritedReviewRepository;
import com.example.demo.theater.vo.MovieReview;
import com.example.demo.theater.vo.WritedReview;

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

    public WritedReview save(String cId, MovieReview newMoviReview) {
        WritedReview writedReview = new WritedReview();
        writedReview.setCId(cId);
        writedReview.setMrNo(newMoviReview.getMovieReviewId());
        return repository.save(writedReview);
    }

    public List<WritedReview> findAll() {
        return repository.findAll();
    }
}
