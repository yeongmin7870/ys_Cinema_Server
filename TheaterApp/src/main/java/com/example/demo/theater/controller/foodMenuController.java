package com.example.demo.theater.controller;

import com.example.demo.theater.dao.FoodMenuDaoService;
import com.example.demo.theater.vo.FoodKind;
import com.example.demo.theater.vo.FoodMenu;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/theater")
public class foodMenuController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodMenuDaoService foodMenuDaoService;

    @GetMapping("/foodMenu/getImages")
    @ApiOperation("음식 이미지 주소 리스트로 가져오기")
    public String[] getImageList() {
        return foodMenuDaoService.getFoodImages();
    }


    @GetMapping("/foodMenu/kindList")
    @ApiOperation("음식 종류 리스트로 가져오기")
    public List<FoodKind> retrieveFoodKind() {
        return foodMenuDaoService.findALlKind();
    }

    @GetMapping("/foodMenu")
    @ApiOperation("음식메뉴와 종류 조인해서 전체 출력")
    public  List<FoodMenu> retrieveAll() {
        List<FoodMenu> all = foodMenuDaoService.findAll();
        logger.info(all.getClass().getSimpleName());

        return all;
    }

    @GetMapping("/foodMenu/kind")
    @ApiOperation("한 종류만 출력")
    public Object[] retrieveOneKind(@RequestParam String foodKindName) {

        Object[] oneKind = foodMenuDaoService.findOneKind(foodKindName);

        return oneKind;
    }

    @PostMapping("/foodMenu")
    @ApiOperation("음식 메뉴 추가")
    public List<Object> addFoodMenu(@RequestBody FoodMenu newFoodMenu, @RequestParam String newFoodKindName) {
        List<Object> objects = foodMenuDaoService.addFoodMenu(newFoodMenu, newFoodKindName);
        return objects;
    }

    @GetMapping("/foodMenu/Images/{id}")
    @ApiOperation("음식 이미지 보여주기")
    public ResponseEntity<Resource> retrieveFoodImage(@PathVariable ("id") String id) throws IOException {
        return foodMenuDaoService.retrieveFoodImage(Integer.valueOf(id));
    }

}
