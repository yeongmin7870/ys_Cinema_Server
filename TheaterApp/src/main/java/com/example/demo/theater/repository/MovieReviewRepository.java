package com.example.demo.theater.repository;

import com.example.demo.theater.vo.Customer;
import com.example.demo.theater.vo.MovieReview;
import com.example.demo.theater.vo.WritedReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {

    MovieReview findByMovieReviewId(Integer id);


    @Query(value = "SELECT SUM(mrReviewStarScore) FROM MovieReview WHERE movieId = :movieId")
    Integer sumRating(@Param("movieId") Integer movieId);  // 평점 합계

    List<MovieReview> findByMovieId(Integer movieId); // 영화아이디로 리뷰 찾기

    @Query(value = "SELECT count(m.movieReviewId) FROM WritedReview w, MovieReview m WHERE w.mrNo = m.movieReviewId And w.cId = :cId AND m.movieId = :movieId")
    Integer oneReview(@Param("cId") String cId, @Param("movieId") Integer movieId);

    @Query(value = "SELECT m FROM MovieReview m Where m.movieReviewId = :movieReviewId")
    MovieReview retrieveReview(@Param("movieReviewId") Integer movieReviewId);

    @Query(value = "SELECT  m,w FROM MovieReview m, WritedReview w WHERE m.movieReviewId = w.mrNo")
    List<Object> retrieveFindAll();   // 전체 리뷰 조인해서 출력

    @Query(value = "SELECT  m FROM MovieReview m, WritedReview w WHERE m.movieReviewId = w.mrNo AND m.movieId = :movieId")
    List<MovieReview> retrieveFindOne(@Param("movieId") Integer movieId);   // 해당 영화 MoviewReivew 만 조인해서 출력

    @Query(value = "SELECT  w FROM MovieReview m, WritedReview w WHERE m.movieReviewId = w.mrNo AND m.movieId = :movieId")
    List<WritedReview> retrieveFindOne2(@Param("movieId") Integer movieId);   // 해당 영화 리뷰 WritedReview 만 조인해서 출력

    @Query(value = "SELECT c FROM MovieReview m, WritedReview w, Customer c WHERE m.movieReviewId = w.mrNo AND w.cId = c.customerId AND m.movieId = :movieId")
    List<Customer> retrieveFindOne3(@Param("movieId") Integer movieId);   // 해당 영화 리뷰 WritedReview 만 조인해서 출력


    @Query(value = "SELECT  m,w FROM MovieReview m, WritedReview w WHERE m.movieReviewId = w.mrNo AND w.cId = :cId")
    List<Object> retrieveMyReview(@Param("cId") String cId);   // 내가 적은 리뷰 조인해서 출력


}