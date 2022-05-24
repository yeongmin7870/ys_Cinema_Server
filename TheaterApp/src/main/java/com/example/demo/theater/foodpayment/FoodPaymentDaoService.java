package com.example.demo.theater.foodpayment;


import com.example.demo.theater.ncOrderList.NcOrderList;
import com.example.demo.theater.ncOrderList.NcOrderListRepository;
import com.example.demo.theater.orderList.OrderList;
import com.example.demo.theater.orderList.OrderListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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

    @Autowired
    private NcOrderListRepository ncOrderListRepository;

    public List<Object> retrieveFoodOrderList(String who, String id) {
        if (who.equals("회원")) {
            return foodPaymentRepository.findCustomerPaymentOrderList2(id);
        } else if (who.equals("비회원")) {
            return foodPaymentRepository.findNonCustPaymentOrderList2(Integer.valueOf(id));
        }
        return null;
    }



    public List<Object> findCustomerPayment(String who) {
        if (who.equals("회원")) {
            return foodPaymentRepository.findCustomerPaymentOrderList();
        } else if (who.equals("비회원")) {
            return foodPaymentRepository.findNonCustPaymentOrderList();
        }
        return null;
    }
    // 회원일떄 음식주문
    public List<Object> orderFood(FoodPayment foodPayment, String cId) {
        OrderList newOrderList = new OrderList();

        List<Object> result = new ArrayList<>();

        FoodPayment newFoodPayment = foodPaymentRepository.save(foodPayment);

        newOrderList.setCId(cId);
        newOrderList.setFp_No(newFoodPayment.getFoodPaymentId());


        OrderList orderList = orderListRepository.save(newOrderList);

        result.add(newFoodPayment);
        result.add(orderList);

        return result;
    }
    // 비회원일때 음식주문
    public List<Object> orderFood2(FoodPayment foodPayment, Integer cId) {
        NcOrderList newOrderList = new NcOrderList();

        List<Object> result = new ArrayList<>();

        FoodPayment newFoodPayment = foodPaymentRepository.save(foodPayment);

        newOrderList.setNc_No(cId);
        newOrderList.setFp_No(newFoodPayment.getFoodPaymentId());


        NcOrderList orderList = ncOrderListRepository.save(newOrderList);

        result.add(newFoodPayment);
        result.add(orderList);

        return result;
    }
}
