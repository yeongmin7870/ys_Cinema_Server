package com.example.demo.theater.controller;

import com.example.demo.theater.dao.ReviewCommentDaoService;
import com.example.demo.theater.exception.MovieNotFoundException;
import com.example.demo.theater.vo.ReviewComment;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class ReviewCommentController {

    @Autowired
    private ReviewCommentDaoService service;

    @GetMapping("/ReviewComment")
    @ApiOperation(value = "영화 전체 대댓글 보여주기")
    public List<ReviewComment> retrieveAllMovieComment() {
        return service.findAll();
    }

    @GetMapping("/ReviewComment/{movieId}/{rcId}")
    @ApiOperation(value = "해당 영화 리뷰의 대댓글만 보여주기")
    public ReviewComment retrieveMovieReview(@PathVariable Integer movieId, Integer rcId) {
        ReviewComment comment = service.retrieveMovieComment(movieId, rcId);

        if (comment == null) {
            throw new MovieNotFoundException(String.format("ID [%s] Not Found", movieId));
        }

        return comment;
    }

    @PostMapping("/ReviewComment")
    @ApiOperation(value = "영화 대댓글 작성 삽입")
    public String newReview(@RequestBody ReviewComment newComment) {
        service.save(newComment);
        return "finish";
    }

    @PutMapping("/ReviewComment")
    @ApiOperation(value = "영화 리뷰 수정")
    public ReviewComment replaceMovieReview(@RequestBody ReviewComment comment) {
        ReviewComment updateMovieReview = service.updateComment(comment);

        return updateMovieReview;
    }

    @DeleteMapping("/ReviewComment/{rcId}")
    @ApiOperation(value = "리뷰 삭제하기")
    public void deleteMovieReview(@PathVariable Integer rcId) {
        service.deleteMovieReview(rcId);
    }
}
