package com.example.demo.theater.movieend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieEndRepository extends JpaRepository<MovieEnd,Integer> {
}
