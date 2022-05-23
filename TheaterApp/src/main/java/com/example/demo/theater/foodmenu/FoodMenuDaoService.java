package com.example.demo.theater.foodmenu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodMenuDaoService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodMenuRepository foodMenuRepository;

    public List<Object> findAll(){
        return foodMenuRepository.findFoodMenu();
    }
}
