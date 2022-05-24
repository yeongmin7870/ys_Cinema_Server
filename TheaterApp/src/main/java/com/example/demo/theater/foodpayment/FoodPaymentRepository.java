package com.example.demo.theater.foodpayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodPaymentRepository extends JpaRepository<FoodPayment,Integer> {

    @Query("SELECT f,o FROM FoodPayment f, OrderList o WHERE f.foodPaymentId = o.fp_No")
    public List<Object> findCustomerPaymentOrderList();   //회원 일때 조회

    @Query("SELECT f,o FROM FoodPayment f, OrderList o WHERE f.foodPaymentId = o.fp_No AND o.cId = :cId")
    public List<Object> findCustomerPaymentOrderList2(@Param("cId") String cId);   //회원 조건 조회




    @Query("SELECT f,o FROM FoodPayment f, NcOrderList o WHERE f.foodPaymentId = o.fp_No")
    public List<Object> findNonCustPaymentOrderList();   //비회원 일때 조회


    @Query("SELECT f,o FROM FoodPayment f, NcOrderList o WHERE f.foodPaymentId = o.fp_No AND o.nc_No = :nc_No")
    public List<Object> findNonCustPaymentOrderList2(@Param("nc_No") Integer nc_No);   //비회원 조건 조회
}
