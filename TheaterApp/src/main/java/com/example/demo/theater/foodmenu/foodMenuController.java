package com.example.demo.theater.foodmenu;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/theater")
public class foodMenuController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodMenuDaoService foodMenuDaoService;


    @GetMapping("/foodMenu")
    @ApiOperation("foodMenu 전체 출력")
    public List<Object> retrieveAll(){
        return foodMenuDaoService.findAll();
    }
}
