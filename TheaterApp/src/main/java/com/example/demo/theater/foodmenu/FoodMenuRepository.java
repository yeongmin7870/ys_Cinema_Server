package com.example.demo.theater.foodmenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu,Integer> {
}
