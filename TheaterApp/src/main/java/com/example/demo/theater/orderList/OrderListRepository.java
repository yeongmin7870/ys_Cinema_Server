package com.example.demo.theater.orderList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, String> {
    @Query("SELECT o FROM OrderList o WHERE o.cId = :cId")
    OrderList retrieveOrderList(@Param("cId") String cId); // 현재 cid를 가진 사람이 주문한 내역이 있는가
}
