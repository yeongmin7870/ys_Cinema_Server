package com.example.demo.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.theater.vo.FoodKind;

@Repository
public interface FoodKindRepository extends JpaRepository<FoodKind,Integer> {


    public FoodKind findByFoodKindName(String foodKindName);
}
