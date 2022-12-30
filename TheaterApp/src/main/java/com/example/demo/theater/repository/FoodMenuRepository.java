package com.example.demo.theater.repository;

import com.example.demo.theater.vo.FoodKind;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, Integer> {

    @Query("SELECT f,k FROM FoodMenu f, FoodKind k WHERE f.foodKindNo = k.foodKindId")
    List<FoodMenu> findFoodMenu();

    @Query("SELECT k FROM FoodMenu f, FoodKind k WHERE f.foodKindNo = k.foodKindId")
    List<FoodKind> findFoodKind();

    // 음식 메뉴와 종류 전부 조인해서 출력


    @Query("SELECT f,k FROM FoodMenu f, FoodKind k WHERE f.foodKindNo = k.foodKindId And k.foodKindName = :foodKindName")
    Object[] findOneKind(@Param("foodKindName") String foodKindName);  // 한종류에 음식 리스트 뽑아내기


    FoodMenu findByFoodMenuId(Integer id);

}
