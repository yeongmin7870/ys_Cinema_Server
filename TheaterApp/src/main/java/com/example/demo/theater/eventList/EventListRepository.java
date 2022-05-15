package com.example.demo.theater.eventList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventListRepository extends JpaRepository<EventList, Integer> {
}
