package com.example.demo.theater.reviewcomment;

import com.example.demo.theater.moviereview.MovieReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ReviewCommentDaoService {

    @Autowired
    private ReviewCommentRepository repository;

    // 누가 어떤 영화에 대댓글 작성했는지 판단여부
    public boolean searchMovieReivew(Integer rcId, Integer mrNo){
        ReviewComment result = repository.retrieveComments(rcId,mrNo);
        if(result != null){
            return true;
        }
        else{
            return false;
        }
    }

    //영화아이디로 리뷰 찾기
    public ReviewComment retrieveMovieComment(Integer mrNo, Integer rcId) {
        ReviewComment comments = repository.retrieveComments(rcId,mrNo);
        return comments;
    }

    public List<ReviewComment> findAll() {
        return repository.findAll();
    }

    public ReviewComment save(ReviewComment comment){
        repository.save(comment);
        return comment;
    }

    public ReviewComment updateComment (ReviewComment comment) {
        ReviewComment reviewComment = repository.retrieveComments(comment.getRcId(), comment.getMrNo());

        Date today = new Date();
        if (reviewComment == null) {
            return null;
        }
        reviewComment.setRc_Content(comment.getRc_Content());
        reviewComment.setRc_Uptime(today);
        reviewComment.setRc_Thumbs(comment.getRc_Thumbs());
        reviewComment.setRc_Bullshit(comment.getRc_Bullshit());


        ReviewComment updateMovieReview = repository.save(reviewComment);

        return updateMovieReview;
    }

    public void deleteMovieReview (Integer rcId) {
        repository.deleteById(rcId);
    }

}
