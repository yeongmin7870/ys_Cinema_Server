package com.example.demo.theater.dao;

import com.example.demo.theater.repository.FoodKindRepository;
import com.example.demo.theater.repository.FoodMenuRepository;
import com.example.demo.theater.vo.FoodKind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        for (int i = 0; i < result.size(); i++) {
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

        if (foodKind1 == null) { // 만약 기존에 입력한 음식 종류가 없는 경우
            foodKind1 = foodKindRepository.save(foodKind); // 새로운 foodKind
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

    ResponseEntity<Resource> retrieveFoodImage(Integer id) throws IOException {
        FoodMenu foodMenu = foodMenuRepository.findByFoodMenuId(id);
        logger.info(foodMenu.toString());
        String path = foodMenu.getFood_Img();
        HttpHeaders headers = new HttpHeaders();
        Path filePath = Paths.get(path);
        Resource resource = new FileSystemResource(path);
        if (path == null) {
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
        }
        headers.add("Content-Type", Files.probeContentType(filePath));
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

    String[] getFoodImages() {
        List<FoodMenu> foodMenus = foodMenuRepository.findAll();
        String[] uri = new String[foodMenus.size()];
        System.out.println(foodMenus);
        for (int i = 0; i < foodMenus.size(); i++) {
            uri[i] = "http://caramels.kro.kr:9632/theater/foodMenu/Images/" + foodMenus.get(i).getFoodMenuId();
        }
        return uri;
    }
}
