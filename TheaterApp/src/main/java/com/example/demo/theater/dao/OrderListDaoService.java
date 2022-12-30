package com.example.demo.theater.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.theater.repository.OrderListRepository;

@Service
public class OrderListDaoService {
    @Autowired
    private OrderListRepository repository;


}
