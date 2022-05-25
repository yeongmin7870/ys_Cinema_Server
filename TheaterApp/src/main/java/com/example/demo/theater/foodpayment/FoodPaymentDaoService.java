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

    public List<FoodPayment> retrieveFoodOrderList(String who, String id) {
        if (who.equals("회원")) {
            List<FoodPayment> foodPayments = foodPaymentRepository.findCustomerPaymentOrderList2F(id);
            List<OrderList> orderLists = foodPaymentRepository.findCustomerPaymentOrderList2O(id);
            List<FoodMenu> foodMenus = foodPaymentRepository.findCustomerPaymentOrderList2FM(id);

            for(int i=0; i<foodPayments.size();i++){
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

            for(int i=0; i<foodPayments.size();i++){
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
