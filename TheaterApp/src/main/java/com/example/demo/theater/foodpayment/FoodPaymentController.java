package com.example.demo.theater.foodpayment;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/theater")
public class FoodPaymentController {

    @Autowired
    private FoodPaymentDaoService foodPaymentDaoService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/foodPayment")
    @ApiOperation(value = "음식주문한거 전체 보기", notes = "who 는 1. 회원 2. 비회원 둘 중 한가지만 판별함")
    public List<Object> retrieveFoodPayment(@RequestParam String who) {
        return foodPaymentDaoService.findCustomerPayment(who);
    }

    @PostMapping("/foodPaymet")
    @ApiOperation("음식주문하기 1. 회원 2. 비회원  ")
    public List<Object> orderFood(@RequestBody FoodPayment foodPayment, @RequestParam String cId, @RequestParam String who) {
        List<Object> list = null;
        if (who.equals("회원")) {
            list = foodPaymentDaoService.orderFood(foodPayment, cId);
        } else if (who.equals("비회원")) {
            list = foodPaymentDaoService.orderFood2(foodPayment, Integer.parseInt(cId));
        }
        return list;
    }

    @GetMapping("/foodPayment/retrieveFood")
    @ApiOperation("비회원 or 회원 자신의 음식주문 정보 가져오기")
    public List<Object> retrieveFoodOrderList(String who, String id) {
        return foodPaymentDaoService.retrieveFoodOrderList(who, id);
    }
}
