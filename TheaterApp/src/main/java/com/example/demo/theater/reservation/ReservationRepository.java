package com.example.demo.theater.reservation;

import com.example.demo.theater.movie.Movie;
import com.example.demo.theater.ncOrderList.NcOrderList;
import com.example.demo.theater.orderList.OrderList;
import com.example.demo.theater.reservation.Reservation;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {


    @Query("SELECT o,r,m FROM OrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.cId = :cId " +
            "AND r.m_No = m.movieId")
    List<Object> retrieveCustomerMovieList(@Param("cId") String cId);


    @Query("SELECT o FROM OrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.cId = :cId " +
            "AND r.m_No = m.movieId")
    List<OrderList> retrieveCustomerMovieListO (@Param("cId") String cId);


    @Query("SELECT r FROM OrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.cId = :cId " +
            "AND r.m_No = m.movieId")
    List<Reservation> retrieveCustomerMovieListR (@Param("cId") String cId);


    @Query("SELECT m FROM OrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.cId = :cId " +
            "AND r.m_No = m.movieId")
    List<Movie> retrieveCustomerMovieListM (@Param("cId") String cId);


    @Query("SELECT max(re.reservationId) FROM Reservation re ")
    Integer findMaxId();


    @Query("SELECT o,r,m FROM NcOrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.nc_No = :nc_No " +
            "AND r.m_No = m.movieId")
    List<Object> retrieveCustomerMovieList2(@Param("nc_No") Integer nc_No);

    @Query("SELECT o FROM NcOrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.nc_No = :nc_No " +
            "AND r.m_No = m.movieId")
    List<NcOrderList> retrieveCustomerMovieList2O(@Param("nc_No") Integer nc_No);

    @Query("SELECT r FROM NcOrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.nc_No = :nc_No " +
            "AND r.m_No = m.movieId")
    List<Reservation> retrieveCustomerMovieList2R(@Param("nc_No") Integer nc_No);

    @Query("SELECT m FROM NcOrderList o, Reservation r, Movie m WHERE o.r_No = r.reservationId AND o.nc_No = :nc_No " +
            "AND r.m_No = m.movieId")
    List<Movie> retrieveCustomerMovieList2M(@Param("nc_No") Integer nc_No);

}
