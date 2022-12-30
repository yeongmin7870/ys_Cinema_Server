package com.example.demo.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.theater.vo.NormalScreen;

@Repository
public interface NormalScreenRepository extends JpaRepository<NormalScreen, String> {
    NormalScreen findByNormalScreenId(String id);
}
