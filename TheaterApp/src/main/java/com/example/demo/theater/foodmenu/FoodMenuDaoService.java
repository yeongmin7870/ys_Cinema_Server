package com.example.demo.theater.foodmenu;

import com.example.demo.theater.foodkind.FoodKind;
import com.example.demo.theater.foodkind.FoodKindRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FoodMenuDaoService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodMenuRepository foodMenuRepository;

    @Autowired
    private FoodKindRepository foodKindRepository;


    public List<Object> findAll() {
        return foodMenuRepository.findFoodMenu();
    }

    public List<Object> findOneKind(String foodKindName) {
        return foodMenuRepository.findOneKind(foodKindName);
    }

    public List<Object> addFoodMenu(FoodMenu newFoodMenu, String newFoodKind){
        List<Object> result = new ArrayList<>();
        Date today = new Date();

        FoodMenu newFoodMenu2= new FoodMenu();
        newFoodMenu2.setFoodName(newFoodMenu.getFoodName());
        newFoodMenu2.setFood_Component(newFoodMenu.getFood_Component());
        newFoodMenu2.setFood_Limit(newFoodMenu.getFood_Limit());
        newFoodMenu2.setFood_Date(today);
        newFoodMenu2.setFood_Price(newFoodMenu.getFood_Price());


        // food kind 넣기
        FoodKind foodKind = new FoodKind();
        foodKind.setFoodKindName(newFoodKind);
        FoodKind foodKind1 = foodKindRepository.save(foodKind);  // 새로운 foodkind

        newFoodMenu2.setFood_Kind_No(foodKind1.getFoodKindId());

        FoodMenu foodMenu = FoodMenuSave(newFoodMenu2);
        logger.info("foodMenu "+foodMenu.toString());
//        result.add(foodMenu);
        result.add(foodKind1);
        return result;
    }

    FoodMenu FoodMenuSave(FoodMenu foodMenu){
        return foodMenuRepository.save(foodMenu);
    }

}
