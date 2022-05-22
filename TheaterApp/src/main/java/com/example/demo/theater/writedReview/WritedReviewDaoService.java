package com.example.demo.theater.writedReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WritedReviewDaoService {


    @Autowired
    private WritedReviewRepository repository;



    public WritedReview save(String cId, Integer mrNo){
        WritedReview writedReview = new WritedReview();
        writedReview.setCId(cId);
        writedReview.setMrNo(mrNo);
        return repository.save(writedReview);
    }


    public List<WritedReview> findAll(){
        return repository.findAll();
    }
}
