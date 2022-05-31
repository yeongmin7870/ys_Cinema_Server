package com.example.demo.theater.foodpayment;


import com.example.demo.theater.foodmenu.FoodMenu;
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
import java.util.Date;
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



    // 회원일떄 음식주문 수정
    public List<Object> orderReplace(FoodPayment newfoodPayment, String cId) {
        FoodPayment foodPayment = foodPaymentRepository.findOneFoodHistory(cId,newfoodPayment.getFoodPaymentId());

        List<Object> result = new ArrayList<>();

        if (newfoodPayment.getFood_No() != 0) { // 음식을 수정하고 싶다면
            foodPayment.setFood_No(newfoodPayment.getFood_No());
        }
        if (newfoodPayment.getFp_Count() != 0) { // 음식 개수를 변경하고 싶어
            foodPayment.setFp_Count(newfoodPayment.getFp_Count());
        }
        if (newfoodPayment.getFp_Price() != 0) {
            foodPayment.setFood_Price(newfoodPayment.getFood_Price());
        }

        foodPaymentRepository.save(foodPayment);

        result.add(newfoodPayment);


        return result;
    }

    // 비회원일떄 음식주문 수정
    public List<Object> NcOrderReplace (FoodPayment newfoodPayment, Integer cId) {
        FoodPayment foodPayment = foodPaymentRepository.findOneFoodNcHistory(cId,newfoodPayment.getFoodPaymentId());

        List<Object> result = new ArrayList<>();




        if (newfoodPayment.getFood_No() != 0) { // 음식을 수정하고 싶다면
            foodPayment.setFood_No(newfoodPayment.getFood_No());
        }
        if (newfoodPayment.getFp_Count() != 0) { // 음식 개수를 변경하고 싶어
            foodPayment.setFp_Count(newfoodPayment.getFp_Count());
        }
        if (newfoodPayment.getFp_Price() != 0) {
            foodPayment.setFood_Price(newfoodPayment.getFood_Price());
        }

        foodPaymentRepository.save(foodPayment);

        result.add(newfoodPayment);


        return result;
    }

    public List<FoodPayment> retrieveFoodOrderList(String who, String id) {
        if (who.equals("회원")) {
            List<FoodPayment> foodPayments = foodPaymentRepository.findCustomerPaymentOrderList2F(id);
            List<OrderList> orderLists = foodPaymentRepository.findCustomerPaymentOrderList2O(id);
            List<FoodMenu> foodMenus = foodPaymentRepository.findCustomerPaymentOrderList2FM(id);

            for (int i = 0; i < foodPayments.size(); i++) {
                foodPayments.get(i).setOrderId(orderLists.get(i).getOrderId());
                foodPayments.get(i).setId(orderLists.get(i).getCId());
                foodPayments.get(i).setFoodName(foodMenus.get(i).getFoodName());
                foodPayments.get(i).setFood_Component(foodMenus.get(i).getFood_Component());
                foodPayments.get(i).setFood_Limit(foodMenus.get(i).getFood_Limit());
                foodPayments.get(i).setFood_Date(foodMenus.get(i).getFood_Date());
                foodPayments.get(i).setFood_Price(foodMenus.get(i).getFood_Price());
                foodPayments.get(i).setFood_Img(foodMenus.get(i).getFood_Img());
                foodPayments.get(i).setFoodKindNo(foodMenus.get(i).getFoodKindNo());
            }
            return foodPayments;

        } else if (who.equals("비회원")) {
            Integer id2 = Integer.valueOf(id);
            List<FoodPayment> foodPayments = foodPaymentRepository.findNonCustPaymentOrderList2F(id2);
            List<NcOrderList> orderLists = foodPaymentRepository.findNonCustPaymentOrderList2O(id2);
            List<FoodMenu> foodMenus = foodPaymentRepository.findNonCustPaymentOrderList2FM(id2);

            for (int i = 0; i < foodPayments.size(); i++) {
                foodPayments.get(i).setOrderId(orderLists.get(i).getNcOrderId());
                foodPayments.get(i).setNid(orderLists.get(i).getNc_No());
                foodPayments.get(i).setFoodName(foodMenus.get(i).getFoodName());
                foodPayments.get(i).setFood_Component(foodMenus.get(i).getFood_Component());
                foodPayments.get(i).setFood_Limit(foodMenus.get(i).getFood_Limit());
                foodPayments.get(i).setFood_Date(foodMenus.get(i).getFood_Date());
                foodPayments.get(i).setFood_Price(foodMenus.get(i).getFood_Price());
                foodPayments.get(i).setFood_Img(foodMenus.get(i).getFood_Img());
                foodPayments.get(i).setFoodKindNo(foodMenus.get(i).getFoodKindNo());
            }
            return foodPayments;

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
    public void orderFood(FoodPayment foodPayment, String cId) {
        Date today = new Date();
        OrderList newOrderList = new OrderList();
        List<Object> result = new ArrayList<>();

        foodPayment.setF_Date(today);
        FoodPayment newFoodPayment = foodPaymentRepository.save(foodPayment);

        newOrderList.setCId(cId);
        newOrderList.setFp_No(newFoodPayment.getFoodPaymentId());


        OrderList orderList = orderListRepository.save(newOrderList);

        result.add(newFoodPayment);
        result.add(orderList);

    }

    // 비회원일때 음식주문
    public List<Object> orderFood2(FoodPayment foodPayment, Integer cId) {
        Date today = new Date();
        NcOrderList newOrderList = new NcOrderList();
        List<Object> result = new ArrayList<>();

        foodPayment.setF_Date(today);

        FoodPayment newFoodPayment = foodPaymentRepository.save(foodPayment);

        newOrderList.setNc_No(cId);
        newOrderList.setFp_No(newFoodPayment.getFoodPaymentId());


        NcOrderList orderList = ncOrderListRepository.save(newOrderList);

        result.add(newFoodPayment);
        result.add(orderList);

        return result;
    }
}
