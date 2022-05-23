package com.example.demo.theater.foodmenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu,Integer> {

    @Query("SELECT f,k FROM FoodMenu f, FoodKind k WHERE f.food_Kind_No = k.foodKindId")
    List<Object> findFoodMenu();  // 음식 메뉴와 종류 전부 조인해서 출력

    @Query("SELECT f,k FROM FoodMenu f, FoodKind k WHERE f.food_Kind_No = k.foodKindId And k.foodKindName = :foodKindName")
    List<Object> findOneKind(@Param("foodKindName") String foodKindName);  // 한종류에 음식 리스트 뽑아내기


}
