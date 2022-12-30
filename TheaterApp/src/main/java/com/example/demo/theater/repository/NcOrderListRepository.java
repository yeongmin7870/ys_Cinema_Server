package com.example.demo.theater.repository;

import com.example.demo.theater.vo.NcOrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NcOrderListRepository extends JpaRepository<NcOrderList, Integer> {
}
