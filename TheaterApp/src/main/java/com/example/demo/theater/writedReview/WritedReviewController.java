package com.example.demo.theater.writedReview;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class WritedReviewController {

    @Autowired
    WritedReviewDaoService daoService;

    @GetMapping("/WritedReview")
    @ApiOperation(value = "성공기원")
    public List<WritedReview> retrieveAllMovieReview() { return daoService.findAll();}

}
