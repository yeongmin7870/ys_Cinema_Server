package com.example.demo.theater.repository;

import com.example.demo.theater.ncOrderList.NcOrderList;
import com.example.demo.theater.vo.FoodPayment;
import com.example.demo.theater.vo.OrderList;
import com.example.demo.theater.vo.foodmenu.FoodMenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.util.List;

@Repository
public interface FoodPaymentRepository extends JpaRepository<FoodPayment, Integer> {


    @Query("SELECT  max(o) FROM OrderList o")
    Integer FoodOrderListMax();

    @Query("SELECT f,o FROM FoodPayment f, OrderList o WHERE f.foodPaymentId = o.fp_No")
    public List<Object> findCustomerPaymentOrderList();   //회원 일때 조회


    @Query("SELECT f FROM FoodPayment f, OrderList o, FoodMenu fm WHERE f.foodPaymentId = o.fp_No AND o.cId = :cId " +
            "AND f.food_No = fm.foodMenuId AND f.foodPaymentId = :foodPaymentId")
    public FoodPayment findOneFoodHistory (@Param("cId") String cId ,@Param("foodPaymentId") Integer foodPaymentId);   // [회원전용]음식 구매내역 수정할때 구매했던 음식주문 한개 찾기


    @Query("SELECT f FROM FoodPayment f, NcOrderList o, FoodMenu fm WHERE f.foodPaymentId = o.fp_No AND o.nc_No = :cId " +
            "AND f.food_No = fm.foodMenuId AND f.foodPaymentId = :foodPaymentId")
    public FoodPayment findOneFoodNcHistory (@Param("cId") Integer cId ,@Param("foodPaymentId") Integer foodPaymentId);   // [비회원전용]음식 구매내역 수정할때 구매했던 음식주문 한개 찾기



    @Query("SELECT f FROM FoodPayment f, OrderList o, FoodMenu fm WHERE f.foodPaymentId = o.fp_No AND o.cId = :cId " +
            "AND f.food_No = fm.foodMenuId")
    public List<FoodPayment> findCustomerPaymentOrderList2F(@Param("cId") String cId);   //회원 조건 조회

    @Query("SELECT o FROM FoodPayment f, OrderList o, FoodMenu fm WHERE f.foodPaymentId = o.fp_No AND o.cId = :cId " +
            "AND f.food_No = fm.foodMenuId")
    public List<OrderList> findCustomerPaymentOrderList2O(@Param("cId") String cId);   //회원 조건 조회


    @Query("SELECT fm FROM FoodPayment f, OrderList o, FoodMenu fm WHERE f.foodPaymentId = o.fp_No AND o.cId = :cId " +
            "AND f.food_No = fm.foodMenuId")
    public List<FoodMenu> findCustomerPaymentOrderList2FM(@Param("cId") String cId);   //회원 조건 조회


    @Query("SELECT f,o FROM FoodPayment f, NcOrderList o WHERE f.foodPaymentId = o.fp_No")
    public List<Object> findNonCustPaymentOrderList();   //비회원 일때 조회


    @Query("SELECT f FROM FoodPayment f, NcOrderList o, FoodMenu fm WHERE f.foodPaymentId = o.fp_No AND o.nc_No = :nc_No " +
            "AND f.food_No = fm.foodMenuId")
    public List<FoodPayment> findNonCustPaymentOrderList2F(@Param("nc_No") Integer nc_No);   //비회원 조건 조회

    @Query("SELECT o FROM FoodPayment f, NcOrderList o, FoodMenu fm WHERE f.foodPaymentId = o.fp_No AND o.nc_No = :nc_No " +
            "AND f.food_No = fm.foodMenuId")
    public List<NcOrderList> findNonCustPaymentOrderList2O(@Param("nc_No") Integer nc_No);   //비회원 조건 조회

    @Query("SELECT fm FROM FoodPayment f, NcOrderList o, FoodMenu fm WHERE f.foodPaymentId = o.fp_No AND o.nc_No = :nc_No " +
            "AND f.food_No = fm.foodMenuId")
    public List<FoodMenu> findNonCustPaymentOrderList2FM(@Param("nc_No") Integer nc_No);   //비회원 조건 조회





}
