package com.example.demo.theater.repository;

import com.example.demo.theater.vo.StoreAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAddressRepository extends JpaRepository<StoreAddress,Integer> {
}