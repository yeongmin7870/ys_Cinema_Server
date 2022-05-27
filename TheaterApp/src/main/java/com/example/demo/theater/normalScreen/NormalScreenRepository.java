package com.example.demo.theater.normalScreen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalScreenRepository extends JpaRepository<NormalScreen, String> {
    NormalScreen findByNormalScreenId(String id);
}
