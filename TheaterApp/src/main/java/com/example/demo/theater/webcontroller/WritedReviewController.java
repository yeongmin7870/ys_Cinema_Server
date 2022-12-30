package com.example.demo.theater.webcontroller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.theater.dao.WritedReviewDaoService;
import com.example.demo.theater.vo.WritedReview;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class WritedReviewController {

    @Autowired
    WritedReviewDaoService daoService;

    @GetMapping("/WritedReview")
    @ApiOperation(value = "현재 리뷰를 작성한 사람들의 정보")
    public List<WritedReview> retrieveAllMovieReview() { return daoService.findAll();}

}
