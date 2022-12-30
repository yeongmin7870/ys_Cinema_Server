package com.example.demo.theater.repository;

import com.example.demo.theater.vo.EventList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventListRepository extends JpaRepository<EventList, Integer> {
}
