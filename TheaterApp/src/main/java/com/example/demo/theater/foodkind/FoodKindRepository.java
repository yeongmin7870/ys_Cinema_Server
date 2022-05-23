package com.example.demo.theater.foodkind;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodKindRepository extends JpaRepository<FoodKind,Integer> {


    public FoodKind findByFoodKindName(String foodKindName);
}
