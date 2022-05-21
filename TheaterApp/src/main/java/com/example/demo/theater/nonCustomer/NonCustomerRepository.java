package com.example.demo.theater.nonCustomer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NonCustomerRepository extends JpaRepository<NonCustomer, Integer> {

    @Query("SELECT n FROM NonCustomer n WHERE n.ncPhone = :ncPhone")
    NonCustomer retrieveNonCustomer(@Param("ncPhone") String ncPhone);
}
