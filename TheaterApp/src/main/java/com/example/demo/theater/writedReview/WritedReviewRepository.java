package com.example.demo.theater.writedReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritedReviewRepository extends JpaRepository<WritedReview, String> {


}
