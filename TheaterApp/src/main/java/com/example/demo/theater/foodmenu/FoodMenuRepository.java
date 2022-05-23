package com.example.demo.theater.foodmenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu,Integer> {

    @Query("SELECT f,k FROM FoodMenu f, FoodKind k WHERE f.food_Kind_No = k.foodKindId")
    List<Object> findFoodMenu();  // 음식 메뉴와 종류 전부 조인해서 출력
}
