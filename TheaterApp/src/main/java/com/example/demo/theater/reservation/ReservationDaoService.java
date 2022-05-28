package com.example.demo.theater.reservation;

import com.example.demo.theater.movie.Movie;
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
        orderList.setR_No(repository.findMaxId());

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
        ncOrderList.setR_No(repository.findMaxId());
        ncOrderListRepository.save(ncOrderList);
        return newReservation;
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
