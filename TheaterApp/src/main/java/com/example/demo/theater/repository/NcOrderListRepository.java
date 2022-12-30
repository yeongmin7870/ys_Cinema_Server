package com.example.demo.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NcOrderListRepository extends JpaRepository<NcOrderList, Integer> {
}
