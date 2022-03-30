package com.example.demo.theater.membership;

import com.example.demo.theater.membership.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberShipRepository extends JpaRepository<MemberShip,Integer> {
}
