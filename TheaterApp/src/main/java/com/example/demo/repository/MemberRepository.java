package com.example.demo.repository;

import com.example.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


//https://www.codejava.net/frameworks/spring-boot/spring-boot-restful-crud-api-examples-with-mysql-database

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
