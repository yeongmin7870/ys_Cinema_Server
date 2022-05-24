package com.example.demo.theater.ncOrderList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NcOrderListRepository extends JpaRepository<NcOrderList,Integer> {
}
