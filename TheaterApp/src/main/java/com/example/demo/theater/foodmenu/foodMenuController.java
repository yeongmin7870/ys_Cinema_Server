package com.example.demo.theater.foodmenu;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/theater")
public class foodMenuController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodMenuDaoService foodMenuDaoService;


    @GetMapping("/foodMenu")
    @ApiOperation("음식메뉴와 종류 조인해서 전체 출력")
    public List<Object> retrieveAll(){
        return foodMenuDaoService.findAll();
    }

    @GetMapping("/foodMenu/kind")
    @ApiOperation("한 종류만 출력")
    public List<Object> retrieveOneKind(@RequestParam String foodKindName){
        return foodMenuDaoService.findOneKind(foodKindName);
    }

    @PostMapping("/foodMenu")
    @ApiOperation("음식 메뉴 추가")
    public List<Object> addFoodMenu(@RequestBody FoodMenu newFoodMenu,@RequestParam String newFoodKindName){
        logger.info(newFoodMenu.toString());
        logger.info(newFoodKindName.toString());

        return foodMenuDaoService.addFoodMenu(newFoodMenu,newFoodKindName);
    }

}
