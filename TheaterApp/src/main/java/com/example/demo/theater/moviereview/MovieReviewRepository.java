package com.example.demo.theater.moviereview;

import com.example.demo.theater.writedReview.WritedReview;
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

//    @Query(value = "INSERT INTO Writed_Review (WR_NO,c_Id, mr_No) VALUES (WRITED_REVIEW_SEQ_WRNO.NEXTVAL,:c_Id,:mr_No)", nativeQuery = true)
//    WritedReview insertWR(@Param("c_Id") String cId, @Param("mr_No") Integer mrNo);

    @Query(value = "SELECT w FROM WritedReview w Where w.cId = :cId AND w.mrNo = :mrNo")
    WritedReview oneReview(@Param("cId") String cId, @Param("mrNo") Integer mrNo);    // 리뷰 쓴적 있는지 판단


    @Query(value = "SELECT m FROM MovieReview m Where m.movieReviewId = :movieReviewId")
    MovieReview retrieveReview(@Param("movieReviewId") Integer movieReviewId);

    @Query(value = "SELECT  m,w FROM MovieReview m, WritedReview w WHERE m.movieReviewId = w.mrNo")
    List<Object> retrieveFindAll();   // 전체 리뷰 조인해서 출력

    @Query(value = "SELECT  m,w FROM MovieReview m, WritedReview w WHERE m.movieReviewId = w.mrNo AND m.movieId = :movieId")
    List<Object> retrieveFindOne(@Param("movieId") Integer movieId);   // 해당 영화 리뷰만 조인해서 출력
}
