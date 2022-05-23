package com.example.demo.theater.foodmenu;

import com.example.demo.theater.foodkind.FoodKind;
import com.example.demo.theater.foodkind.FoodKindRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodMenuDaoService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodMenuRepository foodMenuRepository;

    @Autowired
    private FoodKindRepository foodKindRepository;


    public List<FoodKind> findALlKind() {
        return foodKindRepository.findAll();
    }


    public List<FoodMenu> findAll() {

        List<FoodMenu> result = foodMenuRepository.findFoodMenu();
        List<FoodKind> resultKind = foodMenuRepository.findFoodKind();
        for(int i=0; i<result.size();i++){
            result.get(i).setFoodKindName(resultKind.get(i).getFoodKindName());
        }

        return result;
    }

    public Object[] findOneKind(String foodKindName) {
        return foodMenuRepository.findOneKind(foodKindName);
    }

    public List<Object> addFoodMenu(FoodMenu newFoodMenu, String newFoodKind) {
        List<Object> result = new ArrayList<>();
        Date today = new Date();

        FoodMenu newFoodMenu2 = new FoodMenu();
        newFoodMenu2.setFoodName(newFoodMenu.getFoodName());
        newFoodMenu2.setFood_Component(newFoodMenu.getFood_Component());
        newFoodMenu2.setFood_Limit(newFoodMenu.getFood_Limit());
        newFoodMenu2.setFood_Date(today);
        newFoodMenu2.setFood_Price(newFoodMenu.getFood_Price());


        // food kind 넣기
        FoodKind foodKind = new FoodKind();
        foodKind.setFoodKindName(newFoodKind);

        FoodKind foodKind1;
        foodKind1 = foodKindRepository.findByFoodKindName(newFoodKind);

        if (foodKind1 == null) { //만약 기존에 입력한 음식 종류가 없는 경우
            foodKind1 = foodKindRepository.save(foodKind);  // 새로운 foodKind
        }

        newFoodMenu2.setFoodKindNo(foodKind1.getFoodKindId());

        FoodMenu foodMenu = FoodMenuSave(newFoodMenu2);

        result.add(foodMenu);
        result.add(foodKind1);
        return result;
    }

    FoodMenu FoodMenuSave(FoodMenu foodMenu) {
        return foodMenuRepository.save(foodMenu);
    }


}
