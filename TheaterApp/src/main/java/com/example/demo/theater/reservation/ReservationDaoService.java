package com.example.demo.theater.reservation;

import com.example.demo.theater.movie.Movie;
import com.example.demo.theater.ncOrderList.NcOrderList;
import com.example.demo.theater.ncOrderList.NcOrderListRepository;
import com.example.demo.theater.normalSeat.NormalSeat;
import com.example.demo.theater.normalSeat.NormalSeatRepository;
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

    @Autowired
    private NormalSeatRepository normalSeatRepository;

    // 영화 예매하기 삽입
    public String reserveMovie(Reservation reservation, String cId) {
        NormalSeat normalSeat = new NormalSeat();
        Date today = new Date();
        String str = reservation.getNormalSeatId();
        String[] strArray = str.split(",");
        NormalSeat control = null;

        System.out.println("배열값 확인 " + str );

        if (strArray.length == 1) { // 만약 좌석 값 배열의 길이가 1개라면
            control = normalSeatRepository.findNormalSeatId(reservation.getNormalSeatId()); // 좌석 존재여부를 검색한다
            System.out.println("오류확인 " + control);
            if (control != null) { // 만약 예약한 좌석이 있다면
                return "fail";
            }
        }

        for (int i = 0; i < strArray.length; i++) { // 여러 좌석으로 왔다면 for문을 돌린다
            if (control == null) { // 초기값을 null로해서 시작!     or 여부의 좌석이 있다면
                control = normalSeatRepository.findNormalSeatId(strArray[i]); //그 좌석들을 하나씩 찾아본다
            } else { // 여부의 좌석이 없다면
                return "fail";
            }
            normalSeat.setNormalId(normalSeatRepository.findNormalMax() + 1);
            normalSeat.setNormalSeatId(strArray[i]);
            normalSeatRepository.save(normalSeat);
        }


        reservation.setR_Date(today);  // 예약 테이블에 구매 날짜를 넣어준다 .
        Reservation newReservation = repository.save(reservation); // 가져온 값들을 넣어준다.

        OrderList orderList = new OrderList();
        orderList.setCId(cId);
        orderList.setR_No(repository.findMaxId());

        orderListRepository.save(orderList);
        return "finish";
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
