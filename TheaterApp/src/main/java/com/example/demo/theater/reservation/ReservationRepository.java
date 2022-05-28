package com.example.demo.theater.reservation;

import com.example.demo.theater.orderList.OrderList;
import com.example.demo.theater.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {


    @Query("SELECT o,r,m FROM OrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.cId = :cId " +
            "AND r.m_No = m.movieId")
    List<Object> retrieveCustomerMovieList(@Param("cId") String cId);


    @Query("SELECT max(re.reservationId) FROM Reservation re ")
    Integer findMaxId();


    @Query("SELECT o,r,m FROM NcOrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.nc_No = :nc_No " +
            "AND r.m_No = m.movieId")
    List<Object> retrieveCustomerMovieList2(@Param("nc_No") Integer nc_No);


}
