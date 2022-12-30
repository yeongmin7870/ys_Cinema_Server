package com.example.demo.theater.dao;

import com.example.demo.theater.ncOrderList.NcOrderList;
import com.example.demo.theater.repository.NcOrderListRepository;
import com.example.demo.theater.repository.NormalSeatRepository;
import com.example.demo.theater.repository.OrderListRepository;
import com.example.demo.theater.repository.ReservationRepository;
import com.example.demo.theater.vo.Movie;
import com.example.demo.theater.vo.NormalSeat;
import com.example.demo.theater.vo.OrderList;
import com.example.demo.theater.vo.Reservation;

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

    @Autowired
    private NormalSeatRepository normalSeatRepository;

    // 영화 예매하기 삽입
    public void reserveMovie(Reservation newReservation, String cId) {

        Date today = new Date();
        String str = newReservation.getNormalSeatId();
        String[] strArray = str.split(",");

        Boolean isThereSeat = repository.IsThereSeat(newReservation.getNormalScreenId(),
                newReservation.getNormalSeatId(), newReservation.getMsNo());

        if (isThereSeat != null) {
            return;
        }

        for (int i = 0; i < strArray.length; i++) {
            Reservation reservation = new Reservation();
            reservation.setR_Date(today);
            reservation.setC_Photo("안씀");
            reservation.setM_No(newReservation.getM_No());
            reservation.setNormalScreenId(newReservation.getNormalScreenId());
            reservation.setR_Coupon(0);
            reservation.setMsNo(newReservation.getMsNo());
            reservation.setR_TotalPrice(newReservation.getR_TotalPrice());

            reservation.setNormalSeatId(strArray[i]);
            repository.save(reservation);
            OrderList orderList = new OrderList();
            orderList.setCId(cId);
            orderList.setR_No(repository.findMaxId());
            orderListRepository.save(orderList);
        }

    }

    // 비회원 예매하기 삽입
    public void reserveMovie2(Reservation reservation, Integer NcNo) {
        Date today = new Date(); // 값이 넘어오는 순간 서버 시간 생성 이것은 for문안에 들어가면 안됨.

        String str = reservation.getNormalSeatId();
        String[] strArray = str.split(",");

        for (int i = 0; i < strArray.length; i++) {
            reservation.setR_Date(today);
            reservation.setNormalSeatId(strArray[i]);
            repository.save(reservation);
            NcOrderList ncOrderList = new NcOrderList();
            ncOrderList.setNc_No(NcNo);
            ncOrderList.setR_No(repository.findMaxId());
            ncOrderListRepository.save(ncOrderList);
        }

    }

    public List<Reservation> reserveOrderList(String cId) {
        List<Reservation> reservations = repository.retrieveCustomerMovieListR(cId);
        List<OrderList> orderLists = repository.retrieveCustomerMovieListO(cId);
        List<Movie> movies = repository.retrieveCustomerMovieListM(cId);

        for (int i = 0; i < reservations.size(); i++) {
            reservations.get(i).setOrderId(orderLists.get(i).getOrderId());
            reservations.get(i).setCId(orderLists.get(i).getCId());
            reservations.get(i).setM_Name(movies.get(i).getM_Name());
            reservations.get(i).setM_Categories(movies.get(i).getM_Categories());
            reservations.get(i).setM_Director(movies.get(i).getM_Director());
            reservations.get(i).setM_Hour(movies.get(i).getM_Hour());
        }
        return reservations;
    }

    public List<Reservation> reserveOrderList2(Integer cId) {
        List<Reservation> reservations = repository.retrieveCustomerMovieList2R(cId);
        List<NcOrderList> orderLists = repository.retrieveCustomerMovieList2O(cId);
        List<Movie> movies = repository.retrieveCustomerMovieList2M(cId);

        for (int i = 0; i < reservations.size(); i++) {
            reservations.get(i).setOrderId(orderLists.get(i).getNcOrderId());
            reservations.get(i).setNId(orderLists.get(i).getNc_No());
            reservations.get(i).setM_Name(movies.get(i).getM_Name());
            reservations.get(i).setM_Categories(movies.get(i).getM_Categories());
            reservations.get(i).setM_Director(movies.get(i).getM_Director());
            reservations.get(i).setM_Hour(movies.get(i).getM_Hour());
        }
        return reservations;
    }

}
