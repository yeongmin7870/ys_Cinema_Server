package com.example.demo.theater.moviepre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePreRepository extends JpaRepository<MoviePre,Integer> {
}
