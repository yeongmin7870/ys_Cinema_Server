package com.example.demo.theater.reservation;

import com.example.demo.theater.ncOrderList.NcOrderList;
import com.example.demo.theater.ncOrderList.NcOrderListRepository;
import com.example.demo.theater.orderList.OrderList;
import com.example.demo.theater.orderList.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.Date;
import java.util.List;

@Service
public class ReservationDaoService {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    private NcOrderListRepository ncOrderListRepository;

    // 영화 예매하기 삽입
    public Reservation reserveMovie(Reservation reservation, String cId) {
        Date today = new Date();
        reservation.setR_Date(today);
        Reservation newReservation = repository.save(reservation);
        OrderList orderList = new OrderList();
        orderList.setCId(cId);
        orderList.setR_No(reservation.getReservationId());
        orderListRepository.save(orderList);
        return newReservation;
    }

    // 비회원 예매하기 삽입
    public Reservation reserveMovie2(Reservation reservation, Integer cId) {
        Date today = new Date();
        reservation.setR_Date(today);
        Reservation newReservation = repository.save(reservation);
        NcOrderList ncOrderList = new NcOrderList();
        ncOrderList.setNc_No(cId);
        ncOrderList.setR_No(reservation.getReservationId());
        ncOrderListRepository.save(ncOrderList);
        return newReservation;
    }

    public List<Object> reserveOrderList(String cId) {
        return repository.retrieveCustomerMovieList(cId);
    }

    public List<Object> reserveOrderList2(Integer cId) {
        return repository.retrieveCustomerMovieList2(cId);
    }

}
