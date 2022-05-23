package com.example.demo.theater.foodpayment;


import com.example.demo.theater.orderList.OrderList;
import com.example.demo.theater.orderList.OrderListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodPaymentDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private FoodPaymentRepository foodPaymentRepository;

    @Autowired
    private OrderListRepository orderListRepository;

    public List<Object> findCustomerPayment(String who) {
        if (who.equals("회원")) {
            return foodPaymentRepository.findCustomerPaymentOrderList();
        } else if (who.equals("비회원")) {
            return foodPaymentRepository.findNonCustPaymentOrderList();
        }
        return null;
    }

    public List<Object> orderFood(FoodPayment foodPayment, String cId) {
        FoodPayment newFoodPayment = new FoodPayment();
        OrderList newOrderList = new OrderList();
        List<Object> result = new ArrayList<>();

        newFoodPayment.setFood_No(foodPayment.getFood_No());
        newFoodPayment.setFp_Count(foodPayment.getFp_Count());
        newFoodPayment.setFp_Price(foodPayment.getFp_Price());

        FoodPayment newFoodPayment2 = foodPaymentRepository.save(newFoodPayment);

        newOrderList.setCId(cId);
        logger.info("번호"+newFoodPayment2.getFoodPaymentId().toString());
        newOrderList.setFp_No(newFoodPayment2.getFoodPaymentId());

        OrderList newOrderList2 = orderListRepository.save(newOrderList);

        result.add(newFoodPayment2);
        result.add(newOrderList2);

        return result;
    }
}
