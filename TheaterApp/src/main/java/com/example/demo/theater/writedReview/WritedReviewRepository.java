package com.example.demo.theater.writedReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WritedReviewRepository extends JpaRepository<WritedReview, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM WritedReview w Where w.mrNo = :mrNo")
    void removeMrNo(@Param("mrNo") Integer mrNo);   //영화리뷰를 삭제해주는 기능


}
