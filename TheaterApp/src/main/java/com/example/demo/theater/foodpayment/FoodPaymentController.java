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

    @PostMapping("/foodPayment/pay")
    @ApiOperation(value = "음식주문하기 1. 회원 2. 비회원  ",notes = "food_No : 음식 id " +
            "fp_Count : 개수 " +
            "fp_Price : 음식 가격 " +
            " foodKindNo : 음식 종류 100번부터" )
    public void orderFood(@RequestBody FoodPayment foodPayment, @RequestParam String cId, @RequestParam String who) {


        if (who.equals("회원")) {
            foodPaymentDaoService.orderFood(foodPayment, cId);

        } else if (who.equals("비회원")) {
            foodPaymentDaoService.orderFood2(foodPayment, Integer.parseInt(cId));
        }

    }

    @GetMapping("/foodPayment/retrieveFood")
    @ApiOperation("비회원 or 회원 자신의 음식주문 정보 가져오기")
    public List<FoodPayment> retrieveFoodOrderList(String who, String id) {
        return foodPaymentDaoService.retrieveFoodOrderList(who, id);
    }


    @PutMapping("/foodPaymet")
    @ApiOperation(value = "결제내역 수정(환불, 수정 요청시) 1. 회원 2. 비회원  ",notes = "food_No : 음식 id " +
            "fp_Count : 개수 " +
            "fp_Price : 음식 가격 " +
            "foodPaymentId : 주문내역 ID ")
    public List<Object> replaceFoodPayment(@RequestBody FoodPayment foodPayment, @RequestParam String cId, @RequestParam String who) {
        List<Object> list = null;
        if (who.equals("회원")) {
            list = foodPaymentDaoService.orderReplace(foodPayment, cId);
        } else if (who.equals("비회원")) {
            list = foodPaymentDaoService.NcOrderReplace(foodPayment, Integer.parseInt(cId));
        }
        return list;
    }

}
